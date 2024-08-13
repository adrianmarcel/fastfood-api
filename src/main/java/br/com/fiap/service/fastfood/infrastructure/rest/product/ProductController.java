package br.com.fiap.service.fastfood.infrastructure.rest.product;

import static org.springframework.http.ResponseEntity.*;

import br.com.fiap.service.fastfood.application.port.input.product.ProductCreateUseCase;
import br.com.fiap.service.fastfood.application.port.input.product.ProductDeleteUseCase;
import br.com.fiap.service.fastfood.application.port.input.product.ProductSearchUseCase;
import br.com.fiap.service.fastfood.application.port.input.product.ProductUpdateUseCase;
import br.com.fiap.service.fastfood.domain.model.product.ProductFilterRequest;
import br.com.fiap.service.fastfood.domain.model.product.ProductRequest;
import br.com.fiap.service.fastfood.domain.model.product.ProductResponse;
import br.com.fiap.service.fastfood.domain.model.product.ProductUpdateRequest;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ProductController.BASE_URI)
public class ProductController {

  public static final String BASE_URI = "/v1/products";

  private final ProductCreateUseCase createUseCase;
  private final ProductUpdateUseCase updateUseCase;
  private final ProductDeleteUseCase deleteUseCase;
  private final ProductSearchUseCase searchUseCase;

  @PostMapping
  public ResponseEntity<ProductResponse> create(@Valid @RequestBody ProductRequest request) {
    var response = createUseCase.execute(request);
    return created(URI.create(BASE_URI.concat("/").concat(response.getId().toString())))
        .body(response);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ProductResponse> update(
      @PathVariable("id") UUID id, @Valid @RequestBody ProductUpdateRequest request) {
    request.setId(id);
    return ok(updateUseCase.execute(request));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") UUID id) {
    deleteUseCase.execute(id);
    return noContent().build();
  }

  @GetMapping
  public ResponseEntity<Page<ProductResponse>> search(
      @Valid ProductFilterRequest filterRequest, Pageable pageable) {
    return ok(searchUseCase.execute(filterRequest, pageable));
  }
}

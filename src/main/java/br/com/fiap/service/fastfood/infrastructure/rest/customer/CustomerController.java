package br.com.fiap.service.fastfood.infrastructure.rest.customer;

import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;

import br.com.fiap.service.fastfood.application.port.input.customer.CustomerCreateUseCase;
import br.com.fiap.service.fastfood.application.port.input.customer.CustomerSearchUseCase;
import br.com.fiap.service.fastfood.domain.model.customer.CustomerFilterRequest;
import br.com.fiap.service.fastfood.domain.model.customer.CustomerRequest;
import br.com.fiap.service.fastfood.domain.model.customer.CustomerResponse;
import br.com.fiap.service.fastfood.domain.shared.exception.BusinessException;
import br.com.fiap.service.fastfood.domain.shared.exception.ExceptionCode;
import jakarta.validation.Valid;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(CustomerController.BASE_URI)
public class CustomerController {

  public static final String BASE_URI = "/v1/customers";

  private final CustomerCreateUseCase createUseCase;
  private final CustomerSearchUseCase identifyUseCase;

  @PostMapping
  public ResponseEntity<CustomerResponse> create(@Valid @RequestBody CustomerRequest request) {
    var response = createUseCase.execute(request);
    return created(URI.create(BASE_URI.concat("/").concat(response.getId().toString())))
        .body(response);
  }

  @GetMapping("/{document}")
  public ResponseEntity<CustomerResponse> identify(@PathVariable("document") String document) {
    return ok(
        identifyUseCase
            .execute(CustomerFilterRequest.builder().document(document).build(), Pageable.unpaged())
            .stream()
            .findFirst()
            .orElseThrow(() -> new BusinessException(ExceptionCode.CUSTOMER_NOT_FOUND)));
  }
}

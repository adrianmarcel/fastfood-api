package br.com.fiap.service.fastfood.application.port.input.product;

import br.com.fiap.service.fastfood.domain.model.product.ProductFilterRequest;
import br.com.fiap.service.fastfood.domain.model.product.ProductResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductSearchUseCase {

  Page<ProductResponse> execute(@Valid ProductFilterRequest request, Pageable pageable);
}

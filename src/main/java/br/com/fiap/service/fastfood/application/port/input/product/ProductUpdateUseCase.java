package br.com.fiap.service.fastfood.application.port.input.product;

import br.com.fiap.service.fastfood.domain.model.product.ProductResponse;
import br.com.fiap.service.fastfood.domain.model.product.ProductUpdateRequest;
import jakarta.validation.Valid;

public interface ProductUpdateUseCase {

  ProductResponse execute(@Valid ProductUpdateRequest request);
}

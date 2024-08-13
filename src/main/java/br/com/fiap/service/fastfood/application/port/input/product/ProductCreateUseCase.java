package br.com.fiap.service.fastfood.application.port.input.product;

import br.com.fiap.service.fastfood.domain.model.product.ProductRequest;
import br.com.fiap.service.fastfood.domain.model.product.ProductResponse;
import jakarta.validation.Valid;

public interface ProductCreateUseCase {

  ProductResponse execute(@Valid ProductRequest request);
}

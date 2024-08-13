package br.com.fiap.service.fastfood.application.port.output.category;

import br.com.fiap.service.fastfood.domain.model.category.CategoryGatewayRequest;
import br.com.fiap.service.fastfood.domain.model.category.CategoryGatewayResponse;

public interface CategoryCreateGateway {

  CategoryGatewayResponse execute(CategoryGatewayRequest request);
}

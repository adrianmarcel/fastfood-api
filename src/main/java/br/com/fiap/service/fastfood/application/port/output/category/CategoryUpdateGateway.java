package br.com.fiap.service.fastfood.application.port.output.category;

import br.com.fiap.service.fastfood.domain.model.category.CategoryGatewayRequest;
import br.com.fiap.service.fastfood.domain.model.category.CategoryGatewayResponse;
import java.util.Optional;

public interface CategoryUpdateGateway {

  Optional<CategoryGatewayResponse> execute(CategoryGatewayRequest request);
}

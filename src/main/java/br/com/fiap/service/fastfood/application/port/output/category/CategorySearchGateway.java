package br.com.fiap.service.fastfood.application.port.output.category;

import br.com.fiap.service.fastfood.domain.model.category.CategoryFilterRequest;
import br.com.fiap.service.fastfood.domain.model.category.CategoryGatewayResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategorySearchGateway {

  Page<CategoryGatewayResponse> execute(CategoryFilterRequest filterRequest, Pageable pageable);
}

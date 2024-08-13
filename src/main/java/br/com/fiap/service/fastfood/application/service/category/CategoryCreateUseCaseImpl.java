package br.com.fiap.service.fastfood.application.service.category;

import br.com.fiap.service.fastfood.application.port.input.category.CategoryCreateUseCase;
import br.com.fiap.service.fastfood.application.port.output.category.CategoryCreateGateway;
import br.com.fiap.service.fastfood.domain.model.category.CategoryGatewayRequest;
import br.com.fiap.service.fastfood.domain.model.category.CategoryRequest;
import br.com.fiap.service.fastfood.domain.model.category.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryCreateUseCaseImpl implements CategoryCreateUseCase {

  private final CategoryCreateGateway createGateway;

  @Override
  public CategoryResponse execute(CategoryRequest request) {
    return CategoryResponse.mapper(createGateway.execute(CategoryGatewayRequest.mapper(request)));
  }
}

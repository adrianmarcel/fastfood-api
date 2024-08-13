package br.com.fiap.service.fastfood.application.service.category;

import br.com.fiap.service.fastfood.application.port.input.category.CategorySearchUseCase;
import br.com.fiap.service.fastfood.application.port.output.category.CategorySearchGateway;
import br.com.fiap.service.fastfood.domain.model.category.CategoryFilterRequest;
import br.com.fiap.service.fastfood.domain.model.category.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategorySearchUseCaseImpl implements CategorySearchUseCase {

  private final CategorySearchGateway searchGateway;

  @Override
  public Page<CategoryResponse> execute(CategoryFilterRequest filterRequest, Pageable pageable) {
    return searchGateway.execute(filterRequest, pageable).map(CategoryResponse::mapper);
  }
}

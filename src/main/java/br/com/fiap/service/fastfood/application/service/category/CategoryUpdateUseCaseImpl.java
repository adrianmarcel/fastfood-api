package br.com.fiap.service.fastfood.application.service.category;

import br.com.fiap.service.fastfood.application.port.input.category.CategoryUpdateUseCase;
import br.com.fiap.service.fastfood.application.port.output.category.CategoryUpdateGateway;
import br.com.fiap.service.fastfood.domain.model.category.CategoryGatewayRequest;
import br.com.fiap.service.fastfood.domain.model.category.CategoryResponse;
import br.com.fiap.service.fastfood.domain.model.category.CategoryUpdateRequest;
import br.com.fiap.service.fastfood.domain.shared.exception.BusinessException;
import br.com.fiap.service.fastfood.domain.shared.exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryUpdateUseCaseImpl implements CategoryUpdateUseCase {

  private final CategoryUpdateGateway updateGateway;

  @Override
  public CategoryResponse execute(CategoryUpdateRequest request) {
    return updateGateway
        .execute(CategoryGatewayRequest.mapper(request))
        .map(CategoryResponse::mapper)
        .orElseThrow(() -> new BusinessException(ExceptionCode.CATEGORY_NOT_FOUND));
  }
}

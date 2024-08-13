package br.com.fiap.service.fastfood.application.service.category;

import br.com.fiap.service.fastfood.application.port.input.category.CategoryDeleteUseCase;
import br.com.fiap.service.fastfood.application.port.output.category.CategoryDeleteGateway;
import br.com.fiap.service.fastfood.application.port.output.category.CategorySearchGateway;
import br.com.fiap.service.fastfood.domain.model.category.CategoryFilterRequest;
import br.com.fiap.service.fastfood.domain.shared.exception.BusinessException;
import br.com.fiap.service.fastfood.domain.shared.exception.ExceptionCode;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryDeleteUseCaseImpl implements CategoryDeleteUseCase {

  private final CategoryDeleteGateway deleteGateway;
  private final CategorySearchGateway searchGateway;

  @Override
  public void execute(UUID id) {
    searchGateway
        .execute(CategoryFilterRequest.builder().id(id).build(), Pageable.unpaged())
        .stream()
        .findFirst()
        .ifPresentOrElse(
            product -> deleteGateway.execute(product.getId()),
            () -> {
              throw new BusinessException(ExceptionCode.CATEGORY_NOT_FOUND);
            });
  }
}

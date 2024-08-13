package br.com.fiap.service.fastfood.application.service.product;

import br.com.fiap.service.fastfood.application.port.input.product.ProductDeleteUseCase;
import br.com.fiap.service.fastfood.application.port.output.product.ProductDeleteGateway;
import br.com.fiap.service.fastfood.application.port.output.product.ProductSearchGateway;
import br.com.fiap.service.fastfood.domain.model.product.ProductFilterRequest;
import br.com.fiap.service.fastfood.domain.shared.exception.BusinessException;
import br.com.fiap.service.fastfood.domain.shared.exception.ExceptionCode;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductDeleteUseCaseImpl implements ProductDeleteUseCase {

  private final ProductDeleteGateway deleteGateway;
  private final ProductSearchGateway searchGateway;

  @Override
  public void execute(UUID id) {
    searchGateway
        .execute(ProductFilterRequest.builder().id(id).build(), Pageable.unpaged())
        .stream()
        .findFirst()
        .ifPresentOrElse(
            product -> deleteGateway.execute(product.getId()),
            () -> {
              throw new BusinessException(ExceptionCode.PRODUCT_NOT_FOUND);
            });
  }
}

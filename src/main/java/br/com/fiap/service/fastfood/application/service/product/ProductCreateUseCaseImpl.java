package br.com.fiap.service.fastfood.application.service.product;

import br.com.fiap.service.fastfood.application.port.input.product.ProductCreateUseCase;
import br.com.fiap.service.fastfood.application.port.output.category.CategorySearchGateway;
import br.com.fiap.service.fastfood.application.port.output.product.ProductCreateGateway;
import br.com.fiap.service.fastfood.domain.model.category.CategoryFilterRequest;
import br.com.fiap.service.fastfood.domain.model.product.ProductGatewayRequest;
import br.com.fiap.service.fastfood.domain.model.product.ProductRequest;
import br.com.fiap.service.fastfood.domain.model.product.ProductResponse;
import br.com.fiap.service.fastfood.domain.shared.exception.BusinessException;
import br.com.fiap.service.fastfood.domain.shared.exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCreateUseCaseImpl implements ProductCreateUseCase {

  private final ProductCreateGateway createGateway;
  private final CategorySearchGateway categorySearchGateway;

  @Override
  public ProductResponse execute(ProductRequest request) {
    categorySearchGateway
        .execute(
            CategoryFilterRequest.builder().id(request.getCategory()).build(), Pageable.unpaged())
        .stream()
        .findFirst()
        .orElseThrow(() -> new BusinessException(ExceptionCode.CATEGORY_NOT_FOUND));

    return ProductResponse.mapper(createGateway.execute(ProductGatewayRequest.mapper(request)));
  }
}

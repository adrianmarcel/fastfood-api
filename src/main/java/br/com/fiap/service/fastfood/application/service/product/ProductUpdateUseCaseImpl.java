package br.com.fiap.service.fastfood.application.service.product;

import br.com.fiap.service.fastfood.application.port.input.product.ProductUpdateUseCase;
import br.com.fiap.service.fastfood.application.port.output.product.ProductUpdateGateway;
import br.com.fiap.service.fastfood.domain.model.product.ProductGatewayRequest;
import br.com.fiap.service.fastfood.domain.model.product.ProductResponse;
import br.com.fiap.service.fastfood.domain.model.product.ProductUpdateRequest;
import br.com.fiap.service.fastfood.domain.shared.exception.BusinessException;
import br.com.fiap.service.fastfood.domain.shared.exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductUpdateUseCaseImpl implements ProductUpdateUseCase {

  private final ProductUpdateGateway updateGateway;

  @Override
  public ProductResponse execute(ProductUpdateRequest request) {
    return updateGateway
        .execute(ProductGatewayRequest.mapper(request))
        .map(ProductResponse::mapper)
        .orElseThrow(() -> new BusinessException(ExceptionCode.PRODUCT_NOT_FOUND));
  }
}

package br.com.fiap.service.fastfood.application.service.product;

import br.com.fiap.service.fastfood.application.port.input.product.ProductSearchUseCase;
import br.com.fiap.service.fastfood.application.port.output.product.ProductSearchGateway;
import br.com.fiap.service.fastfood.domain.model.product.ProductFilterRequest;
import br.com.fiap.service.fastfood.domain.model.product.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductSearchUseCaseImpl implements ProductSearchUseCase {

  private final ProductSearchGateway searchGateway;

  @Override
  public Page<ProductResponse> execute(ProductFilterRequest filterRequest, Pageable pageable) {
    return searchGateway.execute(filterRequest, pageable).map(ProductResponse::mapper);
  }
}

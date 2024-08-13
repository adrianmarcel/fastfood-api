package br.com.fiap.service.fastfood.infrastructure.persistence.adapter.product;

import br.com.fiap.service.fastfood.application.port.output.product.ProductSearchGateway;
import br.com.fiap.service.fastfood.domain.model.product.ProductFilterRequest;
import br.com.fiap.service.fastfood.domain.model.product.ProductGatewayResponse;
import br.com.fiap.service.fastfood.infrastructure.persistence.repository.product.ProductRepository;
import br.com.fiap.service.fastfood.infrastructure.persistence.repository.product.ProductSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductSearchDBGatewayImpl implements ProductSearchGateway {

  private final ProductRepository repository;

  @Override
  public Page<ProductGatewayResponse> execute(
      ProductFilterRequest filterRequest, Pageable pageable) {
    return repository
        .findAll(ProductSpecification.build(filterRequest), pageable)
        .map(ProductGatewayResponse::mapper);
  }
}

package br.com.fiap.service.fastfood.infrastructure.persistence.adapter.product;

import br.com.fiap.service.fastfood.application.port.output.product.ProductCreateGateway;
import br.com.fiap.service.fastfood.domain.model.product.ProductGatewayRequest;
import br.com.fiap.service.fastfood.domain.model.product.ProductGatewayResponse;
import br.com.fiap.service.fastfood.infrastructure.persistence.repository.product.ProductEntity;
import br.com.fiap.service.fastfood.infrastructure.persistence.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCreateDBGatewayImpl implements ProductCreateGateway {

  private final ProductRepository repository;

  @Override
  public ProductGatewayResponse execute(ProductGatewayRequest request) {
    return ProductGatewayResponse.mapper(repository.save(ProductEntity.mapper(request)));
  }
}

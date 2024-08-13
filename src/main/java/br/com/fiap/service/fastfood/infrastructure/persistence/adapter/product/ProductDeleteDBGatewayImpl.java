package br.com.fiap.service.fastfood.infrastructure.persistence.adapter.product;

import br.com.fiap.service.fastfood.application.port.output.product.ProductDeleteGateway;
import br.com.fiap.service.fastfood.infrastructure.persistence.repository.product.ProductRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductDeleteDBGatewayImpl implements ProductDeleteGateway {

  private final ProductRepository repository;

  @Override
  public void execute(UUID id) {
    repository.deleteById(id);
  }
}

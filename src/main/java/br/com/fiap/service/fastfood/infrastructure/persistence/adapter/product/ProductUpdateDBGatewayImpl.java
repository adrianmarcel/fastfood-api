package br.com.fiap.service.fastfood.infrastructure.persistence.adapter.product;

import br.com.fiap.service.fastfood.application.port.output.product.ProductUpdateGateway;
import br.com.fiap.service.fastfood.domain.model.product.ProductGatewayRequest;
import br.com.fiap.service.fastfood.domain.model.product.ProductGatewayResponse;
import br.com.fiap.service.fastfood.infrastructure.persistence.repository.product.ProductRepository;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductUpdateDBGatewayImpl implements ProductUpdateGateway {

  private final ProductRepository repository;

  @Override
  public Optional<ProductGatewayResponse> execute(ProductGatewayRequest request) {
    return repository
        .findById(request.getId())
        .map(
            product -> {
              var name = Objects.nonNull(request.getName()) ? request.getName() : product.getName();
              var category =
                  Objects.nonNull(request.getCategory())
                      ? request.getCategory()
                      : product.getCategory();
              var amount =
                  Objects.nonNull(request.getAmount()) ? request.getAmount() : product.getAmount();

              product.setName(name);
              product.setCategory(category);
              product.setAmount(amount);

              return ProductGatewayResponse.mapper(repository.save(product));
            });
  }
}

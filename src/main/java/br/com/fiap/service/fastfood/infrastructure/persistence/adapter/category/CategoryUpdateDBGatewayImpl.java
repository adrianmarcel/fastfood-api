package br.com.fiap.service.fastfood.infrastructure.persistence.adapter.category;

import br.com.fiap.service.fastfood.application.port.output.category.CategoryUpdateGateway;
import br.com.fiap.service.fastfood.domain.model.category.CategoryGatewayRequest;
import br.com.fiap.service.fastfood.domain.model.category.CategoryGatewayResponse;
import br.com.fiap.service.fastfood.infrastructure.persistence.repository.category.CategoryRepository;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryUpdateDBGatewayImpl implements CategoryUpdateGateway {

  private final CategoryRepository repository;

  @Override
  public Optional<CategoryGatewayResponse> execute(CategoryGatewayRequest request) {
    return repository
        .findById(request.getId())
        .map(
            product -> {
              var name = Objects.nonNull(request.getName()) ? request.getName() : product.getName();
              product.setName(name);
              return CategoryGatewayResponse.mapper(repository.save(product));
            });
  }
}

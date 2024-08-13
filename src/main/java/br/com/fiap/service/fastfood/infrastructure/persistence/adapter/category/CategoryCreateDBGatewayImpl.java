package br.com.fiap.service.fastfood.infrastructure.persistence.adapter.category;

import br.com.fiap.service.fastfood.application.port.output.category.CategoryCreateGateway;
import br.com.fiap.service.fastfood.domain.model.category.CategoryGatewayRequest;
import br.com.fiap.service.fastfood.domain.model.category.CategoryGatewayResponse;
import br.com.fiap.service.fastfood.infrastructure.persistence.repository.category.CategoryEntity;
import br.com.fiap.service.fastfood.infrastructure.persistence.repository.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryCreateDBGatewayImpl implements CategoryCreateGateway {

  private final CategoryRepository repository;

  @Override
  public CategoryGatewayResponse execute(CategoryGatewayRequest request) {
    return CategoryGatewayResponse.mapper(repository.save(CategoryEntity.mapper(request)));
  }
}

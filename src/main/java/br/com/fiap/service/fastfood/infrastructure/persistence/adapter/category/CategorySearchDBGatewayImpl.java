package br.com.fiap.service.fastfood.infrastructure.persistence.adapter.category;

import br.com.fiap.service.fastfood.application.port.output.category.CategorySearchGateway;
import br.com.fiap.service.fastfood.domain.model.category.CategoryFilterRequest;
import br.com.fiap.service.fastfood.domain.model.category.CategoryGatewayResponse;
import br.com.fiap.service.fastfood.infrastructure.persistence.repository.category.CategoryRepository;
import br.com.fiap.service.fastfood.infrastructure.persistence.repository.category.CategorySpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategorySearchDBGatewayImpl implements CategorySearchGateway {

  private final CategoryRepository repository;

  @Override
  public Page<CategoryGatewayResponse> execute(
      CategoryFilterRequest filterRequest, Pageable pageable) {
    return repository
        .findAll(CategorySpecification.build(filterRequest), pageable)
        .map(CategoryGatewayResponse::mapper);
  }
}

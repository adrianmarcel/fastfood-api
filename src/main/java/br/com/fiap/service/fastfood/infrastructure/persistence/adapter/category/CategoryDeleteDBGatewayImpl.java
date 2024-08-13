package br.com.fiap.service.fastfood.infrastructure.persistence.adapter.category;

import br.com.fiap.service.fastfood.application.port.output.category.CategoryDeleteGateway;
import br.com.fiap.service.fastfood.infrastructure.persistence.repository.category.CategoryRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryDeleteDBGatewayImpl implements CategoryDeleteGateway {

  private final CategoryRepository repository;

  @Override
  public void execute(UUID id) {
    repository.deleteById(id);
  }
}

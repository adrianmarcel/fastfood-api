package br.com.fiap.service.fastfood.application.port.input.category;

import java.util.UUID;

public interface CategoryDeleteUseCase {

  void execute(UUID id);
}

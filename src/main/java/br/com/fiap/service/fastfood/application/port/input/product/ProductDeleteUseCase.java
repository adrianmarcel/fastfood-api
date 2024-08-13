package br.com.fiap.service.fastfood.application.port.input.product;

import java.util.UUID;

public interface ProductDeleteUseCase {

  void execute(UUID id);
}

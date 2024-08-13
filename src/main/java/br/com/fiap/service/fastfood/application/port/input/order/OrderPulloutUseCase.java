package br.com.fiap.service.fastfood.application.port.input.order;

import java.util.UUID;

public interface OrderPulloutUseCase {

  void execute(UUID id);
}

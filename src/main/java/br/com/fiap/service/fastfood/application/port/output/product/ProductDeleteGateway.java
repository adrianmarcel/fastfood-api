package br.com.fiap.service.fastfood.application.port.output.product;

import java.util.UUID;

public interface ProductDeleteGateway {

  void execute(UUID id);
}

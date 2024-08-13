package br.com.fiap.service.fastfood.application.port.output.category;

import java.util.UUID;

public interface CategoryDeleteGateway {

  void execute(UUID id);
}

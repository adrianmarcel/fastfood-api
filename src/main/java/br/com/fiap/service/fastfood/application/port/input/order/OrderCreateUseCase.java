package br.com.fiap.service.fastfood.application.port.input.order;

import br.com.fiap.service.fastfood.domain.model.order.OrderRequest;
import br.com.fiap.service.fastfood.domain.model.order.OrderResponse;
import jakarta.validation.Valid;

public interface OrderCreateUseCase {

  OrderResponse execute(@Valid OrderRequest request);
}

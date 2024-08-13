package br.com.fiap.service.fastfood.application.port.input.order;

import br.com.fiap.service.fastfood.domain.model.order.OrderStatus;

public interface OrderCheckPaymentUseCase {

  void execute(OrderStatus status);
}

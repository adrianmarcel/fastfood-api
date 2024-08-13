package br.com.fiap.service.fastfood.application.port.output.order;

import br.com.fiap.service.fastfood.domain.model.order.OrderGatewayRequest;
import br.com.fiap.service.fastfood.domain.model.order.OrderGatewayResponse;

public interface OrderCreateGateway {

  OrderGatewayResponse execute(OrderGatewayRequest request);
}

package br.com.fiap.service.fastfood.application.port.output.order;

import br.com.fiap.service.fastfood.domain.model.order.OrderGatewayRequest;
import br.com.fiap.service.fastfood.domain.model.order.OrderGatewayResponse;
import java.util.Optional;

public interface OrderUpdateGateway {

  Optional<OrderGatewayResponse> execute(OrderGatewayRequest request);
}

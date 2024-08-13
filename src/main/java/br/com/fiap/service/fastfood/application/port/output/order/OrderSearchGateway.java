package br.com.fiap.service.fastfood.application.port.output.order;

import br.com.fiap.service.fastfood.domain.model.order.OrderFilterRequest;
import br.com.fiap.service.fastfood.domain.model.order.OrderGatewayResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderSearchGateway {

  Page<OrderGatewayResponse> execute(OrderFilterRequest filterRequest, Pageable pageable);
}

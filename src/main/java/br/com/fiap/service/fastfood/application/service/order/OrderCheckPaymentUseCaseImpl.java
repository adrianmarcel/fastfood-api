package br.com.fiap.service.fastfood.application.service.order;

import br.com.fiap.service.fastfood.application.port.input.order.OrderCheckPaymentUseCase;
import br.com.fiap.service.fastfood.application.port.output.order.OrderSearchGateway;
import br.com.fiap.service.fastfood.application.port.output.order.OrderUpdateGateway;
import br.com.fiap.service.fastfood.domain.model.order.OrderFilterRequest;
import br.com.fiap.service.fastfood.domain.model.order.OrderGatewayRequest;
import br.com.fiap.service.fastfood.domain.model.order.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderCheckPaymentUseCaseImpl implements OrderCheckPaymentUseCase {

  private final OrderSearchGateway searchGateway;
  private final OrderUpdateGateway updateGateway;

  @Override
  public void execute(OrderStatus status) {
    var orders =
        searchGateway
            .execute(OrderFilterRequest.builder().status(status).build(), Pageable.unpaged())
            .getContent();

    orders.forEach(
        order -> {
          var gatewayRequest = OrderGatewayRequest.mapper(order);
          gatewayRequest.setStatus(OrderStatus.PAGO.getDescription());

          updateGateway.execute(gatewayRequest);
        });
  }
}

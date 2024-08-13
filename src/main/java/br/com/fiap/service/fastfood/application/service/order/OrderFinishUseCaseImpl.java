package br.com.fiap.service.fastfood.application.service.order;

import br.com.fiap.service.fastfood.application.port.input.order.OrderFinishUseCase;
import br.com.fiap.service.fastfood.application.port.output.order.OrderSearchGateway;
import br.com.fiap.service.fastfood.application.port.output.order.OrderUpdateGateway;
import br.com.fiap.service.fastfood.domain.model.order.OrderFilterRequest;
import br.com.fiap.service.fastfood.domain.model.order.OrderGatewayRequest;
import br.com.fiap.service.fastfood.domain.model.order.OrderStatus;
import br.com.fiap.service.fastfood.domain.shared.exception.BusinessException;
import br.com.fiap.service.fastfood.domain.shared.exception.ExceptionCode;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderFinishUseCaseImpl implements OrderFinishUseCase {

  private final OrderUpdateGateway updateGateway;
  private final OrderSearchGateway searchGateway;

  @Override
  public void execute(UUID id) {
    searchGateway
        .execute(OrderFilterRequest.builder().id(id).build(), Pageable.unpaged())
        .stream()
        .findFirst()
        .ifPresentOrElse(
            order -> {
              if (!OrderStatus.RECEBIDO.getDescription().equalsIgnoreCase(order.getStatus())) {
                throw new BusinessException(ExceptionCode.ORDER_NOT_PAID);
              }
              var gatewayRequest = OrderGatewayRequest.mapper(order);
              gatewayRequest.setStatus(OrderStatus.PRONTO.getDescription());

              updateGateway.execute(gatewayRequest);
            },
            () -> {
              throw new BusinessException(ExceptionCode.ORDER_NOT_FOUND);
            });
  }
}

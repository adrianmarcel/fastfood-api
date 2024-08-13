package br.com.fiap.service.fastfood.application.service.order;

import br.com.fiap.service.fastfood.application.port.input.order.OrderSearchUseCase;
import br.com.fiap.service.fastfood.application.port.output.order.OrderSearchGateway;
import br.com.fiap.service.fastfood.domain.model.order.OrderFilterRequest;
import br.com.fiap.service.fastfood.domain.model.order.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderSearchUseCaseImpl implements OrderSearchUseCase {

  private final OrderSearchGateway searchGateway;

  @Override
  public Page<OrderResponse> execute(OrderFilterRequest filterRequest, Pageable pageable) {
    return searchGateway.execute(filterRequest, pageable).map(OrderResponse::mapper);
  }
}

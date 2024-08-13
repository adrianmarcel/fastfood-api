package br.com.fiap.service.fastfood.infrastructure.persistence.adapter.order;

import br.com.fiap.service.fastfood.application.port.output.order.OrderCreateGateway;
import br.com.fiap.service.fastfood.domain.model.order.OrderGatewayRequest;
import br.com.fiap.service.fastfood.domain.model.order.OrderGatewayResponse;
import br.com.fiap.service.fastfood.infrastructure.persistence.repository.order.OrderEntity;
import br.com.fiap.service.fastfood.infrastructure.persistence.repository.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderCreateDBGatewayImpl implements OrderCreateGateway {

  private final OrderRepository repository;

  @Override
  public OrderGatewayResponse execute(OrderGatewayRequest request) {
    return OrderGatewayResponse.mapper(repository.save(OrderEntity.mapper(request)));
  }
}

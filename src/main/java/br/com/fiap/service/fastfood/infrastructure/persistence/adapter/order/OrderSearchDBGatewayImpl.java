package br.com.fiap.service.fastfood.infrastructure.persistence.adapter.order;

import br.com.fiap.service.fastfood.application.port.output.order.OrderSearchGateway;
import br.com.fiap.service.fastfood.domain.model.order.OrderFilterRequest;
import br.com.fiap.service.fastfood.domain.model.order.OrderGatewayResponse;
import br.com.fiap.service.fastfood.infrastructure.persistence.repository.order.OrderRepository;
import br.com.fiap.service.fastfood.infrastructure.persistence.repository.order.OrderSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderSearchDBGatewayImpl implements OrderSearchGateway {

  private final OrderRepository repository;

  @Override
  public Page<OrderGatewayResponse> execute(OrderFilterRequest filterRequest, Pageable pageable) {
    return repository
        .findAll(OrderSpecification.build(filterRequest), pageable)
        .map(OrderGatewayResponse::mapper);
  }
}

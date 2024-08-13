package br.com.fiap.service.fastfood.infrastructure.persistence.adapter.order;

import br.com.fiap.service.fastfood.application.port.output.order.OrderUpdateGateway;
import br.com.fiap.service.fastfood.domain.model.order.OrderGatewayRequest;
import br.com.fiap.service.fastfood.domain.model.order.OrderGatewayResponse;
import br.com.fiap.service.fastfood.infrastructure.persistence.repository.order.OrderRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderUpdateDBGatewayImpl implements OrderUpdateGateway {

  private final OrderRepository repository;

  @Override
  @Transactional
  public Optional<OrderGatewayResponse> execute(OrderGatewayRequest request) {
    return repository
        .findById(request.getId())
        .map(
            order -> {
              order.setStatus(request.getStatus());
              return OrderGatewayResponse.mapper(repository.save(order));
            });
  }
}

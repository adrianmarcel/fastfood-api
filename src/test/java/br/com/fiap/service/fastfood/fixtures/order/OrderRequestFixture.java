package br.com.fiap.service.fastfood.fixtures.order;

import br.com.fiap.service.fastfood.domain.model.order.OrderRequest;
import java.util.List;
import java.util.UUID;

public class OrderRequestFixture {

  public static OrderRequest validRequest() {
    return OrderRequest.builder()
        .customer(UUID.fromString("919d8d5b-d72d-45a8-923b-86ed31a5e280"))
        .products(List.of(OrderProductRequestFixture.validRequest()))
        .build();
  }
}

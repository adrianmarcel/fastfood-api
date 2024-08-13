package br.com.fiap.service.fastfood.domain.model.order;

import java.util.UUID;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderFilterRequest {

  private UUID id;
  private UUID customerId;
  private OrderStatus status;
}

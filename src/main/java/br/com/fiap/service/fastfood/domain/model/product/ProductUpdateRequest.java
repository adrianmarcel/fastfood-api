package br.com.fiap.service.fastfood.domain.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductUpdateRequest {

  @JsonIgnore private UUID id;

  private String name;
  private UUID category;
  private BigDecimal amount;
}

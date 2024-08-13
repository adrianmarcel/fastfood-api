package br.com.fiap.service.fastfood.domain.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductFilterRequest {

  @JsonIgnore private UUID id;
  private UUID category;
}

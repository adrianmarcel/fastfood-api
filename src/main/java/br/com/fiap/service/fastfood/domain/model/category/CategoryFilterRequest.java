package br.com.fiap.service.fastfood.domain.model.category;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryFilterRequest {

  @JsonIgnore private UUID id;
  private String name;
}

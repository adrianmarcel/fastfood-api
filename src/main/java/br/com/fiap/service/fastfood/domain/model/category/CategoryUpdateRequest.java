package br.com.fiap.service.fastfood.domain.model.category;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class CategoryUpdateRequest {

  @JsonIgnore private UUID id;

  private String name;
}

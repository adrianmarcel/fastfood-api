package br.com.fiap.service.fastfood.domain.model.customer;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerFilterRequest {

  private String document;
}

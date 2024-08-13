package br.com.fiap.service.fastfood.fixtures.category;

import br.com.fiap.service.fastfood.domain.model.category.CategoryGatewayRequest;

public class CategoryGatewayRequestFixture {

  public static CategoryGatewayRequest validRequest() {
    return CategoryGatewayRequest.builder().name("Category test").build();
  }
}

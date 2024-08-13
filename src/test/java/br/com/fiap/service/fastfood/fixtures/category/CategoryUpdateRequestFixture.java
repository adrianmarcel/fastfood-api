package br.com.fiap.service.fastfood.fixtures.category;

import br.com.fiap.service.fastfood.domain.model.category.CategoryUpdateRequest;

public class CategoryUpdateRequestFixture {

  public static CategoryUpdateRequest validRequest() {
    return CategoryUpdateRequest.builder().name("Category test 2").build();
  }
}

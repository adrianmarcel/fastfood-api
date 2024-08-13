package br.com.fiap.service.fastfood.fixtures.category;

import br.com.fiap.service.fastfood.domain.model.category.CategoryRequest;

public class CategoryRequestFixture {

  public static CategoryRequest validRequest() {
    return CategoryRequest.builder().name("Category test").build();
  }
}

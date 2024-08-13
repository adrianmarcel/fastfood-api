package br.com.fiap.service.fastfood.application.port.input.category;

import br.com.fiap.service.fastfood.domain.model.category.CategoryRequest;
import br.com.fiap.service.fastfood.domain.model.category.CategoryResponse;
import jakarta.validation.Valid;

public interface CategoryCreateUseCase {

  CategoryResponse execute(@Valid CategoryRequest request);
}

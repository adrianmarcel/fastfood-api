package br.com.fiap.service.fastfood.application.port.input.category;

import br.com.fiap.service.fastfood.domain.model.category.CategoryResponse;
import br.com.fiap.service.fastfood.domain.model.category.CategoryUpdateRequest;
import jakarta.validation.Valid;

public interface CategoryUpdateUseCase {

  CategoryResponse execute(@Valid CategoryUpdateRequest request);
}

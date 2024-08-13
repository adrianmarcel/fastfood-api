package br.com.fiap.service.fastfood.application.port.input.category;

import br.com.fiap.service.fastfood.domain.model.category.CategoryFilterRequest;
import br.com.fiap.service.fastfood.domain.model.category.CategoryResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategorySearchUseCase {

  Page<CategoryResponse> execute(@Valid CategoryFilterRequest request, Pageable pageable);
}

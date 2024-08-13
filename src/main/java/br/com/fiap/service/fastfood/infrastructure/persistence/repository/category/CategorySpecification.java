package br.com.fiap.service.fastfood.infrastructure.persistence.repository.category;

import br.com.fiap.service.fastfood.domain.model.category.CategoryFilterRequest;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.data.jpa.domain.Specification;

public final class CategorySpecification {

  private CategorySpecification() {}

  public static Specification<CategoryEntity> build(CategoryFilterRequest filterRequest) {
    return (((root, query, criteriaBuilder) -> {
      List<Predicate> predicates = new ArrayList<>();

      if (Objects.nonNull(filterRequest.getId())) {
        predicates.add(criteriaBuilder.equal(root.get("id"), filterRequest.getId()));
      }

      if (Objects.nonNull(filterRequest.getName())) {
        predicates.add(criteriaBuilder.equal(root.get("name"), filterRequest.getName()));
      }

      return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
    }));
  }
}

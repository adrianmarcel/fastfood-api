package br.com.fiap.service.fastfood.infrastructure.persistence.repository.customer;

import br.com.fiap.service.fastfood.domain.model.customer.CustomerFilterRequest;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.data.jpa.domain.Specification;

public final class CustomerSpecification {

  private CustomerSpecification() {}

  public static Specification<CustomerEntity> build(CustomerFilterRequest filterRequest) {
    return (((root, query, criteriaBuilder) -> {
      List<Predicate> predicates = new ArrayList<>();

      if (Objects.nonNull(filterRequest.getDocument())) {
        predicates.add(criteriaBuilder.equal(root.get("document"), filterRequest.getDocument()));
      }

      return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
    }));
  }
}

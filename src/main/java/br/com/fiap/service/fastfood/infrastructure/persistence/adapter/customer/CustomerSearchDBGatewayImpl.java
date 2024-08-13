package br.com.fiap.service.fastfood.infrastructure.persistence.adapter.customer;

import br.com.fiap.service.fastfood.application.port.output.customer.CustomerSearchGateway;
import br.com.fiap.service.fastfood.domain.model.customer.CustomerFilterRequest;
import br.com.fiap.service.fastfood.domain.model.customer.CustomerGatewayResponse;
import br.com.fiap.service.fastfood.infrastructure.persistence.repository.customer.CustomerRepository;
import br.com.fiap.service.fastfood.infrastructure.persistence.repository.customer.CustomerSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerSearchDBGatewayImpl implements CustomerSearchGateway {

  private final CustomerRepository repository;

  @Override
  public Page<CustomerGatewayResponse> execute(
      CustomerFilterRequest filterRequest, Pageable pageable) {
    return repository
        .findAll(CustomerSpecification.build(filterRequest), pageable)
        .map(CustomerGatewayResponse::mapper);
  }
}

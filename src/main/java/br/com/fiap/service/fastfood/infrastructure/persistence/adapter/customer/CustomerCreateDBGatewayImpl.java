package br.com.fiap.service.fastfood.infrastructure.persistence.adapter.customer;

import br.com.fiap.service.fastfood.application.port.output.customer.CustomerCreateGateway;
import br.com.fiap.service.fastfood.domain.model.customer.CustomerGatewayRequest;
import br.com.fiap.service.fastfood.domain.model.customer.CustomerGatewayResponse;
import br.com.fiap.service.fastfood.infrastructure.persistence.repository.customer.CustomerEntity;
import br.com.fiap.service.fastfood.infrastructure.persistence.repository.customer.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerCreateDBGatewayImpl implements CustomerCreateGateway {

  private final CustomerRepository repository;

  @Override
  public CustomerGatewayResponse execute(CustomerGatewayRequest request) {
    return CustomerGatewayResponse.mapper(repository.save(CustomerEntity.mapper(request)));
  }
}

package br.com.fiap.service.fastfood.application.service.customer;

import br.com.fiap.service.fastfood.application.port.input.customer.CustomerSearchUseCase;
import br.com.fiap.service.fastfood.application.port.output.customer.CustomerSearchGateway;
import br.com.fiap.service.fastfood.domain.model.customer.CustomerFilterRequest;
import br.com.fiap.service.fastfood.domain.model.customer.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerSearchUseCaseImpl implements CustomerSearchUseCase {

  private final CustomerSearchGateway searchGateway;

  @Override
  public Page<CustomerResponse> execute(CustomerFilterRequest filterRequest, Pageable pageable) {
    return searchGateway.execute(filterRequest, pageable).map(CustomerResponse::mapper);
  }
}

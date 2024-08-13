package br.com.fiap.service.fastfood.application.port.input.customer;

import br.com.fiap.service.fastfood.domain.model.customer.CustomerFilterRequest;
import br.com.fiap.service.fastfood.domain.model.customer.CustomerResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerSearchUseCase {

  Page<CustomerResponse> execute(CustomerFilterRequest filterRequest, Pageable pageable);
}

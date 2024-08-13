package br.com.fiap.service.fastfood.application.port.output.customer;

import br.com.fiap.service.fastfood.domain.model.customer.CustomerFilterRequest;
import br.com.fiap.service.fastfood.domain.model.customer.CustomerGatewayResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerSearchGateway {

  Page<CustomerGatewayResponse> execute(CustomerFilterRequest filterRequest, Pageable pageable);
}

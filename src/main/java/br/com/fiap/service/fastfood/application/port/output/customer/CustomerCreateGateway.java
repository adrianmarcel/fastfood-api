package br.com.fiap.service.fastfood.application.port.output.customer;

import br.com.fiap.service.fastfood.domain.model.customer.CustomerGatewayRequest;
import br.com.fiap.service.fastfood.domain.model.customer.CustomerGatewayResponse;

public interface CustomerCreateGateway {

  CustomerGatewayResponse execute(CustomerGatewayRequest request);
}

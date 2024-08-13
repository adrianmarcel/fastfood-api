package br.com.fiap.service.fastfood.application.port.input.customer;

import br.com.fiap.service.fastfood.domain.model.customer.CustomerRequest;
import br.com.fiap.service.fastfood.domain.model.customer.CustomerResponse;
import jakarta.validation.Valid;

public interface CustomerCreateUseCase {

  CustomerResponse execute(@Valid CustomerRequest request);
}

package br.com.fiap.service.fastfood.application.service.customer;

import br.com.fiap.service.fastfood.application.port.input.customer.CustomerCreateUseCase;
import br.com.fiap.service.fastfood.application.port.output.customer.CustomerCreateGateway;
import br.com.fiap.service.fastfood.application.port.output.customer.CustomerSearchGateway;
import br.com.fiap.service.fastfood.domain.model.customer.CustomerFilterRequest;
import br.com.fiap.service.fastfood.domain.model.customer.CustomerGatewayRequest;
import br.com.fiap.service.fastfood.domain.model.customer.CustomerRequest;
import br.com.fiap.service.fastfood.domain.model.customer.CustomerResponse;
import br.com.fiap.service.fastfood.domain.shared.exception.BusinessException;
import br.com.fiap.service.fastfood.domain.shared.exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerCreateUseCaseImpl implements CustomerCreateUseCase {

  private final CustomerCreateGateway createGateway;
  private final CustomerSearchGateway searchGateway;

  @Override
  public CustomerResponse execute(CustomerRequest request) {
    var customer =
        searchGateway
            .execute(
                CustomerFilterRequest.builder().document(request.getDocument()).build(),
                Pageable.unpaged())
            .stream()
            .findFirst();

    if (customer.isPresent()) {
      throw new BusinessException(ExceptionCode.CUSTOMER_ALREADY_EXISTS);
    }

    return CustomerResponse.mapper(createGateway.execute(CustomerGatewayRequest.mapper(request)));
  }
}

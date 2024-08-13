package br.com.fiap.service.fastfood.application.service.order;

import br.com.fiap.service.fastfood.application.port.input.order.OrderCreateUseCase;
import br.com.fiap.service.fastfood.application.port.output.order.OrderCreateGateway;
import br.com.fiap.service.fastfood.application.port.output.product.ProductSearchGateway;
import br.com.fiap.service.fastfood.domain.model.order.*;
import br.com.fiap.service.fastfood.domain.model.product.ProductFilterRequest;
import br.com.fiap.service.fastfood.domain.shared.exception.BusinessException;
import br.com.fiap.service.fastfood.domain.shared.exception.ExceptionCode;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderCreateUseCaseImpl implements OrderCreateUseCase {

  private final ObjectMapper objectMapper;
  private final OrderCreateGateway createGateway;
  private final ProductSearchGateway productSearchGateway;

  @Override
  @SneakyThrows
  public OrderResponse execute(OrderRequest request) {
    validateProducts(request.getProducts());

    var gatewayRequest =
        OrderGatewayRequest.builder()
            .customer(request.getCustomer())
            .products(objectMapper.writeValueAsString(request.getProducts()))
            .status(OrderStatus.RECEBIDO.getDescription())
            .mercadoPagoPaymentId(UUID.randomUUID())
            .build();

    var gatewayResponse = createGateway.execute(gatewayRequest);

    List<OrderProductRequest> mappedProducts =
        objectMapper.readValue(gatewayResponse.getProducts(), new TypeReference<>() {});

    return OrderResponse.builder()
        .id(gatewayResponse.getId())
        .customer(gatewayResponse.getCustomer())
        .products(mappedProducts)
        .status(gatewayResponse.getStatus())
        .mercadoPagoPaymentId(gatewayResponse.getMercadoPagoPaymentId())
        .createdAt(gatewayResponse.getCreatedAt())
        .updatedAt(gatewayResponse.getUpdatedAt())
        .build();
  }

  private void validateProducts(List<OrderProductRequest> products) {
    products.forEach(
        product -> {
          var filterRequest = ProductFilterRequest.builder().id(product.getId()).build();

          productSearchGateway
              .execute(filterRequest, Pageable.unpaged())
              .stream()
              .findFirst()
              .orElseThrow(() -> new BusinessException(ExceptionCode.PRODUCT_NOT_FOUND));
        });
  }
}

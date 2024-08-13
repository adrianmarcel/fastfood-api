package br.com.fiap.service.fastfood.application.port.output.product;

import br.com.fiap.service.fastfood.domain.model.product.ProductGatewayRequest;
import br.com.fiap.service.fastfood.domain.model.product.ProductGatewayResponse;
import java.util.Optional;

public interface ProductUpdateGateway {

  Optional<ProductGatewayResponse> execute(ProductGatewayRequest request);
}

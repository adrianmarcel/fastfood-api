package br.com.fiap.service.fastfood.application.port.output.product;

import br.com.fiap.service.fastfood.domain.model.product.ProductFilterRequest;
import br.com.fiap.service.fastfood.domain.model.product.ProductGatewayResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductSearchGateway {

  Page<ProductGatewayResponse> execute(ProductFilterRequest filterRequest, Pageable pageable);
}

package br.com.fiap.service.fastfood.application.port.input.order;

import br.com.fiap.service.fastfood.domain.model.order.OrderFilterRequest;
import br.com.fiap.service.fastfood.domain.model.order.OrderResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderSearchUseCase {

  Page<OrderResponse> execute(@Valid OrderFilterRequest request, Pageable pageable);
}

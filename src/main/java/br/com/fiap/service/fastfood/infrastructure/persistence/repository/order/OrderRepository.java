package br.com.fiap.service.fastfood.infrastructure.persistence.repository.order;

import br.com.fiap.service.fastfood.infrastructure.persistence.repository.BaseRepository;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends BaseRepository<OrderEntity, UUID> {}

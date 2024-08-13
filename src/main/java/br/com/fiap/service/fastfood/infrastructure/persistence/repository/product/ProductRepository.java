package br.com.fiap.service.fastfood.infrastructure.persistence.repository.product;

import br.com.fiap.service.fastfood.infrastructure.persistence.repository.BaseRepository;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends BaseRepository<ProductEntity, UUID> {}

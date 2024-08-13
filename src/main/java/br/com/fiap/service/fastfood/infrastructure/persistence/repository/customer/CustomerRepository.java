package br.com.fiap.service.fastfood.infrastructure.persistence.repository.customer;

import br.com.fiap.service.fastfood.infrastructure.persistence.repository.BaseRepository;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends BaseRepository<CustomerEntity, UUID> {}

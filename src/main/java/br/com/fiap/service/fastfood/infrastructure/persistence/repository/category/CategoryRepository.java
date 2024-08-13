package br.com.fiap.service.fastfood.infrastructure.persistence.repository.category;

import br.com.fiap.service.fastfood.infrastructure.persistence.repository.BaseRepository;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends BaseRepository<CategoryEntity, UUID> {}

package br.com.fiap.service.fastfood.infrastructure.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan("br.com.fiap")
public class EntityConfiguration {}

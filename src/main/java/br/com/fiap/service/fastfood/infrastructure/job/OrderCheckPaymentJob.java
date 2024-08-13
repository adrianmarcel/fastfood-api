package br.com.fiap.service.fastfood.infrastructure.job;

import br.com.fiap.service.fastfood.application.port.input.order.OrderCheckPaymentUseCase;
import br.com.fiap.service.fastfood.domain.model.order.OrderStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.core.SchedulerLock;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
@ConditionalOnProperty(
  prefix = "app",
  name = "jobs.order-check-payment.enabled",
  havingValue = "true",
  matchIfMissing = true
)
public class OrderCheckPaymentJob {

  private final OrderCheckPaymentUseCase checkPaymentUseCase;

  @Scheduled(fixedDelayString = "${app.jobs.token-expire-caching.delay}")
  @SchedulerLock(
    name = "fastfood-service.order-check-payment-job",
    lockAtLeastForString = "PT30S",
    lockAtMostForString = "PT30S"
  )
  public void execute() {
    checkPaymentUseCase.execute(OrderStatus.RECEBIDO);
  }
}

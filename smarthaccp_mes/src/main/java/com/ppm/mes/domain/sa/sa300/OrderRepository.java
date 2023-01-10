package com.ppm.mes.domain.sa.sa300;

import org.springframework.stereotype.Repository;

import com.chequer.axboot.core.domain.base.AXBootJPAQueryDSLRepository;

@Repository
public interface OrderRepository extends AXBootJPAQueryDSLRepository<Order, Order.OrderId> {
}

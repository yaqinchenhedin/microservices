package com.in28minutes.springboot.microservice.example.forex;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
    ExchangeValue findByFromAndTo(String from, String to);
    List<ExchangeValue> findByFrom(String from);
    List<ExchangeValue> findByConversionMultiple(BigDecimal conversionMultiple);
    List<ExchangeValue> findAll();
}
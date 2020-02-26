package com.in28minutes.springboot.microservice.example.forex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.logging.Logger;


@RestController
public class ForexController {

    @Autowired
    private Environment environment;
    @Autowired
    private ExchangeValueRepository repository;

    private final static Logger LOGGER = Logger.getLogger(ForexController.class.getName());

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        LOGGER.info("**************from=" + from + " && to=" + to);

        ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));

        //YAQIN'S TEST CODE
        ExchangeValue exchangeValue1 = new ExchangeValue(999L, "EUR", "RMB", new BigDecimal(5.23));
        repository.save(exchangeValue1);

        return exchangeValue;
    }

    @RequestMapping("/")
    public String index() {

        return "Greetings from Spring Boot!----with github connected";
    }
}
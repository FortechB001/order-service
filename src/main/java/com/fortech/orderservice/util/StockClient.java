package com.fortech.orderservice.util;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "STOCK-SERV")
public interface StockClient {

    @RequestMapping(value = "/stock/update", method = RequestMethod.PUT)
    void removeFromStock(@RequestParam(name = "productId") String productId, @RequestParam(name = "howMany") Integer howMany);
}

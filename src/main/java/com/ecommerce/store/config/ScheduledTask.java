package com.ecommerce.store.config;

import com.ecommerce.store.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

    @Autowired
    ICartService iCartService;

    @Scheduled(fixedRateString = "${ttl.time}")
    public void taskDelete() {
        iCartService.deleteAll();
    }
}

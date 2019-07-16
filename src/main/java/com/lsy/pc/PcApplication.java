package com.lsy.pc;

import com.lsy.pc.service.OPPOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PcApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(PcApplication.class, args);
    }

}

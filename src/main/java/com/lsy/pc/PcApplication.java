package com.lsy.pc;

import com.lsy.pc.service.OPPOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PcApplication {

    @Autowired
    OPPOService oppoService;
    public static void main(String[] args) {

        SpringApplication.run(PcApplication.class, args);
        Long l = 10000000000L;

    }

}

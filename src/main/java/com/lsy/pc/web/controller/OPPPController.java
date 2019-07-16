package com.lsy.pc.web.controller;

import com.lsy.pc.service.OPPOService;
import com.lsy.pc.web.request.OPPOBreakCodeRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LSY
 * @version 1.0
 * @date 2019/7/16 10:16
 */
@RestController
@RequestMapping("/pc/oppo")
public class OPPPController {

    private final OPPOService oppoService;

    @Value("${oppo.threadNum}")
    private int threadNum;

    public OPPPController(OPPOService oppoService) {
        this.oppoService = oppoService;
    }

    @PostMapping("/break/pwd")
    public void breakPwd(@RequestBody OPPOBreakCodeRequest oppoBreakCodeRequest) {
        oppoService.checkPwd(oppoBreakCodeRequest.getName(), threadNum, 0L);
    }
}

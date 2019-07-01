package com.lsy.pc.service;

import com.lsy.pc.post.ShanghaiOppoPost;

import org.springframework.stereotype.Service;

@Service
public class OPPOService {

    public void checkPwd(String name, int threadNum, Long start) {
        ShanghaiOppoPost shanghaiOppoPost = new ShanghaiOppoPost();
        shanghaiOppoPost.checkPwd(name, threadNum, start);
    }

}

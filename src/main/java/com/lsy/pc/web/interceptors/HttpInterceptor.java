/**
 * BrandBigData.com Inc. Copyright (c) 2018 All Rights Reserved.
 */
package com.lsy.pc.web.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class HttpInterceptor implements ClientHttpRequestInterceptor {

    private static final Logger log = LoggerFactory.getLogger(HttpInterceptor.class);

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        ClientHttpResponse response = execution.execute(request, body);
        traceRequest(request, body);
        traceResponse(response);
        return response;
    }

    private void traceRequest(HttpRequest request, byte[] body) throws IOException {
//        log.info("===========================request begin================================================");
//        log.info("URI         : {}", request.getURI());
//        log.info("Method      : {}", request.getMethod());
//        log.info("Headers     : {}", request.getHeaders());
//        log.info("Request body: {}", new String(body, "UTF-8"));
//        log.info("==========================request end================================================");
    }

    private void traceResponse(ClientHttpResponse response) throws IOException {
//        StringBuilder inputStringBuilder = new StringBuilder();
//        BufferedReader bufferedReader = new BufferedReader(
//                new InputStreamReader(response.getBody(), StandardCharsets.UTF_8));
//        String line = bufferedReader.readLine();
//        while (line != null) {
//            inputStringBuilder.append(line);
//            inputStringBuilder.append('\n');
//            line = bufferedReader.readLine();
//        }
//        log.info("============================response begin==========================================");
//        log.info("Status code  : {}", response.getStatusCode());
//        log.info("Status text  : {}", response.getStatusText());
//        log.info("Headers      : {}", response.getHeaders());
//        log.info("Response body: {}", inputStringBuilder.toString());
//        log.info("=======================response end=================================================");
    }
}
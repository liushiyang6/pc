/**
 * BrandBigData.com Inc. Copyright (c) 2016 All Rights Reserved.
 */
package com.lsy.pc.component;

import com.google.common.collect.Lists;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class HostUtils {

    private static final Logger logger = LoggerFactory.getLogger(HostUtils.class);

    public HostUtils() {
    }

    public static List<String> getServerIpList() {
        ArrayList serverIpList = Lists.newArrayList();

        try {
            Enumeration netInterfaces = NetworkInterface.getNetworkInterfaces();
            while (netInterfaces.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();
                Enumeration inetAddresses = ni.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress ip = (InetAddress) inetAddresses.nextElement();
                    if (StringUtils.isNotEmpty(ip.getHostAddress()) && !ip.isLoopbackAddress() && !ip.getHostAddress().contains(":")) {
                        serverIpList.add(ip.getHostAddress());
                    }
                }
            }
        } catch (SocketException var5) {
            throw new RuntimeException(var5.getMessage(), var5);
        }

        logger.info("获取到当前server的ip为：{}", serverIpList);
        return serverIpList;
    }

    public static String getServerIp() {
        return getServerIpList().get(0);
    }

    public static String getHostName() {
        return System.getenv("COMPUTERNAME") != null ? System.getenv("COMPUTERNAME") : getHostNameForLiunx();
    }

    public static String getPid() {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        return StringUtils.substringBefore(name, "@");
    }

    private static String getHostNameForLiunx() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException var3) {
            String host = var3.getMessage();
            if (host != null) {
                int colon = host.indexOf(58);
                if (colon > 0) {
                    return host.substring(0, colon);
                }
            }

            return "UnknownHost";
        }
    }

}

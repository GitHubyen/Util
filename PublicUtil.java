package com.fh.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * DateTime: 2016/9/17 15:39
 * 功能：获取项目地址及本机IP
 * 思路：
 */
public class PublicUtil {

    //测试
    public static void main(String[] args) {
        System.out.println(getProjectPath()+"\n"+getIp());
    }

    //获取项目地址
    public static String getProjectPath(){
        String nowPath="";
        nowPath=System.getProperty("user.dir")+"/";
        return nowPath;
    }

    //获取本机IP
    public static String getIp(){
        String ip="";
        try {
            InetAddress inet=InetAddress.getLocalHost();
            ip=inet.getHostAddress();
        } catch ( UnknownHostException e ) {
            e.printStackTrace();
        }
        return ip;
    }
}

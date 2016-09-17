package com.fh.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * DateTime: 2016/9/17 15:34
 * 功能：路径工具类：截取特定路径、获取ClassPath、获取URl地址
 * 思路：
 */
public class PathUtil {

    //测试
    public static void main(String[] args) {
        System.out.println("splitString:"+splitString("E:java/IDEA/bin/Helloworld.java","bin/")+"\n");
        //System.out.println("getPicturePath:"+getPicturePath("save","topic"));
        System.out.println("getClasspath:"+getClasspath());
        System.out.println("getClassResources:"+getClassResources());
        System.out.println("pathAddress:"+pathAddress());
    }

    /**
     * 截取特定路径
     * eg：splitString("E:java/IDEA/bin/Helloworld.java","bin/") 输出：E:java/IDEA/
     * @param str   全路径
     * @param param 分隔符
     * @return
     */
    private static String splitString(String str,String param){
        String result=str;
        if(str.contains(param)){
            int start=str.indexOf(param);
            result=str.substring(0,start);
        }
        return result;
    }

    /**
     * 图片访问路径
     * @param pathType  图片类型：visit-访问；save-保存
     * @param pathCategory  图片类别：话题图片-topic、话题回复图片-reply
     * @return
     */
    public static String getPicturePath(String pathType,String pathCategory){
        String strResult="";
        HttpServletRequest request=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        StringBuffer strBuf=new StringBuffer();
        if("visit".equals(pathType)){

        }else if("save".equals(pathType)){
            String projectPath=PublicUtil.getProjectPath().replaceAll("\\\\","/");
            projectPath=splitString(projectPath,"bin/");
            strBuf.append(projectPath);
            strBuf.append("webapps/ROOT/");
        }
        strResult=strBuf.toString();
        return strResult;
    }

    /**
     * 获取Classpath
     * eg:getClasspath:E:/JAVA/IDEA/JavaProject/FH/out/production/FH/../../
     * @return
     */
    public static String getClasspath(){
        String path=(String.valueOf(Thread.currentThread().getContextClassLoader().getResource(""))+"../../").replaceAll("file:/","").replaceAll("%20"," ").trim();
        if(1!=path.indexOf(":")){
            path= File.separator+path;
        }
        return path;
    }

    /**
     * 获取Classpath
     * eg:getClassResources:E:/JAVA/IDEA/JavaProject/FH/out/production/FH/
     * @return
     */
    public static String getClassResources(){
        String path =  (String.valueOf(Thread.currentThread().getContextClassLoader().getResource(""))).replaceAll("file:/", "").replaceAll("%20", " ").trim();
        if(path.indexOf(":") != 1){
            path = File.separator + path;
        }
        return path;
    }

    /**
     * 获取地址
     * @return
     */
    public static String pathAddress(){
        String strResult="";
        HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        StringBuffer strBuf=new StringBuffer();

        strBuf.append(request.getScheme()+"://");   //协议
        strBuf.append(request.getServletPath()+":");//服务器地址
        strBuf.append(request.getServerPort()+"");  //端口号
        strBuf.append(request.getContextPath()+"/"); //上下文路径

        strResult=strBuf.toString();
        return strResult;
    }

}

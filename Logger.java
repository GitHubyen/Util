package com.fh.util;

/**
 * DateTime: 2016/9/17 14:03
 * 功能：Log4j的日志对象
 * 思路：
 */
public class Logger {
    private org.apache.log4j.Logger logger;

    /**
     * 构造方法 初始化Log4j日志对象
     * @param log4jLogger
     */
    private Logger(org.apache.log4j.Logger log4jLogger){
        this.logger=log4jLogger;
    }

    /**
     * 获取构造器，根据类初始化Logger对象
     * @param classObject   Class对象
     * @return
     */
    public static Logger getLogger(Class classObject){
        return new Logger(org.apache.log4j.Logger.getLogger(classObject));
    }

    /**
     * 获取构造器，根据类名初始化Logger对象
     * @param loggerName    类名字符串
     * @return
     */
    public static Logger getLogger(String loggerName){
        return new Logger(org.apache.log4j.Logger.getLogger(loggerName));
    }

    public String getName(){
        return logger.getName();
    }

    public org.apache.log4j.Logger getLog4jLogger(){
        return logger;
    }

    public boolean equals(Logger newLogger){
        return logger.equals(newLogger.getLog4jLogger());
    }

    //  记录 fatal(致命错误) 级别的信息
    public void fatal(Object object){
        logger.fatal(object);
    }

    public void fatal(Object object,Throwable e){
        logger.fatal(object,e);
    }
    //  记录 debug(调试) 级别的信息
    public void debug(Object object){
        logger.debug(object);
    }

    public void debug(Object object,Throwable e){
        logger.debug(object,e);
    }

    //  记录 info(一般) 级别的信息
    public void info(Object object){
        logger.info(object);
    }

    public void info(Object object,Throwable e){
        logger.info(object,e);
    }

    //  记录 warn(警告) 级别的信息
    public void warn(Object object){
        logger.warn(object);
    }

    public void warn(Object object,Throwable e){
        logger.info(object,e);
    }

    //  记录 error(错误) 级别的信息
    public void error(Object object){
        logger.error(object);
    }

    public void error(Object object,Throwable e){
        logger.error(object,e);
    }

}

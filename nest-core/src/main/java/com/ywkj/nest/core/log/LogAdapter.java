package com.ywkj.nest.core.log;

import com.ywkj.nest.core.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;

/**
 * Created by Jove on 2016-03-17.
 */
public class LogAdapter implements ILog ,Serializable {
    Logger logger;

    public LogAdapter(Class clazz) {
        logger = LogManager.getLogger(clazz);

    }

    /**
     * 写DEBUG级别的日志
     *
     * @param message 消息
     * @param args    消息参数
     */
    public void debug(String message, Object... args) {

        if (logger.isDebugEnabled()) {
            StringBuilder builder = new StringBuilder();
            builder.append(message);
            for (Object object : args) {
                if (null != object) {
                    builder.append("\n").append(object.getClass()).append("|").append(object.toString());
                }
            }
            logger.debug(builder);
        }

    }

    /**
     * 写INFO级别的日志
     *
     * @param message 消息
     * @param args    消息参数
     */
    public void info(String message, Object... args) {

        if (logger.isInfoEnabled()) {
            StringBuilder builder = new StringBuilder();
            builder.append(message);
            for (Object object : args) {
                if (null != object) {
                    builder.append("\n").append(object.getClass()).append("|").append(object.toString());
                }
            }
            logger.info(builder);
        }

    }

    /**
     * 写WARN级别的日志
     *
     * @param message 消息
     * @param args    消息参数
     */
    public void warn(String message, Object... args) {

        StringBuilder builder = new StringBuilder();
        builder.append(message);
        for (Object object : args) {
            if (null != object) {
                builder.append("\n").append(object.getClass()).append("|").append(object.toString());
            }
        }
        logger.warn(builder);


    }

    /**
     * 写业务级别的异常日志
     *
     * @param ex      系统异常
     */
    public void error(CustomException ex) {

        StringBuilder builder = new StringBuilder();
        if (null != ex) {
            builder.append(ex.getMessage());
        }
        for (Object object : ex.getParames()) {
            if (null != object) {
                builder.append("\n").append(object.getClass()).append("|").append(object.toString());
            }
        }
        String msg = builder.toString();
        logger.error(builder, ex);

    }

    /**
     * 写系统级别失败的异常日志
     *
     * @param ex   自定义异常
     * @param args 异常参数
     */
    public void fatal(Exception ex, Object... args) {

        StringBuilder builder = new StringBuilder();
        if (null != ex) {
            builder.append(ex.getMessage());
        }
        for (Object object : args) {
            if (null != object) {
                builder.append("\n").append(object.getClass()).append("|").append(object.toString());
            }
        }
        logger.fatal(builder, ex);

    }

}

package com.ywkj.nest.ddd;

import java.util.Properties;

/**
 * 事件通道提供者
 * Created by Jove on 2016-03-21.
 */
public abstract class AbstractChannelProvider implements IEventPublish, IEventSubscribe {

    /**
     * 提供相关的配置项
     */
    protected Properties properties;

}


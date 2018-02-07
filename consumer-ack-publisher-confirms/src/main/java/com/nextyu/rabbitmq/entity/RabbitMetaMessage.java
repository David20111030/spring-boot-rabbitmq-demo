package com.nextyu.rabbitmq.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class RabbitMetaMessage implements Serializable{
    private boolean returnCallback;
    private Object payload;

    public RabbitMetaMessage(Object payload) {
        this.payload = payload;
    }
}

package com.sparta.myblog.dto;

import lombok.Getter;

@Getter
public class SendMessageDto {
    private String message;
    public void sendMessage(String message)
    {
        this.message = message;
    }
}

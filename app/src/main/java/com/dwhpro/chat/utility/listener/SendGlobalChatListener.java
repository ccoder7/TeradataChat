package com.dwhpro.chat.utility.listener;

import com.dwhpro.chat.model.Chat;

/**
 * Created by Ravi on 11/19/2016.
 */

public interface SendGlobalChatListener {
    void scrollToBottom() ;
    void addChat(Chat chat);
    void updateChat(Chat chat);
    void removeChat(String idChat);
}

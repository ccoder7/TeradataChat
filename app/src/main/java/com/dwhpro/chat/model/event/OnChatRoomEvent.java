package com.dwhpro.chat.model.event;

import com.dwhpro.chat.model.Room;

/**
 * Created by Ravi on 11/27/2016.
 */

public class OnChatRoomEvent {
    public final Room room;

    public OnChatRoomEvent(Room room){
        this.room = room;
    }
}

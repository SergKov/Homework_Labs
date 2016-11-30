package laba1.controller;

import laba1.Room;
import laba1.view.View;

/**
 * Created by koval on 29.11.2016.
 */
public class RoomController {

    private Room room;
    private View view;

    public RoomController(Room room, View view) {
        this.room = room;
        this.view = view;
    }
}

package com.library.app.demo;

import java.util.ArrayList;

public class SushiOrder {
    int seatId;
    ArrayList<String> menuItemIds;
    public SushiOrder(int seatId, ArrayList<String> menuItemIds){

        this.seatId = seatId;
        this.menuItemIds= menuItemIds;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public ArrayList<String> getMenuItemIds() {
        return menuItemIds;
    }

    public void setMenuItemIds(ArrayList<String> menuItemIds) {
        this.menuItemIds = menuItemIds;
    }
}

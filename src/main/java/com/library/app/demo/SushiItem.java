package com.library.app.demo;

public class SushiItem {

    public SushiItem(int seatId, String menuItemId) {

        this.SeatId= seatId;
        this.menuItemId = menuItemId;
    }
    int SeatId;
    String menuItemId;

    public void setSeatId(int seatId) {
        SeatId = seatId;
    }

    public void setMenuItemId(String menuItemId) {
        this.menuItemId = menuItemId;
    }
}

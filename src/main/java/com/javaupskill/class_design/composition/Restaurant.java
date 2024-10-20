package com.javaupskill.class_design.composition;

public class Restaurant {
    private Kitchen kitchen;

    public Restaurant(Kitchen kitchen) {
        this.kitchen = kitchen;
    }

    public Kitchen getKitchen() {
        return kitchen;
    }

    public void setKitchen(Kitchen kitchen) {
        this.kitchen = kitchen;
    }

    public void showDailyMenu() {
        kitchen.prepareMenu();
    }
}

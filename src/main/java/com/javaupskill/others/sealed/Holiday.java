package com.javaupskill.others.sealed;

public sealed class Holiday permits MountainHoliday, SeaHoliday {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

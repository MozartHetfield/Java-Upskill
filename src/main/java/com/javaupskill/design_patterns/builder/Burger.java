package com.javaupskill.design_patterns.builder;

public class Burger {
    // required
    private String bun;
    private String meat;
    private String sauce;

    // optional
    private String tomato;
    private String lettuce;
    private String onion;

    public Burger(String bun, String meat, String sauce, String tomato, String lettuce, String onion) {
        this.bun = bun;
        this.meat = meat;
        this.sauce = sauce;
        this.tomato = tomato;
        this.lettuce = lettuce;
        this.onion = onion;
    }

    public String getBun() {
        return bun;
    }

    public void setBun(String bun) {
        this.bun = bun;
    }

    public String getMeat() {
        return meat;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public String getTomato() {
        return tomato;
    }

    public void setTomato(String tomato) {
        this.tomato = tomato;
    }

    public String getLettuce() {
        return lettuce;
    }

    public void setLettuce(String lettuce) {
        this.lettuce = lettuce;
    }

    public String getOnion() {
        return onion;
    }

    public void setOnion(String onion) {
        this.onion = onion;
    }

    @Override
    public String toString() {
        return "Burger{" +
                "bun='" + bun + '\'' +
                ", meat='" + meat + '\'' +
                ", sauce='" + sauce + '\'' +
                ", tomato='" + tomato + '\'' +
                ", lettuce='" + lettuce + '\'' +
                ", onion='" + onion + '\'' +
                '}';
    }

    public static class Builder {
        // required
        private String bun;
        private String meat;
        private String sauce;

        // optional
        private String tomato;
        private String lettuce;
        private String onion;

        public Builder setBun(String bun) {
            this.bun = bun;
            return this;
        }

        public Builder setMeat(String meat) {
            this.meat = meat;
            return this;
        }

        public Builder setSauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public Builder setTomato(String tomato) {
            this.tomato = tomato;
            return this;
        }

        public Builder setLettuce(String lettuce) {
            this.lettuce = lettuce;
            return this;
        }

        public Builder setOnion(String onion) {
            this.onion = onion;
            return this;
        }

        public Burger build() {
            return new Burger(bun, meat, sauce, tomato, lettuce, onion);
        }
    }


}

package com.javaupskill.others;

//class MainChild extends Main {
//    @Override
//    public void test() {
//
//    }
//}

public final class Main {
    public static void main(String[] args) {
//        switchExpressions();
//        final String text = "ceva";
//        text = "altceva";

        records();


    }

    private static void records() {
        Game game = new Game("Chess", 5);
        Game game2 = new Game(4);
        System.out.println(game.name());
        System.out.println(game2.name());
    }


    public final void test() {

    }

    private static void switchExpressions() {
        // statement examples:

        int a = 5;
        if (a > 5) {
            System.out.println(a);
        }

        // expression examples:
//        3 > 2;
//        a % 2 == 0;
//        a % 2;

        switch (a) {
            case 3 -> System.out.println("numar prea mic");
            case 6 -> System.out.println("numar bun!");
            case 10 -> System.out.println("numar prea mare");
            default -> System.out.println("numar necunoscut");
        }

        System.out.println(
                switch (a) {
                    case 3 -> "numar prea mic";
                    case 6 -> "numar bun!";
                    case 10 -> "numar prea mare";
                    default -> "numar necunoscut";
                }
        );
    }


}

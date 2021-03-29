package hexlet.code;

import java.util.Scanner;

public final class Cli implements Game {
    private static final Scanner IN = new Scanner(System.in);

    protected void finalize() throws Throwable {
        super.finalize();
        IN.close();
    }

    public String name() {
        return "Greet";
    }

    public int start() {
        greeting();
        return 0;
    }

    private void greeting() {
        String name = input("May I have your name? ");
        System.out.println("Hello, " + name + "!");
    }

    public static String input(final String welcomeMsg) {
        System.out.print(welcomeMsg);
        return IN.nextLine();
    }
}

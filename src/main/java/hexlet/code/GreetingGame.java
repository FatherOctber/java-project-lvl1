package hexlet.code;

public class GreetingGame implements Game {
    public String name() {
        return "Greet";
    }

    public int start() {
        greeting();
        return 0;
    }

    private void greeting() {
        String name = Cli.input("May I have your name? ");
        System.out.println("Hello, " + name + "!");
    }
}
package hexlet.code;

public final class GreetingGame extends Game {
    public String name() {
        return "Greet";
    }

    @Override
    protected boolean round() {
        greeting();
        return false;
    }

    private void greeting() {
        String name = Cli.input("May I have your name? ");
        System.out.println("Hello, " + name + "!");
    }
}

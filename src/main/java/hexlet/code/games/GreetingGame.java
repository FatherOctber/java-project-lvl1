package hexlet.code.games;

import hexlet.code.Cli;

public final class GreetingGame extends Game {
    public String name() {
        return "Greet";
    }

    @Override
    protected Result round() {
        greeting();
        return Result.noAnswer();
    }

    private void greeting() {
        String name = Cli.input("May I have your name? ");
        System.out.println("Hello, " + name + "!");
    }
}

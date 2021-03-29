package hexlet.code.games;

public final class GreetingGame extends Game {
    public String name() {
        return "Greet";
    }

    @Override
    protected Result round() {
        return Result.noAnswer();
    }
}

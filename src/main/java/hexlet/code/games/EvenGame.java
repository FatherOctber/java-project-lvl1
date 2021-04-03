package hexlet.code.games;

import java.util.function.Function;

public final class EvenGame {
    public static final String NAME = "Even";
    public static final String GAME_CONDITION = "Answer 'yes' if number even"
            + " otherwise answer 'no'.";

    public static final Function<Integer, String> EVEN
            = (number) -> {
        if (number % 2 == 0) {
            return "yes";
        } else {
            return "no";
        }
    };
}

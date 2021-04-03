package hexlet.code.games;

import java.math.BigInteger;
import java.util.function.Function;

public final class Prime {
    private static final int PRIME_CERTAINTY = 100;
    public static final String NAME = "Prime";
    public static final String GAME_CONDITION =
            "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static final Function<
            Integer,
            String> PRIME = (number) -> {
        var prime = BigInteger.valueOf(number)
                .isProbablePrime(PRIME_CERTAINTY);
        if (prime) {
            return "yes";
        } else {
            return "no";
        }
    };
}

package hexlet.code.games;

import java.math.BigInteger;
import java.util.function.Function;

public final class GCDGame {
    public static final String NAME = "GCD";
    public static final String GAME_CONDITION
            = "Find the greatest common divisor of given numbers.";

    public static final Function<
            String,
            Integer> GCD = (rawExpression) -> {
        String[] expression = rawExpression.split(" ");
        var result = BigInteger.valueOf(Long.parseLong(expression[0]))
                .gcd(BigInteger.valueOf(Long.parseLong(expression[1])));
        return result.intValue();
    };

}

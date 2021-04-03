package hexlet.code.games;

import java.util.function.Function;

public final class CaclGame {
    public static final String NAME = "Calc";
    public static final String GAME_CONDITION
            = "What is the result of the expression?";

    public static final Function<
            String,
            Integer> CALCULATE = (rawExpression) -> {
        var sum = rawExpression.split("\\+");
        var sub = rawExpression.split("-");
        var mul = rawExpression.split("\\*");

        if (sum.length == 2) {
            return Integer.parseInt(sum[0].trim())
                    + Integer.parseInt(sum[1].trim());
        }
        if (sub.length == 2) {
            return Integer.parseInt(sub[0].trim())
                    - Integer.parseInt(sub[1].trim());
        }
        if (mul.length == 2) {
            return Integer.parseInt(mul[0].trim())
                    * Integer.parseInt(mul[1].trim());
        }
        return Integer.MIN_VALUE;
    };
}

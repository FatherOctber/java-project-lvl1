package hexlet.code.games;

import hexlet.code.Cli;

import java.math.BigInteger;

public final class GCDGame extends Game {

    @Override
    public String name() {
        return "GCD";
    }

    @Override
    protected Result round() {
        var a = getRandomNumber();
        var b = getRandomNumber();
        System.out.println("Find the greatest common divisor"
                + " of given numbers.");
        System.out.println("Question: " + a + " " + b);
        try {
            var in = Cli.input("Your answer: ");
            var expectedNum = new BigInteger(in);
            var result = BigInteger.valueOf(a).gcd(BigInteger.valueOf(b));
            if (expectedNum.equals(result)) {
                return Result.correct();
            } else {
                return Result.wrong(expectedNum, result);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.noAnswer();
        }
    }

}

package hexlet.code.games;

import hexlet.code.Cli;

import java.math.BigInteger;

public final class Prime extends Game {

    @Override
    public String name() {
        return "Prime";
    }

    @Override
    protected Result round() {
        var number = getRandomNumber();
        System.out.println("Answer 'yes' if given number is prime."
                + " Otherwise answer 'no'.");
        System.out.println("Question: " + number);
        var answer = Cli.input("Your answer: ");
        var prime = BigInteger.valueOf(number).isProbablePrime(100);
        switch (answer) {
            case "yes":
                if (prime) {
                    return Result.correct();
                } else {
                    return Result.wrong("yes", "no");
                }
            case "no":
                if (!prime) {
                    return Result.correct();
                } else {
                    return Result.wrong("no", "yes");
                }
            default:
                return Result.wrong("yes or no", answer);
        }
    }
}

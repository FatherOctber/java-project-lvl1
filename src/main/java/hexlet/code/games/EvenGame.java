package hexlet.code.games;

import hexlet.code.Cli;

public final class EvenGame extends Game {
    @Override
    public String name() {
        return "Even";
    }

    @Override
    protected Result round() {
        var number = getRandomNumber();
        System.out.println("Question: " + number);
        var answer = Cli.input("Your answer: ");
        switch (answer) {
            case "yes":
                if (number % 2 == 0) {
                    return Result.correct();
                } else {
                    return Result.wrong("yes", "no");
                }
            case "no":
                if (number % 2 != 0) {
                    return Result.correct();
                } else {
                    return Result.wrong("no", "yes");
                }
            default:
                return Result.wrong("yes or no", answer);
        }
    }
}

package hexlet.code.games;

import hexlet.code.Cli;

import java.util.ArrayList;
import java.util.List;

public final class Progression extends Game {
    private static final int SEQ_LEN = 10;

    @Override
    public String name() {
        return "Progression";
    }

    @Override
    protected Result round() {
        var firstNumber = getRandomNumber();
        var step = getRandomNumber(10);
        var seq = generateSequence(firstNumber, step);
        var hiddenPosition = getRandomNumber(10) - 1;
        System.out.println("What number is missing in the progression?");
        System.out.print("Question:");
        for (int i = 0; i < seq.size(); i++) {
            if (i == hiddenPosition) {
                System.out.print(" ..");
            } else {
                System.out.print(" " + seq.get(i));
            }
        }
        System.out.println();
        try {
            var in = Cli.input("Your answer: ");
            var expectedNum = Integer.parseInt(in);
            var actual = seq.get(hiddenPosition);
            if (actual == expectedNum) {
                return Result.correct();
            } else {
                return Result.wrong(expectedNum, actual);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return Result.noAnswer();
        }
    }

    public static List<Integer> generateSequence(final int start,
                                                 final int step) {
        var sequence = new ArrayList<Integer>();
        for (int i = 0, currentNumber = start;
             i < SEQ_LEN;
             i++, currentNumber = currentNumber + step) {
            sequence.add(currentNumber);
        }
        return sequence;
    }
}

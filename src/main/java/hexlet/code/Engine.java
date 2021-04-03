package hexlet.code;

import hexlet.code.games.GCDGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.CaclGame;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.function.Function;
import java.util.function.Supplier;

public class Engine {
    private static final int WIN_THRESHOLD = 3;
    private static final int RANDOM_TOP_BORDER = 100;
    private static final int SEQ_LEN = 10;

    public static int start() {
        while (true) {
            System.out.println("Please enter the game number"
                    + " and press Enter.");
            System.out.println("1 - " + Greeting.NAME);
            System.out.println("2 - " + EvenGame.NAME);
            System.out.println("3 - " + CaclGame.NAME);
            System.out.println("4 - " + GCDGame.NAME);
            System.out.println("5 - " + Progression.NAME);
            System.out.println("6 - " + Prime.NAME);
            System.out.println("0 - Exit");
            String choice = Cli.input("Your choice: ");
            try {
                var gameNumber = Integer.parseInt(choice);
                if (gameNumber < 0) {
                    System.out.println("Input number "
                            + "should be grater 0");
                }
                if (gameNumber == 0) {
                    return 0;
                }
                switch (choice) {
                    case "1":
                        greeting();
                        return 0;
                    case "2":
                        return runGameCycle(
                                EvenGame.GAME_CONDITION,
                                Engine::getRandomNumber,
                                EvenGame.EVEN
                        );
                    case "3":
                        return runGameCycle(
                                CaclGame.GAME_CONDITION,
                                Engine::prepareToCalcGame,
                                CaclGame.CALCULATE
                        );
                    case "4":
                        return runGameCycle(
                                GCDGame.GAME_CONDITION,
                                Engine::prepareToGCDGame,
                                GCDGame.GCD
                        );
                    case "5":
                        return runGameCycle(
                                Progression.GAME_CONDITION,
                                Engine::prepareToProgressionGame,
                                Progression.MISSING
                        );
                    case "6":
                        return runGameCycle(
                                Prime.GAME_CONDITION,
                                Engine::getRandomNumber,
                                Prime.PRIME
                        );
                    default:
                        System.out.println("Unknown game with index "
                                + gameNumber);
                }
            } catch (Exception ex) {
                System.err.println("Incorrect variant ("
                        + ex.getMessage() + ")");
            }
        }
    }

    private static int runGameCycle(
            final String condition,
            final Supplier question,
            final Function playbackGame
    ) {
        var winCount = 0;
        var name = greeting();
        while (winCount < WIN_THRESHOLD) {
            System.out.println(condition);
            var questionObject = question.get();
            System.out.println("Question: " + questionObject);
            var answer = Cli.input("Your answer: ");
            var gameResult = playbackGame.apply(questionObject);
            if (gameResult.toString().equals(answer)) {
                System.out.println("Correct!");
                winCount++;
            } else {
                System.out.println("Your answer: " + answer
                        + " is wrong ;(. Correct answer was "
                        + gameResult);
                System.out.println("Let's try again, " + name + "!");
                return 0;
            }
        }
        System.out.println("Congratulations, " + name + "!");
        return 0;
    }

    private static String greeting() {
        System.out.println("Welcome to the Brain Games!");
        String name = Cli.input("May I have your name? ");
        System.out.println(Greeting.hello(name));
        return name;
    }

    private static String prepareToCalcGame() {
        final var a = getRandomNumber();
        final var b = getRandomNumber();
        final int opBorder = 3;
        final var op = getRandomNumber(opBorder);
        String statement = a + " + " + b;
        switch (op) {
            case 0:
                statement = a + " + " + b;
                break;
            case 1:
                statement = a + " - " + b;
                break;
            case 2:
                statement = a + " * " + b;
                break;
            default:
                System.out.println("Unknown operator " + op + ". Set to +");

        }
        return statement;
    }

    private static String prepareToGCDGame() {
        final var a = getRandomNumber();
        final var b = getRandomNumber();
        return a + " " + b;
    }

    private static String prepareToProgressionGame() {
        int[] sequence = new int[SEQ_LEN];
        final int stepBorder = 10;
        final var step = getRandomNumber(stepBorder);
        for (int i = 0, currentNumber = getRandomNumber();
             i < SEQ_LEN;
             i++, currentNumber = currentNumber + step) {
            sequence[i] = currentNumber;
        }
        final var hidden = getRandomNumber(SEQ_LEN);
        String sequenceStr = "";
        for (int i = 0; i < sequence.length; i++, sequenceStr += " ") {
            if (i == hidden) {
                sequenceStr += "..";
            } else {
                sequenceStr += sequence[i];
            }
        }
        return sequenceStr;
    }

    private static int getRandomNumber() {
        return getRandomNumber(RANDOM_TOP_BORDER);
    }

    private static int getRandomNumber(final int topBorder) {
        return (int) ((Math.random() * topBorder - 1) + 1);
    }
}

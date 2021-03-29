package hexlet.code;

public final class EvenGame implements Game {
    private static final int WIN_THRESHOLD = 3;

    @Override
    public String name() {
        return "Even";
    }

    @Override
    public int start() {
        System.out.println("Answer 'yes' if number "
                + "even otherwise answer 'no'.");
        var goodAnswers = 0;
        while (goodAnswers < WIN_THRESHOLD) {
            var number = getRandomNumber();
            System.out.println("Question: " + number);
            var answer = Cli.input("Your answer: ");
            switch (answer) {
                case "yes":
                    if (number % 2 == 0) {
                        goodAnswers++;
                        System.out.println("Correct!");
                    } else {
                        System.out.println("'yes' is wrong answer ;(."
                                + " Correct answer was 'no'.\n"
                                + "Let's try again, Bill!");
                        return 1;
                    }
                    break;
                case "no":
                    if (number % 2 != 0) {
                        goodAnswers++;
                        System.out.println("Correct!");
                    } else {
                        System.out.println("'no' is wrong answer ;(."
                                + " Correct answer was 'yes'.\n"
                                + "Let's try again, Bill!");
                        return 1;
                    }
                    break;
                default:
                    throw new IllegalStateException("Expected 'yes' or 'no'"
                            + " answers. Got " + answer);
            }
        }

        return 0;
    }

    private int getRandomNumber() {
        return (int) ((Math.random() * 99) + 1);
    }
}

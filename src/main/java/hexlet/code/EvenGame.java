package hexlet.code;

public final class EvenGame extends Game {
    private static final int WIN_THRESHOLD = 3;

    @Override
    public String name() {
        return "Even";
    }

    @Override
    protected boolean round() {
        var number = getRandomNumber();
        System.out.println("Question: " + number);
        var answer = Cli.input("Your answer: ");
        switch (answer) {
            case "yes":
                if (number % 2 == 0) {
                    return true;
                } else {
                    System.out.println("'yes' is wrong answer ;(."
                            + " Correct answer was 'no'.\n"
                            + "Let's try again, Bill!");
                    return false;
                }
            case "no":
                if (number % 2 != 0) {
                    return true;
                } else {
                    System.out.println("'no' is wrong answer ;(."
                            + " Correct answer was 'yes'.\n"
                            + "Let's try again, Bill!");
                    return false;
                }
            default:
                throw new IllegalStateException("Expected 'yes' or 'no'"
                        + " answers. Got " + answer);
        }
    }
}

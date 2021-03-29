package hexlet.code;

public abstract class Game {
    static final class Result<A, B> {
        private A expected;
        private B actual;
        private int roundStatus;

        private Result(final A a, final B b, final int status) {
            this.expected = a;
            this.actual = b;
            this.roundStatus = status;
        }

        public static <A, B> Result correct() {
            return new Result(null, null, 0);
        }

        public static <A, B> Result wrong(final A expected, final B actual) {
            return new Result(expected, actual, 1);
        }

        public static <A, B> Result noAnswer() {
            return new Result(null, null, -1);
        }

        public A getExpected() {
            return expected;
        }

        public B getActual() {
            return actual;
        }

        public int getStatus() {
            return roundStatus;
        }
    }

    public abstract String name();

    protected abstract Result round();

    public final int start() {
        var winCount = 0;
        int winThreshold = 3;
        while (winCount < winThreshold) {
            var win = round();
            switch (win.roundStatus) {
                case 0:
                    System.out.println("Correct!");
                    winCount++;
                    break;
                case 1:
                    System.out.println("Your answer: " + win.getExpected()
                            + " is wrong ;(. Correct answer was "
                            + win.getActual());
                    return 1;
                default:
                    return 1;
            }
        }
        return 0;
    }

    protected final int getRandomNumber() {
        return (int) ((Math.random() * 99) + 1);
    }
}

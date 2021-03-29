package hexlet.code;

public abstract class Game {
    public abstract String name();

    protected abstract boolean round();

    public final int start() {
        var winCount = 0;
        int winThreshold = 3;
        while (winCount < winThreshold) {
            var win = round();
            if (win) {
                System.out.println("Correct!");
                winCount++;
            } else {
                return 1;
            }
        }
        return 0;
    }

    protected final int getRandomNumber() {
        return (int) ((Math.random() * 99) + 1);
    }
}

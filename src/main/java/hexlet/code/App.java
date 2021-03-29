package hexlet.code;

import hexlet.code.games.CaclGame;
import hexlet.code.games.Game;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GCDGame;
import hexlet.code.games.GreetingGame;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App {

    private static class Launcher {
        private final Map<Integer, Game> games;

        Launcher(final List<Game> gameList) {
            this.games = IntStream.range(0, gameList.size())
                    .boxed()
                    .collect(Collectors.toMap(
                            Function.identity()
                                    .andThen((index) -> (Integer) index + 1),
                            gameList::get)
                    );
        }

        public void showMenu() {
            while (true) {
                System.out.println("Please enter the game number"
                        + " and press Enter.");
                games.forEach((index, game) ->
                        System.out.println(index + " - " + game.name())
                );
                System.out.println("0 - Exit");
                String choice = Cli.input("Your choice: ");
                try {
                    var gameNumber = Integer.parseInt(choice);
                    if (gameNumber < 0) {
                        throw new IllegalArgumentException("Input number "
                                + "should be grater 0");
                    }
                    if (gameNumber == 0) {
                        System.out.println("Bye!");
                        System.exit(0);
                    }
                    var game = games.get(gameNumber);
                    if (game != null) {
                        int retCode = game.start();
                        if (retCode == 0) {
                            System.out.println("Congratulations!");
                        } else {
                            System.out.println("Game over!");
                        }
                    } else {
                        throw new IllegalArgumentException("The game"
                                + " with number "
                                + gameNumber
                                + " doesn`t exist.");
                    }
                } catch (Exception ex) {
                    System.err.println("Incorrect variant ("
                            + ex.getMessage() + ")");
                }
            }
        }

    }

    public static void main(final String[] args) {
        System.out.println("Welcome to the Brain Games!");
        var launcher = new Launcher(Arrays.asList(
                new GreetingGame(),
                new EvenGame(),
                new CaclGame(),
                new GCDGame(),
                new Progression(),
                new Prime()
        ));
        launcher.showMenu();
    }
}

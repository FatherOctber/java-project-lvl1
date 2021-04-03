package hexlet.code.games;

import java.util.function.Function;

public final class Progression {
    public static final String NAME = "Progression";
    public static final String GAME_CONDITION
            = "What number is missing in the progression?";

    public static final Function<
            String,
            Integer> MISSING = (progressionWithMissedNumber) -> {
        String[] parsed = progressionWithMissedNumber.split(" ");
        int[] sourceProgression = new int[parsed.length - 1];
        int j = 0;
        for (var number : parsed) {
            var num = number.trim();
            if (!num.equals("..")) {
                sourceProgression[j] = Integer.parseInt(num);
                j++;
            }
        }
        int d = (sourceProgression[sourceProgression.length - 1]
                - sourceProgression[0]) / sourceProgression.length;
        int low = 0;
        int high = sourceProgression.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (sourceProgression[mid + 1] - sourceProgression[mid] != d) {
                return sourceProgression[mid] + d;
            }

            if (mid > 0
                    && sourceProgression[mid]
                    - sourceProgression[mid - 1] != d) {
                return sourceProgression[mid - 1] + d;
            }

            if (sourceProgression[mid] == sourceProgression[0] + mid * d) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return Integer.MIN_VALUE;
    };
}

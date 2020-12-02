import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class aoc01 {
    public static void main(final String[] args) throws IOException {
        final List<Integer> lines = Files.lines(Path.of("src/main/resources/input01.txt"))
                .map(Integer::valueOf)
                .collect(toList());

        System.out.println(first(lines));
        System.out.println(second(lines));
    }

    private static int first(final List<Integer> lines) {
        for (final Integer line1 : lines) {
            for (final Integer line2 : lines) {
                if (line1 + line2 == 2020) {
                    return line1 * line2;
                }
            }
        }
        return 0;
    }

    private static int second(final List<Integer> lines) {
        for (final Integer line1 : lines) {
            for (final Integer line2 : lines) {
                for (final Integer line3 : lines) {
                    if (line1 + line2 + line3 == 2020) {
                        return line1 * line2 * line3;
                    }
                }
            }
        }
        return 0;
    }
}

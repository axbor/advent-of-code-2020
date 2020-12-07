import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class aoc3 {

    public static void main(final String[] args) throws IOException {
        final List<String> lines = Files.lines(Path.of("src/main/resources/input03.txt"))
                .map(s -> s.repeat(100))
                .collect(toList());

        final BigDecimal first = first(lines, 1, 1);
        final BigDecimal second = first(lines, 3, 1);
        final BigDecimal third = first(lines, 5, 1);
        final BigDecimal fourth = first(lines, 7, 1);
        final BigDecimal fifth = first(lines, 1, 2);

        System.out.println("sum: " + first.multiply(second).multiply(third).multiply(fourth).multiply(fifth));
    }

    private static BigDecimal first(final List<String> lines, int right, int down) {
        int hits = 0;
        int rightCount = right;
        int downCount = down;
        while (downCount < lines.size()) {
            if (lines.get(downCount).charAt(rightCount) == '#') {
                hits++;
            }
            downCount += down;
            rightCount += right;
        }

        System.out.println("hits = " + hits);
        return BigDecimal.valueOf(hits);
    }



}

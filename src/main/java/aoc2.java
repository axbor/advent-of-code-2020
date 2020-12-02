import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class aoc2 {
    public static void main(final String[] args) throws IOException {
        final List<String> lines = Files.readAllLines(Path.of("src/main/resources/input02.txt"));

        System.out.println(first(lines));
    }

    private static long first(final List<String> lines) {
        final long count = lines.stream().filter(aoc2::checkLine).count();
        System.out.println("count = " + count);
        return count;
    }

    private static boolean checkLine(final String s) {
        final String[] spaceSplit = s.split(" ");
        final String numberWithDash = spaceSplit[0];
        final String characterWithColon = spaceSplit[1];
        final String password = spaceSplit[2];

        final String[] number = numberWithDash.split("-");
        final String startNumber = number[0];
        final String endNumber = number[1];

        final String[] colonSplit = characterWithColon.split(":");
        final String character = colonSplit[0];

        final long count = password.chars().filter(ch -> ch == character.charAt(0)).count();
        return count >= Integer.parseInt(startNumber) && count <= Integer.parseInt(endNumber);
    }
}

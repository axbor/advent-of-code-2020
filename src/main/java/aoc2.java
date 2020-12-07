import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class aoc2 {
    public static void main(final String[] args) throws IOException {
        final List<String> lines = Files.readAllLines(Path.of("src/main/resources/input02.txt"));

        System.out.println(first(lines));
        System.out.println(second(lines));
    }

    private static long first(final List<String> lines) {
        final long count = lines.stream().filter(aoc2::checkLine).count();
        System.out.println("count = " + count);
        return count;
    }

    private static long second(final List<String> lines) {
        final long count = lines.stream().filter(aoc2::checkLineAgain).count();
        System.out.println("count = " + count);
        return count;
    }

    private static boolean checkLineAgain(final String s) {
        final String[] spaceSplit = s.split(" ");
        final String numberWithDash = spaceSplit[0];
        final String characterWithColon = spaceSplit[1];
        final String password = spaceSplit[2];

        final String[] number = numberWithDash.split("-");
        final String startNumber = number[0];
        final String endNumber = number[1];

        final String character = getCharacter(characterWithColon);

        final char c = character.charAt(0);
        final char startChar = password.charAt(Integer.parseInt(startNumber) - 1);
        final char endChar = password.charAt(Integer.parseInt(endNumber) - 1);
        if (startChar == c && endChar != c) {
            return true;
        } else if(startChar != c && endChar == c){
            return true;
        }
        return false;
    }

    private static boolean checkLine(final String s) {
        final String[] spaceSplit = s.split(" ");
        final String numberWithDash = spaceSplit[0];
        final String characterWithColon = spaceSplit[1];
        final String password = spaceSplit[2];

        final String[] number = numberWithDash.split("-");
        final String startNumber = number[0];
        final String endNumber = number[1];

        final String character = getCharacter(characterWithColon);

        final long count = password.chars().filter(ch -> ch == character.charAt(0)).count();
        return count >= Integer.parseInt(startNumber) && count <= Integer.parseInt(endNumber);
    }

    private static String getCharacter(final String characterWithColon) {
        final String[] colonSplit = characterWithColon.split(":");
        final String character = colonSplit[0];
        return character;
    }
}

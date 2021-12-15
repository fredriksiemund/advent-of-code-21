import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day03Test {
    Day03 day03;
    String fileInput;
    String testInput;

    public Day03Test() throws IOException {
        this.day03 = new Day03();
        Path path = Path.of("src/main/java/input/day03.txt");
        this.fileInput = Files.readString(path, StandardCharsets.US_ASCII);
        this.testInput =  "00100\n" +
                "11110\n" +
                "10110\n" +
                "10111\n" +
                "10101\n" +
                "01111\n" +
                "00111\n" +
                "11100\n" +
                "10000\n" +
                "11001\n" +
                "00010\n" +
                "01010";
    }

    @Test
    public void part1() {
        assertEquals(198, day03.part1(testInput));
        assertEquals(841526, day03.part1(fileInput));
    }

    @Test
    public void part2() {
        assertEquals(900, day03.part2(testInput));
        assertEquals(1741971043, day03.part2(fileInput));
    }
}

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day01Test {
    private Day01 day01 = new Day01();
    Path path = Path.of("src/main/java/input/day01.txt");
    String fileInput = Files.readString(path, StandardCharsets.US_ASCII);

    public Day01Test() throws IOException {

    }

    @Test
    public void part1() throws IOException {
        String testInput = "199\n" +
                "200\n" +
                "208\n" +
                "210\n" +
                "200\n" +
                "207\n" +
                "240\n" +
                "269\n" +
                "260\n" +
                "263";
        int testResult = day01.part1(testInput);
        assertEquals(7, testResult);

        int result = day01.part1(fileInput);
        assertEquals(1502, result);
    }

    @Test
    public void part2() throws IOException {
        String testInput = "199\n" +
                "200\n" +
                "208\n" +
                "210\n" +
                "200\n" +
                "207\n" +
                "240\n" +
                "269\n" +
                "260\n" +
                "263";
        int testResult = day01.part2(testInput);
        assertEquals(5, testResult);

        int result = day01.part2(fileInput);
        assertEquals(1538, result);
    }
}

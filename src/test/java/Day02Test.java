import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day02Test {
    private Day02 day02 = new Day02();
    Path path = Path.of("src/main/java/input/day02.txt");
    String fileInput = Files.readString(path, StandardCharsets.US_ASCII);
    String testInput = "forward 5\n" +
            "down 5\n" +
            "forward 8\n" +
            "up 3\n" +
            "down 8\n" +
            "forward 2";

    public Day02Test() throws IOException {
    }

    @Test
    public void part1() {
        assertEquals(150, day02.part1(testInput));
        assertEquals(1746616, day02.part1(fileInput));
    }

    @Test
    public void part2() {
        assertEquals(900, day02.part2(testInput));
        assertEquals(1741971043, day02.part2(fileInput));
    }
}

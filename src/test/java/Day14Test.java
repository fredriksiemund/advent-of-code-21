import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day14Test {
    Day14 day14;
    String fileInput;
    String testInput;

    public Day14Test() throws IOException {
        this.day14 = new Day14();
        Path path = Path.of("src/main/java/input/day14.txt");
        this.fileInput = Files.readString(path, StandardCharsets.US_ASCII);
        this.testInput = "NNCB\n\n" +
                "CH -> B\n" +
                "HH -> N\n" +
                "CB -> H\n" +
                "NH -> C\n" +
                "HB -> C\n" +
                "HC -> B\n" +
                "HN -> C\n" +
                "NN -> C\n" +
                "BH -> H\n" +
                "NC -> B\n" +
                "NB -> B\n" +
                "BN -> B\n" +
                "BB -> N\n" +
                "BC -> B\n" +
                "CC -> N\n" +
                "CN -> C" ;
    }

    @Test
    public void part1() {
        assertEquals(1588, day14.part1(testInput));
        assertEquals(3143, day14.part1(fileInput));
    }

    @Test
    public void part2() {
        assertEquals(2188189693529L, day14.part2(testInput));
        assertEquals(4110215602456L, day14.part2(fileInput));
    }
}

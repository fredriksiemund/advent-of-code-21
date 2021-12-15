import java.util.LinkedList;

public class Day03 implements AocTemplate {
    public int part1(String input) {
        String[] lines = input.split(System.lineSeparator());
        int nbrOfBinaries = lines[0].length();
        int[] counters = new int[nbrOfBinaries];

        for (String line : lines)
            for (int i = 0; i < nbrOfBinaries; i++)
                counters[i] += Character.getNumericValue(line.charAt(i));

        int limit = lines.length / 2;
        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();
        for (int counter : counters) {
            if (counter > limit) {
                gamma.append("1");
                epsilon.append("0");
            } else {
                gamma.append("0");
                epsilon.append("1");
            }
        }
        return Integer.parseInt(gamma.toString(), 2) * Integer.parseInt(epsilon.toString(), 2);
    }

    public int part2(String input) {
        String[] lines = input.split(System.lineSeparator());
        LinkedList<String[]> oxygenGenerator = new LinkedList<>();
        LinkedList<String[]> co2Scrubber = new LinkedList<>();


        for (int  i = 2; i < lines.length; i++) {

        }

        return 0;
    }
}

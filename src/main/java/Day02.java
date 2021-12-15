public class Day02 implements AocTemplate{
    public int part1(String input) {
        String[] lines = input.split(System.lineSeparator());

        int depth = 0;
        int horizontalPos = 0;

        for (String line : lines) {
            String[] s = line.split(" ");
            String command = s[0];
            int value = Integer.parseInt(s[1]);
            switch (command) {
                case "forward": horizontalPos += value;
                                break;
                case "down":    depth += value;
                                break;
                case "up":      depth -= value;
                                break;
                default:        throw new IllegalArgumentException(command + " not supported");
            }
        }

        return depth * horizontalPos;
    }

    public int part2(String input) {
        String[] lines = input.split(System.lineSeparator());

        int aim = 0;
        int depth = 0;
        int horizontalPos = 0;

        for (String line : lines) {
            String[] s = line.split(" ");
            String command = s[0];
            int value = Integer.parseInt(s[1]);
            switch (command) {
                case "forward": horizontalPos += value;
                                depth += aim * value;
                                break;
                case "down":    aim += value;
                                break;
                case "up":      aim -= value;
                                break;
                default:        throw new IllegalArgumentException(command + " not supported");
            }
        }

        return depth * horizontalPos;
    }
}

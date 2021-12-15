public class Day01 implements AocTemplate {
    public int part1(String input) {
        String[] lines = input.split(System.lineSeparator());
        int previousMeasurement = Integer.MIN_VALUE;
        int counter = -1;
        for (String line : lines) {
            int measurement = Integer.parseInt(line);
            if (measurement > previousMeasurement)
                counter++;
            previousMeasurement = measurement;
        }
        return counter;
    }

    public int part2(String input) {
        String[] lines = input.split(System.lineSeparator());

        int val0 = Integer.parseInt(lines[0]);
        int val1 = Integer.parseInt(lines[1]);

        int[] slidingWindows = new int[]{ val0+val1, val1, 0 };
        int previousTotal = Integer.MIN_VALUE;
        int counter = -1;

        for (int  i = 2; i < lines.length; i++) {
            // Add new measurement
            int measurement = Integer.parseInt(lines[i]);
            for (int j = 0; j < slidingWindows.length; j++)
                slidingWindows[j] = slidingWindows[j] + measurement;
            // Sum complete window
            int window = (i + 1) % 3;
            int total = slidingWindows[window];
            counter += total > previousTotal ? 1 : 0;
            previousTotal = total;
            slidingWindows[window] = 0;
        }

        return counter;
    }
}

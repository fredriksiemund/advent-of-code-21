import java.util.HashMap;
import java.util.LinkedList;

public class Day14 {

    public int part1(String input) {
        String[] lines = input.split(System.lineSeparator());
        String polymerTemplateString = lines[0];

        LinkedList<String> polymerTemplate = new LinkedList<>();

        for(int i = 0; i < polymerTemplateString.length(); i++) {
            polymerTemplate.add(String.valueOf(polymerTemplateString.charAt(i)));
        }

        HashMap<String, String> rules = new HashMap<>();

        for (int  i = 2; i < lines.length; i++) {
            String line = lines[i];
            String[] template = line.split(" -> ");
            rules.put(template[0], template[1]);
        }

        for (int i = 0; i < 10; i++) {
            LinkedList<String> newPolymerTemplate = new LinkedList<>();
            for (int j = 0; j < polymerTemplate.size(); j++) {
                String current = polymerTemplate.get(j);
                newPolymerTemplate.add(current);

                if (j + 1 < polymerTemplate.size()) {
                    String pair = current + polymerTemplate.get(j + 1);
                    String element = rules.get(pair);

                    if (element != null) {
                        newPolymerTemplate.add(element);
                    }
                }
            }
            polymerTemplate = newPolymerTemplate;
        }


        HashMap<String, Integer> result = new HashMap<>();

        for (String element : polymerTemplate) {
            Integer count = result.get(element);
            Integer newCount = count != null ? count + 1 : 1;
            result.put(element, newCount);
        }

        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        for (String key : result.keySet()) {
            Integer value = result.get(key);
            if (value < lowest) {
                lowest = value;
            }
            if (value > highest) {
                highest = value;
            }
        }

        return highest - lowest;
    }

    private void incrementIfExists(HashMap<String, Long> counter, String pair, Long value) {
        if (counter.containsKey(pair)) {
            counter.put(pair, counter.get(pair) + value);
        }
    }

    public long part2(String input) {
        String[] lines = input.split(System.lineSeparator());

        HashMap<String, String> rules = new HashMap<>();
        HashMap<String, Long> emptyCounter = new HashMap<>();

        for (int  i = 2; i < lines.length; i++) {
            String line = lines[i];
            String[] template = line.split(" -> ");
            rules.put(template[0], template[1]);
            emptyCounter.put(template[0], 0L);
        }

        HashMap<String, Long> counter = new HashMap<>(emptyCounter);
        String polymerTemplateString = lines[0];

        for(int i = 0; i < polymerTemplateString.length() - 1; i++) {
            String pair = polymerTemplateString.substring(i, i + 2);
            counter.put(pair, counter.get(pair) + 1);
        }

        for (int i = 0; i < 40; i++) {
            HashMap<String, Long> newCounter = new HashMap<>(emptyCounter);
            for (String key : counter.keySet()) {
                Long value = counter.get(key);
                String insertElement = rules.get(key);
                if (insertElement != null) {
                    String[] split = key.split("");
                    String pair1 = split[0] + insertElement;
                    String pair2 = insertElement + split[1];
                    incrementIfExists(newCounter, pair1, value);
                    incrementIfExists(newCounter, pair2, value);
                }
            }
            counter = new HashMap<>(newCounter);
        }

        HashMap<String, Long> result = new HashMap<>();

        for (String key : counter.keySet()) {
            String[] letters = key.split("");
            Long count = result.get(letters[0]);
            if (count != null) {
                result.put(letters[0], counter.get(key) + count);
            } else {
                result.put(letters[0], counter.get(key));
            }
        }
        String lastElement = String.valueOf(polymerTemplateString.charAt(polymerTemplateString.length() - 1));
        result.put(lastElement, result.get(lastElement) + 1);

        long highest = Long.MIN_VALUE;
        long lowest = Long.MAX_VALUE;

        for (String key : result.keySet()) {
            Long value = result.get(key);
            if (value < lowest) {
                lowest = value;
            }
            if (value > highest) {
                highest = value;
            }
        }

        return highest - lowest;
    }
}

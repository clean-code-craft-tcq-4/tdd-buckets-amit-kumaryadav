package ChargingRange;

import java.util.*;

public class ChargingRange {

    public Map<String, Integer> getRanges(ArrayList<Integer> input) {
        Collections.sort(input);
        Map<String, Integer> result = new HashMap<>();
        int previousElement = input.get(0), currentReference = 0;
        for (int j = 0; j < input.size(); j++) {
            if ((input.get(j) != previousElement) && (previousElement + 1 != input.get(j))) {
                String key = input.get(currentReference) + " - " + previousElement;
                result.put(key, j - currentReference);
                currentReference = j;
            }
            if (j == input.size() - 1) {
                String key = input.get(currentReference) + " - " + input.get(j);
                result.put(key, j - currentReference + 1);
            }
            previousElement = input.get(j);
        }
        return result;
    }

    public  void printCSVFormat(Map<String, Integer> input) {
        System.out.println("Range, Readings");
        input.forEach((k, v) -> {
            System.out.println(k + ", " + v);
        });
    }
}
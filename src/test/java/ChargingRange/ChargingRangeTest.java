package ChargingRange;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class ChargingRangeTest {
    ChargingRange chargingRange = new ChargingRange();


    @Test
    public void getChargingRange() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(4, 5));
        Map<String, Integer> result = chargingRange.getRanges(input);
        assertTrue(!result.isEmpty());
        assertTrue(result.get("4 - 5") == 2);
    }

    @Test
    public void testRanges() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(3, 5, 8, 9, 10));
        Map<String, Integer> result = chargingRange.getRanges(input);
        assertTrue(!result.isEmpty());
        assertTrue(result.get("8 - 10") == 3);
        assertTrue(result.get("3 - 3") == 1);
        assertTrue(result.get("5 - 5") == 1);
    }
}

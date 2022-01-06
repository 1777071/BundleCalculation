package tian.bundlecalculator.first.calculator;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PriceCalculator {
    public Map<Integer, Double> getPrice(Map<Integer, Integer> bundlesList, Map<Integer, Double> bundlePriceNumbers) {
        Map<Integer, Double> orderBundle = orderFromLowToHigh(bundlePriceNumbers);
        //Put the multi result in a new map
        Map<Integer, Double> res = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : bundlesList.entrySet()) {
            double resPrice = entry.getValue() * orderBundle.get(entry.getKey());
            res.put(entry.getKey(), resPrice);
        }

        return res;
    }

    //Sort the map  that contains the price details
    private Map<Integer, Double> orderFromLowToHigh(Map<Integer, Double> order) {
        TreeMap<Integer, Double> treeMap = new TreeMap<>((o1, o2) -> o1 > o2 ? 1 : 0);
        treeMap.putAll(order);
        return treeMap;
    }
}

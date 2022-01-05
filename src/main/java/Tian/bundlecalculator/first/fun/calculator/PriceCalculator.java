package Tian.bundlecalculator.first.fun.calculator;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PriceCalculator {
    public Map<Integer, Double> getPrice(Map<Integer, Integer> bundlesList, Map<Integer, Double> bundleNumbers) {
        Map<Integer, Double> orderBundle = orderFromLowToHigh(bundleNumbers);
        Map<Integer, Double> res = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : bundlesList.entrySet()) {
            double resPrice = entry.getValue() * orderBundle.get(entry.getKey());
            res.put(entry.getKey(), resPrice);
        }

        return res;
    }

    private Map<Integer, Double> orderFromLowToHigh(Map<Integer, Double> order) {
        TreeMap<Integer, Double> treeMap = new TreeMap<>((o1, o2) -> o1 > o2 ? 1 : 0);
        treeMap.putAll(order);
        return treeMap;
    }
}

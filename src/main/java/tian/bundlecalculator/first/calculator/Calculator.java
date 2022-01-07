package tian.bundlecalculator.first.calculator;

import java.util.*;
import java.util.stream.Collectors;

public class Calculator {
    public Map<Integer, Integer> calculateBundles(int bundleNumber, Map<Integer, Double> processBundle) {

        Map<Integer, Integer> res = new HashMap<>();
        Set<Integer> bundleSize = processBundle.keySet();
        List<Integer> orderBundle = bundleSize.stream().sorted().collect(Collectors.toList());
        if (bundleNumber < orderBundle.get(0)) {
            res.put(orderBundle.get(0), 1);
            return res;
        }
        Map<Integer, Map<Integer, Integer>> possibleCombination = new HashMap<>();
        for (int i = 1; i < orderBundle.get(0); i++) {
            possibleCombination.put(i, initialValue(bundleSize.size(), orderBundle));
        }

        Set<Integer> auoqtoli = new HashSet<>(bundleSize);
        for (int i = orderBundle.get(0); i <= bundleNumber; i++) {
            for (int j = bundleSize.size() - 1; j >= 0; j--) {
                //No remains
                //The bundle number could satisfy the request
                if ((i - orderBundle.get(j) == 0)) {
                    possibleCombination.put(i, updateMap(i, orderBundle));
                    auoqtoli.add(i);
                    break;
                } else {
                    //The rest could be satisfied by the bundle number
                    if (auoqtoli.contains(i - orderBundle.get(j))) {
                        possibleCombination.put(i, possibleCombination.get(i - orderBundle.get(j)));
                        Map<Integer, Integer> mid = new HashMap<>(possibleCombination.get(i));
                        auoqtoli.add(i);

                        mid.put(orderBundle.get(j), mid.get(orderBundle.get(j)) + 1);
                        possibleCombination.put(i, mid);
                        break;
                    }
                }
            }
            //With remains
            if (!auoqtoli.contains(i)) {
                int lastSize = i - orderBundle.get(0);
                int bundleCounts = lastBundleNumber(possibleCombination, lastSize);
                Map<Integer, Integer> mid = new HashMap<>(i - orderBundle.get(0));
                for (int bundle : orderBundle) {
                    //Current bundles satisfy the request
                    if (i < bundle) {
                        Map<Integer, Integer> newValue = updateMap(bundle, orderBundle);
                        possibleCombination.put(i, newValue);
                        break;
                    } else {
                        int currentBundle = i - bundle;
                        int currentCounts = lastBundleNumber(possibleCombination, currentBundle);

                        if (bundleCounts - currentCounts >= 0) {
                            mid.putAll(possibleCombination.get(currentBundle));
                            int lastNumber = mid.get(bundle);
                            mid.put(bundle, lastNumber + 1);
                            possibleCombination.put(i, mid);
                        }
                    }
                }
            }
        }
        res.putAll(possibleCombination.get(bundleNumber));
        res = orderFromLowToHigh(res);
        return res;
    }

    // Sort the map
    private Map<Integer, Integer> orderFromLowToHigh(Map<Integer, Integer> order) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>((o1, o2) -> o1 > o2 ? 1 : -1);
        treeMap.putAll(order);
        return treeMap;
    }

    //The small number could be satisfied by the smallest bundles
    private Map<Integer, Integer> initialValue(int size, List<Integer> order) {
        Map<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < size; i++) {
            res.put(order.get(i), 0);
        }
        res.put(order.get(0), 1);
        return res;
    }

    private Map<Integer, Integer> updateMap(int size, List<Integer> orderBundle) {
        Map<Integer, Integer> res = new HashMap<>();
        for (Integer integer : orderBundle) {
            res.put(integer, 0);
        }
        res.put(size, 1);
        return res;
    }

    private int lastBundleNumber(Map<Integer, Map<Integer, Integer>> possibleCombination, int lastSize) {
        Map<Integer, Integer> lastNumber = possibleCombination.get(lastSize);
        int bundleCounts = 0;
        for (Map.Entry<Integer, Integer> entry : lastNumber.entrySet()) {
            bundleCounts += entry.getValue();
        }
        return bundleCounts;
    }
}

package tian.bundlecalculator.first.model;

import tian.bundlecalculator.first.calculator.Calculator;
import tian.bundlecalculator.first.domain.Bundles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OrderProcessor {

    public Map<String, Object> process(OrderDetails customersDetails) {
        Map<String, Object> res = new HashMap<>();
        ArrayList<String> allCategories = new ArrayList<>();
        ArrayList<Integer> allNumbers = new ArrayList<>();
        ArrayList<Map<Integer, Integer>> bundleListResult = new ArrayList<>();
        ArrayList<Map<Integer, Double>> priceListResult = new ArrayList<>();
        ArrayList<Double> allPrice = new ArrayList<>();
        for (OrderItem item : customersDetails.customersRequest) {
            String bundleTypes = item.getCategory();
            int filesNumber = item.getNumber();
            allCategories.add(bundleTypes);
            allNumbers.add(filesNumber);

            Bundles bb = new Bundles();
            Map<Integer, Double> processBundle = bb.getCategories(bundleTypes);
            Calculator packagesAndPrice = new Calculator();
            Map<Integer, Integer> bundlesList = packagesAndPrice.calculateBundles(item.getNumber(), processBundle);
            bundleListResult.add(bundlesList);

            Map<Integer, Integer> currentBundlePrice = new HashMap<>(bundlesList);
            Map<Integer, Double> priceListRes = new HashMap<>();

            for (Integer i : bundlesList.keySet()) {
                priceListRes.put(i, currentBundlePrice.get(i) * processBundle.get(i));
            }

            priceListResult.add(priceListRes);
            allPrice.add(totalPrice(priceListRes));
        }
        res.put("allCategories", allCategories);
        res.put("allNumbers", allNumbers);
        res.put("bundleListResult", bundleListResult);
        res.put("priceListResult", priceListResult);
        res.put("allPrice", allPrice);
        return res;

    }

    private double totalPrice(Map<Integer, Double> priceRes) {
        double res = 0.0;
        for (Map.Entry<Integer, Double> entry : priceRes.entrySet()) {
            res += entry.getValue();
        }
        return res;
    }
}

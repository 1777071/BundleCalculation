package Tian.bundlecalculator.first;



import Tian.bundlecalculator.first.fun.analyzer.CustomersDetails;
import Tian.bundlecalculator.first.fun.analyzer.Item;
import Tian.bundlecalculator.first.fun.calculator.CalculatorOfTheBundlesNumbers;
import Tian.bundlecalculator.first.fun.calculator.PriceCalculator;
import Tian.bundlecalculator.first.utils.Bundles;


import java.util.ArrayList;
import java.util.Map;

public class OrderProcessor {

    public final ArrayList<String> allKinds = new ArrayList<>();
    public final ArrayList<Integer> allNumbers = new ArrayList<>();
    public final ArrayList<Map<Integer, Integer>> bundleListResult = new ArrayList<>();
    public final ArrayList<Map<Integer, Double>> priceListResult = new ArrayList<>();
    public final ArrayList<Double> allPrice = new ArrayList<>();

    public void process(CustomersDetails customersDetails) {
        for (Item item : customersDetails.customersRequest) {
            String bundleKinds = item.getKinds();
            int filesNumber = item.getNumber();
            allKinds.add(bundleKinds);
            allNumbers.add(filesNumber);

            Bundles bb=new Bundles();
            Map<Integer, Double> processBundle = bb.getKinds(bundleKinds);
            CalculatorOfTheBundlesNumbers countPackages = new CalculatorOfTheBundlesNumbers();
            Map<Integer, Integer> bundlesList = countPackages.calculateBundles(item.getNumber(), processBundle);
            bundleListResult.add(bundlesList);

            PriceCalculator getPrice = new PriceCalculator();
            Map<Integer, Double> priceRes = getPrice.getPrice(bundlesList, processBundle);

            priceListResult.add(priceRes);

            allPrice.add(totalPrice(priceRes));
        }

    }

    private double totalPrice(Map<Integer, Double> priceRes) {
        double res = 0.0;
        for (Map.Entry<Integer, Double> entry : priceRes.entrySet()) {
            res += entry.getValue();
        }
        return res;
    }
}

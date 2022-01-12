package tian.bundlecalculator.first;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class OrderPrinter {
    public void print(ResList resList) {
        for (int i = 0; i < resList.getAllCategories().size(); i++) {
            String type = resList.getAllCategories().get(i);
            Map<Integer, Integer> bundlesNumber = resList.getBundleListResult().get(i);
            Map<Integer, Double> totalCost = resList.getPriceListResult().get(i);
            //The FLAC result type is double and keep two decimal places
            Double theWholeCost = (totalCost.values()).stream().reduce(0.0, Double::sum);
            if (type.equals("FLAC")) {
                DecimalFormat keepTwoDecimals = new DecimalFormat("#.00");
                String flacValue = keepTwoDecimals.format(theWholeCost);
                System.out.println(resList.getAllNumbers().get(i) + " " + resList.getAllCategories().get(i) + " $ " + flacValue);
                totalCost.forEach((itemSize, itemPrice) -> System.out.print(validateFlac(bundlesNumber, itemSize, itemPrice)));
            } else {
                System.out.println(resList.getAllNumbers().get(i) + " " + resList.getAllCategories().get(i) + " $ " + theWholeCost.intValue());
                totalCost.forEach((itemSize, itemPrice) -> System.out.print(validateImgAndVid(bundlesNumber, itemSize, itemPrice)));
            }
        }
    }

    private String validateFlac(Map<Integer, Integer> bundlesNumber, int i, Double bundleCost) {
        Map<Integer, Integer> numberList = new HashMap<>(bundlesNumber);
        if (numberList.get(i) == 0.0) {
            return "";
        } else {
            DecimalFormat reserve = new DecimalFormat("#.00");
            String flacCurrentBundleCost = reserve.format(bundleCost);
            return numberList.get(i) + " * " + i + " $ " + flacCurrentBundleCost + "\n";
        }
    }

    private String validateImgAndVid(Map<Integer, Integer> bundlesNumber, int i, Double bundleCost) {
        Map<Integer, Integer> numberList = new HashMap<>(bundlesNumber);
        if (numberList.get(i) == 0) {
            return "";
        } else {
            int singleBundleCost = (int) Math.round(bundleCost);
            return numberList.get(i) + " * " + i + " $ " + singleBundleCost + "\n";
        }
    }
}

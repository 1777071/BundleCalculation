package com.example.demo;

//import jdk.dynalink.Operation;

import java.util.ArrayList;
import java.util.Map;

public class OrderProcess {

    public final ArrayList<String> allKinds=new ArrayList<>();
    public final ArrayList<Integer> allNumbers=new ArrayList<>();
    public final ArrayList<Map<Integer,Integer>> bundleListResult=new ArrayList<>();
    public final ArrayList<Map<Integer,Double>> priceListResult=new ArrayList<>();
    public final ArrayList<Double> allPrice=new ArrayList<>();

    public void process(CustomersDetails customersDetails){
        for (Item item:customersDetails.customersRequest) {
            String bundleKinds=item.getKinds();
            int filesNumber=item.getNumber();
            allKinds.add(bundleKinds);
            allNumbers.add(filesNumber);

            Operation bundleInfo = Bundles
                        .getKind(bundleKinds)
                        .orElseThrow(() -> new IllegalArgumentException("Invalid Operator"));

            Map<Integer,Double> processBundle=bundleInfo.applyBundles();
            Calculation countPackages=new Calculation();
            Map<Integer,Integer> bundlesList=countPackages.calculateBundles(item.getNumber(),processBundle);
            bundleListResult.add(bundlesList);

            CalculatePrice getPrice=new CalculatePrice();
            Map<Integer, Double> priceRes=getPrice.getPrice(bundlesList,processBundle);

            priceListResult.add(priceRes);

            allPrice.add(totalPrice(priceRes));
        }

    }

    private double totalPrice(Map<Integer,Double> priceRes){
        double res=0.0;
        for (Map.Entry<Integer,Double> entry:priceRes.entrySet()) {
            res+= entry.getValue();
        }
        return res;
    }
}

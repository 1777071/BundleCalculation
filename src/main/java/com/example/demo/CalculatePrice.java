package com.example.demo;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class CalculatePrice {
    public Map<Integer,Double> getPrice( Map<Integer,Integer> bundlesList,Map<Integer,Double> bundleNumbers){
        System.out.println(bundlesList+"List");
        System.out.println(bundleNumbers+"Numbers");
        Map<Integer,Double> orderBundle=orderFromLowToHigh(bundleNumbers);
        Map<Integer,Double>res=new HashMap<>();
        for (Map.Entry<Integer,Integer> entry:bundlesList.entrySet()) {
            double resPrice=entry.getValue()*orderBundle.get(entry.getKey());
            DecimalFormat reserve=new DecimalFormat("#.00");
            reserve.setRoundingMode(RoundingMode.HALF_UP);
            resPrice=Double.parseDouble(reserve.format(resPrice));
            res.put(entry.getKey(),resPrice);
        }
        System.out.println(res+"res");
        return res;
    }
    private Map<Integer,Double>orderFromLowToHigh(Map<Integer,Double> order){
        TreeMap<Integer,Double> treeMap = new TreeMap<>((o1, o2) -> o1>o2?1:0);
        treeMap.putAll(order);
        return treeMap;
    }
}

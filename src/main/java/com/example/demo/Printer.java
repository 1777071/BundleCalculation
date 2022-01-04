package com.example.demo;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Printer {
    public void printer(ArrayList<Integer> resNumber, ArrayList<String> resKinds, ArrayList<Map<Integer, Integer>> resBundle, ArrayList<Map<Integer, Double>> resPrice, ArrayList<Double> resAllPrice) {

        for (int i = 0; i < resKinds.size(); i++) {
            String kind = resKinds.get(i);
            if (kind.equals("FLAC")) {
                DecimalFormat reserve=new DecimalFormat("#.00");
                String flacValue=reserve.format(resAllPrice.get(i));
                System.out.println(resNumber.get(i) + " " + resKinds.get(i) + " " + "$" + flacValue);
            } else {
                System.out.println(resNumber.get(i) + " " + resKinds.get(i) + " " + "$" + (int) Math.round(resAllPrice.get(i)));
            }

            Set<Integer> resCombination = resBundle.get(i).keySet();
            List<Integer> resDetails = resCombination.stream().sorted().collect(Collectors.toList());
            Set<Integer> resPriceCombination = resPrice.get(i).keySet();
            List<Integer> resPriceDetails = resPriceCombination.stream().sorted().collect(Collectors.toList());
            for (int j = 0; j < resDetails.size(); j++) {
                Map<Integer, Integer> middle = new HashMap<>(resBundle.get(i));
                if (kind.equals("FLAC")) {
                    System.out.print(judgeFlacNull(middle, i, resDetails, resPrice, j, resPriceDetails));
                } else {
                    System.out.print(judgeNull(middle, i, resDetails, resPrice, j, resPriceDetails));
                }
            }

        }
    }

    private String judgeNull(Map<Integer, Integer> resBundle, int i, List<Integer> resDetails, ArrayList<Map<Integer, Double>> resPrice, int j, List<Integer> resPriceDetails) {
        if (resBundle.get(resDetails.get(j)) == 0) {
            return "";
        } else {
            int mid = (int) Math.round(resPrice.get(i).get(resPriceDetails.get(j)));
            return resBundle.get(resDetails.get(j)) + " * " + resDetails.get(j) + " $" + mid + "\n";
        }
    }

    private String judgeFlacNull(Map<Integer, Integer> resBundle, int i, List<Integer> resDetails, ArrayList<Map<Integer, Double>> resPrice, int j, List<Integer> resPriceDetails) {
        if (resBundle.get(resDetails.get(j)) == 0.0) {
            return "";
        } else {
            DecimalFormat reserve=new DecimalFormat("#.00");
            String flacCurrentValue=reserve.format( resPrice.get(i).get(resPriceDetails.get(j)));
            return resBundle.get(resDetails.get(j)) + " * " + resDetails.get(j) + " $" + flacCurrentValue + "\n";
        }
    }
}

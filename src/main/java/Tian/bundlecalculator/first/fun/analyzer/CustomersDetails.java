package Tian.bundlecalculator.first.fun.analyzer;

import java.util.ArrayList;

public class CustomersDetails {
    public ArrayList<Item> customersRequest = new ArrayList<>();

    public void add(Item request) {
        customersRequest.add(request);
    }
}

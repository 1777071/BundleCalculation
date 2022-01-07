package tian.bundlecalculator.first.model;

import java.util.ArrayList;

public class OrderDetails {
    public ArrayList<OrderItem> customersRequest = new ArrayList<>();

    public void add(OrderItem request) {
        customersRequest.add(request);
    }
}

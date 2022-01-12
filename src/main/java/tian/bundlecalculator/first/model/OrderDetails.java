package tian.bundlecalculator.first.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderDetails {
    private List<OrderItem> orderItems = new ArrayList<>();

    public void add(OrderItem request) {
        orderItems.add(request);
    }
}

package tian.bundlecalculator.first.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OrderDetails {
    private List<OrderItem> orderItems = new ArrayList<>();

    public void add(OrderItem request) {
        orderItems.add(request);
    }
}

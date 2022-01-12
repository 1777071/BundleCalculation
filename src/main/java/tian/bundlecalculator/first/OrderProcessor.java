package tian.bundlecalculator.first;

import tian.bundlecalculator.first.calculator.Calculator;
import tian.bundlecalculator.first.model.Bundles;
import tian.bundlecalculator.first.model.OrderDetails;
import tian.bundlecalculator.first.model.OrderItem;

import java.util.List;
import java.util.Map;

public class OrderProcessor {
    public ResList process(OrderDetails orderDetails) {
        ResList resList = new ResList();
        List<OrderItem> items = orderDetails.getOrderItems();
        items.forEach((item) -> {
            String bundleTypes = item.getCategory();
            int filesNumber = item.getNumber();

            resList.addCategoryItem(bundleTypes);
            resList.addNumberItem(filesNumber);

            Bundles bb = new Bundles();
            Map<Integer, Double> processBundle = bb.getCategories(bundleTypes);
            Calculator packagesAndPrice = new Calculator();
            Map<Integer, Integer> bundlesList = packagesAndPrice.calculateBundles(filesNumber, processBundle);
            resList.addBundleListItem(bundlesList);
        });
        return resList;
    }
}


package tian.bundlecalculator.first;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tian.bundlecalculator.first.analyzer.OrderReader;
import tian.bundlecalculator.first.model.OrderDetails;
import tian.bundlecalculator.first.model.OrderProcessor;

import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Logger;

@Slf4j
@SpringBootApplication
//@SuppressWarnings("unchecked")
public class CalculationDemo {
    public static void main(String[] args) {
        Logger log = Logger.getGlobal();

        OrderReader orderDetails = new OrderReader();
        OrderDetails inputOrders = orderDetails.read();
        log.info(inputOrders.toString());

        OrderProcessor dealOrder = new OrderProcessor();
        Map<String, Object> result = dealOrder.process(inputOrders);

        ArrayList<Map<Integer, Double>> resPrice = new ArrayList<>();
        ArrayList<Map<Integer, Integer>> resBundle = new ArrayList<>();
        ArrayList<String> resCategories = new ArrayList<>();
        ArrayList<Integer> resNumber = new ArrayList<>();
        ArrayList<Double> resAllPrice = new ArrayList<>();
        try {
            resBundle = (ArrayList<Map<Integer, Integer>>) result.get("bundleListResult");
            resPrice = (ArrayList<Map<Integer, Double>>) result.get("priceListResult");
            resCategories = (ArrayList<String>) result.get("allCategories");
            resNumber = (ArrayList<Integer>) result.get("allNumbers");
            resAllPrice = (ArrayList<Double>) result.get("allPrice");
        } catch (ClassCastException e) {
            log.info(e + " The input format has some problem please input like '10 IMG'");
        }

        Printer resPrinter = new Printer();
        resPrinter.printer(resNumber, resCategories, resBundle, resPrice, resAllPrice);

    }
}

package Tian.bundlecalculator.first;

import Tian.bundlecalculator.first.fun.analyzer.CustomersDetails;
import Tian.bundlecalculator.first.fun.analyzer.GetTheOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Logger;

@Slf4j
@SpringBootApplication
public class CalcultionDemo {

    public static void main(String[] args) {
        Logger log = Logger.getGlobal();

        GetTheOrder getTheOrder = new GetTheOrder();
        CustomersDetails custoersDetails = getTheOrder.read();
        log.info(custoersDetails.toString());

        OrderProcessor dealOrder = new OrderProcessor();
        dealOrder.process(custoersDetails);

        ArrayList<String> resKinds = dealOrder.allKinds;
        ArrayList<Integer> resNumber = dealOrder.allNumbers;
        ArrayList<Map<Integer, Integer>> resBundle = dealOrder.bundleListResult;

        ArrayList<Map<Integer, Double>> resPrice = dealOrder.priceListResult;
        ArrayList<Double> resAllPrice = dealOrder.allPrice;

        Printer resPrinter = new Printer();
        resPrinter.printer(resNumber, resKinds, resBundle, resPrice, resAllPrice);

    }

}

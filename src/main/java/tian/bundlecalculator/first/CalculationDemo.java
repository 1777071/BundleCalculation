package tian.bundlecalculator.first;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tian.bundlecalculator.first.analyzer.CustomersDetails;
import tian.bundlecalculator.first.analyzer.Reader;

import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Logger;

@Slf4j
@SpringBootApplication
public class CalculationDemo {

    public static void main(String[] args) {
        Logger log = Logger.getGlobal();

        Reader getTheOrder = new Reader();
        CustomersDetails customersDetails = getTheOrder.read();
        log.info(customersDetails.toString());

        OrderProcessor dealOrder = new OrderProcessor();
        dealOrder.process(customersDetails);

        ArrayList<String> resCategories = dealOrder.allCategories;
        ArrayList<Integer> resNumber = dealOrder.allNumbers;
        ArrayList<Map<Integer, Integer>> resBundle = dealOrder.bundleListResult;

        ArrayList<Map<Integer, Double>> resPrice = dealOrder.priceListResult;
        ArrayList<Double> resAllPrice = dealOrder.allPrice;

        Printer resPrinter = new Printer();
        resPrinter.printer(resNumber, resCategories, resBundle, resPrice, resAllPrice);

    }

}

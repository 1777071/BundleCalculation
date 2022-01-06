package tian.bundlecalculator.first;

import tian.bundlecalculator.first.analyzer.CustomersDetails;
import tian.bundlecalculator.first.analyzer.Reader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Logger;

@Slf4j
@SpringBootApplication
public class CalculationDemo {

    public static void main(String[] args) {
        Logger log = Logger.getGlobal();

        Reader getTheOrder = new Reader();
        CustomersDetails custoersDetails = getTheOrder.read();
        log.info(custoersDetails.toString());

        OrderProcessor dealOrder = new OrderProcessor();
        dealOrder.process(custoersDetails);

        ArrayList<String> resCategorys = dealOrder.allCategories;
        ArrayList<Integer> resNumber = dealOrder.allNumbers;
        ArrayList<Map<Integer, Integer>> resBundle = dealOrder.bundleListResult;

        ArrayList<Map<Integer, Double>> resPrice = dealOrder.priceListResult;
        ArrayList<Double> resAllPrice = dealOrder.allPrice;

        Printer resPrinter = new Printer();
        resPrinter.printer(resNumber, resCategorys, resBundle, resPrice, resAllPrice);

    }

}

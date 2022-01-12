package tian.bundlecalculator.first;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tian.bundlecalculator.first.model.OrderDetails;

import java.util.logging.Logger;

@Slf4j
@SpringBootApplication
public class CalculationDemo {
    public static void main(String[] args) {
        Logger log = Logger.getGlobal();

        OrderReader orderDetails = new OrderReader();
        OrderDetails inputOrders = orderDetails.read();
        log.info(inputOrders.toString());

        OrderProcessor dealOrder = new OrderProcessor();
        ResList resList = dealOrder.process(inputOrders);

        OrderPrinter resOrderPrinter = new OrderPrinter();
        resOrderPrinter.printer(resList);

    }
}

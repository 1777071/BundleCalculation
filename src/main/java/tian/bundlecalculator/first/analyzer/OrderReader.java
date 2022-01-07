package tian.bundlecalculator.first.analyzer;

import tian.bundlecalculator.first.model.OrderDetails;
import tian.bundlecalculator.first.model.OrderItem;

import java.util.Scanner;
import java.util.logging.Logger;

public class OrderReader {
    public OrderDetails read() {
        Logger log = Logger.getGlobal();
        OrderDetails details = new OrderDetails();
        System.out.println("Please input your request");
        System.out.println("Please use the structure '10 IMG'");
        try {
            Scanner scan = new Scanner(System.in);
            String nextLine = scan.nextLine();
            while (nextLine != null && !nextLine.equals("")) {
                String[] currentLine = nextLine.split("\\s+");
                if (new Classification().evaluation(currentLine[1])) {
                    OrderItem currentItem = new OrderItem();
                    currentItem.setCategory(currentLine[1]);
                    currentItem.setNumber(Integer.parseInt(currentLine[0]));
                    details.add(currentItem);
                }
                nextLine = scan.nextLine();
            }

        } catch (IndexOutOfBoundsException ex) {
            log.info("Please input correct format like: 10 IMG and use");
            ex.printStackTrace();
        }
        return details;
    }


}

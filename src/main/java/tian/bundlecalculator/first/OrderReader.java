package tian.bundlecalculator.first;

import tian.bundlecalculator.first.model.OrderDetails;
import tian.bundlecalculator.first.model.OrderItem;

import java.util.Scanner;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class OrderReader {
    public OrderDetails read() {
        Logger log = Logger.getGlobal();
        OrderDetails orderdetails = new OrderDetails();
        System.out.println("Please input your request");
        System.out.println("Please use the structure '10 IMG'");
        try {
            Scanner scan = new Scanner(System.in);
            String nextLine = scan.nextLine();
            while (nextLine != null && !nextLine.equals("")) {
                String[] currentLine = nextLine.split("\\s+");
                OrderItem currentItem = new OrderItem();
                currentItem.setCategory(currentLine[1]);
                currentItem.setNumber(Integer.parseInt(currentLine[0]));
                orderdetails.add(currentItem);
                nextLine = scan.nextLine();
            }

        } catch (IndexOutOfBoundsException ex) {
            log.info("Please input correct format like: 10 IMG and use");
            log.warning((ex.toString()));
        }
        orderdetails.setOrderItems(orderdetails.getOrderItems().stream().
                filter(item -> "FLAC".equals(item.getCategory()) || "IMG".equals(item.getCategory()) || "VID".equals(item.getCategory())).collect(Collectors.toList()));
        return orderdetails;
    }


}

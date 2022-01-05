package Tian.bundlecalculator.first.fun.analyzer;

import java.util.Scanner;
import java.util.logging.Logger;

public class GetTheOrder {
    public CustomersDetails read() {
        Logger log = Logger.getGlobal();
        CustomersDetails details = new CustomersDetails();
        System.out.println("Please input your request");
        System.out.println("Please use the structure '10 IMG'");
        try {
            Scanner scan = new Scanner(System.in);
            String nextLine = scan.nextLine();
            while (nextLine != null && !nextLine.equals("")) {
                String[] evaline = nextLine.split("\\s+");
                if (new Classification().evaluation(evaline[1])) {
                    Item request = new Item();
                    request.setKinds(evaline[1]);
                    request.setNumber(Integer.parseInt(evaline[0]));
                    details.add(request);
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

package tian.bundlecalculator.first.analyzer;

import java.util.Scanner;
import java.util.logging.Logger;

public class Reader {
    public CustomersDetails read() {
        Logger log = Logger.getGlobal();
        CustomersDetails details = new CustomersDetails();
        System.out.println("Please input your request");
        System.out.println("Please use the structure '10 IMG'");
        try {
            Scanner scan = new Scanner(System.in);
            String nextLine = scan.nextLine();
            while (nextLine != null && !nextLine.equals("")) {
                String[] currentLine = nextLine.split("\\s+");
                if (new Classification().evaluation( currentLine[1])) {
                    Item request = new Item();
                    request.setCategory( currentLine[1]);
                    request.setNumber(Integer.parseInt( currentLine[0]));
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

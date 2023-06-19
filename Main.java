import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        try {

            Queue qCounter1 = new Queue();
            Queue qCounter2 = new Queue();
            Queue qCounter3 = new Queue();

            // Create file reader to read input file
            BufferedReader br = new BufferedReader(new FileReader("customer.txt"));

            // Create ArrayList
            LinkedList<CustomerInformation> customerList = new LinkedList<CustomerInformation>();

            // Create object
            CustomerInformation cust;

            // Declare indata (a line in input file)
            String inline = null;

            double Total = 0.0;

            while ((inline = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(inline, ";");

                String custId = st.nextToken();
                String custIC = st.nextToken();
                double counterPaid = Double.parseDouble(st.nextToken());

                ArrayList<ItemInformation> itemList = new ArrayList<>();
                StringTokenizer itemToken = new StringTokenizer(st.nextToken(), ":");
                while (itemToken.hasMoreTokens()) {
                    StringTokenizer infoToken = new StringTokenizer(itemToken.nextToken(), ",");
                    String itemId = infoToken.nextToken();
                    String itemName = infoToken.nextToken();
                    double itemPrice = Double.parseDouble(infoToken.nextToken());
                    String date = infoToken.nextToken();

                    ItemInformation item = new ItemInformation(itemId, itemName, itemPrice, date);
                    itemList.add(item);
                    counterPaid += itemPrice;

                }
                cust = new CustomerInformation(custId, custIC, counterPaid);
                cust.addItem(itemList);
                customerList.add(cust);
            }
            br.close();

            for(int i = 0; i < customerList.size(); i++){
                CustomerInformation customer;
                cust = customerList.get(i);
                System.out.println(cust.getItemQuantity());
            }
            // for(CustomerInformation customer: customerList){
            //     System.out.println(customer.getItemQuantity());
            // }
            // while (!customerList.isEmpty()) {
            //     for (CustomerInformation customer : customerList) {
            //         if (customer.getItemQuantity() <= 5) {
            //             if (qCounter1.size < 5) {
            //                 customerList.remove(customer);
            //                 qCounter1.enqueue(customer);
            //             }
            //             else if (qCounter2.size < 5) {
            //                 customerList.remove(customer);
            //                 qCounter1.enqueue(customer);
            //             }
            //         }
            //         else if (customer.getItemQuantity() > 5) {
            //             customerList.remove(customer);
            //             qCounter3.enqueue(customer);
            //         }
            //     }
            // }

            // int menu = 0;
            // do {
            //     String input;
            //     input = JOptionPane.showInputDialog(null, "Please Select Menu\n1)Remove and Add new customer at counter 1\n2)Remove and add new customer at counter 2\n3)Exit");
            //     menu = Integer.parseInt(input);

            //     switch(menu){
            //        case 1:

            //     }




            // } while(menu != 3);


        } catch (FileNotFoundException fnfe) {
            System.out.println("File not found");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}

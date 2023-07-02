import java.text.DecimalFormat;
import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

class Main {// open class
	public static void main(String[] args) throws FileNotFoundException, IOException {// open main

		try {// open try
			DecimalFormat decimalFormat = new DecimalFormat("0.00");
			// create 3 queues
			Queue qCounter1 = new Queue();
			Queue qCounter2 = new Queue();
			Queue qCounter3 = new Queue();

			// create an empty stack
			Stack completedStack = new Stack();

			// Crate file reader to read input file
			BufferedReader br = new BufferedReader(new FileReader("customer.txt"));

			// Create LinkedList
			LinkedList<CustomerInformation> customerList = new LinkedList<CustomerInformation>();

			// Create object
			CustomerInformation cust;

			// Declare in data (a line in input file)
			String inline = null;

			double Total = 0.0;
			int totalCustomer = 0;

			while ((inline = br.readLine()) != null) {// open while
														// create Tokenizer
				StringTokenizer st = new StringTokenizer(inline, ";");
				String custId = st.nextToken();
				String custIC = st.nextToken();
				int counterPaid = Integer.parseInt(st.nextToken());

				// create ArrayList
				ArrayList<ItemInformation> itemList = new ArrayList<>();
				// create Tokenizer for item
				StringTokenizer itemToken = new StringTokenizer(st.nextToken(), ":");
				while (itemToken.hasMoreTokens()) {// open while for input data item
					StringTokenizer infoToken = new StringTokenizer(itemToken.nextToken(), ",");
					String itemId = infoToken.nextToken();
					String itemName = infoToken.nextToken();
					double itemPrice = Double.parseDouble(infoToken.nextToken());
					String date = infoToken.nextToken();

					ItemInformation item = new ItemInformation(itemId, itemName, itemPrice, date);
					itemList.add(item);
					counterPaid += itemPrice;

				} // close while for input data item

				// assign attribute to object
				cust = new CustomerInformation(custId, custIC, counterPaid);

				// add object to arraylist
				cust.addItem(itemList);
				// add object to LinkedList
				customerList.add(cust);
				totalCustomer++;
			} // close while
				// close input file after read all the data
			br.close();

			new Gui(customerList, qCounter1, qCounter2, qCounter3, totalCustomer, completedStack);

		} // close try
		catch (FileNotFoundException fnfe) {
			System.out.println("File not found");
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}// close main
}// close class
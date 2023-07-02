import java.text.DecimalFormat;
import java.util.*;

public class CustomerInformation {
	DecimalFormat decimalFormat = new DecimalFormat("0.00");

	// declaration of variable
	private String custId;
	private String custIC;
	private int counterPaid;
	private LinkedList<ItemInformation> itemList;

	// method Constructor with parameter
	CustomerInformation(String id, String ic, int paid) {
		custId = id;
		custIC = ic;
		counterPaid = paid;
		this.itemList = new LinkedList<>();
	}

	// Accessor for each attributes
	public String getCustIC() {
		return custIC;
	}

	public String getCustId() {
		return custId;
	}

	public int getCounterPaid() {
		return counterPaid;
	}

	// method to calculate the total price of all item purchased by customer
	public double totalPrice() {
		double total = 0;
		for (ItemInformation items : itemList) {
			total = total + items.getItemPrice();
		}
		return total;
	}

	// method to return the total number of items purchased by customer
	public int getItemQuantity() {
		return itemList.size();
	}

	// methods to add multiple items at once to the customer's list of purchased
	// items
	public void addItem(List<ItemInformation> items) {
		itemList.addAll(items);
	}

	// mutator for counter paid
	public void setCounterPaid(int counter) {
		counterPaid = counter;
	}

	// methods to add every single item to the customer's list of purchased items
	public void purchaseItem(ItemInformation item) {
		itemList.add(item);
	}

	// methods to remove a specific item from the customer's list of purchased items
	public void removePurchasedItem(ItemInformation item) {
		itemList.remove(item);
	}

	// method to display purchased items
	public String displayPurchasedItems() {
		ItemInformation item;
		StringBuilder sb = new StringBuilder();

		sb.append("\n+----------+---------+----------------+------------+--------------+\n");
		sb.append("|Item No.  | Item ID |   Item Name    | Item Price |     Date     |\n");
		sb.append("+----------+---------+----------------+------------+--------------+\n");

		for (int i = 0; i < itemList.size(); i++) {
			item = itemList.get(i);
			sb.append(String.format("| %-8s | %-7s | %-14s | %10.2f | %12s |%n", (i + 1), item.getItemId(),
					item.getItemName(), item.getItemPrice(), item.getDatePurchase()));
		}

		sb.append("+----------+---------+----------------+------------+--------------+\n");

		return sb.toString();
	}

	// printing method
	public String toString() {
		return ("ID: " + custId + "\nIc: " + custIC + "\nCounter Paid: " + counterPaid + "\nQuantity: "
				+ getItemQuantity() + displayPurchasedItems() + "Total : " + decimalFormat.format(totalPrice()) + "\n");
	}
}
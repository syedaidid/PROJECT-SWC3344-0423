import java.util.*;

class CustomerInformation {
	String custId;
	String custIC;
	double counterPaid;
	private LinkedList<ItemInformation> itemList;

	CustomerInformation(String id, String ic, double paid) {
		custId = id;
		custIC = ic;
		counterPaid = paid;
		this.itemList = new LinkedList<>();
	}

	public void purchaseItem(ItemInformation item) {
		itemList.add(item);
	}

	public void removePurchasedItem(ItemInformation item) {
		itemList.remove(item);
	}

	public String toString() {
		return ("ID: " + custId + "\nIc: " + custIC + "\nCounter Paid: " + counterPaid + "\nQuantity: "
				+ getItemQuantity() + "\n");
	}

	public void addItem(List<ItemInformation> items) {
		itemList.addAll(items);
	}

	public LinkedList<ItemInformation> getPurchasedItems() {
		return itemList;
	}

	public void displayPurchasedItems() {

		System.out.println("Customer ID: " + custId);
		System.out.println("Purchased Items");
		System.out.println("---------------");
		for (ItemInformation item : itemList) {
			System.out.println("Item ID: " + item.getItemId());
			System.out.println("Item Name: " + item.getItemName());
			System.out.println("Item Price: " + item.getItemPrice());
			System.out.print("\n");
		}
		System.out.println("Total: " + counterPaid);
		System.out.println("+---------------------------+");
	}

	public String getCustIC() {
		return null;
	}

	public String getCustId() {
		return null;
	}

	public String getCounterPaid() {
		return null;
	}

	public ArrayList<ItemInformation> getItems() {
		return null;
	}

	public int getItemQuantity() {
		return itemList.size();
	}
}

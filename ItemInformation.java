class ItemInformation {
	String itemId;
	String itemName;
	double itemPrice;
	String datePurchase;

	ItemInformation() {
		itemId = "";
		itemName = "";
		itemPrice = 0.0;
		datePurchase = "";
	}

	ItemInformation(String id, String name, double price, String d) {
		itemId = id;
		itemName = name;
		itemPrice = price;
		datePurchase = d;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getDatePurchase() {
		return datePurchase;
	}

}

package codingAssignment;

public class groceryItem {

	private int glist_id;
	private String name;
	private String department;
	private int quantity;
	private boolean purchased;
	
	public groceryItem(int glist_id, String name, String department, int quantity, boolean purchased) {
		this.setGlist_id(glist_id);
		this.setName(name);
		this.setDepartment(department);
		this.setQuantity(quantity);
		this.setPurchased(purchased);
	}

	public int getGlist_id() {
		return glist_id;
	}

	public void setGlist_id(int glist_id) {
		this.glist_id = glist_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isPurchased() {
		return purchased;
	}

	public void setPurchased(boolean purchased) {
		this.purchased = purchased;
	}
	
}

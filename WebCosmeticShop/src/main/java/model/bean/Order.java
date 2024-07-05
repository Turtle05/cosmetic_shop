package model.bean;

public class Order {
	private String OrderID;
	private String CustomerID;
	private String EmployeeID;
	private Float GrandTotal;

	public String getOrderID() {
		return OrderID;
	}

	public void setOrderID(String orderID) {
		OrderID = orderID;
	}

	public String getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}

	public String getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(String employeeID) {
		EmployeeID = employeeID;
	}

	public Float getGrandTotal() {
		return GrandTotal;
	}

	public void setGrandTotal(Float grandTotal) {
		GrandTotal = grandTotal;
	}

}

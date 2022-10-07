package appendixB;

public class Order {
	private int orderId;
	private String productId;
	private String productName;
	private String unit;
	private int volume;
	private String employeeId;

	//getterメソッド
	public int getOrderId() {
		return orderId;
	}

	//setterメソッド
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	//getterメソッド
	public String getProductId() {
		return productId;
	}

	//setterメソッド
	public void setProductId(String productId) {
		this.productId = productId;
	}

	//getterメソッド
	public String getProductName() {
		return productName;
	}

	//setterメソッド
	public void setProductName(String productName) {
		this.productName = productName;
	}

	//getterメソッド
	public String getUnit() {
		return unit;
	}

	//setterメソッド
	public void setUnit(String unit) {
		this.unit = unit;
	}

	//getterメソッド
	public int getVolume() {
		return volume;
	}

	//setterメソッド
	public void setVolume(int volume) {
		this.volume = volume;
	}

	//getterメソッド
	public String getemployeeId() {
		return employeeId;
	}
	//setterメソッド
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

}

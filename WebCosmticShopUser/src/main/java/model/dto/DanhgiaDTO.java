package model.dto;

public class DanhgiaDTO {
	private String id;
	private String customerID;
	private String productGroupID;
	private int star;
	private String comment;
	private float starRate;
	private int rateNum;
	private String fullname;

	
	
	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getProductGroupID() {
		return productGroupID;
	}

	public void setProductGroupID(String productGroupID) {
		this.productGroupID = productGroupID;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public float getStarRate() {
		return starRate;
	}

	public void setStarRate(float starRate) {
		this.starRate = starRate;
	}

	public int getRateNum() {
		return rateNum;
	}

	public void setRateNum(int rateNum) {
		this.rateNum = rateNum;
	}

}

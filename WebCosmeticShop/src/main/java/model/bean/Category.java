package model.bean;

public class Category {

	private String CategoryID;
	private String CategoryName;
	private String CategoryGroupID;
	private String CategoryGroupName;
	
	
	public String getCategoryGroupName() {
		return CategoryGroupName;
	}
	public void setCategoryGroupName(String categoryGroupName) {
		CategoryGroupName = categoryGroupName;
	}
	public String getCategoryID() {
		return CategoryID;
	}
	public void setCategoryID(String categoryID) {
		CategoryID = categoryID;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryGroupName) {
		CategoryName = categoryGroupName;
	}
	public String getCategoryGroupID() {
		return CategoryGroupID;
	}
	public void setCategoryGroupID(String categoryGroupID) {
		CategoryGroupID = categoryGroupID;
	}
	
	
}

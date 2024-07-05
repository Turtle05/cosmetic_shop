package model.bean;

public class Customer {
private String CustomerID;
private String Fullname;
private String Email;
private String Phone;
private String Gender;
private String Address;
private String Enable;

private String Birthday;
private String Username;
private String Password;



public String getEnable() {
	return Enable;
}
public void setEnable(String enable) {
	Enable = enable;
}
public String getCustomerID() {
	return CustomerID;
}
public void setCustomerID(String customerID) {
	CustomerID = customerID;
}
public String getFullname() {
	return Fullname;
}
public void setFullname(String fullname) {
	Fullname = fullname;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getPhone() {
	return Phone;
}
public void setPhone(String phone) {
	Phone = phone;
}
public String getGender() {
	return Gender;
}
public void setGender(String gender) {
	Gender = gender;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public String getBirthday() {
	return Birthday;
}
public void setBirthday(String birthday) {
	Birthday = birthday;
}
public String getUsername() {
	return Username;
}
public void setUsername(String username) {
	Username = username;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}

}

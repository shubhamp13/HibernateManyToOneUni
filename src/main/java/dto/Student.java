package dto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Student 
{
	@Id
	private int id;
	private String name;
	private String emailId;
	private String address;
	private long phNo;
	@ManyToOne 
	private Department department;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhNo() {
		return phNo;
	}
	public void setPhNo(long phNo) {
		this.phNo = phNo;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", emailId=" + emailId + ", address=" + address + ", phNo="
				+ phNo + ", department=" + department + "]";
	}
	
	
}

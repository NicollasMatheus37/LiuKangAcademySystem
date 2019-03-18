package model;

import java.util.Date;

public class RegistrationModel {
	
	private int registrationCode;	
	private int studentCode;
	private Date registrationDate;
	private int dueDate;
	private Date endDate;
	
	public int getRegistrationCode() {
		return registrationCode;
	}
	public void setRegistrationCode(int registrationCode) {
		this.registrationCode = registrationCode;
	}
	public int getStudentCode() {
		return studentCode;
	}
	public void setStudentCode(int studentCode) {
		this.studentCode = studentCode;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public int getDueDate() {
		return dueDate;
	}
	public void setDueDate(int dueDate) {
		this.dueDate = dueDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
}

















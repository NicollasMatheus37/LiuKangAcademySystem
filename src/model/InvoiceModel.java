package model;

import java.util.Date;

public class InvoiceModel {
	
	private int registrationCode;
	private Date dueDate;
	private float value;
	private Date paymentDate;
	private Date cancelDate;
	
	public int getRegistrationCode() {
		return registrationCode;
	}
	public void setRegistrationCode(int registrationCode) {
		this.registrationCode = registrationCode;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public Date getCancelDate() {
		return cancelDate;
	}
	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}
	
	
}

















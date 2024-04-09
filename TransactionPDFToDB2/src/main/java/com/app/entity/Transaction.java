package com.app.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String transactionId;
	private double transactionAmount;
	private LocalDateTime transactionDate;
	private String transactionType; 
	private String transactionDetails;// Adding transactionType field

	// Constructors
	public Transaction() {
	}

	

	public Transaction(String transactionId, double transactionAmount, LocalDateTime transactionDate,
			String transactionType, String transactionDetails) {
		super();
		this.transactionId = transactionId;
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
		this.transactionType = transactionType;
		this.transactionDetails = transactionDetails;
	}



	// toString() method
	@Override
	public String toString() {
		return "Transaction{" + "id=" + id + ", transactionId='" + transactionId + '\'' + ", transactionAmount='"
				+ transactionAmount + '\'' + ", transactionDate='" + transactionDate + '\'' + ", transactionType='"
				+ transactionType + '\'' + '}';
	}



	public String getTransactionId() {
		return transactionId;
	}



	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}



	public double getTransactionAmount() {
		return transactionAmount;
	}



	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}



	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}



	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}



	public String getTransactionType() {
		return transactionType;
	}



	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}



	public String getTransactionDetails() {
		return transactionDetails;
	}



	public void setTransactionDetails(String transactionDetails) {
		this.transactionDetails = transactionDetails;
	}

	

	
}

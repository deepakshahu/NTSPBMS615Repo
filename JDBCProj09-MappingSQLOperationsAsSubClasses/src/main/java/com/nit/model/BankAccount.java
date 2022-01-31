package com.nit.model;

import lombok.Data;

@Data
public class BankAccount {
	private Long acno;
	private String holderName;
	private Float balance;
	private String status;
}

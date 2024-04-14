package az.hafizrzazade.bankingsystem.model;

import java.time.LocalDate;

public class Transaction {
	private Integer id;
	private Integer accountId;
	private String transactionType;
	private Integer amount;
	private LocalDate transactionDateTime;

	public Integer getId() {
		return id;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public LocalDate getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(LocalDate transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", accountId=" + accountId + ", transactionType=" + transactionType
				+ ", amount=" + amount + ", transactionDateTime=" + transactionDateTime + "]";
	}

}

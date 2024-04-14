package az.hafizrzazade.bankingsystem.model;

public class CustomerAccount {
	private Integer id;
	private String customerFullName;
	private String customerPhoneNumber;
	private String accountPassword;
	private Integer moneyAmount;

	public Integer getId() {
		return id;
	}

	public String getCustomerFullName() {
		return customerFullName;
	}

	public void setCustomerFullName(String customerFullName) {
		this.customerFullName = customerFullName;
	}

	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public String getAccountPassword() {
		return accountPassword;
	}

	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}

	public Integer getMoneyAmount() {
		return moneyAmount;
	}

	public void setMoneyAmount(Integer moneyAmount) {
		this.moneyAmount = moneyAmount;
	}

	@Override
	public String toString() {
		return "CustomerAccount [id=" + id + ", customerFullName=" + customerFullName + ", customerPhoneNumber="
				+ customerPhoneNumber + ", accountPassword=" + accountPassword + ", moneyAmount=" + moneyAmount + "]";
	}

}

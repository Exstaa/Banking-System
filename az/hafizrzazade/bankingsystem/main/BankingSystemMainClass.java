package az.hafizrzazade.bankingsystem.main;


import az.hafizrzazade.bankingsystem.model.CustomerAccount;
import az.hafizrzazade.bankingsystem.model.Transaction;
import az.hafizrzazade.bankingsystem.repository.CustomerAccountRepository;
import az.hafizrzazade.bankingsystem.repository.TransactionRepository;

public class BankingSystemMainClass {
	public static void main(String[] args) {
		Transaction transaction = new Transaction();
		CustomerAccount customerAccount = new CustomerAccount();
		CustomerAccountRepository customerAccountRepository = new CustomerAccountRepository();
		TransactionRepository transactionRepository = new TransactionRepository();		
	}
}

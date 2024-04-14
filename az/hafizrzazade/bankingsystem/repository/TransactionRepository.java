package az.hafizrzazade.bankingsystem.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import az.hafizrzazade.bankingsystem.database.Database;
import az.hafizrzazade.bankingsystem.model.Transaction;

public class TransactionRepository {
	private Connection conn;

	public void addTransaction(Transaction t) {
		try {
			conn = Database.connect();
			PreparedStatement st;
			ResultSet rs;
			if (t.getTransactionType().equals("Deposit")) {
				st = conn.prepareStatement("SELECT * FROM customer_account WHERE id='" + t.getAccountId() + "'");
				rs = st.executeQuery();
				if (rs.next()) {
					Integer accountAmount = rs.getInt("amount") + t.getAmount();
					st = conn.prepareStatement("UPDATE customer_account SET amount='" + accountAmount + "' WHERE id='"
							+ t.getAccountId() + "'");
					st.execute();
					st = conn.prepareStatement(
							"INSERT INTO transaction(account_id,transaction_type,amount,transaction_date) VALUES(?,?,?,?)");
					st.setInt(1, t.getAccountId());
					st.setString(2, t.getTransactionType());
					st.setInt(3, t.getAmount());
					st.setDate(4, Date.valueOf(t.getTransactionDateTime()));
					st.execute();
					System.out.println("Operation has been successfully completed.");
				} else {
					System.out.println("Account not found.");
				}
			} else {
				st = conn.prepareStatement("SELECT * FROM customer_account WHERE id='" + t.getAccountId() + "'");
				rs = st.executeQuery();
				if (rs.next()) {
					Integer accountAmount;
					if (rs.getInt("amount") > t.getAmount()) {
						accountAmount = rs.getInt("amount") - t.getAmount();
					} else {
						accountAmount = t.getAmount() - rs.getInt("amount");
					}
					st = conn.prepareStatement("UPDATE customer_account SET amount='" + accountAmount + "' WHERE id='"
							+ t.getAccountId() + "'");
					st.execute();
					st = conn.prepareStatement(
							"INSERT INTO transaction(account_id,transaction_type,amount,transaction_date) VALUES(?,?,?,?)");
					st.setInt(1, t.getAccountId());
					st.setString(2, t.getTransactionType());
					st.setInt(3, t.getAmount());
					st.setDate(4, Date.valueOf(t.getTransactionDateTime()));
					st.execute();
					System.out.println("Operation has been successfully completed.");
				} else {
					System.out.println("Account not found");
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}

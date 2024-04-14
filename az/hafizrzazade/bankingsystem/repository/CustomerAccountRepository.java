package az.hafizrzazade.bankingsystem.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import az.hafizrzazade.bankingsystem.database.Database;
import az.hafizrzazade.bankingsystem.model.CustomerAccount;

public class CustomerAccountRepository {
	private Connection conn;

	// Account Password Has To Be Unique.

	public void signUpToAccount(CustomerAccount c) {
		try {
			conn = Database.connect();
			String query = "SELECT * FROM customer_account WHERE password='" + c.getAccountPassword() + "'";
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet resultSet = st.executeQuery();
			if (resultSet.next()) {
				System.out.println("Welcome " + resultSet.getString("fullname"));
			} else {
				query = "INSERT INTO customer_account(fullname,phone,password,amount) VALUES(?,?,?,?)";
				st = conn.prepareStatement(query);
				st.setString(1, c.getCustomerFullName());
				st.setString(2, c.getCustomerPhoneNumber());
				st.setString(3, c.getAccountPassword());
				st.setInt(4, c.getMoneyAmount());
				st.execute();
				System.out.println("Account has been created successfully.");
			}

			st.close();
			conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public String getAccountByPassword(String accountPassword) {
		String returnString = null;
		try {
			CustomerAccount account;
			conn = Database.connect();
			String query = "SELECT * FROM customer_account WHERE password='" + accountPassword + "'";
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet resultSet = st.executeQuery();
			if (resultSet.next()) {
				account = new CustomerAccount();
				account.setCustomerFullName(resultSet.getString("fullname"));
				account.setAccountPassword(resultSet.getString("password"));
				account.setCustomerPhoneNumber(resultSet.getString("password"));
				account.setMoneyAmount(resultSet.getInt("amount"));
				System.out.println(account.toString());
				st.close();
				conn.close();
				returnString = account.toString();
			} else {
				returnString = "Account not found.";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return returnString;
	}

	public void deleteAccount(String accountPassword) {
		try {
			conn = Database.connect();
			String query = "SELECT * FROM customer_account WHERE password='" + accountPassword + "'";
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet resultSet = st.executeQuery();
			if (resultSet.next()) {
				query = "DELETE FROM customer_account WHERE password='" + accountPassword + "'";
				st = conn.prepareStatement(query);
				st.execute();
				System.out.println("Account has been deleted successfully");
			} else {
				System.out.println("Account not found.");
			}

			st.close();
			conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}

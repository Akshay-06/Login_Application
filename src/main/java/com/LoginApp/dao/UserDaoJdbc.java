package com.LoginApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.LoginApp.Util.DbConnector;
import com.LoginApp.model.User;

public class UserDaoJdbc implements UserDao {
	public Connection getConnection() {
		DbConnector dbConfig = new DbConnector();
		return dbConfig.connectToDatabase();
	}

	@Override
	public boolean checkUserCredentials(User user) {

		String query = "select * from users where username=? and password=?";
		Connection con = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());

			rs = ps.executeQuery();
			if (rs.next())
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createUser(User user) {
		// TODO Auto-generated method stub

		String query = "insert into users(username,email,password) values (?,?,?)";
		Connection con = getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());

			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub

		User user = new User();
		String query = "select * from users where username=?";
		Connection con = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				user.setEmail(rs.getString("email"));
				user.setId(rs.getInt("id"));
				user.setPassword(rs.getString("password"));
				user.setUsername(rs.getString("username"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub

		String query = "update users set username=?, password=? where email=?";
		Connection con = getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbconnection.ConnectionProvider;
import userbean.UserBean;

public class UserDao {

    private Connection conn;

    public UserDao() {
    	conn = ConnectionProvider.getConnection();
    }

    public void addUser(UserBean userBean) {
        try {
        	String sql = "INSERT INTO users(userid, firstname,lastname)" +
    		" VALUES (?, ?, ? )";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, userBean.getCustomerId());
            ps.setString(2, userBean.getCustFirstName());
            ps.setString(3, userBean.getCustLastName());            
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUser(int userId) {
        try {
        	String sql = "DELETE FROM users WHERE userid=?";
            PreparedStatement ps = conn
                    .prepareStatement(sql);
            ps.setInt(1, userId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
      }

    public void editUser(UserBean userBean) {    	
    	try {
    		String sql = "UPDATE users SET firstname=?, lastname=?" +
            " WHERE userid=?";
            PreparedStatement ps = conn
                    .prepareStatement(sql);
            ps.setString(1, userBean.getCustFirstName());
            ps.setString(2, userBean.getCustLastName());            
            ps.setInt(3, userBean.getCustomerId());
            ps.executeUpdate();            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<UserBean> getAllUsers() {
        List<UserBean> users = new ArrayList<UserBean>();
        try {
        	String sql = "SELECT * FROM Customers";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserBean userBean = new UserBean();
                userBean.setCustomerId(rs.getInt("CustomerId"));
                userBean.setCustFirstName(rs.getString("CustFirstName"));
                userBean.setCustLastName(rs.getString("CustLastName"));                             
                users.add(userBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public UserBean getUserById(int userId) {
    	UserBean userBean = new UserBean();
        try {
        	String sql = "SELECT * FROM users WHERE userid=?";
            PreparedStatement ps = conn.
                    prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            	userBean.setCustomerId(rs.getInt("userid"));
            	userBean.setCustFirstName(rs.getString("firstname"));
            	userBean.setCustLastName(rs.getString("lastname"));                           
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userBean;
    }
}
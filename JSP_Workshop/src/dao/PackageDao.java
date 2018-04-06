package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbconnection.ConnectionProvider;
import packages.Packages;


public class PackageDao {
	
	

	 private Connection conn;
	 
	 public PackageDao(){
	    	conn = ConnectionProvider.getConnection();
	    }
	 
	 public List<Packages> getPackagesForCustomer(String userId) {
	        List<Packages> packageList = new ArrayList<Packages>();
	        try {
	        	String sql = "SELECT p.PackageId, PkgName, PkgStartDate, PkgEndDate, PkgDesc, PkgBasePrice, BookingId, BookingDate, TravelerCount FROM Packages p INNER JOIN Bookings b ON b.PackageId = p.PackageId INNER JOIN Customers c ON c.CustomerId = b.CustomerId Where userid=?";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, userId);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                Packages pkgs = new Packages();
	                pkgs.setPackageId(rs.getInt("PackageId"));
	                pkgs.setPkgName(rs.getString("PkgName"));
	                pkgs.setPkgStartDate(rs.getDate("pkgStartDate"));    
	                pkgs.setPkgEndDate(rs.getDate("pkgEndDate"));
	                pkgs.setPkgDesc(rs.getString("pkgDesc"));
	                pkgs.setPkgBasePrice(rs.getDouble("pkgBasePrice"));
	                pkgs.setBookingId(rs.getInt("BookingId"));
	                pkgs.setBookingDate(rs.getDate("BookingDate"));
	                
	                packageList.add(pkgs);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return packageList;
	    }
	
	
}

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
	 
	 public List<Packages> getPackagesForCustomer(int customerId) {
	        List<Packages> packageList = new ArrayList<Packages>();
	        try {
	        	String sql = "SELECT Packages.PackageId, PkgName, PkgStartDate, PkgEndDate, PkgDesc, PkgBasePrice, BookingId, BookingDate, TravelerCount FROM Packages INNER JOIN Bookings ON Bookings.PackageId = Packages.PackageId Where CustomerId=?";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, customerId);
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

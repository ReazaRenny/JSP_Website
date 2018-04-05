package packages;

import java.sql.Date;

public class Packages {

	 public int PackageId;
     public String PkgName;
     public Date PkgStartDate;
     public Date PkgEndDate;
     public String PkgDesc;
     public Double PkgBasePrice;
     public int BookingId;
     public Date BookingDate;
     public int TravelerCount;
     
	public int getPackageId() {
		return PackageId;
	}
	public void setPackageId(int packageId) {
		PackageId = packageId;
	}
	public String getPkgName() {
		return PkgName;
	}
	public void setPkgName(String pkgName) {
		PkgName = pkgName;
	}
	public Date getPkgStartDate() {
		return PkgStartDate;
	}
	public void setPkgStartDate(Date pkgStartDate) {
		PkgStartDate = pkgStartDate;
	}
	public Date getPkgEndDate() {
		return PkgEndDate;
	}
	public void setPkgEndDate(Date pkgEndDate) {
		PkgEndDate = pkgEndDate;
	}
	public String getPkgDesc() {
		return PkgDesc;
	}
	public void setPkgDesc(String pkgDesc) {
		PkgDesc = pkgDesc;
	}
	public Double getPkgBasePrice() {
		return PkgBasePrice;
	}
	public void setPkgBasePrice(Double pkgBasePrice) {
		PkgBasePrice = pkgBasePrice;
	}
	public int getBookingId() {
		return BookingId;
	}
	public void setBookingId(int bookingId) {
		BookingId = bookingId;
	}
	public Date getBookingDate() {
		return BookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		BookingDate = bookingDate;
	}
	public int getTravelerCount() {
		return TravelerCount;
	}
	public void setTravelerCount(int travelerCount) {
		TravelerCount = travelerCount;
	}
	
}

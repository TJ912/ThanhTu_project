package Model;

public class DocGia {
	private String hoTen;
	private String mssv;
	private String email;
	private String soDt;
	public DocGia(String mssv,String hoTen, String soDt,  String email) {
		this.hoTen = hoTen;
		this.mssv = mssv;
		this.email = email;
		this.soDt = soDt;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getMssv() {
		return mssv;
	}
	public void setMssv(String mssv) {
		this.mssv = mssv;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSoDt() {
		return soDt;
	}
	public void setSoDt(String soDt) {
		this.soDt = soDt;
	}
	
	
}

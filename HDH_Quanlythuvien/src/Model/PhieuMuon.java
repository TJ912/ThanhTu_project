package Model;

import java.util.Date;

public class PhieuMuon {
	private String maSach;
	private String mssv;
	private String ngayMuon;
	private String ngayTra;
//	private Date ngayMuon
	
	public PhieuMuon(String maSach,String mssv, String ngayMuon, String ngayTra) {
		this.maSach = maSach;
		this.mssv=mssv;
		this.ngayMuon = ngayMuon;
		this.ngayTra = ngayTra;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getNgayMuon() {
		return ngayMuon;
	}

	public void setNgayMuon(String ngayMuon) {
		this.ngayMuon = ngayMuon;
	}

	public String getNgayTra() {
		return ngayTra;
	}

	public void setNgayTra(String ngayTra) {
		this.ngayTra = ngayTra;
	}

	public String getMssv() {
		return mssv;
	}

	public void setMssv(String mssv) {
		this.mssv = mssv;
	}
	
	
}

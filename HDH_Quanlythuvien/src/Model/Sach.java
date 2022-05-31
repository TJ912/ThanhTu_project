package Model;

public class Sach {

	protected String maSach;
	protected String tenSach;
	protected String tacGia;
	protected String namXuatBan;
	protected int soLuongSachDaMuon;
	protected int soLuongSachConLai;
	protected TheLoai theLoai;

	public Sach(String maSach, String tenSach, String tacGia,TheLoai theLoai, String namXuatBan, int soLuongSachDaMuon,
			int soLuongSachConLai) {
		super();
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.tacGia = tacGia;
		this.theLoai=theLoai;
		this.namXuatBan = namXuatBan;
		this.soLuongSachDaMuon = soLuongSachDaMuon;
		this.soLuongSachConLai = soLuongSachConLai;
	}
	
	

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public String getNamXuatBan() {
		return namXuatBan;
	}

	public void setNamXuatBan(String namXuatBan) {
		this.namXuatBan = namXuatBan;
	}

	public int getSoLuongSachDaMuon() {
		return soLuongSachDaMuon;
	}

	public void setSoLuongSachDaMuon(int soLuongSachDaMuon) {
		this.soLuongSachDaMuon = soLuongSachDaMuon;
	}

	public int getSoLuongSachConLai() {
		return soLuongSachConLai;
	}

	public void setSoLuongSachConLai(int soLuongSachConLai) {
		this.soLuongSachConLai = soLuongSachConLai;
	}

	@Override
	public String toString() {
		return "Sach [maSach=" + maSach + ", tenSach=" + tenSach + ", tacGia=" + tacGia + ", namXuatBan=" + namXuatBan
				+ ", soLuongSachDaMuon=" + soLuongSachDaMuon + ", soLuongSachConLai=" + soLuongSachConLai + "]";
	}

	public String getTheLoai() {
		return this.theLoai.getTenTheLoai();
	}

	public int getThoigianmuon() {
		return this.theLoai.getThoiGianMuon();
	}
	
}

package Dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import Model.DocGia;
import Model.GiaoTrinh;
import Model.Khac;
import Model.KhoaLuanTieuLuan;
import Model.LuanVanLuanAn;
import Model.PhieuMuon;
import Model.Sach;
import Model.SachThamKhao;
import Model.TheLoai;

public class Dao {
	public ArrayList<Sach> readBookFromFile() {
		ArrayList<Sach> list = new ArrayList<Sach>();
		String fileName = "src/Data/Sach.txt";
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName, StandardCharsets.UTF_8));
			String line = br.readLine();
			while (line != null) {
				String[] attributes = line.trim().split(",");
				String theLoai = attributes[4];
				TheLoai theLoai2;
				if (theLoai.equalsIgnoreCase("Giáo trình")) {
					theLoai2 = new GiaoTrinh();
				} else if (theLoai.equalsIgnoreCase("Khóa luận/tiểu luận")) {
					theLoai2 = new KhoaLuanTieuLuan();
				} else if (theLoai.equalsIgnoreCase("Luận văn/luận án")) {
					theLoai2 = new LuanVanLuanAn();
				} else if (theLoai.equalsIgnoreCase("Sách tham khảo")) {
					theLoai2 = new SachThamKhao();
				} else if (theLoai.equalsIgnoreCase("Khác")) {
					theLoai2 = new Khac();
				} else {
					theLoai2 = null;
				}

				Sach sach = new Sach(attributes[0], attributes[1], attributes[2], theLoai2, attributes[3],
						Integer.parseInt(attributes[5]), Integer.parseInt(attributes[6]));

				list.add(sach);
				line = br.readLine();
			}
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return list;
	}

	public void writeBookToFile(ArrayList<Sach> list) {
		String fileName = "src/Data/Sach.txt";
		try {
			BufferedWriter br = new BufferedWriter(new FileWriter(fileName, StandardCharsets.UTF_8));
			for (Sach sach : list) {
				String string = sach.getMaSach() + "," + sach.getTenSach() + "," + sach.getTacGia() + ","
						+ sach.getNamXuatBan() + "," + sach.getTheLoai() + "," + sach.getSoLuongSachDaMuon() + ","
						+ sach.getSoLuongSachConLai() + "\n";
				br.write(string);
			}
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public ArrayList<DocGia> readReaderFromFile() {
		ArrayList<DocGia> list = new ArrayList<DocGia>();
		String fileName = "src/Data/Docgia.txt";
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName, StandardCharsets.UTF_8));
			String line = br.readLine();
			while (line != null) {
				String[] attributes = line.trim().split(",");
				String mssvString = attributes[0];
				String hoTenString = attributes[1];
				String soDtString = attributes[2];
				String emailString = attributes[3];

				DocGia docGia = new DocGia(mssvString, hoTenString, soDtString, emailString);

				list.add(docGia);
				line = br.readLine();
			}
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return list;
	}

	public void writeReaderToFile(ArrayList<DocGia> list) {
		String fileName = "src/Data/Docgia.txt";
		try {
			BufferedWriter br = new BufferedWriter(new FileWriter(fileName, StandardCharsets.UTF_8));
			for (DocGia docGia : list) {
				String string = docGia.getMssv() + "," + docGia.getHoTen() + "," + docGia.getSoDt() + ","
						+ docGia.getEmail() + "\n";
				br.write(string);
			}
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public ArrayList<PhieuMuon> readTicketFromFile() {
		ArrayList<PhieuMuon> list = new ArrayList<PhieuMuon>();
		String fileName = "src/Data/Phieumuon.txt";
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName, StandardCharsets.UTF_8));
			String line = br.readLine();
			while (line != null) {
				String[] attributes = line.trim().split(",");
				String maSachString = attributes[0];
				String mssvString = attributes[1];
				String ngayMuonString = attributes[2];
				String ngayTraString = attributes[3];
				PhieuMuon phieuMuon = new PhieuMuon(maSachString, mssvString, ngayMuonString, ngayTraString);
				list.add(phieuMuon);
				line = br.readLine();
			}
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return list;
	}
	
	public void writeTicketToFile(ArrayList<PhieuMuon> list) {
		String fileName = "src/Data/Phieumuon.txt";
		try {
			BufferedWriter br = new BufferedWriter(new FileWriter(fileName, StandardCharsets.UTF_8));
			for (PhieuMuon docGia : list) {
				String string = docGia.getMaSach() + "," + docGia.getMssv() + "," + docGia.getNgayMuon() + ","
						+ docGia.getNgayTra() + "\n";
				br.write(string);
			}
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}

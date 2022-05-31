package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import com.toedter.calendar.JDateChooser;

import Dao.Dao;
import Model.DocGia;
import Model.PhieuMuon;
import Model.Sach;
import other.BorderDesign;
import other.RGB;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Formatter;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QuanLyPhieuMuon extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textMasach;
	private JTextField textMssv;
	private JTextField textTimkiem;
	private JDateChooser dateNgaymuon;
	private JDateChooser dateNgaytra;
	private JTable table;
	private DefaultTableModel tableModel;
	private static ArrayList<PhieuMuon> listTicket=new Dao().readTicketFromFile();
	private static ArrayList<Sach> listBook=new Dao().readBookFromFile();
	private static ArrayList<DocGia> listReader=new Dao().readReaderFromFile();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyPhieuMuon frame = new QuanLyPhieuMuon();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QuanLyPhieuMuon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
//***********************Khung Phieu Muon *********************************
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 1186, 613);
		contentPane_1.setBackground(new RGB().DarkSaphire);
		contentPane.add(contentPane_1);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setToolTipText("");
		panel.setBackground(Color.WHITE);
		panel.setBorder(new MatteBorder(0,0,10,0,new RGB().SunFlower));
		panel.setBounds(0, 0, 1186, 82);
		contentPane_1.add(panel);

		JLabel lblQuanLySach = new JLabel("QU\u1EA2N L\u00DD PHI\u1EBEU M\u01AF\u1EE2N");
		lblQuanLySach.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuanLySach.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblQuanLySach.setBorder(new BorderDesign().getLineBorder(new Color(229, 57, 53)));
		lblQuanLySach.setBounds(397, 18, 386, 46);
		panel.add(lblQuanLySach);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new BorderDesign().getTitle("Thêm và chỉnh sửa", new RGB().DarkGrey,new RGB().SunFlower));
		panel_1.setBackground(new RGB().MidnightBlue);
		panel_1.setBounds(0, 92, 421, 362);
		contentPane_1.add(panel_1);

		JLabel lblMSch = new JLabel("M\u00E3 s\u00E1ch");
		lblMSch.setBounds(21, 93, 130, 13);
		lblMSch.setForeground(Color.white);
		panel_1.add(lblMSch);

		JLabel lblMssv = new JLabel("MSSV");
		lblMssv.setBounds(21, 133, 130, 13);
		lblMssv.setForeground(Color.white);
		panel_1.add(lblMssv);

		JLabel lblNgyMn = new JLabel("Ng\u00E0y m\u01B0\u1EE3n");
		lblNgyMn.setBounds(21, 173, 130, 13);
		lblNgyMn.setForeground(Color.white);
		panel_1.add(lblNgyMn);

		JLabel lblNgyPhiTr = new JLabel("Ng\u00E0y ph\u1EA3i tr\u1EA3");
		lblNgyPhiTr.setBounds(21, 213, 130, 13);
		lblNgyPhiTr.setForeground(Color.white);
		panel_1.add(lblNgyPhiTr);

		textMasach = new JTextField();
		textMasach.setColumns(10);
		textMasach.setBounds(178, 90, 202, 19);
		panel_1.add(textMasach);

		textMssv = new JTextField();
		textMssv.setColumns(10);
		textMssv.setBounds(178, 130, 202, 19);
		panel_1.add(textMssv);

		dateNgaymuon = new JDateChooser();
		dateNgaymuon.setBounds(178, 173, 202, 19);
		dateNgaymuon.setDateFormatString("dd/MM/yyyy");
		panel_1.add(dateNgaymuon);

		dateNgaytra = new JDateChooser();
		dateNgaytra.setBounds(178, 207, 202, 19);
		dateNgaytra.setDateFormatString("dd/MM/yyyy");
		panel_1.add(dateNgaytra);
		//*******************Khum tim kiem***************************
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(452, 95, 324, 57);
		panel_2.setBorder(new BorderDesign().getMatte(5,Color.yellow));
		contentPane_1.add(panel_2);

		JLabel lblTmKimTheo = new JLabel("Tìm kiếm theo MSSV");
		lblTmKimTheo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTmKimTheo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTmKimTheo.setBounds(84, 5, 156, 20);
		panel_2.add(lblTmKimTheo);

		textTimkiem = new JTextField();
		textTimkiem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
					if (textTimkiem.getText().length() == 0) {
						tableModel.setRowCount(0);
						addDatatotable();
					}
				}
			}
		});
		textTimkiem.setColumns(10);
		textTimkiem.setBounds(25, 28, 162, 19);
		panel_2.add(textTimkiem);

		JButton btnTimkiem = new JButton("T\u00ECm ki\u1EBFm");
		btnTimkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String timkiemString = textTimkiem.getText();
				int count = 0;
				if (timkiemString.trim().length() != 0) {
					for (PhieuMuon i : listTicket) {
						if (i.getMssv().contains(timkiemString.trim())) {
							tableModel.setRowCount(count);
							tableModel.addRow(
									new Object[] { i.getMaSach(), i.getMssv(), i.getNgayMuon(), i.getNgayTra() });
							count++;
						}
					}
					if (count == 0) {
						JOptionPane.showMessageDialog(contentPane, "Không có phiếu mượn phù hợp");
					}
				}else {
					JOptionPane.showMessageDialog(contentPane, "vui lòng điền thông tin vào ô tìm kiếm");
				}
			}
		});
		btnTimkiem.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTimkiem.setBounds(210, 27, 93, 21);
		panel_2.add(btnTimkiem);

		JButton btnTaomoi = new JButton("T\u1EA1o m\u1EDBi");
		btnTaomoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNull();
			}
		});
		btnTaomoi.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTaomoi.setBounds(10, 491, 85, 21);
		contentPane_1.add(btnTaomoi);

		JButton btnThem = new JButton("Th\u00EAm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maSachString = textMasach.getText();
				String mssvString = textMssv.getText();
				Date ngayMuonDate = dateNgaymuon.getDate();
				Date ngayTraDate = dateNgaytra.getDate();
				PhieuMuon phieuMuon = checkValidTicket(maSachString, mssvString, ngayMuonDate, ngayTraDate);
				if (phieuMuon != null) {
					listTicket.add(phieuMuon);
					listBook.get(indexOfBook(maSachString))
							.setSoLuongSachConLai(listBook.get(indexOfBook(maSachString)).getSoLuongSachConLai() - 1);
					listBook.get(indexOfBook(maSachString))
							.setSoLuongSachDaMuon(listBook.get(indexOfBook(maSachString)).getSoLuongSachDaMuon() + 1);
					tableModel.addRow(new Object[] { phieuMuon.getMaSach(), phieuMuon.getMssv(),
							phieuMuon.getNgayMuon(), phieuMuon.getNgayTra() });
					setNull();
					JOptionPane.showMessageDialog(contentPane, "Thêm thành công");
				}
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThem.setBounds(170, 491, 85, 21);
		contentPane_1.add(btnThem);

		JButton btnXoa = new JButton("X\u00F3a");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getRowCount() != 0) {
					if (table.getSelectedRowCount() == 0) {
						JOptionPane.showMessageDialog(contentPane, "Vui lòng chọn một hàng để xóa");
					} else if (table.getSelectedRowCount() > 1) {
						JOptionPane.showMessageDialog(contentPane, "Mỗi lần chỉ xóa được một hàng");
					} else {
						listTicket.remove(indexOfTicket(tableModel.getValueAt(table.getSelectedRow(), 1).toString()));
						listBook.get(indexOfBook(tableModel.getValueAt(table.getSelectedRow(), 0).toString()))
								.setSoLuongSachConLai(listBook
										.get(indexOfBook(tableModel.getValueAt(table.getSelectedRow(), 0).toString()))
										.getSoLuongSachConLai() + 1);
						listBook.get(indexOfBook(tableModel.getValueAt(table.getSelectedRow(), 0).toString()))
								.setSoLuongSachDaMuon(listBook
										.get(indexOfBook(tableModel.getValueAt(table.getSelectedRow(), 0).toString()))
										.getSoLuongSachDaMuon() - 1);
						tableModel.removeRow(table.convertColumnIndexToModel(table.getSelectedRow()));
						JOptionPane.showMessageDialog(contentPane, "Xóa thành công");
					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "Bảng trống");
				}
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXoa.setBounds(330, 491, 85, 21);
		contentPane_1.add(btnXoa);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(450, 161, 726, 293);
		contentPane_1.add(scrollPane);
//********************Bang du lieu**************************
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (table.getSelectedRowCount() == 1) {
					textMasach.setText(tableModel.getValueAt(table.getSelectedRow(), 0).toString());
					textMssv.setText(tableModel.getValueAt(table.getSelectedRow(), 1).toString());
					try {
						dateNgaymuon.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(table.getValueAt(table.getSelectedRow(), 2).toString()));
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						dateNgaytra.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(table.getValueAt(table.getSelectedRow(), 3).toString()));
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		tableModel = new DefaultTableModel(new Object[][] {}, new String[] { "M\u00E3 s\u00E1ch", "MSSV",
				"Ng\u00E0y m\u01B0\u1EE3n", "Ng\u00E0y ph\u1EA3i tr\u1EA3" }) {
			/**
					 * 
					 */
					private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);

		scrollPane.setViewportView(table);
		addDatatotable();
		table.setAutoCreateRowSorter(true);

		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);
		sorter.setModel(table.getModel());
		Comparator<String> comparator = new Comparator<String>() {
			@Override
			public int compare(String name1, String name2) {
				String[] s = name1.split(" ");
				String[] k = name2.split(" ");
				int p = (s[s.length - 1].length());
				int q = (k[k.length - 1].length());
				return (name1.substring(name1.length() - p, name1.length()))
						.compareToIgnoreCase(name2.substring(name2.length() - q, name2.length()));
			}
		};
		sorter.setComparator(0, comparator);
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dao objDao = new Dao();
				objDao.writeBookToFile(listBook);
				objDao.writeReaderToFile(listReader);
				objDao.writeTicketToFile(listTicket);
				Home obj = new Home();
				obj.setVisible(true);
				setVisible(false);
			}
		});
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHome.setBounds(1004, 571, 172, 32);
		ImageIcon icon=new ImageIcon(new ImageIcon("src/other/home.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		btnHome.setIcon(icon);
		contentPane_1.add(btnHome);

		JButton btnLuufile = new JButton("L\u01B0u file");
		btnLuufile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dao objDao = new Dao();
				objDao.writeBookToFile(listBook);
				objDao.writeReaderToFile(listReader);
				objDao.writeTicketToFile(listTicket);
				JOptionPane.showMessageDialog(contentPane, "Lưu thành công");
			}
		});
		btnLuufile.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLuufile.setBounds(1046, 492, 130, 21);
		contentPane_1.add(btnLuufile);
	}

	public void addDatatotable() {
		Object rowData[] = new Object[4];
		for (PhieuMuon phieuMuon : listTicket) {
			rowData[0] = phieuMuon.getMaSach();
			rowData[1] = phieuMuon.getMssv();
			rowData[2] = phieuMuon.getNgayMuon();
			rowData[3] = phieuMuon.getNgayTra();
			tableModel.addRow(rowData);
		}
	}

	public PhieuMuon checkValidTicket(String maSach, String mssv, Date ngayMuon, Date ngayTra) {
		if (maSach.trim().length() * mssv.trim().length() != 0 && ngayMuon != null && ngayTra != null) {
			if (indexOfBook(maSach) != -1) {
				if (indexOfReader(mssv) != -1) {
					if((ngayTra.getTime()-ngayMuon.getTime()>0)) {
					if ((ngayTra.getTime() - ngayMuon.getTime()) / 86400000 <= listBook.get(indexOfBook(maSach))
							.getThoigianmuon()) {
						if (listBook.get(indexOfBook(maSach)).getSoLuongSachConLai() >= 1) {
							SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
							String ngayMuonString = format.format(ngayMuon);
							String ngayTraString = format.format(ngayTra);
							
							return new PhieuMuon(maSach.toUpperCase(), mssv, ngayMuonString, ngayTraString);
						} else {
							JOptionPane.showMessageDialog(contentPane, "Đã hết sách yêu cầu");
							return null;
						}
					} else {
						JOptionPane.showMessageDialog(contentPane, "Thời gian mượn vượt quá quy định");
						return null;
					}
					} else {
						JOptionPane.showMessageDialog(contentPane, "Thời gian mượn không hợp lệ");
						return null;
					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "Không tồn tại mssv");
					return null;
				}
			} else {
				JOptionPane.showMessageDialog(contentPane, "Không tồn tại mã sách");
				return null;
			}
		} else {
			JOptionPane.showMessageDialog(contentPane, "Vui lòng nhập đầy đủ thông tin");
			return null;
		}
	}

	public int indexOfBook(String maSachString) {
		for (Sach i : listBook) {
			if (i.getMaSach().equalsIgnoreCase(maSachString.trim())) {
				return listBook.indexOf(i);
			}
		}
		return -1;
	}

	public int indexOfReader(String mssvString) {
		for (DocGia i : listReader) {
			if (i.getMssv().equalsIgnoreCase(mssvString.trim())) {
				return listReader.indexOf(i);
			}
		}
		return -1;
	}

	public int indexOfTicket(String mssv) {
		for (PhieuMuon i : listTicket) {
			if (i.getMssv().equalsIgnoreCase(mssv.trim())) {
				return listTicket.indexOf(i);
			}
		}
		return -1;
	}

	public void setNull() {
		dateNgaytra.setDate(null);
		dateNgaymuon.setDate(null);
		textMasach.setText("");
		textMssv.setText("");
	}
}

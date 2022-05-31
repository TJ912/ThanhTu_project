package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Dao.Dao;
import Model.GiaoTrinh;
import Model.Khac;
import Model.KhoaLuanTieuLuan;
import Model.LuanVanLuanAn;
import Model.Sach;
import Model.SachThamKhao;
import Model.TheLoai;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.awt.event.ActionEvent;
import java.lang.Integer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import other.*;
public class QuanLySach extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textMasach;
	private JTextField textTensach;
	private JTextField textTacgia;
	private JTextField textNamxuatban;
	private JTextField textSoluongdamuon;
	private JTextField textSoluongconlai;
	private JTable table;
	private JTextField textTimkiem;
	private JComboBox<String> cbxTheloai;
	private static ArrayList<Sach> list = new Dao().readBookFromFile();
	private DefaultTableModel tableModel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					Dao objDao = new Dao();
//					list = objDao.readBookFromFile();
					QuanLySach frame = new QuanLySach();
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
	public QuanLySach() {
		setTitle("Phần mềm quản lý thư viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new RGB().DarkSaphire);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
//*************************** Khung sách*****************************************************//
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setToolTipText("");
		panel.setBackground(Color.WHITE);
		
		
		panel.setBounds(0, 0, 1186, 82);
		panel.setBorder(new MatteBorder(0,0,10,0,new RGB().SunFlower));
		contentPane.add(panel);

		JLabel lblQuanLySach = new JLabel("QU\u1EA2N L\u00DD S\u00C1CH");
		lblQuanLySach.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuanLySach.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblQuanLySach.setBounds(459, 18, 268, 46);
		lblQuanLySach.setBorder(new BorderDesign().getLineBorder(new Color(229, 57, 53)));
		panel.add(lblQuanLySach);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 109, 383, 380);
		contentPane.add(panel_1);
		panel_1.setBorder(new BorderDesign().getTitle("Thêm và chỉnh sửa", new RGB().DarkGrey,new RGB().SunFlower));
		panel_1.setBackground(new RGB().MidnightBlue);
		panel_1.setLayout(null);

		JLabel lblMasach = new JLabel("Mã sách");
		lblMasach.setBounds(20, 38, 147, 13);
		lblMasach.setForeground(Color.white);
		panel_1.add(lblMasach);

		JLabel lblTensach = new JLabel("Tên sách");
		lblTensach.setBounds(20, 78, 147, 13);
		lblTensach.setForeground(Color.white);
		panel_1.add(lblTensach);

		JLabel lblTacgia = new JLabel("Tác giả");
		lblTacgia.setBounds(20, 118, 147, 13);
		lblTacgia.setForeground(Color.white);
		panel_1.add(lblTacgia);

		JLabel lblNamxuatban = new JLabel("Năm xuất bản");
		lblNamxuatban.setBounds(20, 158, 147, 13);
		lblNamxuatban.setForeground(Color.white);
		panel_1.add(lblNamxuatban);

		JLabel lblSoluongdamuon = new JLabel("Số lượng đã mượn");
		lblSoluongdamuon.setBounds(20, 198, 147, 13);
		lblSoluongdamuon.setForeground(Color.white);
		panel_1.add(lblSoluongdamuon);

		JLabel lblSoluongconlai = new JLabel("Số lượng còn lại");
		lblSoluongconlai.setBounds(20, 238, 147, 13);
		lblSoluongconlai.setForeground(Color.white);
		panel_1.add(lblSoluongconlai);

		textMasach = new JTextField();
		textMasach.setBounds(167, 38, 202, 19);
		panel_1.add(textMasach);
		textMasach.setColumns(10);

		textTensach = new JTextField();
		textTensach.setBounds(167, 78, 202, 19);
		panel_1.add(textTensach);
		textTensach.setColumns(10);

		textTacgia = new JTextField();
		textTacgia.setBounds(167, 118, 202, 19);
		panel_1.add(textTacgia);
		textTacgia.setColumns(10);

		textNamxuatban = new JTextField();
		textNamxuatban.setBounds(167, 158, 202, 19);
		panel_1.add(textNamxuatban);
		textNamxuatban.setColumns(10);

		textSoluongdamuon = new JTextField();
		textSoluongdamuon.setBounds(167, 198, 202, 19);
		panel_1.add(textSoluongdamuon);
		textSoluongdamuon.setColumns(10);

		textSoluongconlai = new JTextField();
		textSoluongconlai.setBounds(167, 238, 202, 19);
		panel_1.add(textSoluongconlai);
		textSoluongconlai.setColumns(10);

		JLabel lblTheloai = new JLabel("Thể loại");
		lblTheloai.setBounds(20, 278, 147, 13);
		lblTheloai.setForeground(Color.white);
		panel_1.add(lblTheloai);

		cbxTheloai = new JComboBox<String>();
		cbxTheloai.setModel(new DefaultComboBoxModel<String>(
				new String[] { "","Gi\u00E1o tr\u00ECnh", "Kh\u00F3a lu\u1EADn/Ti\u1EC3u lu\u1EADn",
						"Lu\u1EADn v\u0103n/Lu\u1EADn \u00E1n", "S\u00E1ch tham kh\u1EA3o", "Kh\u00E1c" }));
		cbxTheloai.setBounds(167, 278, 202, 21);
		panel_1.add(cbxTheloai);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(393, 198, 783, 277);
		contentPane.add(scrollPane);
//****************************Table***********************************************************************
		table = new JTable() {
			 public boolean editCellAt(int row, int column, java.util.EventObject e) {
	             return false;
	             }
		};
		tableModel = new DefaultTableModel(new String[] { "Mã sách", "Tên sách",
				"Tác giả", "Năm xuất bản", "Thể loại",
				"Số lượng đã mượn", "Số lượng còn lại" },
				0);
		table.setModel(tableModel);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				textMasach.setText(tableModel.getValueAt(table.getSelectedRow(), 0).toString());
//				textTensach.setText(tableModel.getValueAt(table.getSelectedRow(), 1).toString());
//				textTacgia.setText(tableModel.getValueAt(table.getSelectedRow(), 2).toString());
//				textNamxuatban.setText(tableModel.getValueAt(table.getSelectedRow(), 3).toString());
//				cbxTheloai.setSelectedItem(tableModel.getValueAt(table.getSelectedRow(), 4).toString());
//				textSoluongdamuon.setText(tableModel.getValueAt(table.getSelectedRow(), 5).toString());
//				textSoluongconlai.setText(tableModel.getValueAt(table.getSelectedRow(), 6).toString());
				int i=table.convertRowIndexToModel(table.getSelectedRow());
				
				textMasach.setText(tableModel.getValueAt(i, 0).toString());
				textTensach.setText(tableModel.getValueAt(i, 1).toString());
				textTacgia.setText(tableModel.getValueAt(i, 2).toString());
				textNamxuatban.setText(tableModel.getValueAt(i, 3).toString());
				cbxTheloai.setSelectedItem(tableModel.getValueAt(i, 4).toString());
				textSoluongdamuon.setText(tableModel.getValueAt(i, 5).toString());
				textSoluongconlai.setText(tableModel.getValueAt(i, 6).toString());
			}
		});
		table.setModel(tableModel);
		// CHinh sua kich thuoc tung cot trong bang
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(51);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(143);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(103);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(90);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(6).setPreferredWidth(90);
		
		scrollPane.setViewportView(table);
		// table.setEnabled(false);
		addDatatotable();
		table.setAutoCreateRowSorter(true);
		//Sắp xếp
		
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);
		sorter.setModel(table.getModel());
		Comparator<String> comparator = new Comparator<String>() {
			@Override
			public int compare(String name1, String name2) {
				if (name1.length() > name2.length())
					return 1;
				else if (name1.length() < name2.length())
					return -1;
				return name1.compareTo(name2);
				
			}
		};
		Comparator<Integer> comparatorInt = new Comparator<Integer>() {
			@Override
			public int compare(Integer int1, Integer int2) {
				String name1 = String.valueOf(int1);
				String name2 = String.valueOf(int2);
				if (name1.length() > name2.length())
					return 1;
				else if (name1.length() < name2.length())
					return -1;
				return name1.compareTo(name2);
			}
		};
		sorter.setComparator(0,comparator);
		sorter.setComparator(3, comparator);
		sorter.setComparator(6, comparatorInt);
		sorter.setComparator(5, comparatorInt);
//*************************khung tìm kiếm**************************************************************************//
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(393, 109, 342, 57);
		contentPane.add(panel_2);
		panel_2.setBorder(new BorderDesign().getMatte(5,Color.yellow));
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("T\u00ECm ki\u1EBFm theo m\u00E3 s\u00E1ch");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		lblNewLabel.setBounds(84, 5, 156, 20);
		panel_2.add(lblNewLabel);

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
		textTimkiem.setBounds(25, 28, 162, 19);
		panel_2.add(textTimkiem);
		textTimkiem.setColumns(10);

		JButton btnTimkiem = new JButton("T\u00ECm ki\u1EBFm");
		btnTimkiem.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTimkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String timKiem = textTimkiem.getText().replaceAll("\\s", "");
				tableModel.setRowCount(0);
				if (timKiem.length() != 0) {
					int count = 0;
					for (Sach i : list) {
						if (i.getMaSach().toLowerCase().contains(timKiem.toLowerCase())) {
							Object rowData[] = new Object[7];
							rowData[0] = i.getMaSach();
							rowData[1] = i.getTenSach();
							rowData[2] = i.getTacGia();
							rowData[3] = i.getNamXuatBan();

							rowData[4] = i.getTheLoai();

							rowData[5] = i.getSoLuongSachDaMuon();
							rowData[6] = i.getSoLuongSachConLai();
							tableModel.addRow(rowData);
							count++;
						}
					}
					if (count == 0) {
						JOptionPane.showMessageDialog(contentPane, "Không có mã sách");
						addDatatotable();
					}

				} else {
					JOptionPane.showMessageDialog(contentPane, "Vui lòng nhập mã số sách cần tìm");
					addDatatotable();
				}
			}
		});
		btnTimkiem.setBounds(210, 27, 93, 21);
		panel_2.add(btnTimkiem);

		JButton btnTaomoi = new JButton("T\u1EA1o m\u1EDBi");
		btnTaomoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNull();
			}
		});
		btnTaomoi.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTaomoi.setBounds(10, 508, 85, 21);
		contentPane.add(btnTaomoi);

		JButton btnThem = new JButton("Th\u00EAm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maSach = textMasach.getText().toUpperCase();
				String tenSach = textTensach.getText();
				String tacGia = textTacgia.getText();
				String namXuatban = textNamxuatban.getText();
				String soLuongdamuon = textSoluongdamuon.getText();
				String soLuongconlai = textSoluongconlai.getText();
				int theLoai = cbxTheloai.getSelectedIndex();
				if (checkValidBook(maSach, tenSach, tacGia, namXuatban, theLoai, soLuongdamuon,
						soLuongconlai) != null) {
					String theLoaiString = cbxTheloai.getSelectedItem().toString();
					Sach sach = checkValidBook(maSach, tenSach, tacGia, namXuatban, theLoai, soLuongdamuon,
							soLuongconlai);
					if (indexOf(sach.getMaSach()) == -1) {
						list.add(sach);
						tableModel.addRow(new Object[] { maSach, tenSach, tacGia, namXuatban, theLoaiString,
								soLuongdamuon, soLuongconlai });
						textMasach.setText("");
						textTensach.setText("");
						textNamxuatban.setText("");
						textSoluongconlai.setText("");
						textSoluongdamuon.setText("");
						textTacgia.setText("");
						cbxTheloai.setSelectedIndex(0);
						JOptionPane.showMessageDialog(contentPane, "Thêm thành công.");
					} else {
						JOptionPane.showMessageDialog(contentPane, "Mã số sách đã tồn tại");
					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "Vui lòng điền đầy đủ thông tin");
				}
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThem.setBounds(170, 508, 85, 21);
		contentPane.add(btnThem);

		JButton btnSua = new JButton("S\u1EEDa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRowCount() == 1) {
					if (checkValidBook(textMasach.getText().toUpperCase(), textTensach.getText(), textTacgia.getText(),
							textNamxuatban.getText(), cbxTheloai.getSelectedIndex(), textSoluongdamuon.getText(),
							textSoluongconlai.getText()) != null) {
						int index = indexOf(table.getValueAt(table.getSelectedRow(), 0).toString());
						if (index >= 0) {
							list.set(indexOf(textMasach.getText()),
									checkValidBook(textMasach.getText(), textTensach.getText(), textTacgia.getText(),
											textNamxuatban.getText(), cbxTheloai.getSelectedIndex(),
											textSoluongdamuon.getText(), textSoluongconlai.getText()));
							tableModel.setValueAt(textMasach.getText(), table.getSelectedRow(), 0);
							tableModel.setValueAt(textTensach.getText(), table.getSelectedRow(), 1);
							tableModel.setValueAt(textTacgia.getText(), table.getSelectedRow(), 2);
							tableModel.setValueAt(textNamxuatban.getText(), table.getSelectedRow(), 3);
							tableModel.setValueAt(cbxTheloai.getSelectedItem(), table.getSelectedRow(), 4);
							tableModel.setValueAt(textSoluongdamuon.getText(), table.getSelectedRow(), 5);
							tableModel.setValueAt(textSoluongconlai.getText(), table.getSelectedRow(), 6);
							textMasach.setText("");
							textTensach.setText("");
							textNamxuatban.setText("");
							textSoluongconlai.setText("");
							textSoluongdamuon.setText("");
							textTacgia.setText("");
							cbxTheloai.setSelectedIndex(0);
							JOptionPane.showMessageDialog(contentPane, "Sửa thông tin thành công");
						}
					}
				} else {
					if (table.getRowCount() == 0) {
						JOptionPane.showMessageDialog(contentPane, "Bảng trống");
					} else {
						JOptionPane.showMessageDialog(contentPane, "Vui lòng chọn một hàng để sửa thông tin");
					}
				}
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSua.setBounds(330, 508, 85, 21);
		contentPane.add(btnSua);

		JButton btnXoa = new JButton("X\u00F3a");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRowCount() == 1) {
					int index = indexOf(table.getValueAt(table.getSelectedRow(), 0).toString());
					list.remove(index);
					tableModel.removeRow(table.getSelectedRow());
					textMasach.setText("");
					textTensach.setText("");
					textNamxuatban.setText("");
					textSoluongconlai.setText("");
					textSoluongdamuon.setText("");
					textTacgia.setText("");
					cbxTheloai.setSelectedIndex(0);
					JOptionPane.showMessageDialog(contentPane, "Xóa thành công");
				} else {
					if (table.getRowCount() == 0)
						JOptionPane.showMessageDialog(contentPane, "Bảng trống");
					else if (table.getSelectedRowCount() == 0) {
						JOptionPane.showMessageDialog(contentPane, "Vui lòng chọn hàng muốn xóa");
					} else if (table.getSelectedRowCount() > 1) {
						JOptionPane.showMessageDialog(contentPane, "Chỉ chỉ cho phép xóa một hàng mỗi lần");
					}
				}
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXoa.setBounds(490, 508, 101, 21);
		contentPane.add(btnXoa);

		JButton btnThongke = new JButton("Th\u1ED1ng k\u00EA");
		btnThongke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int daMuon = 0;
				int conLai = 0;
				for (Sach i : list) {
					daMuon += i.getSoLuongSachDaMuon();
					conLai += i.getSoLuongSachConLai();
				}
				JOptionPane.showMessageDialog(contentPane,
						"Tổng số lượng sách đã cho mượn:" + daMuon + "\n" + "Tổng số lượng sách còn lại:" + conLai);
			}
		});
		btnThongke.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThongke.setBounds(860, 508, 110, 21);
		contentPane.add(btnThongke);
		
		ImageIcon icon=new ImageIcon(new ImageIcon("src/other/home.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		JButton btnHome = new JButton("HOME");
		btnHome.setIcon(icon);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dao objDao = new Dao();
				objDao.writeBookToFile(list);
				Home obj = new Home();
				obj.setVisible(true);
				setVisible(false);
			}
		});
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHome.setBounds(1004, 571, 172, 32);
		contentPane.add(btnHome);

		JButton btnLuufile = new JButton("L\u01B0u file");
		btnLuufile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dao objDao = new Dao();
				objDao.writeBookToFile(list);
				JOptionPane.showMessageDialog(contentPane, "Lưu thành công");
			}
		});
		btnLuufile.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLuufile.setBounds(1046, 509, 130, 21);
		contentPane.add(btnLuufile);

	}

	public void addDatatotable() {
		Object rowData[] = new Object[7];
		for (Sach sach : list) {
			rowData[0] = sach.getMaSach();
			rowData[1] = sach.getTenSach();
			rowData[2] = sach.getTacGia();
			rowData[3] = sach.getNamXuatBan();

			rowData[4] = sach.getTheLoai();

			rowData[5] = sach.getSoLuongSachDaMuon();
			rowData[6] = sach.getSoLuongSachConLai();
			tableModel.addRow(rowData);
		}
	}

	public Sach checkValidBook(String maSach, String tenSach, String tacGia, String namXuatBan, Integer theLoai,
			String soLuongdamuon, String soLuongconlai) {
		int damuon = tryParse(soLuongdamuon);
		int conlai = tryParse(soLuongconlai);
		if (maSach.length() * tenSach.length() * tacGia.length() * theLoai * namXuatBan.length() * damuon
				* conlai != 0) {
			TheLoai theLoai2;
			if (theLoai == 1) {
				theLoai2 = new GiaoTrinh();
			} else if (theLoai == 2) {
				theLoai2 = new KhoaLuanTieuLuan();
			} else if (theLoai == 3) {
				theLoai2 = new LuanVanLuanAn();
			} else if (theLoai == 4) {
				theLoai2 = new SachThamKhao();
			} else if (theLoai == 5) {
				theLoai2 = new Khac();
			} else {
				theLoai2 = null;
			}
			Sach sach = new Sach(maSach.toUpperCase(), tenSach, tacGia, theLoai2, namXuatBan, damuon, conlai);
			return sach;
		}
		return null;
	}

	public int tryParse(String number) {
		try {
			return Integer.parseInt(number);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public int indexOf(String msSach) {
		for (Sach i : list) {
			if (i.getMaSach().equals(msSach))
				return list.indexOf(i);
		}
		return -1;
	}
	public void setNull() {
		textMasach.setText("");
		textTensach.setText("");
		textNamxuatban.setText("");
		textSoluongconlai.setText("");
		textSoluongdamuon.setText("");
		textTacgia.setText("");
		cbxTheloai.setSelectedIndex(0);
	}
}

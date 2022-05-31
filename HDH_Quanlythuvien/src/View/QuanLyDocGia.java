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
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Dao.Dao;
import Model.DocGia;
import other.BorderDesign;
import other.RGB;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class QuanLyDocGia extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textHoten;
	private JTextField textMssv;
	private JTextField textSodt;
	private JTextField textEmail;
	private JTextField textTimkiem;
	private JTable table;
	private static ArrayList<DocGia> list=new Dao().readReaderFromFile();
	private DefaultTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					Dao objDao = new Dao();
//					list = objDao.readReaderFromFile();
					QuanLyDocGia frame = new QuanLyDocGia();
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
	public QuanLyDocGia() {
		setTitle("Phần mềm quản lý thư viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new RGB().DarkSaphire);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setToolTipText("");
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1186, 82);
		panel.setBorder(new MatteBorder(0,0,10,0,new RGB().SunFlower));
		contentPane.add(panel);

		JLabel lblQuanLySach = new JLabel("QU\u1EA2N L\u00DD \u0110\u1ED8C GI\u1EA2");
		lblQuanLySach.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuanLySach.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblQuanLySach.setBounds(437, 18, 312, 46);
		lblQuanLySach.setBorder(new BorderDesign().getLineBorder(new Color(229, 57, 53)));
		panel.add(lblQuanLySach);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 92, 421, 362);
		panel_1.setBorder(new BorderDesign().getTitle("Thêm và chỉnh sửa", new RGB().DarkGrey,new RGB().SunFlower));
		panel_1.setBackground(new RGB().MidnightBlue);
		contentPane.add(panel_1);

		JLabel lblHTn = new JLabel("H\u1ECD t\u00EAn");
		lblHTn.setBounds(21, 93, 130, 13);
		lblHTn.setForeground(Color.white);
		panel_1.add(lblHTn);

		JLabel lblMssv = new JLabel("MSSV");
		lblMssv.setBounds(21, 133, 130, 13);
		lblMssv.setForeground(Color.white);
		panel_1.add(lblMssv);

		JLabel lblSinThoi = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		lblSinThoi.setBounds(21, 173, 130, 13);
		lblSinThoi.setForeground(Color.white);
		panel_1.add(lblSinThoi);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(21, 213, 130, 13);
		lblEmail.setForeground(Color.white);
		panel_1.add(lblEmail);

		textHoten = new JTextField();
		textHoten.setColumns(10);
		textHoten.setBounds(178, 90, 202, 19);
		panel_1.add(textHoten);

		textMssv = new JTextField();
		textMssv.setColumns(10);
		textMssv.setBounds(178, 130, 202, 19);
		panel_1.add(textMssv);

		textSodt = new JTextField();
		textSodt.setColumns(10);
		textSodt.setBounds(178, 170, 202, 19);
		panel_1.add(textSodt);

		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(178, 210, 202, 19);
		panel_1.add(textEmail);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(452, 94, 324, 57);
		panel_2.setBorder(new BorderDesign().getMatte(5,Color.yellow));
		contentPane.add(panel_2);

		JLabel lblTmKimTheo = new JLabel("T\u00ECm ki\u1EBFm theo MSSV");
		lblTmKimTheo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTmKimTheo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTmKimTheo.setBounds(84, 5, 156, 20);
		panel_2.add(lblTmKimTheo);

		textTimkiem = new JTextField();
		textTimkiem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar()==KeyEvent.VK_BACK_SPACE) {
					if(textTimkiem.getText().length()==0) {
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
				String timKiemString = textTimkiem.getText();
				tableModel.setRowCount(0);
				if (timKiemString.replaceAll("\\s", "").length() != 0) {
					int count = 0;
					for (DocGia docGia : list) {
						if (docGia.getMssv().contains(timKiemString.trim())) {
							tableModel.addRow(new Object[] { docGia.getMssv(), docGia.getHoTen(), docGia.getSoDt(),
									docGia.getEmail() });
							count++;
						}
					}
					if (count == 0) {
						addDatatotable();
						JOptionPane.showMessageDialog(contentPane, "Không có mssv cần tìm");
					}
				} else {
					addDatatotable();
					JOptionPane.showMessageDialog(contentPane, "Vui lòng nhập mssv cần tìm");
				}
			}
		});
		btnTimkiem.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTimkiem.setBounds(210, 27, 93, 21);
		panel_2.add(btnTimkiem);

		JButton btnTaomoi = new JButton("T\u1EA1o m\u1EDBi");
		btnTaomoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textHoten.setText("");
				textMssv.setText("");
				textEmail.setText("");
				textSodt.setText("");
			}
		});
		btnTaomoi.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTaomoi.setBounds(10, 491, 85, 21);
		contentPane.add(btnTaomoi);

		JButton btnThem = new JButton("Th\u00EAm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mssvString = textMssv.getText();
				String hoTenString = textHoten.getText();
				String soDtString = textSodt.getText();
				String emailString = textEmail.getText();

				if (checkValiDocGia(mssvString, hoTenString, soDtString, emailString) != null) {
					if (indexOf(mssvString) == -1) {
						list.add(checkValiDocGia(mssvString, hoTenString, soDtString, emailString));
						tableModel.addRow(new Object[] { mssvString, hoTenString, soDtString, emailString });
						textHoten.setText("");
						textMssv.setText("");
						textEmail.setText("");
						textSodt.setText("");
						JOptionPane.showMessageDialog(contentPane, "Thêm thành công");
					} else {
						JOptionPane.showMessageDialog(contentPane, "Trùng Sinh Viên");
					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "Vui lòng điền đầy đủ thông tin");
				}
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThem.setBounds(170, 491, 85, 21);
		contentPane.add(btnThem);

		JButton btnSua = new JButton("S\u1EEDa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRowCount() == 1) {
					int i = indexOf(table.getValueAt(table.getSelectedRow(), 0).toString());

					String mssvString = textMssv.getText();
					String hoTenString = textHoten.getText();
					String soDtString = textSodt.getText();
					String emailString = textEmail.getText();

					DocGia docGia = checkValiDocGia(mssvString, hoTenString, soDtString, emailString);

					if (docGia != null) {
						if (indexOf(mssvString) != i) {
							JOptionPane.showMessageDialog(contentPane, "Trùng mssv");
						} else {
							list.set(indexOf(mssvString), docGia);
							textHoten.setText("");
							textMssv.setText("");
							textEmail.setText("");
							textSodt.setText("");
							tableModel.setRowCount(0);
							addDatatotable();
							JOptionPane.showMessageDialog(contentPane, "Sửa thành công");
						}
					} else {
						JOptionPane.showMessageDialog(contentPane, "Vui lòng điền đầy đủ thông tin");
					}
				}
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSua.setBounds(330, 491, 85, 21);
		contentPane.add(btnSua);

		JButton btnXoa = new JButton("X\u00F3a");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getRowCount() != 0) {
					if (table.getSelectedRowCount() == 1) {
						int index = indexOf(table.getValueAt(table.getSelectedRow(), 0).toString());
						list.remove(index);
						tableModel.removeRow(table.getSelectedRow());
//						list.remove(indexOf(tableModel.getValueAt(table.getSelectedRow(), 0).toString()));
						textHoten.setText("");
						textMssv.setText("");
						textEmail.setText("");
						textSodt.setText("");
						JOptionPane.showMessageDialog(contentPane, "Xóa thành công");
					} else if (table.getSelectedRowCount() == 0) {
						JOptionPane.showMessageDialog(contentPane, "Vui lòng chọn một hàng cần xóa");
					} else {
						JOptionPane.showMessageDialog(contentPane, "Chỉ cho phép xóa một hàng mỗi lần");
					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "Bảng trống");
				}
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXoa.setBounds(490, 491, 85, 21);
		contentPane.add(btnXoa);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(452, 161, 724, 293);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textMssv.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
				textHoten.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
				textSodt.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				textEmail.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
			}
		});
		tableModel = new DefaultTableModel(
				new String[] { "MSSV", "H\u1ECD t\u00EAn", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "Email" }, 0);
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(130);
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
				if (name1.length() > name2.length())
					return 1;
				else if (name1.length() < name2.length())
					return -1;
				return name1.compareTo(name2); 
			}
		};
		sorter.setComparator(1, comparator);

		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home obj = new Home();
				Dao objDao = new Dao();
				objDao.writeReaderToFile(list);
				obj.setVisible(true);
				setVisible(false);
			}
		});
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHome.setBounds(1004, 571, 172, 32);
		ImageIcon icon=new ImageIcon(new ImageIcon("src/other/home.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		btnHome.setIcon(icon);
		contentPane.add(btnHome);

		JButton btnLuufile = new JButton("L\u01B0u file");
		btnLuufile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dao objDao = new Dao();
				objDao.writeReaderToFile(list);
				JOptionPane.showMessageDialog(contentPane, "Lưu thành công");
			}
		});
		btnLuufile.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLuufile.setBounds(1046, 492, 130, 21);
		contentPane.add(btnLuufile);
	}

	public void addDatatotable() {
		Object rowData[] = new Object[4];
		for (DocGia docGia : list) {
			rowData[0] = docGia.getMssv();
			rowData[1] = docGia.getHoTen();
			rowData[2] = docGia.getSoDt();
			rowData[3] = docGia.getEmail();
			tableModel.addRow(rowData);
		}
	}

	public DocGia checkValiDocGia(String mssv, String hoTen, String soDt, String email) {
		if (mssv.replaceAll("\\s", "").length() * hoTen.replaceAll("\\s", "").length()
				* soDt.replaceAll("\\s", "").length() * email.replaceAll("\\s", "").length() != 0) {
			return new DocGia(mssv.trim(), hoTen.trim(), soDt.trim(), email.trim());
		}
		return null;
	}

	public int indexOf(String mssv) {
		for (DocGia i : list) {
			if (i.getMssv().equals(mssv) == true) {
				return list.indexOf(i);
			}
		}
		return -1;
	}

}

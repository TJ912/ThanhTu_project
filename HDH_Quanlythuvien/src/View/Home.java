package View;

import java.awt.EventQueue;
import other.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.SystemColor;

public class Home extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setTitle("Phần mềm quản lý thư viên");
		ImageIcon icon=new ImageIcon("background.jpg");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new RGB().MidnightBlue);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Color btnColor=new Color(130, 204, 221);
		Color btnForeColor=new Color(255, 238, 88);
		Color btnBord=new Color(255, 255, 0);
		
		ImageIcon img=new ImageIcon("background.jpg");
//		JLabel background=new JLabel("",img,JLabel.CENTER);
//		background.setBounds(0,150,1000,1000);
//		contentPane.add(background);
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBackground(new Color(33, 33, 33));

		panel.setBounds(0, 0, 1186, 92);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblWelcome = new JLabel("THƯ VIỆN");
		lblWelcome.setBounds(459, 36, 268, 46);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblWelcome.setForeground(new Color(255, 179, 0));
		panel.add(lblWelcome);
		
		JPanel pnlMember=new JPanel();
		pnlMember.setBounds(00,100,350,200);
		pnlMember.setBackground(new RGB().Waterfall);
		pnlMember.setBorder(new BorderDesign().getTitle("Nhóm 4", new RGB().Orange, new RGB().Jalapenred));
		pnlMember.setLayout(null);
		contentPane.add(pnlMember);
		
//		background.setBounds(0,0,350,200);
//		pnlMember.add(background);
		
		JLabel mem1=new JLabel("Nguyễn Ngọc Duy Cường    18200071");
		mem1.setBounds(30,20,300,50);
		mem1.setFont(new Font("Saira Semi Condensed",Font.BOLD,15));
		mem1.setForeground(Color.white);
		pnlMember.add(mem1);
		
		JLabel mem2=new JLabel("Trần Tấn Phát                         18200198");
		mem2.setBounds(30,50,300,50);
		mem2.setFont(new Font("Saira Semi Condensed",Font.BOLD,15));
		mem2.setForeground(Color.white);
		pnlMember.add(mem2);
		JLabel mem3=new JLabel("Nguyễn Thanh Tú                  18200275");
		mem3.setBounds(30,80,300,50);
		mem3.setFont(new Font("Saira Semi Condensed",Font.BOLD,15));
		mem3.setForeground(Color.white);
		pnlMember.add(mem3);
		JLabel mem4=new JLabel("Lương Thanh Tùng               18200280");
		mem4.setBounds(30,110,300,50);
		mem4.setForeground(Color.white);
		mem4.setFont(new Font("Saira Semi Condensed",Font.BOLD,15));
		pnlMember.add(mem4);
		
		JLabel Imagee=new JLabel();
		Imagee.setBounds(0, 0, 1200, 650);
		Imagee.setIcon(new ImageIcon(getClass().getResource("/other/bb.jpg")));
		
		JButton btnQuanLySach = new JButton("QUẢN LÝ SÁCH");
		btnQuanLySach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLySach obj=new QuanLySach();
				obj.setVisible(true);
				setVisible(false);
			}
		});
		btnQuanLySach.setBackground(btnColor);
		btnQuanLySach.setForeground(btnForeColor);
		btnQuanLySach.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnQuanLySach.setBounds(390, 143, 406, 54);
//		btnQuanLySach.setBorder(newbtn EtchedBorder(FRAMEBITS, getBackground(), getForeground()));
		btnQuanLySach.setBorder(new BorderDesign().getMatte(5, btnBord));
		contentPane.add(btnQuanLySach);
		
		
		
		
		JButton btnNewButton_1 = new JButton("QUẢN LÍ ĐỘC GIẢ");
		btnNewButton_1.setBackground(btnColor);
		btnNewButton_1.setForeground(btnForeColor);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
//		btnNewButton_1.setBorder(new RoundedBorder(10));
		btnNewButton_1.setBorder(new BorderDesign().getMatte(5, btnBord));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyDocGia obj=new QuanLyDocGia();
				obj.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(390, 253, 406, 54);
		contentPane.add(btnNewButton_1);
		
		
		
		
		JButton btnNewButton_2 = new JButton("QUẢN LÍ PHIẾU MƯỢN");
		btnNewButton_2.setBackground(btnColor);
		btnNewButton_2.setForeground(btnForeColor);
		btnNewButton_2.setBorder(new BorderDesign().getMatte(5, btnBord));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuanLyPhieuMuon obj=new QuanLyPhieuMuon();
				obj.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_2.setBounds(390, 363, 406, 54);
		contentPane.add(btnNewButton_2);
		contentPane.add(Imagee);
	}
}

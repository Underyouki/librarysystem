package Testv1;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;

import java.util.Calendar;
import java.util.Date;
public class Manager_Login extends JFrame {

	private JPanel contentPane;
	public JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager_Login frame = new Manager_Login();
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
	public Manager_Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7BA1\u7406\u5458\u767B\u5F55");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel.setBounds(156, 10, 129, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5DE5\u53F7\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(60, 64, 68, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(59, 126, 42, 15);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(127, 72, 195, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {//返回
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(309, 197, 93, 23);
		contentPane.add(btnNewButton);
		
		//密码错误标签
		JLabel lblNewLabel_3 = new JLabel("\u5DE5\u53F7\u6216\u5BC6\u7801\u9519\u8BEF\uFF0C\u8BF7\u91CD\u65B0\u8F93\u5165");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(137, 162, 185, 15);
		contentPane.add(lblNewLabel_3);
				
		passwordField = new JPasswordField();
		passwordField.setBounds(127, 123, 195, 21);
		contentPane.add(passwordField);
		lblNewLabel_3.setVisible(false);
		
		
		JButton btnNewButton_1 = new JButton("\u767B\u5F55");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strP = new String(passwordField.getPassword());//密码
				String strT = new String(textField.getText());//工号
				
				String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=LibraryManagement";
				String userName="sa";
				String userPwd="QWEASDZXC000000";
				Connection dbConn = null;
				String sql = "select 工号,密码 from 图书管理员";
				
				try {
					Statement state = null;
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					dbConn = DriverManager.getConnection(dbURL,userName,userPwd);
					state = dbConn.createStatement();
					ResultSet rs = state.executeQuery(sql);
					while (rs.next()) {
						//System.out.println(rs.getString(1)+" "+rs.getString(2));
						if(strT.equals(rs.getString(1)) && strP.equals(rs.getString(2))) {
							
							Calendar c = Calendar.getInstance();
							String s = String.valueOf(c.getTime());
							
							M_mainPage mPage = new M_mainPage();
							mPage.setVisible(true);
							lblNewLabel_3.setVisible(false);
							PreparedStatement pst = null;
							pst = dbConn.prepareStatement("insert into 操作账号 values(?,?)");
							pst.setString(1, strT);
							pst.setTimestamp(2, new Timestamp(c.getTimeInMillis()));//插入时间戳
							pst.addBatch();
							pst.executeBatch();

							lblNewLabel_3.setVisible(false);
						}
						else {
							lblNewLabel_3.setVisible(true);
						}
					}
					dbConn.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(61, 197, 93, 23);
		contentPane.add(btnNewButton_1);
		
		return;
	}
}

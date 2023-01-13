package Testv1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;
import java.util.Calendar;
public class UpdatePassword extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdatePassword frame = new UpdatePassword();
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
	public UpdatePassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u4FEE\u6539\u4E2A\u4EBA\u5BC6\u7801");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(144, 10, 140, 31);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");//返回
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(331, 228, 93, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("\u539F\u5BC6\u7801");
		lblNewLabel_1.setBounds(31, 57, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u65B0\u5BC6\u7801");
		lblNewLabel_2.setBounds(31, 108, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		lblNewLabel_3.setBounds(10, 151, 54, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u8F93\u5165\u9519\u8BEF\uFF0C\u8BF7\u6821\u68C0");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBounds(90, 192, 225, 15);
		contentPane.add(lblNewLabel_4);
		lblNewLabel_4.setVisible(false);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(78, 54, 237, 23);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(78, 105, 237, 23);
		contentPane.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(78, 151, 237, 23);
		contentPane.add(passwordField_2);
		

		JLabel lblNewLabel_5 = new JLabel("\u4FEE\u6539\u6210\u529F");
		lblNewLabel_5.setBounds(31, 206, 54, 15);
		contentPane.add(lblNewLabel_5);
		lblNewLabel_5.setVisible(false);
		
		JButton btnNewButton_1 = new JButton("\u786E\u8BA4");
		btnNewButton_1.addActionListener(new ActionListener() {//修改密码
			public void actionPerformed(ActionEvent e) {
				String s1 = new String(String.valueOf(passwordField.getPassword()));
				String s2 = new String(String.valueOf(passwordField_1.getPassword()));
				String s3 = new String(String.valueOf(passwordField_2.getPassword()));
				
				String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=LibraryManagement";
				String userName="sa";
				String userPwd="QWEASDZXC000000";
				Connection dbConn = null;
				String sql = "select 工号,密码 from 图书管理员";
				String sql1 = "select 借书证号,密码 from 借书者";
				
				String num = new String ();
				try {
					Statement state = null;
					Statement state0 = null;
					Statement state1 = null;
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					dbConn = DriverManager.getConnection(dbURL,userName,userPwd);
					state = dbConn.createStatement();
					state0 = dbConn.createStatement();
					state1 = dbConn.createStatement();
					
					ResultSet rs = state.executeQuery(sql);
					ResultSet rs0 = state0.executeQuery(sql1);
					
					
					String sql0 = "select top 1* from 操作账号 order by 操作账号 desc";
					ResultSet rs1 = state1.executeQuery(sql0);		//最后一行
					String s10 = new String();
					while(rs1.next()) {
						s10 = rs1.getString(1);//操作账号
					}
					num = s10;
					PreparedStatement pst = null;
					
					while (rs.next()) {			//如果是图书管理员
						//System.out.println(rs.getString(1)+" "+rs.getString(2));
						String tmp = rs.getString(1);			//账号
						String tmp_1 = rs.getString(2);			//原密码
						if(tmp.equals(num) && tmp_1.equals(s1)) {	//工号是当前操作账号
							if(s2.equals(s3)) {
								String sql_1 = "update 图书管理员 set 密码=? where 工号=?";
								pst = dbConn.prepareStatement(sql_1);
								pst.setString(1, s3);
								pst.setString(2, num);
								pst.executeUpdate();
								lblNewLabel_5.setVisible(true);
								if(lblNewLabel_5.isVisible()) {
									lblNewLabel_4.setVisible(false);
								}
							}else {
								lblNewLabel_4.setVisible(true);
							}
						}
						else {
							lblNewLabel_4.setVisible(true);
						}
					}
					
					while (rs0.next()) {			//如果是借书者
						//System.out.println(rs.getString(1)+" "+rs.getString(2));
						String tmp = rs0.getString(1);
						String tmp_1 = rs0.getString(2);			//原密码
						if(tmp.equals(num) && tmp_1.equals(s1)) {
							if(s2.equals(s3)) {
								String sql_1 = "update 借书者 set 密码=? where 借书证号=?";
								pst = dbConn.prepareStatement(sql_1);
								pst.setString(1, s3);
								pst.setString(2, num);
								pst.executeUpdate();
								lblNewLabel_5.setVisible(true);
								lblNewLabel_4.setVisible(false);
							}else {
								lblNewLabel_4.setVisible(true);
							}
						}
						else {
							lblNewLabel_4.setVisible(true);
						}
					}
					if(lblNewLabel_5.isVisible()) {
						lblNewLabel_4.setVisible(false);
					}
					
				//	pst.close();
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
		btnNewButton_1.setBounds(10, 228, 93, 23);
		contentPane.add(btnNewButton_1);
		
	}
}

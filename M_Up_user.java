package Testv1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class M_Up_user extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					M_Up_user frame = new M_Up_user();
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
	public M_Up_user() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u60F3\u8981\u4FEE\u6539/\u6DFB\u52A0\u7684\u501F\u4E66\u8005\u7684\u8D26\u53F7\u662F");
		lblNewLabel.setBounds(10, 28, 187, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(195, 25, 104, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D");
		lblNewLabel_1.setBounds(10, 64, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(49, 61, 90, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u6027\u522B");
		lblNewLabel_2.setBounds(10, 104, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(49, 101, 66, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u8054\u7CFB\u7535\u8BDD");
		lblNewLabel_3.setBounds(10, 135, 54, 15);
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(71, 132, 126, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u804C\u4E1A");
		lblNewLabel_4.setBounds(10, 166, 54, 15);
		contentPane.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(49, 163, 148, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u6240\u5728\u5355\u4F4D");
		lblNewLabel_5.setBounds(0, 197, 54, 15);
		contentPane.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(59, 194, 195, 21);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u64CD\u4F5C\u6210\u529F");
		lblNewLabel_6.setBounds(113, 232, 54, 15);
		contentPane.add(lblNewLabel_6);
		lblNewLabel_6.setVisible(false);
		
		JLabel lblNewLabel_8 = new JLabel("\u8BF7\u8F93\u5165\u201C\u7537\u201D\u6216\u201C\u5973\u201D");
		lblNewLabel_8.setForeground(Color.RED);
		lblNewLabel_8.setBounds(158, 104, 148, 15);
		contentPane.add(lblNewLabel_8);
		lblNewLabel_8.setVisible(false);
		
		JLabel lblNewLabel_7 = new JLabel("\u5FC5\u586B");
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setBounds(309, 28, 66, 15);
		contentPane.add(lblNewLabel_7);
		lblNewLabel_7.setVisible(false);
		
		JLabel lblNewLabel_9 = new JLabel("\u6570\u636E\u5E93\u4E2D\u6CA1\u6709\u8BE5\u8D26\u6237");
		lblNewLabel_9.setForeground(Color.RED);
		lblNewLabel_9.setBounds(200, 52, 135, 15);
		contentPane.add(lblNewLabel_9);
		lblNewLabel_9.setVisible(false);
		
		JLabel lblNewLabel_10 = new JLabel("\u6BCF\u4E2A\u9879\u76EE\u90FD\u5FC5\u586B");
		lblNewLabel_10.setForeground(Color.RED);
		lblNewLabel_10.setBounds(273, 135, 116, 15);
		contentPane.add(lblNewLabel_10);
		lblNewLabel_10.setVisible(false);
		
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(331, 228, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {//修改
			public void actionPerformed(ActionEvent e) {
				String name = new String(textField_1.getText());
				String work = new String(textField_4.getText());
				String sex = new String(textField_2.getText());
				String phone = new String(textField_3.getText());
				String site = new String(textField_5.getText());
				String num = new String(textField.getText());
				
				lblNewLabel_10.setVisible(false);
				if(num.equals("")) {			//借书证号必填
					lblNewLabel_7.setVisible(true);//“必填”标签
				}
				else {
					lblNewLabel_7.setVisible(false);
				}
				
				String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=LibraryManagement";
				String userName="sa";
				String userPwd="QWEASDZXC000000";
				Connection dbConn = null;
				
				try {
					Statement state = null;
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					dbConn = DriverManager.getConnection(dbURL,userName,userPwd);
					state = dbConn.createStatement();
					
					PreparedStatement pst = null;
					if (name.equals("") == false) {
						String sql = "update 借书者 set 姓名=? where 借书证号=?";
						pst = dbConn.prepareStatement(sql);
						pst.setString(1, name);
						pst.setString(2, num);
						pst.executeUpdate();
						
					}
					if(sex.equals("") == false) {
						try {
							String sql = "update 借书者 set 性别=? where 借书证号=?";
							pst = dbConn.prepareStatement(sql);
							pst.setString(1, sex);
							pst.setString(2, num);
							pst.executeUpdate();
							lblNewLabel_8.setVisible(false);
						}
						catch(Exception ee) {
							// TODO Auto-generated catch block
							ee.printStackTrace();
							lblNewLabel_8.setVisible(true);
							lblNewLabel_6.setVisible(false);
						}
					}
					if(work.equals("") == false) {
						String sql = "update 借书者 set 职业=? where 借书证号=?";
						pst = dbConn.prepareStatement(sql);
						pst.setString(1, work);
						pst.setString(2, num);
						pst.executeUpdate();
						
					}
					if(phone.equals("") == false) {
						String sql = "update 借书者 set 联系电话=? where 借书证号=?";
						pst = dbConn.prepareStatement(sql);
						pst.setString(1, phone);
						pst.setString(2, num);
						pst.executeUpdate();
						
					}
					if(site.equals("") == false) {
						String sql = "update 借书者 set 所在单位=? where 借书证号=?";
						pst = dbConn.prepareStatement(sql);
						pst.setString(1, site);
						pst.setString(2, num);
						pst.executeUpdate();
						
					}
					pst.close();
					dbConn.close();
					lblNewLabel_9.setVisible(false);
					lblNewLabel_6.setVisible(true);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}/*catch(Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					lblNewLabel_9.setVisible(true);
				}*/
				
				if(lblNewLabel_8.isVisible() || lblNewLabel_9.isVisible()) {
					lblNewLabel_6.setVisible(false);
				}
				if(lblNewLabel_6.isVisible()) {
					lblNewLabel_7.setVisible(false);
					lblNewLabel_8.setVisible(false);
					lblNewLabel_9.setVisible(false);
				}
			}
		});
		btnNewButton_1.setBounds(10, 228, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u6DFB\u52A0");
		btnNewButton_2.addActionListener(new ActionListener() {//添加
			public void actionPerformed(ActionEvent e) {
				
				String name = new String(textField_1.getText());
				String work = new String(textField_4.getText());
				String sex = new String(textField_2.getText());
				String phone = new String(textField_3.getText());
				String site = new String(textField_5.getText());
				String num = new String(textField.getText());
				
				if(num.equals("") || name.equals("") || sex.equals("") || phone.equals("") || work.equals("") || site.equals("")) {
					lblNewLabel_10.setVisible(true);//“必填”标签，每个项都必填
					lblNewLabel_6.setVisible(false);
				}
				else {
					lblNewLabel_10.setVisible(false);
				
					String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=LibraryManagement";
					String userName="sa";
					String userPwd="QWEASDZXC000000";
					Connection dbConn = null;
					try {
						Statement state = null;
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						dbConn = DriverManager.getConnection(dbURL,userName,userPwd);
						state = dbConn.createStatement();
				
						PreparedStatement pst = null;
						String sql = "insert into 借书者 values(?,?,?,?,?,?,?)";
						pst = dbConn.prepareStatement(sql);
						pst.setString(1, num);
						pst.setString(2, name);
						pst.setString(3, sex);
						pst.setString(4, phone);
						pst.setString(5, work);
						pst.setString(6, site);
						pst.setString(7, "123456");
						pst.addBatch();
						pst.executeBatch();
							
						lblNewLabel_8.setVisible(false);
						lblNewLabel_6.setVisible(true);
						
					}catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						lblNewLabel_8 .setVisible(true);
					} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
						e1.printStackTrace();
						lblNewLabel_8 .setVisible(true);
					}
				}
				if(lblNewLabel_8.isVisible() || lblNewLabel_9.isVisible()) {
					lblNewLabel_6.setVisible(false);
				}
				if(lblNewLabel_6.isVisible()) {
					lblNewLabel_7.setVisible(false);
					lblNewLabel_8.setVisible(false);
					lblNewLabel_9.setVisible(false);
					lblNewLabel_10.setVisible(false);
					
				}
			}
		});
		btnNewButton_2.setBounds(177, 225, 93, 23);
		contentPane.add(btnNewButton_2);
			
	}
}

package Testv1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AddBook extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBook frame = new AddBook();
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
	public AddBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6DFB\u52A0\u56FE\u4E66");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(170, 10, 92, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u4E66\u53F7");
		lblNewLabel_1.setBounds(32, 48, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(71, 45, 148, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u4E66\u540D");
		lblNewLabel_2.setBounds(32, 80, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(71, 77, 242, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u4F5C\u8005");
		lblNewLabel_3.setBounds(32, 113, 54, 15);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(71, 110, 242, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u51FA\u7248\u793E");
		lblNewLabel_4.setBounds(32, 144, 54, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u5B9A\u4EF7");
		lblNewLabel_5.setBounds(32, 172, 54, 15);
		contentPane.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(71, 141, 242, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(71, 169, 242, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u5185\u5BB9\u7B80\u4ECB");
		lblNewLabel_6.setBounds(17, 197, 54, 15);
		contentPane.add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setBounds(71, 194, 242, 21);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\u72B6\u6001");
		lblNewLabel_7.setBounds(32, 225, 54, 15);
		contentPane.add(lblNewLabel_7);
		
		textField_6 = new JTextField();
		textField_6.setBounds(71, 222, 242, 21);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(71, 250, 242, 21);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("\u64CD\u4F5C\u6210\u529F");
		lblNewLabel_9.setBounds(137, 281, 54, 15);
		contentPane.add(lblNewLabel_9);
		lblNewLabel_9.setVisible(false);
		
		JLabel lblNewLabel_10 = new JLabel("\u64CD\u4F5C\u5931\u8D25");
		lblNewLabel_10.setForeground(Color.RED);
		lblNewLabel_10.setBounds(135, 296, 54, 15);
		contentPane.add(lblNewLabel_10);
		lblNewLabel_10.setVisible(false);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.addActionListener(new ActionListener() {//确认
			public void actionPerformed(ActionEvent e) {
				String num = new String(textField.getText());
				String name = new String(textField_1.getText());
				String writer = new String(textField_2.getText());
				String publish = new String(textField_3.getText());
				String price = new String(textField_4.getText());
				String intro = new String(textField_5.getText());
				String status = new String(textField_6.getText());
				String cla = new String(textField_7.getText());
				
				if(num.equals("") || name.equals("") || writer.equals("") || publish.equals("") || price.equals("")||intro.equals("") ||status.equals("") || cla.equals("")) {
					lblNewLabel_10.setVisible(true);
				}
				else {
				String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=LibraryManagement";
				String userName="sa";
				String userPwd="QWEASDZXC000000";
				Connection dbConn = null;
				
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					dbConn = DriverManager.getConnection(dbURL,userName,userPwd);
					
					PreparedStatement pst = null;
					pst = dbConn.prepareStatement("insert into 图书 values(?,?,?,?,?,?,?,?)");
					pst.setString(1, num);//书号
					pst.setString(2, name);//书名
					pst.setString(3, writer);//作者
					pst.setString(4, publish);//出版社
					pst.setString(5, price);//定价
					pst.setString(6, intro);//内容简介
					pst.setString(7, status);//状态
					pst.setString(8, cla);//分类
					pst.addBatch();
					pst.executeBatch();
						
					dbConn.close();
					lblNewLabel_9.setVisible(true);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					lblNewLabel_10.setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					lblNewLabel_10.setVisible(true);
				}
				
				}
				if(lblNewLabel_9.isVisible())
					lblNewLabel_10.setVisible(false);
			}
		});
		btnNewButton.setBounds(32, 275, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(308, 275, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_8 = new JLabel("\u5206\u7C7B");
		lblNewLabel_8.setBounds(32, 250, 54, 15);
		contentPane.add(lblNewLabel_8);
		
	}

}
package Testv1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
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
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Lend extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lend frame = new Lend();
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
	public Lend() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(514, 342, 93, 23);
		contentPane.add(btnNewButton_1);
		
		
		JLabel lblNewLabel_1 = new JLabel("\u8F93\u5165\u4E66\u53F7");
		lblNewLabel_1.setBounds(10, 315, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(63, 312, 93, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u64CD\u4F5C\u6210\u529F");
		lblNewLabel_2.setBounds(163, 346, 54, 15);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);		//������
		
		JLabel lblNewLabel = new JLabel("\u64CD\u4F5C\u5931\u8D25");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(113, 346, 54, 15);
		contentPane.add(lblNewLabel);
		lblNewLabel.setVisible(false);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 597, 295);
		contentPane.add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 300, 150);
		panel.add(scrollPane);
		
		String []Name = {"���", "����", "����", "������","����","���ݼ��","״̬","����"};
		Object [][] rowData = new Object [100][8];           
		JTable table = new JTable(rowData, Name);
		table.setBounds(297, 179, -279, -124);
		table.setRowHeight(30);                          //�����и�
		table.getColumnModel().getColumn(0).setPreferredWidth(110); //��һ���п�
		table.setPreferredScrollableViewportSize(new Dimension(580 ,300));    //���ù�������ӿڴ�С�������ô�С����������Ҫ�϶���������
		scrollPane.setViewportView(table);
		
		try {
			String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=LibraryManagement";
			String userName="sa";
			String userPwd="QWEASDZXC000000";
			Connection dbConn = null;
			
			Statement state = null;
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			dbConn = DriverManager.getConnection(dbURL,userName,userPwd);
			state = dbConn.createStatement();
			String sql0 = "select * from ͼ��";
			ResultSet rs = state.executeQuery(sql0);
			
			int i = 0;
			while(rs.next() && i<rowData.length) {
					
				rowData[i][0] = rs.getString(1);
				rowData[i][1] = rs.getString(2);   
				rowData[i][2] = rs.getString(3);   
				rowData[i][3] = rs.getString(4);   
				rowData[i][4] = rs.getString(5);
				rowData[i][5] = rs.getString(6);
				rowData[i][6] = rs.getString(7);
				rowData[i][7] = rs.getString(8);
				i++;
			}
			dbConn.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JLabel lblNewLabel_3 = new JLabel("\u4E00\u6B21\u6700\u591A\u501F8\u672C");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(221, 315, 93, 15);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setVisible(false);
		
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			//��ѯ
				BookFind bf = new BookFind();
				bf.setVisible(true);
			}
		});
		
		btnNewButton.setBounds(514, 311, 93, 23);
		contentPane.add(btnNewButton);
		JButton btnNewButton_2 = new JButton("\u501F\u9605");
		btnNewButton_2.addActionListener(new ActionListener() {//����
			public void actionPerformed(ActionEvent e) {
				String textBook = new String(textField_1.getText());
				String num = new String();
				String name = new String();
				String Bname = new String();
				String tmp = null;
				String status = null;
				
				try {
					String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=LibraryManagement";
					String userName="sa";
					String userPwd="QWEASDZXC000000";
					Connection dbConn = null;
					
					Statement state = null;
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					dbConn = DriverManager.getConnection(dbURL,userName,userPwd);
					state = dbConn.createStatement();
					//String sql0 = "select * from ͼ��";
					//ResultSet rs = state.executeQuery(sql0);
					
					String sql0 = "select top 1* from �����˺� order by ʱ�� desc";
					ResultSet rs = state.executeQuery(sql0);		//���һ��
					String s1 = new String();
					while(rs.next()) {
						s1 = rs.getString(1);
					}
					num = s1;//�˺�
					
					Statement sta = dbConn.createStatement();
					String sql = "select count(*) from ���� where ����֤��='"+num+"'";
					ResultSet re = sta.executeQuery(sql);
					while(re.next()) {
						tmp = re.getString(1);			//��¼һ�����˶��ٱ�
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(tmp.equals("8")) { //һ��������8����
					lblNewLabel_3.setVisible(true);
					lblNewLabel_2.setVisible(false);
					
				}
				else {
					try{
						String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=LibraryManagement";
						String userName="sa";
						String userPwd="QWEASDZXC000000";
						Connection dbConn = null;
					
						Statement state = null;
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						dbConn = DriverManager.getConnection(dbURL,userName,userPwd);
						state = dbConn.createStatement();
					
						Statement state_1 = dbConn.createStatement();
						String sql1 = "select * from ������ where ����֤��='"+num+"'";
						ResultSet rs1 = state_1.executeQuery(sql1);
						String s2 = new String();
						while(rs1.next()) {
							s2 = rs1.getString(2);
						}
						name = s2;
					
						Statement state_2 = dbConn.createStatement();
						String sql2 = "select * from ͼ�� where ���='"+textBook+"'";
						ResultSet rs2 = state_2.executeQuery(sql2);
						String s3 = new String();
						while(rs2.next()) {
							s3 = rs2.getString(2);
						}
						Bname = s3;		//����
					
						Statement state_4 = dbConn.createStatement();
						String sql3 = "select * from ͼ�� where ���='"+textBook+"'";
						ResultSet rs3 = state_4.executeQuery(sql3);
						String s4 = new String();
						while(rs3.next()) {
							s4 = rs3.getString("״̬");
						}
						status = s4;
						
						if(status.equals("�ѽ��")) {
							lblNewLabel.setVisible(true);
						}
						else {
							lblNewLabel.setVisible(false);
						Calendar c = Calendar.getInstance();
					
						PreparedStatement pst = null;
						pst = dbConn.prepareStatement("insert into ���� values(?,?,?,?,?)");
						pst.setString(1, num);
						pst.setString(2, name);
						pst.setString(3, textBook);
						pst.setString(4, Bname);
						pst.setTimestamp(5, new Timestamp(c.getTimeInMillis()));
						pst.addBatch();
						pst.executeBatch();
					
						PreparedStatement pst1 = null;
						pst1 = dbConn.prepareStatement("update ͼ�� set ״̬=? where ���=?");
						pst1.setString(1, "�ѽ��");
						pst1.setString(2, textBook);
						pst1.addBatch();
						pst1.executeBatch();
					
						lblNewLabel_2.setVisible(true);
						
						String sql0 = "select * from ͼ��";
						ResultSet rs = state.executeQuery(sql0);
						
						int i = 0;
						while(rs.next() && i<rowData.length) {
								
							rowData[i][0] = rs.getString(1);
							rowData[i][1] = rs.getString(2);   
							rowData[i][2] = rs.getString(3);   
							rowData[i][3] = rs.getString(4);   
							rowData[i][4] = rs.getString(5);
							rowData[i][5] = rs.getString(6);
							rowData[i][6] = rs.getString(7);
							rowData[i][7] = rs.getString(8);
							i++;
						}
						//ˢ��
						TableModel tml = new DefaultTableModel(rowData,Name);
						table.setModel(tml);
						dbConn.close();
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						lblNewLabel.setVisible(true);
						lblNewLabel_2.setVisible(false);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						lblNewLabel.setVisible(true);
						lblNewLabel_2.setVisible(false);
					}
					if(lblNewLabel_2.isVisible()) {
						lblNewLabel.setVisible(false);
					}
				}
			}
		});
		btnNewButton_2.setBounds(10, 342, 93, 23);
		contentPane.add(btnNewButton_2);
	}

}
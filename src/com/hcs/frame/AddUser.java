package com.hcs.frame;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.hcs.bean.Role;
import com.hcs.bean.User;
import com.hcs.dao.RoleDao;
import com.hcs.dao.UserDao;

public class AddUser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jPanel = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
	private JButton jButton = null;
	private JButton jButton1 = null;
	private JLabel jLabel6 = null;
	private JTextField jTextField = null;
	private JPasswordField jPasswordField = null;
	private JPasswordField jPasswordField1 = null;
	private JComboBox jComboBox = null;
	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints12.gridy = 6;
			gridBagConstraints12.weightx = 1.0;
			gridBagConstraints12.gridx = 1;
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints11.gridy = 5;
			gridBagConstraints11.weightx = 1.0;
			gridBagConstraints11.gridx = 1;
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			gridBagConstraints10.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints10.gridy = 4;
			gridBagConstraints10.weightx = 1.0;
			gridBagConstraints10.gridx = 1;
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints9.gridy = 3;
			gridBagConstraints9.weightx = 1.0;
			gridBagConstraints9.gridx = 1;
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.gridx = 1;
			gridBagConstraints8.gridy = 2;
			jLabel6 = new JLabel();
			jLabel6.setText("JLabel");
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.gridx = 1;
			gridBagConstraints7.gridy = 7;
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 0;
			gridBagConstraints6.gridy = 7;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 0;
			gridBagConstraints5.gridy = 6;
			jLabel5 = new JLabel();
			jLabel5.setText("权        限：");
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.gridy = 5;
			jLabel4 = new JLabel();
			jLabel4.setText("确认密码:");
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 0;
			gridBagConstraints3.gridy = 4;
			jLabel3 = new JLabel();
			jLabel3.setText("密        码：");
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.gridy = 3;
			jLabel2 = new JLabel();
			jLabel2.setText("名        称：");
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.gridy = 2;
			jLabel1 = new JLabel();
			jLabel1.setText("用户    ID：");
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 1;
			gridBagConstraints.gridy = 0;
			jLabel = new JLabel();
			jLabel.setText("请输入用户相关信息");
			jPanel = new JPanel();
			
			gridBagConstraints.insets = new Insets(0, 0, 0, 100);
			gridBagConstraints1.insets = new Insets(0, 50, 0, 0);
			gridBagConstraints2.insets = new Insets(0, 50, 0, 0);
			gridBagConstraints3.insets = new Insets(0, 50, 0, 0);
			gridBagConstraints4.insets = new Insets(0, 50, 0, 0);
			gridBagConstraints5.insets = new Insets(0, 50, 0, 0);
			
			jPanel.setLayout(new GridBagLayout());
			jPanel.add(jLabel, gridBagConstraints);
			jPanel.add(jLabel1, gridBagConstraints1);
			jPanel.add(jLabel2, gridBagConstraints2);
			jPanel.add(jLabel3, gridBagConstraints3);
			jPanel.add(jLabel4, gridBagConstraints4);
			jPanel.add(jLabel5, gridBagConstraints5);
			jPanel.add(getJButton(), gridBagConstraints6);
			jPanel.add(getJButton1(), gridBagConstraints7);
			jPanel.add(jLabel6, gridBagConstraints8);
			jPanel.add(getJTextField(), gridBagConstraints9);
			jPanel.add(getJPasswordField(), gridBagConstraints10);
			jPanel.add(getJPasswordField1(), gridBagConstraints11);
			jPanel.add(getJComboBox(), gridBagConstraints12);
		}
		return jPanel;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setPreferredSize(new Dimension(60, 22));
			jButton.setText("添加");
			jButton.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					String name = getJTextField().getText().trim();
					String passwd = new String(getJPasswordField().getPassword());
					String confirmPwd = new String(getJPasswordField1().getPassword());
					Role role = (Role)getJComboBox().getSelectedItem();
					System.out.println(role);
					System.out.println(name + ", " + passwd + ", " + confirmPwd + ", " + role.getRoleLevel() + ", " + role.getRoleName());
					User user = new User(name, passwd, role);
					if(userDao.addUser(user)){
						JOptionPane.showMessageDialog(null, "用户添加成功！");
					}
					AddUser.this.dispose();
				}
				
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setPreferredSize(new Dimension(60, 22));
			jButton1.setText("取消");
			jButton1.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					AddUser.this.dispose();
				}
				
			});
		}
		return jButton1;
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setPreferredSize(new Dimension(100, 22));
		}
		return jTextField;
	}

	/**
	 * This method initializes jPasswordField	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getJPasswordField() {
		if (jPasswordField == null) {
			jPasswordField = new JPasswordField();
			jPasswordField.setPreferredSize(new Dimension(100, 22));
		}
		return jPasswordField;
	}

	/**
	 * This method initializes jPasswordField1	
	 * 	
	 * @return javax.swing.JPasswordField	
	 */
	private JPasswordField getJPasswordField1() {
		if (jPasswordField1 == null) {
			jPasswordField1 = new JPasswordField();
			jPasswordField1.setPreferredSize(new Dimension(100, 22));
		}
		return jPasswordField1;
	}

	
	private RoleDao roleDao = new RoleDao();
	private UserDao userDao = new UserDao();  //  @jve:decl-index=0:
	/**
	 * This method initializes jComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox() {
		if (jComboBox == null) {
			List<Role> roles = roleDao.listRoles();
			Vector<Role> rolesVec = new Vector<Role>();
			for(Role role : roles){
				rolesVec.add(role);
			}
			jComboBox = new JComboBox(rolesVec);
			jComboBox.setPreferredSize(new Dimension(100, 22));
		}
		return jComboBox;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AddUser thisClass = new AddUser();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public AddUser() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(380, 234);
		this.setContentPane(getJPanel());
		this.setTitle("添加用户");
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"

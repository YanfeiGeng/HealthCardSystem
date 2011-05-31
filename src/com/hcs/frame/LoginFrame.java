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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.hcs.bean.Role;
import com.hcs.bean.User;
import com.hcs.dao.RoleDao;
import com.hcs.dao.UserDao;
import com.hcs.util.UIUtil;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jPanel = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JTextField jTextField = null;
	private JButton jButton = null;
	private JButton jButton1 = null;
	private JLabel jLabel3 = null;
	private JComboBox jComboBox = null;
	private JPasswordField jPasswordField = null;
	/**
	 * This is the default constructor
	 */
	public LoginFrame() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(365, 200);
		this.setContentPane(getJPanel());
		this.setTitle("健康体检管理系统登录");
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints4.gridy = 2;
			gridBagConstraints4.weightx = 1.0;
			gridBagConstraints4.gridx = 1;
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints21.gridy = 4;
			gridBagConstraints21.weightx = 1.0;
			gridBagConstraints21.gridx = 1;
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 0;
			gridBagConstraints11.gridy = 4;
			gridBagConstraints11.insets = new Insets(10, 30, 0, 0);
			jLabel3 = new JLabel();
			jLabel3.setText("权    限：");
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 1;
			gridBagConstraints6.gridy = 5;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 0;
			gridBagConstraints5.gridy = 5;
			gridBagConstraints5.insets = new Insets(0, 30, 0, 0);
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints3.gridy = 1;
			gridBagConstraints3.weightx = 1.0;
			gridBagConstraints3.gridx = 1;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.gridy = 2;
			jLabel2 = new JLabel();
			jLabel2.setText("密    码：");
			gridBagConstraints2.insets = new Insets(10, 30, 0, 0);
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.gridy = 1;
			gridBagConstraints1.insets = new Insets(10, 30, 0, 0);
			jLabel1 = new JLabel();
			jLabel1.setText("用户名：");
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 1;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.insets = new Insets(0, 0, 0, 70);
			jLabel = new JLabel();
			jLabel.setText("欢迎使用登录健康体检管理系统");
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.add(jLabel, gridBagConstraints);
			jPanel.add(jLabel1, gridBagConstraints1);
			jPanel.add(jLabel2, gridBagConstraints2);
			jPanel.add(getJTextField(), gridBagConstraints3);
			jPanel.add(getJButton(), gridBagConstraints5);
			jPanel.add(getJButton1(), gridBagConstraints6);
			jPanel.add(jLabel3, gridBagConstraints11);
			jPanel.add(getJComboBox(), gridBagConstraints21);
			jPanel.add(getJPasswordField(), gridBagConstraints4);
		}
		return jPanel;
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
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("登录");
			jButton.setPreferredSize(new Dimension(60, 22));
			jButton.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					if(authUser()){
						jButton.setEnabled(false);
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								Main thisClass = new Main();
								UIUtil.setInCenter(thisClass);
								thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								thisClass.setVisible(true);
								LoginFrame.this.dispose();
							}
						});
					} else {
						JOptionPane.showMessageDialog(null, "用户名或密码错误！", "健康体检登录", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			});
		}
		return jButton;
	}
	
	
	private UserDao userDao = new UserDao();
	private boolean authUser(){
		String name = this.getJTextField().getText().trim();
		String password = new String(this.getJPasswordField().getPassword());
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		user = userDao.authUser(user); 
		if(user != null && user.getId() != null){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("取消");
			jButton1.setPreferredSize(new Dimension(60, 22));
			jButton1.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					LoginFrame.this.dispose();
				}
				
			});
		}
		return jButton1;
	}
	
	private RoleDao roleDao = new RoleDao();
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
		}
		return jComboBox;
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

	public static void main(String[] args){
		try {
			Main.initGlobalFont();
			UIManager.setLookAndFeel(new com.sun.java.swing.plaf.windows.WindowsLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				LoginFrame thisClass = new LoginFrame();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				UIUtil.setInCenter(thisClass);
				thisClass.setVisible(true);
			}
		});
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"

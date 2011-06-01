package com.hcs.frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import com.hcs.dao.RoleDao;
import com.hcs.util.RoleDefinition;

public class AddRole extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jPanel = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel5 = null;
	private JButton jButton = null;
	private JButton jButton1 = null;
	private JLabel jLabel6 = null;
	private JTextField jTextField = null;
	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.fill = GridBagConstraints.BOTH;
			gridBagConstraints11.gridy = 6;
			gridBagConstraints11.weightx = 1.0;
			gridBagConstraints11.weighty = 1.0;
			gridBagConstraints11.gridx = 1;
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints9.gridy = 3;
			gridBagConstraints9.weightx = 1.0;
			gridBagConstraints9.gridx = 1;
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.gridx = 1;
			gridBagConstraints8.gridy = 2;
			jLabel6 = new JLabel();
			jLabel6.setText("N/A");
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
			jLabel5.setText("Ȩ        �ޣ�");
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.gridy = 3;
			jLabel2 = new JLabel();
			jLabel2.setText("��        �ƣ�");
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.gridy = 2;
			jLabel1 = new JLabel();
			jLabel1.setText("Ȩ��    ID��");
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 1;
			gridBagConstraints.gridy = 0;
			jLabel = new JLabel();
			jLabel.setText("������Ȩ�������Ϣ");
			jPanel = new JPanel();
			
			gridBagConstraints.insets = new Insets(0, 0, 0, 100);
			gridBagConstraints1.insets = new Insets(0, 50, 0, 0);
			gridBagConstraints2.insets = new Insets(0, 50, 0, 0);
			gridBagConstraints5.insets = new Insets(0, 50, 0, 0);
			
			jPanel.setLayout(new GridBagLayout());
			jPanel.add(jLabel, gridBagConstraints);
			jPanel.add(jLabel1, gridBagConstraints1);
			jPanel.add(jLabel2, gridBagConstraints2);
			jPanel.add(jLabel5, gridBagConstraints5);
			jPanel.add(getJButton(), gridBagConstraints6);
			jPanel.add(getJButton1(), gridBagConstraints7);
			jPanel.add(jLabel6, gridBagConstraints8);
			jPanel.add(getJTextField(), gridBagConstraints9);
			JScrollPane listPane = new JScrollPane(getJList());
			jPanel.add(listPane, gridBagConstraints11);
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
			jButton.setText("���");
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
			jButton1.setText("ȡ��");
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

	private RoleDao roleDao = new RoleDao();
	private JList jList = null;
	
	class AtmoRole{
		
		public AtmoRole(int level, String name) {
			super();
			this.level = level;
			this.name = name;
		}

		private int level;
		
		private String name;

		public int getLevel() {
			return level;
		}

		public void setLevel(int level) {
			this.level = level;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return this.name;
		}
		
	}
	
	/**
	 * This method initializes jList	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJList() {
		if (jList == null) {
			Vector<AtmoRole> roles = new Vector<AtmoRole>();
			roles.add(new AtmoRole(RoleDefinition.BASIC_INFO, "��Ա������Ϣ����"));
			roles.add(new AtmoRole(RoleDefinition.HEALTH_CHECK, "���������"));
			roles.add(new AtmoRole(RoleDefinition.HEALTH_STATICS, "ͳ��������Ϣ����"));
			roles.add(new AtmoRole(RoleDefinition.USER_ROLE, "�û�Ȩ�޹���"));
			jList = new JList(roles);
			jList.setVisibleRowCount(3);
			jList.setBorder(new LineBorder(Color.BLACK, 1));
		}
		return jList;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AddRole thisClass = new AddRole();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public AddRole() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(400, 300);
		this.setContentPane(getJPanel());
		this.setTitle("���Ȩ��");
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"

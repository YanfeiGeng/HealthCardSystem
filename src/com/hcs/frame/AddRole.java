package com.hcs.frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import com.hcs.bean.AtmoRole;
import com.hcs.bean.Role;
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
	private Role role = null;  //  @jve:decl-index=0:
	private RoleManageFrame roleManageFrame = null;
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
//			gridBagConstraints11.fill = GridBagConstraints.BOTH;
			gridBagConstraints11.gridy = 6;
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
			jLabel6.setEnabled(false);
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
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.gridy = 3;
			jLabel2 = new JLabel();
			jLabel2.setText("名        称：");
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.gridy = 2;
			jLabel1 = new JLabel();
			jLabel1.setText("权限    ID：");
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 1;
			gridBagConstraints.gridy = 0;
			jLabel = new JLabel();
			jLabel.setText("请输入权限相关信息");
			jPanel = new JPanel();
			
			gridBagConstraints.insets = new Insets(0, 0, 0, 100);
			gridBagConstraints1.insets = new Insets(10, 50, 0, 0);
			gridBagConstraints2.insets = new Insets(10, 50, 0, 0);
			gridBagConstraints5.insets = new Insets(10, 50, 0, 0);
			
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
			listPane.setPreferredSize(new Dimension(200, 100));
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
			jButton.setText("添加");
			jButton.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					Object[] objs = getJList().getSelectedValues();
					StringBuffer roleLevel = new StringBuffer();
					for(int i = 0; i < objs.length; i++){
						AtmoRole role = (AtmoRole)objs[i];
						roleLevel.append(role.getLevel());
						if(i < objs.length -1){
							roleLevel.append(",");
						}
					}
					String name = getJTextField().getText().trim();
					Role role = new Role(name, roleLevel.toString());
					if(AddRole.this.getRole() != null){
						role.setId(AddRole.this.getRole().getId());
						roleDao.updateRole(role);
						JOptionPane.showMessageDialog(null, "权限修改成功！");
						AddRole.this.getRoleManageFrame().refreshRoleTable();
					} else {
						if(roleDao.addRole(role)){
							JOptionPane.showMessageDialog(null, "权限添加成功！");
							AddRole.this.getRoleManageFrame().refreshRoleTable();
						}
					}
					
					AddRole.this.dispose();
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
					AddRole.this.dispose();
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
			jTextField.setPreferredSize(new Dimension(200, 22));
		}
		return jTextField;
	}

	private RoleDao roleDao = new RoleDao();  //  @jve:decl-index=0:
	private JList jList = null;
	
	
	
	/**
	 * This method initializes jList	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJList() {
		if (jList == null) {
			jList = new JList(RoleDefinition.roles);
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
	
	public AddRole(Role role) {
		super();
		initialize();
		this.role = role;
		if(this.role != null){
			jLabel6.setText(role.getId());
			jTextField.setText(role.getRoleName());
			this.setTitle("编辑权限");
			jButton.setText("更新");
			ListModel model = jList.getModel();
			int size = model.getSize();
			List<Integer> selectIndexs = new ArrayList<Integer>();
			for(int pos = 0; pos < size; pos++){
				AtmoRole roleI = (AtmoRole) model.getElementAt(pos);
				String roleLevel = this.role.getRoleLevel();
				if(roleI != null && roleLevel != null && roleLevel.contains(String.valueOf(roleI.getLevel()))){
					selectIndexs.add(pos);
				}
			}
			int[] indexs = new int[selectIndexs.size()];
			for(int i = 0; i < indexs.length; i++){
				indexs[i] = selectIndexs.get(i).intValue();
			}
			jList.setSelectedIndices(indexs);
		}
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(400, 300);
		this.setContentPane(getJPanel());
		this.setTitle("添加权限");
	}

	public RoleManageFrame getRoleManageFrame() {
		return roleManageFrame;
	}

	public void setRoleManageFrame(RoleManageFrame roleManageFrame) {
		this.roleManageFrame = roleManageFrame;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"

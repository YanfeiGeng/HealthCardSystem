package com.hcs.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import com.hcs.util.DataOperator;
import com.hcs.util.UIUtil;

public class BasicInfoManageFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JMenuBar jJMenuBar = null;
	private JMenu jMenu = null;
	private JMenu jMenu1 = null;
	private JTable jTable = null;

	/**
	 * This method initializes jJMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getJMenu());
			jJMenuBar.add(getJMenu1());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu() {
		if (jMenu == null) {
			jMenu = new JMenu();
			jMenu.setText("�༭��ѡ�У�");
			jMenu.addMouseListener(new MouseAdapter(){

				@Override
				public void mouseClicked(MouseEvent e) {
					int rowSel = getRowSelected(); 
					if(rowSel == -1){
						JOptionPane.showMessageDialog(null, "��ѡ����Ҫ�༭���У�");
					} else {
						String[] value = data.get(rowSel);
						BasicInfoInputFrame infoInputFrame = new BasicInfoInputFrame();
						UIUtil.setInCenter(infoInputFrame);
						infoInputFrame.initValue(value);
						infoInputFrame.setVisible(true);
					}
				}
				
			});
		}
		return jMenu;
	}

	/**
	 * This method initializes jMenu1	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu1() {
		if (jMenu1 == null) {
			jMenu1 = new JMenu();
			jMenu1.setText("ɾ����ѡ�У�");
			jMenu1.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent e) {
					int rowSel = getRowSelected(); 
					if(rowSel == -1){
						JOptionPane.showMessageDialog(null, "��ѡ����Ҫɾ�����У�");
					} else {
						int yesOrNo = JOptionPane.showConfirmDialog(null, "ȷ��Ҫɾ��ѡ��������", "ɾ��ȷ��", JOptionPane.YES_NO_OPTION);
						if(yesOrNo == JOptionPane.YES_OPTION){
							DefaultTableModel model = (DefaultTableModel) getJTable().getModel();
							model.removeRow(rowSel);
						}
					}
				}
				
			});
		}
		return jMenu1;
	}
	
	public int getRowSelected(){
		return this.getJTable().getSelectedRow();
	}
	
	private List<String[]> data = DataOperator.getHealthCardRecords();  //  @jve:decl-index=0:

	/**
	 * This method initializes jTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable() {
		if (jTable == null) {
			String[] columnNames = {"����֤ID", "����", "�Ա�", "����", "��������", "����", "��סַ", "��챨��"};
			String[][] initData = new String[data.size()][8];
			for(int i = 0; i < initData.length; i++){
				initData[i] = data.get(i);
			}
			DefaultTableModel model = new DefaultTableModel(initData, columnNames);
			jTable = new JTable(model);
			jTable.setPreferredScrollableViewportSize(new Dimension(500, 70));
		}
		return jTable;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				BasicInfoManageFrame thisClass = new BasicInfoManageFrame();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public BasicInfoManageFrame() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(752, 340);
		this.setJMenuBar(getJJMenuBar());
		this.setContentPane(getJContentPane());
		this.setTitle("����֤���Ϲ���");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			
			JScrollPane scrollPane = new JScrollPane(getJTable());
		    add(scrollPane);
			jContentPane.add(scrollPane, BorderLayout.CENTER);
		}
		return jContentPane;
	}

} 
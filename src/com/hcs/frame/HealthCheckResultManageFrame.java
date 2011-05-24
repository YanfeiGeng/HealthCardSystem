package com.hcs.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import com.hcs.util.CheckResultOperator;
import com.hcs.util.UIUtil;

public class HealthCheckResultManageFrame extends JFrame {

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
			jMenu.setText("编辑（选中）");
			jMenu.addMouseListener(new MouseAdapter(){

				@Override
				public void mouseClicked(MouseEvent e) {
					int rowSel = getRowSelected(); 
					if(rowSel == -1){
						JOptionPane.showMessageDialog(null, "请选中需要编辑的行！");
					} else {
						DefaultTableModel model = (DefaultTableModel) getJTable().getModel();
						Object value = model.getValueAt(rowSel, 0);
						System.out.println("Value is: " + value);
						
						String[] checkResult = CheckResultOperator.getCheckResult(value.toString());
						for(String it : checkResult){
							System.out.println(it);
						}
						
						HealthCheckResultInputFrame checkResultFrame = new HealthCheckResultInputFrame();
						UIUtil.setInCenter(checkResultFrame);
						checkResultFrame.initValue(checkResult);
						checkResultFrame.setVisible(true);
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
			jMenu1.setText("删除（选中）");
			jMenu1.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent e) {
					int rowSel = getRowSelected(); 
					if(rowSel == -1){
						JOptionPane.showMessageDialog(null, "请选中需要删除的行！");
					} else {
						int yesOrNo = JOptionPane.showConfirmDialog(null, "确认要删除选定的行吗？", "删除确认", JOptionPane.YES_NO_OPTION);
						if(yesOrNo == JOptionPane.YES_OPTION){
							DefaultTableModel model = (DefaultTableModel) getJTable().getModel();
							CheckResultOperator.deleteCheckResultRecord(model.getValueAt(rowSel, 0).toString());
							CheckResultOperator.saveData();
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
	
	private List<String[]> data = CheckResultOperator.getCheckResultRecords();  //  @jve:decl-index=0:

	/**
	 * This method initializes jTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable() {
		if (jTable == null) {
			String[] columnNames = {"体检结果ID", "一般情况", "生化室", "放射科", "心电图", "检验科", "其他"};
			String[][] initData = new String[data.size()][7];
			for(int i = 0; i < initData.length; i++){
				initData[i] = new String[7];
				for(int j = 0; j <= initData[i].length; j++){
					if(j == 6){
						initData[i][j] = "无";
					}
					if(j > 5){
						continue;
					}
					if(j >= 2){
						initData[i][j] = data.get(i)[j + 6];
					} else {
						initData[i][j] = data.get(i)[j];
					}
				}
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
				HealthCheckResultManageFrame thisClass = new HealthCheckResultManageFrame();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public HealthCheckResultManageFrame() {
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
		this.setTitle("体检结果管理界面");
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

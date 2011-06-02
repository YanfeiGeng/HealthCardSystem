package com.hcs.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import com.hcs.bean.BasicInformation;
import com.hcs.dao.BasicInfoDao;
import com.hcs.util.BasicInfoOperator;
import com.hcs.util.UIUtil;

public class BasicInfoManageFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JMenuBar jJMenuBar = null;
	private JMenu jMenu = null;
	private JMenu jMenu1 = null;
	private JTable jTable = null;
	private BasicInfoDao basicDao = new BasicInfoDao();

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
						Object id = model.getValueAt(rowSel, 0);
						BasicInformation basicInfo = basicDao.getHealthCardRecordById(id.toString());
						
						BasicInfoInputFrame infoInputFrame = new BasicInfoInputFrame();
						infoInputFrame.setBasicInfoFrame(BasicInfoManageFrame.this);
						UIUtil.setInCenter(infoInputFrame);
						infoInputFrame.initValue(basicInfo);
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
							Object id = model.getValueAt(rowSel, 0);
							basicDao.deleteHealthCardRecord(id.toString());
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
	
	private List<String[]> data = BasicInfoOperator.getHealthCardRecords();  //  @jve:decl-index=0:
	
	private DefaultTableModel initBasicInfo(){
		List<BasicInformation> basicRecords = basicDao.getHealthCardRecords();
		String[] columnNames = {"健康证ID", "姓名", "性别", "年龄", "出生日期", "籍贯", "现住址", "体检报告"};
		String[][] initData = new String[basicRecords.size()][8];
		
		//Original Usage
//		for(int i = 0; i < initData.length; i++){
//			initData[i] = data.get(i);
//		}
		
		for(int i = 0; i < basicRecords.size(); i++){
			BasicInformation info = basicRecords.get(i);
			initData[i][0] = info.getId();
			initData[i][1] = info.getName();
			initData[i][2] = info.getSex();
			initData[i][3] = info.getAge();
			initData[i][4] = info.getBirthday().toString();
			initData[i][5] = info.getAddress();
			initData[i][6] = info.getCurrentAddress();
			initData[i][7] = info.getCheckReport();
		}
		DefaultTableModel model = new DefaultTableModel(initData, columnNames);
		return model;
	}
	
	public void refreshBasicInfoTable(){
		getJTable().setModel(initBasicInfo());
		((DefaultTableModel)getJTable().getModel()).fireTableStructureChanged();
	}

	/**
	 * This method initializes jTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable() {
		if (jTable == null) {
			jTable = new JTable(initBasicInfo());
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
		this.setSize(800, 340);
		this.setJMenuBar(getJJMenuBar());
		this.setContentPane(getJContentPane());
		this.setTitle("健康证资料管理");
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

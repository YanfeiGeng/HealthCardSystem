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

import com.hcs.bean.CheckResultBean;
import com.hcs.dao.HealthCheckResultDao;
import com.hcs.util.CheckResultOperator;
import com.hcs.util.UIUtil;

public class HealthCheckResultManageFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JMenuBar jJMenuBar = null;
	private JMenu jMenu = null;
	private JMenu jMenu1 = null;
	private JTable jTable = null;
	private HealthCheckResultDao checkDao = new HealthCheckResultDao();  //  @jve:decl-index=0:

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
						
						//Original Usage
//						String[] checkResult = CheckResultOperator.getCheckResult(value.toString());
//						for(String it : checkResult){
//							System.out.println(it);
//						}
						CheckResultBean checkResult = checkDao.getCheckResult(value.toString());
						
						SelectBasicInfoForCheckResult sbifr = new SelectBasicInfoForCheckResult(checkResult);
						sbifr.setCheckResultFrame(HealthCheckResultManageFrame.this);
						UIUtil.setInCenter(sbifr);
						sbifr.setVisible(true);
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
							String id = model.getValueAt(rowSel, 0).toString();
							checkDao.deleteCheckResultRecord(id);
							
							//Original usage
//							CheckResultOperator.deleteCheckResultRecord(id);
//							CheckResultOperator.saveData();
							model.removeRow(rowSel);
							JOptionPane.showMessageDialog(null, "成功删除体检结果！");
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
	
	//Original Usage
//	private List<String[]> data = CheckResultOperator.getCheckResultRecords();  

	private DefaultTableModel initHealthCheck(){
		String[] columnNames = {"体检结果ID", "一般情况", "生化室", "放射科", "心电图", "检验科", "其他"};
		List<CheckResultBean> resultList = checkDao.getCheckResultRecords();
		String[][] initData = new String[resultList.size()][7];
		for(int i = 0; i < resultList.size(); i++){
			CheckResultBean result = resultList.get(i);
			initData[i][0] = result.getResultID(); 
			initData[i][1] = result.getGeneralInfo();
			initData[i][2] = result.getShParam1();
			initData[i][3] = result.getRayResult();
			initData[i][4] = result.getHeartResult();
			initData[i][5] = result.getCheckResult();
			initData[i][6] = "暂无";
		}
		
		//Original Usage
//		for(int i = 0; i < initData.length; i++){
//			initData[i] = new String[7];
//			for(int j = 0; j <= initData[i].length; j++){
//				if(j == 6){
//					initData[i][j] = "无";
//				}
//				if(j > 5){
//					continue;
//				}
//				if(j >= 2){
//					initData[i][j] = data.get(i)[j + 6];
//				} else {
//					initData[i][j] = data.get(i)[j];
//				}
//			}
//		}
		DefaultTableModel model = new DefaultTableModel(initData, columnNames);
		return model;
	}
	
	public void refreshCheckResultTable(){
		getJTable().setModel(initHealthCheck());
		((DefaultTableModel)getJTable().getModel()).fireTableStructureChanged();
	}
	
	/**
	 * This method initializes jTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable() {
		if (jTable == null) {
			
			jTable = new JTable(initHealthCheck());
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
		this.setSize(800, 340);
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

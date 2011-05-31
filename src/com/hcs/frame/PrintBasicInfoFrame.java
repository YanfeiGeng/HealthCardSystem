package com.hcs.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.Sides;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.hcs.bean.BasicInformation;
import com.hcs.dao.BasicInfoDao;
import com.hcs.util.BasicInfoOperator;
import com.hcs.util.UIUtil;

public class PrintBasicInfoFrame extends JFrame {

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
			jMenu.setText("��ӡԤ����ѡ�У�");
			jMenu.addMouseListener(new MouseAdapter(){

				@Override
				public void mouseClicked(MouseEvent e) {
					int rowSel = getRowSelected(); 
					if(rowSel == -1){
						JOptionPane.showMessageDialog(null, "��ѡ����Ҫ��ӡ�Ľ���֤��");
					} else {
						DefaultTableModel model = (DefaultTableModel) getJTable().getModel();
						Object id = model.getValueAt(rowSel, 0);
						BasicInformation basicInfo = basicDao.getHealthCardRecordById(id.toString());
						StringBuffer content = new StringBuffer();
//						for(int i = 0; i < value.length; i++){
//							content.append();
//							content.append(value[i]);
//							content.append("\r\n");
//						}
//						"����֤ID", "����", "�Ա�", "����", "��������", "����", "��סַ", "��챨��
						content.append(columnNames[0] + ":   ")
							.append(basicInfo.getId() + "\n\r")
							.append(columnNames[1] + ":   ")
							.append(basicInfo.getName() + "\n\r")
							.append(columnNames[2] + ":   ")
							.append(basicInfo.getSex() + "\n\r")
							.append(columnNames[3] + ":   ")
							.append(basicInfo.getAge() + "\n\r")
							.append(columnNames[4] + ":   ")
							.append(basicInfo.getBirthday().toString() + "\n\r")
							.append(columnNames[5] + ":   ")
							.append(basicInfo.getAddress() + "\n\r")
							.append(columnNames[6] + ":   ")
							.append(basicInfo.getCurrentAddress() + "\n\r")
							.append(columnNames[6] + ":   ")
							.append(basicInfo.getCheckReport());
						
						PrintPreview preview = new PrintPreview();
						preview.init(content.toString());
						preview.setSize(500, 400);
						UIUtil.setInCenter(preview);
						preview.setVisible(true);
					}
				}
				
			});
		}
		return jMenu;
	}
	
	private JMenu getJMenu1() {
		if (jMenu1 == null) {
			jMenu1 = new JMenu();
			jMenu1.setText("��ӡ��ѡ�У�");
			jMenu1.addMouseListener(new MouseAdapter(){

				@Override
				public void mouseClicked(MouseEvent e) {
					int rowSel = getRowSelected(); 
					if(rowSel == -1){
						JOptionPane.showMessageDialog(null, "��ѡ����Ҫ��ӡ�Ľ���֤��");
					} else {
						String[] value = data.get(rowSel);
						PrintService printService = PrintServiceLookup.lookupDefaultPrintService();
						String printerName = printService.getName();
						if(null == printerName || "".equals(printerName)){
							JOptionPane.showMessageDialog(null, "�޷��ҵ���ӡ������ȷ�ϴ�ӡ���Ѱ�װ��ȷ!");
						} else {
							StringBuffer content = new StringBuffer();
							for(int i = 0; i < value.length; i++){
								content.append(columnNames[i] + ":   ");
								content.append(value[i]);
								content.append("\r\n");
							}
							InputStream inputStream = new ByteArrayInputStream(content.toString().getBytes());
							Doc healthDoc = new SimpleDoc(inputStream, DocFlavor.INPUT_STREAM.AUTOSENSE, null);
							DocPrintJob printJob = printService.createPrintJob();
							PrintRequestAttributeSet attr = new HashPrintRequestAttributeSet();
							attr.add(Sides.DUPLEX);
							attr.add(new Copies(1));
							
//							try {
//								printJob.print(healthDoc, attr);
//							} catch (PrintException e1) {
//								e1.printStackTrace();
//							}
						}
					}
				}
				
			});
		}
		return jMenu1;
	}
	
//	class PrintPreview extends JFrame{
//		
//		private JEditorPane jEditorPane;
//		
//		void init(String value){
//			this.jEditorPane = new JEditorPane();
//			jEditorPane.setEditable(false);
//			jEditorPane.setText(value);
//			jEditorPane.setSize(400, 300);
//			JScrollPane scroll = new JScrollPane();
//			scroll.add(jEditorPane);
//			this.add(scroll);
//			this.setVisible(true);
//			this.setSize(500, 400);
//			UIUtil.setInCenter(this);
//		}
//		
//	}
	
	public int getRowSelected(){
		return this.getJTable().getSelectedRow();
	}
	
	private List<String[]> data = BasicInfoOperator.getHealthCardRecords(); 

	String[] columnNames = {"����֤ID", "����", "�Ա�", "����", "��������", "����", "��סַ", "��챨��"};
	
	/**
	 * This method initializes jTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable() {
		if (jTable == null) {
			List<BasicInformation> basicRecords = basicDao.getHealthCardRecords();
			String[][] initData = new String[basicRecords.size()][8];
			
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
			
//			for(int i = 0; i < initData.length; i++){
//				initData[i] = data.get(i);
//			}
			DefaultTableModel model = new DefaultTableModel(initData, columnNames);
			jTable = new MyTable(model);
			jTable.setPreferredScrollableViewportSize(new Dimension(500, 70));
			jTable.setRowSelectionAllowed(true);
		}
		return jTable;
	}
	
	class MyTable extends JTable{
		
		private static final long serialVersionUID = 5106259727277399853L;

		MyTable(TableModel model){
			super(model);
		}

		public boolean isCellEditable(int row, int column) {
			return false;
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PrintBasicInfoFrame thisClass = new PrintBasicInfoFrame();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public PrintBasicInfoFrame() {
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

package com.Yue.isurrender;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class isurrender extends JFrame{
	private static final long serialVersionUID = 1L;

	private JPanel panel = null;
	
	private JButton start = null;
	
	private JScrollPane jscrollpane = null;
	
	private JTextArea area = null;
	
	private JLabel introduction = null;
	
	private JLabel codeby = null;
	
	private String path = "./answer.txt";

	private String[] nums = writeToDat(path);

	private static List<String> list = new ArrayList<String>();

	
	public isurrender() {
		createFile();
		init();
	}
	
	private void init() {
		setSize(400,400);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(screenSize.width / 2 - getWidth() / 2,
				screenSize.height / 2 - getHeight() / 2);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(getPanel());
		setTitle("人生解答系統");
		setVisible(true);
	}
	
	private void createFile() {
		File file = new File(path);
		if(!file.exists()) {
			file.getParentFile().mkdir();
			FileWriter fw = null;
			try {
				file.createNewFile();
				fw = new FileWriter(path);
				fw.write("請記得輸入答案，換行會自動偵測");
			} catch(IOException e) {
				e.getStackTrace();
			} finally {
				try {
	                if (fw != null) {
	                	fw.flush();
	                    fw.close();
	                }
	            } catch (IOException e) {}
				
			}
		}
	}
	
	private String[] writeToDat(String path) {
		File file = new File(path);
		String[] nums = null;
		BufferedReader br = null;
		
		try {
			br =new BufferedReader(new FileReader(file));
			String line = null;
			
			while((line = br.readLine()) != null) {
				list.add(line);
			}
			
		} catch(IOException e) {
			e.getStackTrace();
		} finally {
			try {
				if(br != null) {
					br.close();
				}		
			} catch (IOException e) {}
		}
		
		nums = new String[(list.size())];
		
		for(int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			nums[i] = s;
		}
		return nums;
	}
	
	private int randomNum(int length) {
		Random random = new Random();
		int num = random.nextInt(length);
		return num;
	}
	
	private void doTxt() {
		String ans = nums[randomNum(list.size())].toString();
		getArea().setText(ans);
	}
	
	private JPanel getPanel() {
		if(this.panel == null) {
			this.panel = new JPanel();
			this.panel.setLayout((LayoutManager)null);
			this.panel.add(getJSrollPane(), null);
			this.panel.add(getStart(), null);
			this.panel.add(getLabel(), null);
			this.panel.add(codeBy(), null);
		}
		return this.panel;
	}
	
	private JScrollPane getJSrollPane() {
		if(this.jscrollpane == null) {
			this.jscrollpane = new JScrollPane();
			this.jscrollpane.setBounds(new Rectangle(10, 30, 365, 200));
			this.jscrollpane.setViewportView(getArea());
		}
		return this.jscrollpane;
	}
	
	private JTextArea getArea() {
		if(this.area == null) {
			this.area = new JTextArea();
			this.area.setFont(new java.awt.Font("Dialog", 0, 30));
			this.area.setEditable(false);
		}
		return this.area;
	}
	
	private JButton getStart() {
		if(this.start == null) {
			this.start = new JButton();
			this.start.setBounds(new Rectangle(10, 250, 100, 50));
			this.start.setFont(new java.awt.Font("Dialog", 0, 30));
			this.start.setActionCommand("按鈕");
			this.start.setText("按鈕");
			this.start.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					isurrender frame = (isurrender)((JButton)e.getSource()).getTopLevelAncestor();
					frame.doTxt();
				}
			});
		}
		return this.start;
	}
	
	private JLabel getLabel() {
		if(this.introduction == null) {
			this.introduction = new JLabel();
			this.introduction.setBounds(new Rectangle(150, 250, 200, 50));
			this.introduction.setFont(new java.awt.Font("Dialog", 0, 15));
			this.introduction.setText("<html>誠心誠意的發問並按下按鈕，系統將會給你神聖的答案</html>");
		}
		return this.introduction;
	}
	private JLabel codeBy() {
		if(this.codeby == null) {
			this.codeby = new JLabel();
			this.codeby.setBounds(new Rectangle(290, 315, 100, 75));
			this.codeby.setFont(new java.awt.Font("Dialog", 0, 12));
			this.codeby.setText("<html>Code By:月Yue</html>");
		}
		return this.codeby;
	}
	
	public static void main(String[] args) {
		new isurrender();
	}
}

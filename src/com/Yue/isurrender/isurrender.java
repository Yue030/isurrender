package com.Yue.isurrender;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class isurrender extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private static final String[] txt = {
			"可以", "好的", "由你自己決定", "不行", "不可以",
			"問問離你最近的人", "打電話問你朋友", "休息\n是為了走更長遠的路", "拿出你的十元硬幣\n一筊定江山!", "閉上雙眼按到你想停為止！",
			"忍一時風平浪靜\n退一步海闊天空", "邊問邊跪拜\n離你最近的人", "該休息了\n但如果你已經休息充足\n就可以繼續前行了", "看看你手機的電量\n雙數則是\n單數則否",
			"相信張開雙眼\n第一眼所看到的東西", "看看自己的想法~\n追隨夢想~~", "打開youtube的第一部影片\n他將會給你答案", "先做個10下伏地挺身~\n再問問我吧!!", "去做一些有意義的事吧！",
			"欲窮千里目\n更上一層樓\n(能,但有更好的)", "先訂閱胡子再提問一次吧！", "問問你最好的朋友\n你會得到答案", "接下來的三小時都由你做主", "小心\n做完之後\n可能會有神秘的事發生",
			"你覺得呢(ﾉ´∀｀*)...\n不行( ･ิϖ･ิ)", "走出房門\n見到的第一個人\n會給你相反的答案 ", "你的心裡已經有答案了\n又何必問我呢", "just do it！！", "靜思十分鐘後再來問我"
			};

	private JPanel panel = null;
	
	private JButton start = null;
	
	private JScrollPane jscrollpane = null;
	
	private JTextArea area = null;
	
	private JLabel introduction = null;
	
	private JLabel codeby = null;
	
	public isurrender() {
		init();
	}
	
	private void init() {
		setSize(400,400);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(screenSize.width / 2 - getWidth() / 2,
				screenSize.height / 2 - getHeight() / 2);
		setResizable(false);
		setContentPane(getPanel());
		setTitle("人生解答系統");
		setVisible(true);
	}
	
	public int randomNum(int length) {
		Random random = new Random();
		int num = random.nextInt(length);
		return num;
	}
	
	public void doTxt() {
		String ans = txt[randomNum(txt.length)].toString();
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

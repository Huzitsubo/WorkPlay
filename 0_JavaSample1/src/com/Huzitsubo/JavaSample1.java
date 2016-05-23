package com.Huzitsubo;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JavaSample1 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		JFrame frame = new JFrame("test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(720, 480);
		frame.setVisible(true);
		
		JLabel label = new JLabel();

		ImageIcon icon = new ImageIcon("C:/bar.png");
		label.setIcon(icon);
		
		frame.add(label);
	}

}

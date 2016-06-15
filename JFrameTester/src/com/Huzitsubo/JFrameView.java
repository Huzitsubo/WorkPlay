package com.Huzitsubo;

import java.awt.*;
import javax.swing.*;

public class JFrameView extends JFrame {

	public Color color1, color2;

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		JFrameView f1 = new JFrameView();

	}

	// Constructor
	public JFrameView() {
		super("Swing DrawLine");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		color1 = new Color(255, 0, 0);
		color2 = new Color(0, 255, 0);
		setSize(300, 200);
		setVisible(true);
	}

	// Paint Method
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(color1);
		g.drawLine(20, 50, 250, 50);
		g.setColor(color2);
		g.drawLine(20, 60, 250, 160);
	}
}

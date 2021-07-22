package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectStrategy {

	private JFrame frame;
	private LatexEditorView latexEditorView;
	/**
	 * Launch the application.
	*/

	/**
	 * Create the application.
	 * @param latexEditorView 
	 */
	public SelectStrategy(LatexEditorView latexEditorView) {
		this.latexEditorView = latexEditorView;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnVolatile = new JButton("Volatile");
		btnVolatile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexEditorView.setStrategyCode(0);
				latexEditorView.enact("enable");
				
				BasicWindow basicWindow = new BasicWindow(latexEditorView);
				basicWindow.changeVisibility(true);
				frame.dispose();
			}
		});
		btnVolatile.setBounds(94, 23, 97, 25);
		frame.getContentPane().add(btnVolatile);
		
		JButton btnStable = new JButton("Stable");
		btnStable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexEditorView.setStrategyCode(1);
				latexEditorView.enact("enable");

				BasicWindow basicWindow = new BasicWindow(latexEditorView);
				basicWindow.changeVisibility(true);
				frame.dispose();
			}
		});
		btnStable.setBounds(94, 80, 97, 25);
		frame.getContentPane().add(btnStable);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BasicWindow basicWindow = new BasicWindow();
				basicWindow.changeVisibility(true);
				frame.dispose();
			}
		});
		btnBack.setBounds(94, 150, 97, 25);
		frame.getContentPane().add(btnBack);
	}

	public void changeVisibility(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(b);
	}
}

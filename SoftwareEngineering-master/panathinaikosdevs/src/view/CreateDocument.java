package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateDocument {

	private JFrame frame;
	private LatexEditorView latexEditorView;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public CreateDocument(LatexEditorView latexEditorView) {
		this.latexEditorView = latexEditorView;
		initialize();
	}

	public void changeVisibility(boolean visibility) {
		frame.setVisible(visibility);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnReport = new JButton("Report");
		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				latexEditorView.setTemplateName("report");
				latexEditorView.enact("create");
				BasicWindow basicWindow = new BasicWindow(latexEditorView);
				basicWindow.changeVisibility(true);
				frame.dispose();
			}
		});
		btnReport.setBounds(58, 30, 97, 25);
		frame.getContentPane().add(btnReport);
		
		JButton btnBook = new JButton("Book");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexEditorView.setTemplateName("book");
				latexEditorView.enact("create");
				BasicWindow basicWindow = new BasicWindow(latexEditorView);
				basicWindow.changeVisibility(true);
				frame.dispose();
			}
		});
		btnBook.setBounds(58, 83, 97, 25);
		frame.getContentPane().add(btnBook);
		
		JButton btnArticle = new JButton("Article");
		btnArticle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexEditorView.setTemplateName("article");
				latexEditorView.enact("create");
				BasicWindow basicWindow = new BasicWindow(latexEditorView);
				basicWindow.changeVisibility(true);
				frame.dispose();
			}
		});
		btnArticle.setBounds(58, 143, 97, 25);
		frame.getContentPane().add(btnArticle);
		
		JButton btnLetter = new JButton("Letter");
		btnLetter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexEditorView.setTemplateName("letter");
				latexEditorView.enact("create");
				BasicWindow basicWindow = new BasicWindow(latexEditorView);
				basicWindow.changeVisibility(true);
				frame.dispose();
			}
		});
		btnLetter.setBounds(58, 195, 97, 25);
		frame.getContentPane().add(btnLetter);
		
		JButton btnEmpty = new JButton("Empty");
		btnEmpty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexEditorView.setTemplateName("empty");
				latexEditorView.enact("create");
				BasicWindow basicWindow = new BasicWindow(latexEditorView);
				basicWindow.changeVisibility(true);
				frame.dispose();
			}
		});
		btnEmpty.setBounds(58, 246, 97, 25);
		frame.getContentPane().add(btnEmpty);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BasicWindow basicWindow = new BasicWindow(latexEditorView);
				basicWindow.changeVisibility(true);
				frame.dispose();
			}
		});
		btnBack.setBounds(58, 296, 97, 25);
		frame.getContentPane().add(btnBack);
	}

}

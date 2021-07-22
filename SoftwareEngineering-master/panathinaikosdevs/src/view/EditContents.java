package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JEditorPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Font;

public class EditContents {

	private JFrame frame;
	private LatexEditorView latexEditorView;
	
	public void changeVisibility(boolean visibility) {
		frame.setVisible(visibility);
	}
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public EditContents(LatexEditorView latexEditorView) {
		this.latexEditorView = latexEditorView;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 811, 619);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 31, 781, 515);
		frame.getContentPane().add(scrollPane);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setText(latexEditorView.getVersionsManager().getCurrentDocument().getContents());
		editorPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		scrollPane.setViewportView(editorPane);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem mntmChapter = new JMenuItem("Chapter");
		mntmChapter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(latexEditorView.getTemplateName().equals("letter") || latexEditorView.getTemplateName().equals("article")) {
					JOptionPane.showMessageDialog(null, 
                            "You can't add chapter in "+latexEditorView.getTemplateName(), 
                            "WARNING", 
                            JOptionPane.WARNING_MESSAGE);
				}
				else {
					latexEditorView.setCode(1);
					latexEditorView.setPosition(editorPane.getCaretPosition());
					latexEditorView.enact("addLatex");
					editorPane.setText(latexEditorView.getVersionsManager().getCurrentDocument().getContents());
				}
			}
		});
		menuBar.add(mntmChapter);
		
		JMenu mnSection = new JMenu("Section");
		menuBar.add(mnSection);
		
		JMenuItem mntmSection = new JMenuItem("Section");
		mntmSection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(latexEditorView.getTemplateName().equals("letter")) {
					JOptionPane.showMessageDialog(null, 
                            "You can't add section in letter", 
                            "WARNING", 
                            JOptionPane.WARNING_MESSAGE);
				}
				else {
					latexEditorView.setCode(2);
					latexEditorView.setPosition(editorPane.getCaretPosition());
					latexEditorView.enact("addLatex");
					editorPane.setText(latexEditorView.getVersionsManager().getCurrentDocument().getContents());
				}
			}
		});
		mnSection.add(mntmSection);
		
		JMenuItem mntmSubsection = new JMenuItem("Subsection");
		mntmSubsection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(latexEditorView.getTemplateName().equals("letter")) {
					JOptionPane.showMessageDialog(null, 
                            "You can't add subsection in letter", 
                            "WARNING", 
                            JOptionPane.WARNING_MESSAGE);
				}
				else {
					latexEditorView.setCode(3);
					latexEditorView.setPosition(editorPane.getCaretPosition());
					latexEditorView.enact("addLatex");
					editorPane.setText(latexEditorView.getVersionsManager().getCurrentDocument().getContents());
				}
			}
		});
		mnSection.add(mntmSubsection);
		
		JMenuItem mntmSubsubsection = new JMenuItem("Subsubsection");
		mntmSubsubsection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(latexEditorView.getTemplateName().equals("letter")) {
					JOptionPane.showMessageDialog(null, 
                            "You can't add subsubsection in letter", 
                            "WARNING", 
                            JOptionPane.WARNING_MESSAGE);
				}
				else {
					latexEditorView.setCode(4);
					latexEditorView.setPosition(editorPane.getCaretPosition());
					latexEditorView.enact("addLatex");
					editorPane.setText(latexEditorView.getVersionsManager().getCurrentDocument().getContents());
				}
			}
		});
		mnSection.add(mntmSubsubsection);
		
		JMenu mnList = new JMenu("List");
		menuBar.add(mnList);
		
		JMenuItem mntmItemize = new JMenuItem("Itemize");
		mntmItemize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(latexEditorView.getTemplateName().equals("letter")) {
					JOptionPane.showMessageDialog(null, 
                            "You can't add list in letter", 
                            "WARNING", 
                            JOptionPane.WARNING_MESSAGE);
				}
				else {
					latexEditorView.setCode(5);
					latexEditorView.setPosition(editorPane.getCaretPosition());
					latexEditorView.enact("addLatex");
					editorPane.setText(latexEditorView.getVersionsManager().getCurrentDocument().getContents());			
				}
			}
		});
		mnList.add(mntmItemize);
		
		JMenuItem mntmList = new JMenuItem("Enumeration");
		mntmList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(latexEditorView.getTemplateName().equals("letter")) {
					JOptionPane.showMessageDialog(null, 
                            "You can't add list in letter", 
                            "WARNING", 
                            JOptionPane.WARNING_MESSAGE);
				}
				else {
					latexEditorView.setCode(6);
					latexEditorView.setPosition(editorPane.getCaretPosition());
					latexEditorView.enact("addLatex");
					editorPane.setText(latexEditorView.getVersionsManager().getCurrentDocument().getContents());			
				}
			}
		});
		mnList.add(mntmList);
		
		JMenuItem mntmTable = new JMenuItem("Table");
		mntmTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(latexEditorView.getTemplateName().equals("letter")) {
					JOptionPane.showMessageDialog(null, 
                            "You can't add table in letter", 
                            "WARNING", 
                            JOptionPane.WARNING_MESSAGE);
				}
				else {
					latexEditorView.setCode(7);
					latexEditorView.setPosition(editorPane.getCaretPosition());
					latexEditorView.enact("addLatex");
					editorPane.setText(latexEditorView.getVersionsManager().getCurrentDocument().getContents());			
				}
			}
		});
		menuBar.add(mntmTable);
		
		JMenuItem mntmFigure = new JMenuItem("Figure");
		mntmFigure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(latexEditorView.getTemplateName().equals("letter")) {
					JOptionPane.showMessageDialog(null, 
                            "You can't add figure in letter", 
                            "WARNING", 
                            JOptionPane.WARNING_MESSAGE);
				}
				else {
					latexEditorView.setCode(8);
					latexEditorView.setPosition(editorPane.getCaretPosition());
					latexEditorView.enact("addLatex");
					editorPane.setText(latexEditorView.getVersionsManager().getCurrentDocument().getContents());			
				}
			}
		});
		menuBar.add(mntmFigure);
		
		JMenu mnSave = new JMenu("Save");
		menuBar.add(mnSave);
		
		JMenuItem mntmSaveAndExit = new JMenuItem("Save and exit");
		mntmSaveAndExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexEditorView.setContents(editorPane.getText());
				
				latexEditorView.enact("edit");
				frame.dispose();
				BasicWindow basicWindow = new BasicWindow(latexEditorView);
				basicWindow.changeVisibility(true);
			}
		});
		mnSave.add(mntmSaveAndExit);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnSave.add(mntmSave);
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexEditorView.setContents(editorPane.getText());
				latexEditorView.enact("edit");
			}
		});
	}
}

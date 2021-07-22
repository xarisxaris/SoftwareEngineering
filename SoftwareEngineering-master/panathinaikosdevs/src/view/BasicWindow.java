package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.VersionsManager;
import model.strategies.VersionsStrategy;
import model.strategies.VolatileVersionsStrategy;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BasicWindow {

	private JFrame frmPanathinaikosdevs;
	private LatexEditorView latexEditorView;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BasicWindow window = new BasicWindow();
					window.frmPanathinaikosdevs.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void changeVisibility(boolean visibility) {
		frmPanathinaikosdevs.setVisible(visibility);
	}
	/**
	 * Create the application.
	 */
	public BasicWindow() {
		latexEditorView = new LatexEditorView();
		VersionsStrategy strategy = new VolatileVersionsStrategy();
		VersionsManager versionsManager = new VersionsManager(strategy, latexEditorView);
		latexEditorView.makeController(versionsManager);
		latexEditorView.setVersionsManager(versionsManager);
		initialize();
	}
	public BasicWindow(LatexEditorView latexEditorView) {
		this.latexEditorView = latexEditorView;
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPanathinaikosdevs = new JFrame();
		frmPanathinaikosdevs.setTitle("PanathinaikosDevs");
		frmPanathinaikosdevs.setBounds(100, 100, 266, 589);
		frmPanathinaikosdevs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPanathinaikosdevs.getContentPane().setLayout(null);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateDocument createDocument = new CreateDocument(latexEditorView);
				createDocument.changeVisibility(true);
				frmPanathinaikosdevs.dispose();
			}
		});
		btnCreate.setBounds(12, 33, 175, 25);
		frmPanathinaikosdevs.getContentPane().add(btnCreate);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				if(chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					String name = chooser.getSelectedFile().getAbsolutePath();
					latexEditorView.getVersionsManager().getCurrentDocument().setName(name);
					latexEditorView.enact("save");
				}
				
			}
		});
		btnSave.setBounds(12, 436, 175, 25);
		frmPanathinaikosdevs.getContentPane().add(btnSave);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					latexEditorView.setFilename(chooser.getSelectedFile().getAbsolutePath());
					latexEditorView.enact("load");
					frmPanathinaikosdevs.dispose();
					BasicWindow basicWindow = new BasicWindow(latexEditorView);
					basicWindow.changeVisibility(true);
				}
			}
		});
		btnLoad.setBounds(12, 493, 175, 25);
		frmPanathinaikosdevs.getContentPane().add(btnLoad);
		
		JButton btnEnableStrategy = new JButton("Enable strategy");
		btnEnableStrategy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(latexEditorView.getVersionsManager().isEnabled()) {
					JOptionPane.showMessageDialog(null, 
                            "You have the strategy enabled.", 
                            "WARNING", 
                            JOptionPane.WARNING_MESSAGE);
				}
				else {
					SelectStrategy selectStrategy = new SelectStrategy(latexEditorView);
					selectStrategy.changeVisibility(true);
					frmPanathinaikosdevs.dispose();
				}
			}
		});
		btnEnableStrategy.setBounds(12, 202, 175, 25);
		frmPanathinaikosdevs.getContentPane().add(btnEnableStrategy);
		
		JButton btnChangeStrategy = new JButton("Change strategy");
		btnChangeStrategy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexEditorView.enact("switch");
			}
		});
		btnChangeStrategy.setBounds(12, 261, 175, 25);
		frmPanathinaikosdevs.getContentPane().add(btnChangeStrategy);
		
		JButton btnDisableStrategy = new JButton("Disable strategy");
		btnDisableStrategy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(latexEditorView.getVersionsManager().isEnabled() == false) {
					JOptionPane.showMessageDialog(null, 
                            "You have the strategy is not enabled.", 
                            "WARNING", 
                            JOptionPane.WARNING_MESSAGE);
				}
				else {
					latexEditorView.enact("disable");
				}
			}
		});
		btnDisableStrategy.setBounds(12, 322, 175, 25);
		frmPanathinaikosdevs.getContentPane().add(btnDisableStrategy);
		
		JButton btnEditContents = new JButton("Edit contents");
		btnEditContents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditContents editContents = new EditContents(latexEditorView);
				editContents.changeVisibility(true);
				frmPanathinaikosdevs.dispose();
			}
		});
		btnEditContents.setBounds(12, 145, 175, 25);
		frmPanathinaikosdevs.getContentPane().add(btnEditContents);
		
		JButton btnAddContents = new JButton("Add contents");
		btnAddContents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditContents editContents = new EditContents(latexEditorView);
				editContents.changeVisibility(true);
				frmPanathinaikosdevs.dispose();
			}
		});
		btnAddContents.setBounds(12, 89, 175, 25);
		frmPanathinaikosdevs.getContentPane().add(btnAddContents);
		
		JButton btnRollback = new JButton("Rollback");
		btnRollback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(latexEditorView.getVersionsManager().previousVersionAvailable() == false) {
					JOptionPane.showMessageDialog(null, 
                            "You can't rollback.", 
                            "WARNING", 
                            JOptionPane.WARNING_MESSAGE);
				}
				else{
					latexEditorView.enact("rollback");
				}
			}
		});
		btnRollback.setBounds(12, 376, 175, 25);
		frmPanathinaikosdevs.getContentPane().add(btnRollback);
	}
}

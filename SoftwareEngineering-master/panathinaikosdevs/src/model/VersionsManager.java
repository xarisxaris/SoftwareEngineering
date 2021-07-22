package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import model.strategies.StableVersionsStrategy;
import model.strategies.VersionsStrategy;
import model.strategies.VolatileVersionsStrategy;
import view.LatexEditorView;

public class VersionsManager {
	private Document currentDocument;
	private VersionsStrategy strategy;
	private boolean enabled;
	private LatexEditorView latexEditorView;
	
	public VersionsManager(VersionsStrategy strategy, LatexEditorView latexEditorView) {
		super();
		this.strategy = strategy;
		this.latexEditorView = latexEditorView;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void enable() {
		enabled = true;
	}
	public void disable() {
		enabled = false;
	}

	public void setStrategy(VersionsStrategy strategy) {
		this.strategy = strategy;
	}

	public void setCurrentVersion(Document currentDocument) {
		this.currentDocument = currentDocument;
	}
	
	public Document getPreviousVersion() {
		return strategy.getVersion();
	}
	
	public void rollbackToPreviousVersion() {
		currentDocument = strategy.getVersion();
		strategy.removeVersion();
	}
	
	public boolean previousVersionAvailable() {
		if(strategy.getVersion() == null)
			return false;
		return true;
	}
	public String getTemplateName() {
		// TODO Auto-generated method stub
		return latexEditorView.getTemplateName();
	}

	public Document getCurrentDocument() {
		return currentDocument;
	}

	public LatexEditorView getLatexEditorView() {
		return latexEditorView;
	}
	
	public void addLatexCommand(int code, int pos) {
		String s1 = currentDocument.getContents().substring(0, pos);
		String s2 = currentDocument.getContents().substring(pos);
		
		if(code == 1) {
			String addString = "\\chapter{}\n";
			currentDocument.setContents(s1+addString+s2);
		}
		else if(code == 2) {
			String addString = "\\section{}\n";
			currentDocument.setContents(s1+addString+s2);
		}
		else if(code == 3) {
			String addString = "\\subsection{}\n";
			currentDocument.setContents(s1+addString+s2);
		}
		else if(code == 4) {
			String addString = "\\subsubsection{}\n";
			currentDocument.setContents(s1+addString+s2);
		}
		else if(code == 5) {
			String addString = "\\begin{itemize}\n"+
					"\\item ...\n"+
					"\\item ...\n"+
					"\\end{itemize}\n";
			currentDocument.setContents(s1+addString+s2);
		}
		else if(code == 6) {
			String addString = "\\begin{enumerate}\n"+
					"\\item ...\n"+
					"\\item ...\n"+
					"\\end{enumerate}\n";
			currentDocument.setContents(s1+addString+s2);
		}
		else if(code == 7) {
			String addString = "\\begin{table}\n"+
					"\\caption{....}\\label{...}\n"+
					"\\begin{tabular}{|c|c|c|}\n"+
					"\\hline\n"+
					"... &...&...\\\\\n"+
					"... &...&...\\\\\n"+
					"... &...&...\\\\\n"+
					"\\hline\n"+
					"\\end{tabular}\n"+
					"\\end{table}\n";
			currentDocument.setContents(s1+addString+s2);
		}
		else if(code == 8) {
			String addString = "\\begin{figure}\n" + 
					"\\includegraphics[width=...,height=...]{...}\n" + 
					"\\caption{....}\\label{...}\n" + 
					"\\end{figure}\n";
			currentDocument.setContents(s1+addString+s2);
		}
		
	}
	
	public void readFromFile() {
		String filename = latexEditorView.getFilename();
		try {
			FileInputStream stream = new FileInputStream(filename);
			Scanner scanner = new Scanner(stream);
			
			String contents = "";
			while(scanner.hasNextLine()) {
				contents = contents + scanner.nextLine() + "\n";
			}
			currentDocument = new Document();
			currentDocument.setContents(contents);
			
			if(contents.startsWith("\\documentclass[11pt,twocolumn,a4paper]{article}")) {
				latexEditorView.setTemplateName("article");
			}
			else if(contents.startsWith("\\documentclass[11pt,a4paper]{book}")) {
				latexEditorView.setTemplateName("book");
			}
			else if(contents.startsWith("\\documentclass{letter}")) {
				latexEditorView.setTemplateName("letter");
			}
			else if(contents.startsWith("\\documentclass[11pt,a4paper]{report}")) {
				latexEditorView.setTemplateName("report");
			}
			else {
				latexEditorView.setTemplateName("empty");
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createStrategy(int strategyCode) {
		// TODO Auto-generated method stub
		if(strategyCode == 0) {
			strategy = new VolatileVersionsStrategy();
		}
		else {
			strategy = new StableVersionsStrategy();
		}
		
	}

	public VersionsStrategy getStrategy() {
		return strategy;
	}
	
}

package controller.commands;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import model.VersionsManager;
import model.strategies.VersionsStrategy;
import model.strategies.VolatileVersionsStrategy;
import view.LatexEditorView;

class LoadCommandTest {
	private LatexEditorView latexEditorView = new LatexEditorView();
	private VersionsStrategy strategy = new VolatileVersionsStrategy();
	private VersionsManager versionsManager = new VersionsManager(strategy, latexEditorView);
	
	private LoadCommand loadCommand = new LoadCommand(versionsManager);
	
	
	public LoadCommandTest(){
		latexEditorView.setVersionsManager(versionsManager);
	}
	
	@Test
	void test() {
		latexEditorView.setFilename("test_0.tex");
		loadCommand.execute();
		
		String contents = versionsManager.getCurrentDocument().getContents();
		
		
		String contentsFile = "";
		
		String filename = "test_0.tex";
		try {
			FileInputStream stream = new FileInputStream(filename);
			Scanner scanner = new Scanner(stream);
			
			
			while(scanner.hasNextLine()) {
				contentsFile = contentsFile + scanner.nextLine() + "\n";
			}
		}
		catch(IOException e) {
			
		}

		assertEquals(true, contents.equals(contentsFile));
		
		
	}

}

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

class SaveCommandTest {
	private LatexEditorView latexEditorView = new LatexEditorView();
	private VersionsStrategy strategy = new VolatileVersionsStrategy();
	private VersionsManager versionsManager = new VersionsManager(strategy, latexEditorView);
	
	private CreateCommand createCommand = new CreateCommand(versionsManager);
	private SaveCommand saveCommand = new SaveCommand(versionsManager);
	
	
	public SaveCommandTest(){
		latexEditorView.setVersionsManager(versionsManager);
		latexEditorView.setTemplateName("article");
		createCommand.execute();
	}
	
	@Test
	void test() {
		
		String contents = versionsManager.getCurrentDocument().getContents();
		latexEditorView.getVersionsManager().getCurrentDocument().setName("test");
		
		saveCommand.execute();
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

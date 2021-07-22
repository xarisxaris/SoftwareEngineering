package controller.commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.VersionsManager;
import model.strategies.VersionsStrategy;
import model.strategies.VolatileVersionsStrategy;
import view.LatexEditorView;

class EditCommandTest {
	private LatexEditorView latexEditorView = new LatexEditorView();
	private VersionsStrategy strategy = new VolatileVersionsStrategy();
	private VersionsManager versionsManager = new VersionsManager(strategy, latexEditorView);
	
	private CreateCommand createCommand = new CreateCommand(versionsManager);
	private EditCommand editCommand = new EditCommand(versionsManager);
	
	
	public EditCommandTest(){
		latexEditorView.setVersionsManager(versionsManager);
		latexEditorView.setTemplateName("");
		createCommand.execute();
	}
	
	@Test
	void test() {
		
		String contents = "\\chapter{Edit}\nthis is a test";
			
		latexEditorView.setContents(contents);
		editCommand.execute();
		String contentsNew = versionsManager.getCurrentDocument().getContents();
		assertEquals(true, contents.equals(contentsNew));
		
		
	}

}

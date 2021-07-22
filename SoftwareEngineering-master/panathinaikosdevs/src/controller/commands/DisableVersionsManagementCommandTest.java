package controller.commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.VersionsManager;
import model.strategies.StableVersionsStrategy;
import model.strategies.VersionsStrategy;
import model.strategies.VolatileVersionsStrategy;
import view.LatexEditorView;

class DisableVersionsManagementCommandTest {
	private LatexEditorView latexEditorView = new LatexEditorView();
	private VersionsStrategy strategy = new VolatileVersionsStrategy();
	private VersionsStrategy strategy1 = new StableVersionsStrategy();
	private VersionsManager versionsManager = new VersionsManager(strategy, latexEditorView);
	
	private CreateCommand createCommand = new CreateCommand(versionsManager);
	private EditCommand editCommand = new EditCommand(versionsManager);
	private DisableVersionsManagementCommand disableCommand = new DisableVersionsManagementCommand(versionsManager);
	
	
	public DisableVersionsManagementCommandTest(){
		latexEditorView.setVersionsManager(versionsManager);
		latexEditorView.setTemplateName("");
		createCommand.execute();
	}
	
	@Test
	void test() {
		disableCommand.execute();
		
		String contents = "\\chapter{Edit}\nthis is a test";
			
		latexEditorView.setContents(contents);
		editCommand.execute();
		
		
		assertEquals(0, versionsManager.getStrategy().getEntireHistory().size());	
		assertEquals(false, versionsManager.isEnabled());
		
	}

}

package controller.commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.VersionsManager;
import model.strategies.StableVersionsStrategy;
import model.strategies.VersionsStrategy;
import model.strategies.VolatileVersionsStrategy;
import view.LatexEditorView;

class RollbackToPreviousVersionTest {
	private LatexEditorView latexEditorView = new LatexEditorView();
	private VersionsStrategy strategy = new VolatileVersionsStrategy();
	private VersionsStrategy strategy1 = new StableVersionsStrategy();
	private VersionsManager versionsManager = new VersionsManager(strategy, latexEditorView);
	
	private CreateCommand createCommand = new CreateCommand(versionsManager);
	private EditCommand editCommand = new EditCommand(versionsManager);
	private EnableVersionsManagementCommand enableCommand = new EnableVersionsManagementCommand(versionsManager);
	private RollbackToPreviousVersionCommand rollbackCommand = new RollbackToPreviousVersionCommand(versionsManager);
	
	public RollbackToPreviousVersionTest(){
		latexEditorView.setVersionsManager(versionsManager);
		latexEditorView.setTemplateName("");
		createCommand.execute();
	}
	
	@Test
	void test() {
		enableCommand.execute();
		String contentsOld = versionsManager.getCurrentDocument().getContents();
		String contents = "\\chapter{Edit}\nthis is a test";
			
		latexEditorView.setContents(contents);
		editCommand.execute();
		rollbackCommand.execute();
		String contentsNew = versionsManager.getCurrentDocument().getContents();
		assertEquals(true, contentsNew.equals(contentsOld));
		
	}
}

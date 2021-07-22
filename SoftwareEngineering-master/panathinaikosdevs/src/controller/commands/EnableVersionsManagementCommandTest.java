package controller.commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.VersionsManager;
import model.strategies.StableVersionsStrategy;
import model.strategies.VersionsStrategy;
import model.strategies.VolatileVersionsStrategy;
import view.LatexEditorView;

class EnableVersionsManagementCommandTest {
	private LatexEditorView latexEditorView = new LatexEditorView();
	private VersionsStrategy strategy = new VolatileVersionsStrategy();
	private VersionsStrategy strategy1 = new StableVersionsStrategy();
	private VersionsManager versionsManager = new VersionsManager(strategy, latexEditorView);
	
	private CreateCommand createCommand = new CreateCommand(versionsManager);
	private EditCommand editCommand = new EditCommand(versionsManager);
	private EnableVersionsManagementCommand enableCommand = new EnableVersionsManagementCommand(versionsManager);
	
	
	public EnableVersionsManagementCommandTest(){
		latexEditorView.setVersionsManager(versionsManager);
		latexEditorView.setTemplateName("");
		createCommand.execute();
	}
	
	@Test
	void test() {
		enableCommand.execute();
		
		String contents = "\\chapter{Edit}\nthis is a test";
			
		latexEditorView.setContents(contents);
		editCommand.execute();
		String contentsOld = versionsManager.getPreviousVersion().getContents();
		assertEquals(true, contentsOld.equals(""));
		
		latexEditorView = new LatexEditorView();
		versionsManager = new VersionsManager(strategy1, latexEditorView);
		createCommand = new CreateCommand(versionsManager);
		editCommand = new EditCommand(versionsManager);
		enableCommand = new EnableVersionsManagementCommand(versionsManager);
		latexEditorView.setVersionsManager(versionsManager);
		latexEditorView.setTemplateName("");
		createCommand.execute();
		enableCommand.execute();
		
		contents = "\\chapter{Edit}\nthis is a test";
			
		latexEditorView.setContents(contents);
		editCommand.execute();
		contentsOld = versionsManager.getPreviousVersion().getContents();
		assertEquals(true, contentsOld.equals(""));
		
	}
}

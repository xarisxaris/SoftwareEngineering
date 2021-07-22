package controller.commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.VersionsManager;
import model.strategies.StableVersionsStrategy;
import model.strategies.VersionsStrategy;
import model.strategies.VolatileVersionsStrategy;
import view.LatexEditorView;

class ChangeVersionStrategyCommandTest {
	private LatexEditorView latexEditorView = new LatexEditorView();
	private VersionsStrategy strategy = new VolatileVersionsStrategy();
	private VersionsStrategy strategy1 = new StableVersionsStrategy();
	private VersionsManager versionsManager = new VersionsManager(strategy, latexEditorView);
	
	private CreateCommand createCommand = new CreateCommand(versionsManager);
	private EditCommand editCommand = new EditCommand(versionsManager);
	private ChangeVersionsStrategyCommand changeCommand = new ChangeVersionsStrategyCommand(versionsManager);
	private EnableVersionsManagementCommand enableCommand = new EnableVersionsManagementCommand(versionsManager);
	
	
	public ChangeVersionStrategyCommandTest(){
		latexEditorView.setVersionsManager(versionsManager);
		latexEditorView.setTemplateName("");
		createCommand.execute();
	}
	
	@Test
	void test() {
		changeCommand.execute();
		boolean b = false;
		if(versionsManager.getStrategy() instanceof StableVersionsStrategy) {
			b = true;
		}
		assertEquals(true, b);
		
		changeCommand.execute();
		b = false;
		if(versionsManager.getStrategy() instanceof VolatileVersionsStrategy) {
			b = true;
		}
	}

}

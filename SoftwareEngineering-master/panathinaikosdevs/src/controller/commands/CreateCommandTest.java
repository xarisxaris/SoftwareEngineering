package controller.commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.VersionsManager;
import model.strategies.VersionsStrategy;
import model.strategies.VolatileVersionsStrategy;
import view.LatexEditorView;

class CreateCommandTest {
	private LatexEditorView latexEditorView = new LatexEditorView();
	private VersionsStrategy strategy = new VolatileVersionsStrategy();
	private VersionsManager versionsManager = new VersionsManager(strategy, latexEditorView);
	
	private CreateCommand createCommand = new CreateCommand(versionsManager);
	public CreateCommandTest(){
		latexEditorView.setVersionsManager(versionsManager);
	}
	
	@Test
	void test() {
		latexEditorView.setTemplateName("article");
		createCommand.execute();
		String contents = versionsManager.getCurrentDocument().getContents();
		assertEquals(true, contents.startsWith("\\documentclass[11pt,twocolumn,a4paper]{article}"));
	
		latexEditorView.setTemplateName("book");
		createCommand.execute();
		contents = versionsManager.getCurrentDocument().getContents();
		assertEquals(true, contents.startsWith("\\documentclass[11pt,a4paper]{book}"));
	
		latexEditorView.setTemplateName("letter");
		createCommand.execute();
		contents = versionsManager.getCurrentDocument().getContents();
		assertEquals(true, contents.startsWith("\\documentclass{letter}"));
	
		latexEditorView.setTemplateName("report");
		createCommand.execute();
		contents = versionsManager.getCurrentDocument().getContents();
		assertEquals(true, contents.startsWith("\\documentclass[11pt,a4paper]{report}"));
		
		latexEditorView.setTemplateName("empty");
		createCommand.execute();
		contents = versionsManager.getCurrentDocument().getContents();
		assertEquals(true, contents.startsWith(""));
		
		
	}

}

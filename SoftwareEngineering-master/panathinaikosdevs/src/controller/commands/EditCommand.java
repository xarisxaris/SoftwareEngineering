package controller.commands;

import model.Document;
import model.DocumentManager;
import model.VersionsManager;

public class EditCommand implements Command {
	private VersionsManager versionsManager;
	
	public EditCommand(VersionsManager versionsManager) {
		super();
		this.versionsManager = versionsManager;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		String contents = versionsManager.getLatexEditorView().getContents();
		if(versionsManager.isEnabled()) {
			versionsManager.getStrategy().putVersion(versionsManager.getCurrentDocument());
			versionsManager.getCurrentDocument().increaseVersionId();
		}
		versionsManager.getCurrentDocument().setContents(contents);
	}

}

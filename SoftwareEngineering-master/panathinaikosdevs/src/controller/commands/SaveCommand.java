package controller.commands;

import model.Document;
import model.DocumentManager;
import model.VersionsManager;

public class SaveCommand implements Command {
	private VersionsManager versionsManager;
	
	public SaveCommand(VersionsManager versionsManager) {
		super();
		this.versionsManager = versionsManager;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		versionsManager.getCurrentDocument().save();
	}

}

package controller.commands;

import model.Document;
import model.DocumentManager;
import model.VersionsManager;

public class LoadCommand implements Command {
	private VersionsManager versionsManager;
	
	public LoadCommand(VersionsManager versionsManager) {
		super();
		this.versionsManager = versionsManager;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
		versionsManager.readFromFile();
	}

}

package controller.commands;

import model.VersionsManager;

public class CommandsFactory {
	private VersionsManager versionsManager;
	
	public CommandsFactory(VersionsManager versionsManager) {
		this.versionsManager = versionsManager;
	}
	
	public Command createCommand(String command) {
		if(command.equals("create")) {
			return new CreateCommand(versionsManager);
		}
		else if(command.equals("edit")) {
			return new EditCommand(versionsManager);
		}
		else if(command.equals("addLatex")) {
			return new AddLatexCommand(versionsManager);
		}
		else if(command.equals("save")) {
			return new SaveCommand(versionsManager);
		}
		else if(command.equals("load")) {
			return new LoadCommand(versionsManager);
		}
		else if(command.equals("enable")) {
			return new EnableVersionsManagementCommand(versionsManager);
		}
		else if(command.equals("disable")) {
			return new DisableVersionsManagementCommand(versionsManager);
		}
		else if(command.equals("rollback")) {
			return new RollbackToPreviousVersionCommand(versionsManager);
		}
		else if(command.equals("switch")) {
			return new ChangeVersionsStrategyCommand(versionsManager);
		}
		return null;
	}
}

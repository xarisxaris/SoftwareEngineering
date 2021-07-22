package controller.commands;

import model.VersionsManager;

public class EnableVersionsManagementCommand implements Command{
	private VersionsManager versionsManager;
	
	public EnableVersionsManagementCommand(VersionsManager versionsManager) {
		super();
		this.versionsManager = versionsManager;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		int strategyCode = versionsManager.getLatexEditorView().getStrategyCode();
		versionsManager.createStrategy(strategyCode);
		versionsManager.enable();
	}
}

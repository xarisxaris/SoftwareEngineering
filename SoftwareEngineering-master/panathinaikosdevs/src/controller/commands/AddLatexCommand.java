package controller.commands;

import model.Document;
import model.DocumentManager;
import model.VersionsManager;
import view.LatexEditorView;

public class AddLatexCommand implements Command {
	private VersionsManager versionsManager;
	
	public AddLatexCommand(VersionsManager versionsManager) {
		super();
		this.versionsManager = versionsManager;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		int code = versionsManager.getLatexEditorView().getCode();
		int pos = versionsManager.getLatexEditorView().getPosition();
		versionsManager.addLatexCommand(code, pos);
	}

}

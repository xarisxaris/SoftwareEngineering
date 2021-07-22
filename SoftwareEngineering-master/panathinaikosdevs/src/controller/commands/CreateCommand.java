package controller.commands;

import model.Document;
import model.DocumentManager;
import model.VersionsManager;

public class CreateCommand implements Command {
	private VersionsManager versionsManager;
	private DocumentManager documentManager;
	
	public CreateCommand(VersionsManager versionsManager) {
		super();
		this.versionsManager = versionsManager;
		this.documentManager = new DocumentManager();
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		String templateName = versionsManager.getTemplateName();
		Document doc = documentManager.createDocument(templateName);
		versionsManager.setCurrentVersion(doc);
	}

}

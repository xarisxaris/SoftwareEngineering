package controller;

import java.util.HashMap;

import controller.commands.Command;
import controller.commands.CommandsFactory;
import model.VersionsManager;

public class LatexEditorController {
	private HashMap<String, Command> commands;
	
	public LatexEditorController(VersionsManager versionsManager) {
		commands = new HashMap<String, Command>();
		CommandsFactory factory = new CommandsFactory(versionsManager);
		commands.put("create", factory.createCommand("create"));
		commands.put("edit", factory.createCommand("edit"));
		commands.put("addLatex", factory.createCommand("addLatex"));
		commands.put("save", factory.createCommand("save"));
		commands.put("load", factory.createCommand("load"));
		commands.put("enable", factory.createCommand("enable"));
		commands.put("disable", factory.createCommand("disable"));
		commands.put("rollback", factory.createCommand("rollback"));
		commands.put("switch", factory.createCommand("switch"));
	}

	public void enact(String command) {
		Command com = commands.get(command);
		com.execute();
	}
	
}

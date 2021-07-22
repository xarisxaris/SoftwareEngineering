package controller.commands;

import java.util.ArrayList;

import model.Document;
import model.VersionsManager;
import model.strategies.StableVersionsStrategy;
import model.strategies.VersionsStrategy;
import model.strategies.VolatileVersionsStrategy;

public class ChangeVersionsStrategyCommand implements Command{
	private VersionsManager versionsManager;
	
	public ChangeVersionsStrategyCommand(VersionsManager versionsManager) {
		super();
		this.versionsManager = versionsManager;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		VersionsStrategy oldStrategy = versionsManager.getStrategy();
		ArrayList<Document> list = oldStrategy.getEntireHistory();
		VersionsStrategy newStrategy = null;
		System.out.println(list.size());

		if(oldStrategy instanceof VolatileVersionsStrategy) {
			newStrategy = new StableVersionsStrategy();
		}
		else {
			newStrategy = new VolatileVersionsStrategy();
		}
		
		newStrategy.setEntireHistory(list);
		versionsManager.setStrategy(newStrategy);
	}

}

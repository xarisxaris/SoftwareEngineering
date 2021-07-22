package model.strategies;

import java.util.ArrayList;
import java.util.List;

import model.Document;

public class VolatileVersionsStrategy implements VersionsStrategy {
	private ArrayList<Document> versionHistory = new ArrayList<Document>();
	@Override
	public void putVersion(Document doc) {
		// TODO Auto-generated method stub
		versionHistory.add(doc.clone());
	}

	@Override
	public Document getVersion() {
		// TODO Auto-generated method stub
		if(versionHistory.size() > 0) {
			return versionHistory.get(versionHistory.size() - 1);
		}
		return null;
	}

	@Override
	public void setEntireHistory(List<Document> docs) {
		// TODO Auto-generated method stub
		versionHistory.addAll(docs);
	}

	@Override
	public ArrayList<Document> getEntireHistory() {
		// TODO Auto-generated method stub
		return versionHistory;
	}

	@Override
	public void removeVersion() {
		// TODO Auto-generated method stub
		if(versionHistory.size() > 0) {
			versionHistory.remove(versionHistory.size() - 1);
		}
	}

}

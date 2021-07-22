package model.strategies;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Document;

public class StableVersionsStrategy implements VersionsStrategy{
	private int versionID = -1;
	private String name = "";
	
	@Override
	public void putVersion(Document doc) {
		// TODO Auto-generated method stub
		doc.save();
		versionID = doc.getVersionID();
		name = doc.getName();
		System.out.println("v"+versionID);
	}

	@Override
	public Document getVersion() {
		// TODO Auto-generated method stub
		if(versionID == -1)
			return null;
		String filename = name +"_"+versionID+".tex";
		try {
			FileInputStream stream = new FileInputStream(filename);
			Scanner scanner = new Scanner(stream);
			
			String contents = "";
			while(scanner.hasNextLine()) {
				contents = contents + scanner.nextLine() + "\n";
			}
			Document doc = new Document();
			doc.setContents(contents);
			return doc;
		}
		catch(IOException e) {
			
		}
		return null;
	}

	@Override
	public void setEntireHistory(List<Document> docs) {
		// TODO Auto-generated method stub
		for(int i = 0; i < docs.size(); i++) {
			Document doc = docs.get(i);
			doc.save();
		}
		if(docs.size() > 0) {
			Document doc = docs.get(docs.size() -1);
			versionID = doc.getVersionID();
			name = doc.getName();
		}
	}

	@Override
	public ArrayList<Document> getEntireHistory() {
		// TODO Auto-generated method stub
		ArrayList<Document> list = new ArrayList<Document>();
		for(int i = 0; i <= versionID; i++) {
			String filename = name +"_"+i+".tex";
			try {
				FileInputStream stream = new FileInputStream(filename);
				Scanner scanner = new Scanner(stream);
				
				String contents = "";
				while(scanner.hasNextLine()) {
					contents = contents + scanner.nextLine() + "\n";
				}
				Document doc = new Document();
				doc.setContents(contents);
				list.add(doc);
				scanner.close();
			}
			catch(IOException e) {
				
			}
		}
		return list;
	}

	@Override
	public void removeVersion() {
		// TODO Auto-generated method stub
		versionID--;
	}

}

package model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Document {
	private String author;
	private String date;
	private String copyright;
	private int versionID = 0;
	private String contents;
	private String name = "template";
	
	
	public void setName(String name) {
		this.name = name;
	}

	public Document(String author, String date, String copyright, int versionID, String contents) {
		super();
		this.author = author;
		this.date = date;
		this.copyright = copyright;
		this.versionID = versionID;
		this.contents = contents;
	}

	public Document() {
		// TODO Auto-generated constructor stub
		this.contents = "";
	}
	
	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	
	public void save() {
		try {
			FileOutputStream stream = new FileOutputStream(name+"_"+versionID+".tex");
			PrintWriter writer = new PrintWriter(stream);
			
			writer.print(contents);
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Document clone() {
		return new Document(author, date, copyright, versionID, contents);
	}
	
	public void increaseVersionId() {
		versionID++;
	}

	public int getVersionID() {
		// TODO Auto-generated method stub
		return versionID;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
}

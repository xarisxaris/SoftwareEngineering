package view;

import controller.LatexEditorController;
import model.VersionsManager;

public class LatexEditorView {
	private LatexEditorController latexEditorController;
	private VersionsManager versionsManager;
	
	private String templateName;
	private String contents;
	private int code;
	private String filename;
	private int strategyCode;
	private int position;
	
	
	public int getStrategyCode() {
		return strategyCode;
	}
	public void setStrategyCode(int strategyCode) {
		this.strategyCode = strategyCode;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public VersionsManager getVersionsManager() {
		return versionsManager;
	}
	public void setVersionsManager(VersionsManager versionsManager) {
		this.versionsManager = versionsManager;
	}
	public void makeController(VersionsManager versionsManager) {
		latexEditorController = new LatexEditorController(versionsManager);
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	
	public String getTemplateName() {
		// TODO Auto-generated method stub
		return templateName;
	}
	public void enact(String command) {
		latexEditorController.enact(command);
	}
	public void setPosition(int caretPosition) {
		this.position = caretPosition;
		
	}
	public int getPosition() {
		// TODO Auto-generated method stub
		return position;
	}
	
}

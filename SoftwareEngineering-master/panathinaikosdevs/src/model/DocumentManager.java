package model;

import java.util.HashMap;

public class DocumentManager {
	private HashMap<String, Document> templates;
	
	public DocumentManager() {
		templates = new HashMap<String, Document>();
		addArticle();
		addBook();
		addReport();
		addLetter();
	}
	
	public Document createDocument(String templateName) {
		Document doc = templates.get(templateName);
		if(doc == null) {
			return new Document();
		}
		else {
			return doc.clone();
		}
	}
	
	public void addArticle() {
		String articleContents = "\\documentclass[11pt,twocolumn,a4paper]{article}\n"+

				"\\begin{document}\n"+
				"\\title{Article: How to Structure a LaTeX Document}\n"+
				"\\author{Author1 \\and Author2 \\and ...}\n"+
				"\\date{\\today}\n"+

				"\\maketitle\n"+

				"\\section{Section Title 1}\n"+

				"\\section{Section Title 2}\n"+

				"\\section{Section Title.....}\n"+

				"\\section{Conclusion}\n"+

				"\\section*{References}\n"+

				"\\end{document}\n";
		
		Document doc = new Document();
		doc.setContents(articleContents);
		templates.put("article", doc);
	}
	
	public void addBook() {
		String bookContents = "\\documentclass[11pt,a4paper]{book}\n"+

				"\\begin{document}\n"+
				"\\title{Book: How to Structure a LaTeX Document}\n"+
				"\\author{Author1 \\and Author2 \\and ...}\n"+
				"\\date{\\today}\n"+

				"\\maketitle\n"+

				"\\frontmatter\n"+

				"\\chapter{Preface}\n"+
				"% ...\n"+

				"\\mainmatter\n"+
				"\\chapter{First chapter}\n"+
				"\\section{Section Title 1}\n"+
				"\\section{Section Title 2}\n"+
				"\\section{Section Title.....}\n"+

				"\\chapter{....}\n"+

				"\\chapter{Conclusion}\n"+

				"\\chapter*{References}\n"+


				"\\backmatter\n"+
				"\\chapter{Last note}\n"+

				"\\end{document}\n";
		
		Document doc = new Document();
		doc.setContents(bookContents);
		templates.put("book", doc);
	}
	
	public void addLetter() {
		String letterContents = "\\documentclass{letter}\n"+
				"\\usepackage{hyperref}\n"+
				"\\signature{Sender's Name}\n"+
				"\\address{Sender's address...}\n"+
				"\\begin{document}\n"+

				"\\begin{letter}{Destination address....}\n"+
				"\\opening{Dear Sir or Madam:}\n"+

				"I am writing to you .......\n"+


				"\\closing{Yours Faithfully,}\n"+

				"\\ps\n"+

				"P.S. text ....."+

				"\\encl{Copyright permission form}\n"+

				"\\end{letter}\n"+
				"\\end{document}\n";
		
		Document doc = new Document();
		doc.setContents(letterContents);
		templates.put("letter", doc);
	}
	
	public void addReport() {
		String reportContents = "\\documentclass[11pt,a4paper]{report}\n"+

				"\\begin{document}\n"+
				"\\title{Report Template: How to Structure a LaTeX Document}\n"+
				"\\author{Author1 \\and Author2 \\and ...}\n"+
				"\\date{\\today}\n"+
				"\\maketitle\n"+

				"\\begin{abstract}\n"+
				"Your abstract goes here...\n"+
				"...\n"+
				"\\end{abstract}\n"+

				"\\chapter{Introduction}\n"+
				"\\section{Section Title 1}\n"+
				"\\section{Section Title 2}\n"+
				"\\section{Section Title.....}\n"+

				"\\chapter{....}\n"+

				"\\chapter{Conclusion}\n"+


				"\\chapter*{References}\n"+

				"\\end{document}\n";
		
		Document doc = new Document();
		doc.setContents(reportContents);
		templates.put("report", doc);
	}
}

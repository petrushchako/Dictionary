package ie.gmit.dip;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Oleksandr Petrushchak
 * @version 1.0
 *
 */
public class WordDetail {
	private String word;
	private String wordtype;
	private String definition;	
	private List<Integer> pages = new ArrayList<>();
	
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getWordtype() {
		return wordtype;
	}
	public void setWordtype(String wordtype) {
		this.wordtype = wordtype;
	}
	public String getDefinition() {
		return definition;
	}
	public void setDefinition(String definition) {
		this.definition = definition;
	}
	public List<Integer> getPages() {
		return pages;
	}
	public void setPages(List<Integer> pages) {
		this.pages = pages;
	}
}

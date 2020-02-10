
package ie.gmit.dip;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 
 * @author Oleksandr Petrushchak
 * @version 1.0
 *
 */
public class Parser {
	
	private boolean isIgnored = true;
	ParseStringWords parseStrings = new ParseStringWords();
	ParseDisctionary parseDisctionary= new ParseDisctionary();
	ParseQuery parseQuery = new ParseQuery();
	
	/**
	 * Check if file StopWords contains word from input.
	 * @param next
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isStopWord(String next) throws Exception {
		parseStrings.parse(Constants.StopWords); // parse StopWords file
		if(!parseStrings.getStringWords().contains(next)) { // if StopWords does not contains "next", return false
			isIgnored = false;
		}
		return isIgnored; // if StopWords contains "next" return true
	}

	
	/**
	 * Generate output of word's detail, type, pages and number of times mentioned in the document.
	 * @param word
	 * @param queryFileName
	 * @throws Exception
	 */
	public void getWordFromDictionary(String word, String queryFileName) throws Exception {
		parseDisctionary.parse(Constants.Dictionary);
		Map<String, WordDetail> dictionary = parseDisctionary.getDictionary();
		parseQuery.parse(dictionary, queryFileName);
		List <Integer> pages = dictionary.get(word.toUpperCase()).getPages(); // Add page numbers into a list
        
		System.out.println("Definition: " + dictionary.get(word.toUpperCase()).getDefinition()+"\""); // output word's definition from dictionary
        System.out.println("Word Type: \""+ dictionary.get(word.toUpperCase()).getWordtype()+"\""); // output word's detail from dictionary
        System.out.println("Repeated " + pages.size()+ " times."); // output size of pages ArrayList to show how many times word was mentioned.
     	System.out.println("Pages: " + pages.stream().distinct().collect(Collectors.toList())); // output list without duplicates

	}
}

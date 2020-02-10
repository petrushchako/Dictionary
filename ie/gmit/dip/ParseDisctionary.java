package ie.gmit.dip;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/** 
 * @author Oleksandr Petrushchak
 * @version 1.0
 */
public class ParseDisctionary implements Dictionary{
	
	private Map<String, WordDetail> dictionary = new TreeMap<>(); //O(log(n)) 
	private WordDetail current = null;
	private StringBuilder builder = new StringBuilder();

	/**
	 * Read file,break down content by double quotes and add it into StringBuilder  
	 * @param dictionaryFileName
	 * @exception Exception
	 */
	@Override
	public void parse(String dictionaryFileName) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(dictionaryFileName)));
		String line = null;

		while ((line = br.readLine()) != null){
			if (line.startsWith("\"")) {
				current = new WordDetail();
				builder.append(line);
			}
			if (line.endsWith("\"") && current != null) {
				process();			
			}
		}
		br.close();
	}
	

	private void process(){
		StringBuilder temp = new StringBuilder();
		
		int state = 0;
		for (int i = 0; i < builder.length(); i++){
			char next = builder.charAt(i);
			
			if (next == '\u0022'){ //Double-quotes
				if (state == 1){
					current.setWord(temp.toString());
					temp.setLength(0);
				}else if (state == 3){
					current.setWordtype(temp.toString());
					temp.setLength(0);
				}else if (state == 4){
					current.setDefinition(builder.substring(i, builder.length()));
					addWordDetail();
					return;
				}
				state++;
			}else{
				temp.append(next);
			}
		}
	}
	
	private void addWordDetail(){
		WordDetail entry = dictionary.get(current.getWord());
		
		if (entry == null){
			dictionary.put(current.getWord().toUpperCase(), current);
		}else{
			entry.setDefinition(entry.getDefinition() + "\n" + current.getDefinition());
		}
		current = null;
		resetBuilder();
	}

	
	/**
	 * Reset StringBuilder, by setting length to 0.
	 */
	private void resetBuilder(){
		builder.setLength(0); // reset String Builder
	}
	
	public Map<String, WordDetail> getDictionary() {
		return dictionary;
	}

	public void setDictionary(Map<String, WordDetail> dictionary) {
		this.dictionary = dictionary;
	}
}

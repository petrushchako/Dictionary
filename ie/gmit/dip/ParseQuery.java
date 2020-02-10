package ie.gmit.dip;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @author Oleksandr Petrushchak
 * @version 1.0
 *
 */
public class ParseQuery{
	private Map<String, WordDetail> index = new TreeMap<>(); 
	
	/**
	 * Break file into pages(40 lines per page).
	 * @param dictionary
	 * @param queryFileName
	 * @throws Exception
	 */
	public void parse(Map<String, WordDetail> dictionary, String queryFileName) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(queryFileName)));
		
		String line = null;
		List<Integer> pages = new ArrayList<>();
		int lineNumber = 0;
		int page = 1;
		
		while ((line = br.readLine()) != null){
			line = line.toUpperCase().replaceAll("[^A-Za-z0-9 ]", "");
			lineNumber++; // increment line counter
			
			if (lineNumber % 40 == 0){ // when lineNumber reaches 40, start new page
				page++;
			}
			
			String[] words = line.split(" ");
			for (String s : words){
					WordDetail entry = dictionary.get(s);
					if (entry != null){
						pages.add(page);
						entry.setPages(pages);
						index.put(s, entry);
					}					
			}
		}
		br.close();
	}

}

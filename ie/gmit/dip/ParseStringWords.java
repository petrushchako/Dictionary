package ie.gmit.dip;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

/** 
 * @author Oleksandr Petrushchak
 * @version 1.0
 */
public class ParseStringWords implements Dictionary{
	private Set<String> stop = new TreeSet<String>();	
	private Set<String> stringWords;

	/**
	 * Read stopWordFileName and add reading into stop TreeSet.
	 * @param stopWordFileName
	 * @exception Exception
	 */
	@Override
	public void parse(String stopWordFileName) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(stopWordFileName)));
		String line = null;
		
		while ((line = br.readLine()) != null){
			stop.add(line);
		}

		setStringWords(stop); // pass TreeSet to setter&getter
		br.close();
	}

	public Set<String> getStringWords() {
		return stringWords;
	}

	public void setStringWords(Set<String> stringWords) {
		this.stringWords = stringWords;
	}
}

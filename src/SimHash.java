import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SimHash {

	//Remove the punctuation
	private String removePunctuation(String source){
		       
		return source.replaceAll( "\\p{Punct}", "" ); 
	}
	//Remove stop_words
	private String removeStopWords(String source) throws IOException{
		
		String filestopwords = "D:/~±œ“µ…Ëº∆/stopword.txt";
		File file = new File(filestopwords);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		Set<String> stopWords = new HashSet<String>();
		String temp = null;
		while((temp = reader.readLine()) != null){
			stopWords.add(temp);
		}
		String[] words = source.split(" ");
		String result = "";
		for(int i=0;i < words.length; i++)
		{
			if(stopWords.contains(words[i])){
				continue;
			}else{
				result += words[i]+" ";
			}
		}
		
		return result;
	}
	//calculate idf
	private double calculateIDF(String word){
		
		return 0;
	}
    //calculate weight
	private HashMap<String,Double> calculateWeight(String source){
		String[] words = source.split(" ");
		HashMap<String,Double> map = new HashMap<String,Double>();
		for(int i=0;i<words.length;i++){
			if(map.containsKey(words[i])){
				double temp = map.get(words[i]);
				map.remove(words[i]);
				map.put(words[i], temp+1);
			}else{
				map.put(words[i], 1.0d);
			}
		}
		
	    Iterator iter = map.keySet().iterator();
	    HashMap<String,Double> map2 = new HashMap<String,Double>();
	    while(iter.hasNext()){  	
	    	String key = (String) iter.next();
	    	double weight = map.get(key);
	    	weight = weight/map.size();
	    	map2.put(key, weight);
	    }
	    return map2;
	} 
	//calculate distance
	public int calculateDifference(String target1,String target2){
		
		try {
			System.out.println(calculateWeight(removeStopWords(removePunctuation(target1))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
}

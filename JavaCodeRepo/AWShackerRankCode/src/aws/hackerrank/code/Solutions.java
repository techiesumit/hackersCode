package aws.hackerrank.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Solutions {
	public ArrayList<String> topNCompetitors()
{
		int numCompetitors = 3;
		int topNCompetitors=2; 
		List<String> competitors= new ArrayList<String>();
		competitors.add("ana");competitors.add("beta");competitors.add("cella");
		int numReviews=5;
		List<String> reviews = new ArrayList<String>();
		reviews.add("ana is ana");
		reviews.add("ana is nn");
		reviews.add("beta is none");
		reviews.add("cella is ana");
		reviews.add("beta is bta");
		
		//int reviews1[] = new int[numCompetitors];
		Map<String, Integer> reviewMap= new HashMap<String, Integer>();
		LinkedHashMap<String,Integer> highSore= new LinkedHashMap<String, Integer>();
		String topCom[] =new String[topNCompetitors];
		String comString="";
		int comCount =0;
		for(comCount=0; comCount<numCompetitors;comCount++)
			 {
			comString= competitors.get(comCount);
			int occurence=0;
			for( String revString : reviews) {
				int count = ( revString.split(comString,-1).length)-1;
				if(count > 0) {
					occurence++;
				}
			}
			if(occurence>0) {
			reviewMap.put(comString, occurence);
			}
			
		}
		highSore= reviewMap.entrySet()
				.stream() 
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue())) 
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
		
		Object[] array = highSore.keySet().toArray();
		
		for(int i=0; i<topNCompetitors;i++) {
			topCom[i]= (String) array[i];
		}
		List<String> topCompi = new ArrayList<String>();
		Collections.addAll(topCompi, topCom);
		(topCompi.stream()).forEachOrdered(s->System.out.print(s+" "));
	return (ArrayList<String>) topCompi;
		
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Solutions().topNCompetitors();

	}

}

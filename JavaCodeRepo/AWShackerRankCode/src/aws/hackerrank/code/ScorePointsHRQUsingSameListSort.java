package aws.hackerrank.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScorePointsHRQUsingSameListSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> elements= new ArrayList<Integer>();
		elements.add(1);
		elements.add(2);
		elements.add(1);
		elements.add(3);
		elements.add(2);
		elements.add(3);
		elements.add(5);
		elements.add(4);
		elements.add(6);
		
		System.out.print(ScorePointsHRQUsingSameListSort.maxPoints(elements));

	}

	public static long maxPoints(List<Integer> elements) {
		int finalScore = 0;
		// Write your code here
		Collections.sort(elements);
		// Get the Max Element as it is last
	//	System.out.println("First Time ");
	//	elements.stream().forEach(s->System.out.print(s+" "));
	//	System.out.println(" ");
		
	//	if (elements.size() > 0) {
		
		while (elements.size()>0) {
		//	elements.stream().forEach(s->System.out.print(s+" "));
			elements.stream().forEach(s->System.out.print(s+" "));
			System.out.println("Size of List "+elements.size());
			int maxStart = elements.get(elements.size() - 1);
			elements.remove(elements.size() - 1);
			finalScore+= maxStart;
			System.out.println(maxStart);
			
			int i=0;
			for (; i < elements.size(); i++) {
		System.out.println(i + " = " + elements.get(i));
				if(elements.get(i)==maxStart) {
					finalScore+=maxStart;
					elements.remove(i);
					i=0;
				}else {
					if(elements.get(i)==(maxStart+1) || elements.get(i)==(maxStart-1)) {
						elements.remove(i);
						i=0;
					}
					
				}
				
			}
			
	}

		return finalScore;

	}
}

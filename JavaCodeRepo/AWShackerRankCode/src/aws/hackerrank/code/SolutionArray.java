package aws.hackerrank.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class SolutionArray {
	
	public static int segment(int x, List<Integer> arr) {
		int seg = 0;
		int j=0;
		
		LinkedHashMap<Integer, List<Integer>> subMap= new  LinkedHashMap<Integer, List<Integer>>();
		List<Integer> finalList = new ArrayList<Integer>();
		for(int i=0;i<arr.size();i++) {
			int k=0;
			j=i;
			List<Integer> subList= new ArrayList<Integer>();
			for(;k<x;k++) {
				subList.add(arr.get(j));
				j++;
				
			}
			Collections.sort(subList);
			// Get the minimum Value
			
			// Add it to Map
			finalList.add(subList.get(0));
			subMap.put(i, subList);
			
			if(j==arr.size()) {
				
				break;
			}
			
		}
		Collections.sort(finalList);
		seg=finalList.get(finalList.size() - 1);
		
		return seg;
	    // Write your code here

	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> array=new ArrayList<Integer>();
		array.add(2);
		array.add(5);
		array.add(4);
		array.add(6);
		array.add(8);
		array.add(8);
		System.out.print( SolutionArray.segment(3, array));
		

	}

}

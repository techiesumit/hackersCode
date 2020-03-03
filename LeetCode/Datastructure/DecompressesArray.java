/*
Decompress Run-Length Encoded List
We are given a list nums of integers representing a list compressed with run-length encoding.

Consider each adjacent pair of elements [a, b] = [nums[2*i], nums[2*i+1]] (with i >= 0).  For each such pair, there are a elements with value b in the decompressed list.

Return the decompressed list.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [2,4,4,4]
Explanation: The first pair [1,2] means we have freq = 1 and val = 2 so we generate the array [2].
The second pair [3,4] means we have freq = 3 and val = 4 so we generate [4,4,4].
At the end the concatenation [2] + [4,4,4] is [2,4,4,4].
 

Constraints:

2 <= nums.length <= 100
nums.length % 2 == 0
1 <= nums[i] <= 100

References
https://leetcode.com/problems/decompress-run-length-encoded-list/
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class DecompressesArray {
    public int[] decompressRLElist(int[] nums) {
        // Create a List to contain the output f
        List<Integer> outList=new ArrayList<Integer>();
        // Check if the Edge Cases are covered and all the conditions are met.
        if(nums.length >=2  && nums.length <=100 && (nums.length % 2 ==0)) {
            int frequency=0;
            int value=0;
            for (int i = 0; i < nums.length ; i++) {
                frequency=nums[i];
                i++;
                value=nums[i];
                // Check if the Frequenecy is greater than zero
                if(frequency > 0){
                    for (int j = 0; j < frequency; j++) {
                        outList.add(value);
                    }
                }

            }
        }else
        {
            System.out.println("Array lenght is not in the range ");
        }
       
       // return outList.stream().mapToInt(Integer::intValue).toArray();
      // Use the Stream classes to convert the ArrayList to int Array
        return outList.stream().mapToInt(Integer::intValue).toArray();
      
    }

    public static void main(String[] args) {
        DecompressesArray compressesArray = new DecompressesArray();
        int arrray[]= new int[] {1,2,3,4, 0,5};
        //Use Stream to display the value.
        Arrays.stream(compressesArray.decompressRLElist(arrray)).forEach(intvalue->System.out.print(intvalue+" "));

    }
    }
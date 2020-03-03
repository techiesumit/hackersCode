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
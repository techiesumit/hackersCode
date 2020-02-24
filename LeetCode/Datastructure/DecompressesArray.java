import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DecompressesArray {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> outList=new ArrayList<Integer>();
        if(nums.length >=2  && nums.length <=100 && (nums.length % 2 ==0)) {
            int frequency=0;
            int value=0;
            for (int i = 0; i < nums.length ; i++) {
                frequency=nums[i];
                i++;
                value=nums[i];
                if(frequency > 0 && value >0){
                    for (int j = 0; j < frequency; j++) {
                        outList.add(value);
                    }
                }

            }
        }else
        {
            System.out.println("Array lenght is not in the range ");
        }
       // Integer returnArray[]= Integer[]  outList.toArray();
        return outList.stream().mapToInt(Integer::intValue).toArray();
      //  return Arrays.stream(returnArray).mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        CompressesArray compressesArray = new CompressesArray();
        int arrray[]= new int[] {1,2,3,4};
        Arrays.stream(compressesArray.decompressRLElist(arrray)).forEach(intvalue->System.out.println(intvalue+" "));
    }
}

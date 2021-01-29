package jianzhi.offer;

public class TwoSum {
    /**
     * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[2,7] 或者 [7,2]
     * 示例 2：
     *
     * 输入：nums = [10,26,30,31,47,60], target = 40
     * 输出：[10,30] 或者 [30,10]
     *  
     *
     * 限制：
     *
     * 1 <= nums.length <= 10^5
     * 1 <= nums[i] <= 10^6
     */
    public int[] twoSum(int[] nums, int target) {
        int[] twoNum = new int[2];
        for(int no1=0;no1<nums.length-1;no1++){
            int numValue1 = nums[no1];
            int numValue2 = binarySearchValue(no1,nums.length,nums,target);
            if((numValue1+numValue2)==target){
                twoNum[0] = numValue1;
                twoNum[1] = numValue2;
                return twoNum;
            }
        }
        return twoNum;
    }

    public int binarySearchValue(int start,int end,int[] nums, int target){
        if(start>=end){
            return nums[start]-1;
        }
        int middle = (end-start)/2;
        if((nums[start]+nums[middle])==target){
            return nums[middle];
        }
        int firstValue = binarySearchValue(start,middle,nums,target);
        if(firstValue>nums[start]){
            return firstValue;
        }
        int secondValue = binarySearchValue(middle+1,end,nums,target);
        if(secondValue>nums[middle+1]){
            return secondValue;
        }

        return nums[start]-1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{16,16,18,24,30,32};
        int target = 48;
        int[] result = new TwoSum().twoSum(nums,target);
        System.out.println(result[0]+"  "+result[1]);
    }
}

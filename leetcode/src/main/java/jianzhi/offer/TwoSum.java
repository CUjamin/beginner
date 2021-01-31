package jianzhi.offer;

import java.util.HashSet;
import java.util.Set;

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
        Set<Integer> numSet = new HashSet<>();
        for(int num:nums){
            int tempTarget = target-num;
            if(numSet.contains(tempTarget)){
                twoNum[0] = num;
                twoNum[1] = tempTarget;
                break;
            }
            numSet.add(num);
        }

        return twoNum;
    }
    public int[] twoSum2(int[] nums, int target) {
        int[] twoNum = new int[2];
        int no1 = 0;
        while(nums[no1]<=(target/2)){
            int numValue1 = nums[no1];
            int tempTargetValue = target-numValue1;
            int numValue2 = binarySearchValue(no1,nums.length,nums,tempTargetValue);
            if(numValue2<numValue1){
                no1++;
                continue;
            }else {
                twoNum[0]=numValue1;
                twoNum[1]=numValue2;
                break;
            }
        }
        return twoNum;
    }

    public int binarySearchValue(int start,int end,int[] nums, int tempTargetValue){
        int tempStart = start;
        int tempEnd = end;
        int resultValue = nums[start]-1;
        while (tempStart<tempEnd){
            int tempMiddle = tempStart+(tempEnd-tempStart)/2;
            if(tempTargetValue==nums[tempMiddle]){
                return nums[tempMiddle];
            }
            if(tempTargetValue<nums[tempMiddle]){
                tempEnd = tempMiddle;
                continue;
            }
            if(tempTargetValue>nums[tempMiddle]){
                tempStart = tempMiddle;
                continue;
            }
        }
        return resultValue;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{16,16,18,24,30,32};
        int target = 48;
        int[] result = new TwoSum().twoSum(nums,target);
        System.out.println(result[0]+"  "+result[1]);
    }
}

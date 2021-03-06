package jianzhi.offer.normal;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cujamin
 */
public class SingleNumber {
    /**
     * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
     *
     *  
     *
     * 示例 1：
     * 输入：nums = [3,4,3,3]
     * 输出：4
     * 示例 2：
     *
     * 输入：nums = [9,1,7,9,7,9,7]
     * 输出：1
     *  
     *
     * 限制：
     *
     * 1 <= nums.length <= 10000
     * 1 <= nums[i] < 2^31
     */
    public int singleNumber(int[] nums) {
        Set<Integer> singleNumSet = new HashSet<>();
        Set<Integer> repeatNumSet = new HashSet<>();
        for(int num:nums){
            if(singleNumSet.contains(num)){
                singleNumSet.remove(num);
                repeatNumSet.add(num);
                continue;
            }
            if(!repeatNumSet.contains(num)){
                singleNumSet.add(num);
            }
        }
        return singleNumSet.stream().findAny().get();
    }
}

package jianzhi.offer.normal;



/**
 * 剑指 Offer 64. 求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 * <p>
 * 输入: n = 9
 * 输出: 45
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= n <= 10000
 */
/**
 * @author cujamin
 * @date 2021/1/31
 */
public class SumNums {
    public int sumNums(int n) {
        return n == 0 ? 0 : n+sumNums(n - 1);
    }
}

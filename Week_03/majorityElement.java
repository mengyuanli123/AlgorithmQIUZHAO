import java.util.Arrays;

/**
 169. 多数元素
 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

 你可以假设数组是非空的，并且给定的数组总是存在多数元素。

 示例 1:

 输入: [3,2,3]
 输出: 3
 示例 2:

 输入: [2,2,1,1,1,2,2]
 输出: 2
 */
public class majorityElement {

    public int solution1(int[] nums) {

        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        int[] record = new int[max + 1];

        int times = nums.length/2;

        for (int numItem : nums) {
            record[numItem]+=1;

            if (record[numItem] > times)
                return numItem;
        }
        return -1;
    }

    public int solution2(int[] nums) {

        int candidate = nums[0];
        int count = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate)
                count++;
            else {
                --count;
                if(count == 0){
                    candidate = nums[i];
                    count = 1;
                }
            }
        }
        return candidate;
    }
}

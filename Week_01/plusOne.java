/**
 66. 加一
 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

 你可以假设除了整数 0 之外，这个整数不会以零开头。

 示例 1:

 输入: [1,2,3]
 输出: [1,2,4]
 解释: 输入数组表示数字 123。
 示例 2:

 输入: [4,3,2,1]
 输出: [4,3,2,2]
 解释: 输入数组表示数字 4321。
 */

public class plusOne {

    public int[] solution(int[] digits) {
        for(int i = digits.length-1;i>=0;i--){
            if(digits[i]==9){
                digits[i] = 0;
            }else {
                digits[i] = digits[i] + 1;
                return digits;
            }
        }
        digits = new int[digits.length+1];
        digits[0]=1;
        return digits;
    }

    public int[] solution2(int[] digits) {
        int index = digits.length-1;

        if(digits[index]<9){
            digits[index] = digits[index]+1;
            return digits;
        }else{
            while(index>=0 && digits[index]==9){
                digits[index] = 0;
                index--;
            }
            if(index>=0){
                digits[index] = digits[index]+1;
                return digits;
            }
            else{
                int[] digit_new = new int[digits.length+1];
                digit_new[0] = 1;
                return digit_new;
            }
        }
    }
}

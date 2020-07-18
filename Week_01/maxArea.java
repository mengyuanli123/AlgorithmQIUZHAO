/**
 11. 盛最多水的容器
 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

 说明：你不能倾斜容器，且 n 的值至少为 2。

 示例：

 输入：[1,8,6,2,5,4,8,3,7]
 输出：49
 */
public class maxArea {

    public int solution1(int[] height) {

        int maxArea = 0;
        for(int i = 0;i<height.length-1;i++){
            for(int j = i+1;j<height.length;j++){
                int area = Math.min(height[i],height[j])*(j-i);
                maxArea = Math.max(area,maxArea);
            }
        }
        return maxArea;
    }

    public int solution2(int[] height) {
        int i = 0;
        int j = height.length-1;

        int max = 0;

        while(i<j){

            max = height[i]<height[j]?
                    Math.max(max,(j-i)*height[i++]):
                    Math.max(max,(j-i)*height[j--]);
        }
        return max;
    }
}

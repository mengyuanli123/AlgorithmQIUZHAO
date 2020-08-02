import java.util.ArrayList;
import java.util.List;

/**
 22. 括号生成
 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

 示例：

 输入：n = 3
 输出：[
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 */
public class generateParenthesis {

    public static void main(String[] args) {

        List<String> res = generateParenthesis(3);
        for (String item : res) {
            System.out.println(item);
        }
    }

    public static List<String> generateParenthesis(int n) {

        List<String> parenthesisList = new ArrayList<String>();
        generator(0, 0, n, parenthesisList, "");
        return parenthesisList;
    }

    private static void generator(int left, int right, int max, List<String> list, String s) {

        if (left == max && right == max) {
            list.add(s);
            return;
        }

        if (left < max)
            generator(left + 1, right, max, list, s+"(");

        if (left > right)
            generator(left, right + 1, max, list, s+")");
    }
}

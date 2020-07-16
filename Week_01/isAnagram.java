import java.util.HashMap;

/**
 242. 有效的字母异位词
 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

 示例 1:

 输入: s = "anagram", t = "nagaram"
 输出: true

 示例 2:

 输入: s = "rat", t = "car"
 输出: false
 说明:
 你可以假设字符串只包含小写字母。
 */

public class isAnagram {
    public boolean isAnagram(String s, String t) {

        if(s.length()!=t.length())
            return false;

        HashMap<Character,Integer> letterDict = new HashMap<Character, Integer>();
        for(char c: s.toCharArray()){
            if(null!=letterDict.get(c))
                letterDict.put(c,letterDict.get(c)+1);
            else
                letterDict.put(c,1);
        }

        for(char c: t.toCharArray()){
            if(null!=letterDict.get(c) && letterDict.get(c)>=1)
                letterDict.put(c,letterDict.get(c)-1);
            else
                return false;
        }
        return true;
    }
}

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 127. 单词接龙
 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：

 每次转换只能改变一个字母。
 转换过程中的中间单词必须是字典中的单词。
 说明:

 如果不存在这样的转换序列，返回 0。
 所有单词具有相同的长度。
 所有单词只由小写字母组成。
 字典中不存在重复的单词。
 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 示例 1:

 输入:
 beginWord = "hit",
 endWord = "cog",
 wordList = ["hot","dot","dog","lot","log","cog"]

 输出: 5

 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 返回它的长度 5。
 示例 2:

 输入:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log"]

 输出: 0

 解释: endWord "cog" 不在字典中，所以无法进行转换。

 */
public class ladderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord))
            return 0;

        Queue<String> wordQueue = new LinkedList<String>();
        boolean[] visited = new boolean[wordList.size()];
        int idx = wordList.indexOf(beginWord);
        if (idx != -1) {
            visited[idx] = true;
        }

        wordQueue.offer(beginWord);

        int count = 0;

        while (!wordQueue.isEmpty()) {

            int queueSize = wordQueue.size();
            count++;

            for (int i = 0; i < queueSize; i++) {
                String currentWord = wordQueue.poll();

                for (int j = 0; j < wordList.size(); j++) {
                    String wordItem = wordList.get(j);
                    if (visited[j])
                        continue;
                    if (!canBeConverted(wordItem,currentWord))
                        continue;
                    if (wordItem.equals(endWord))
                        return count + 1;

                    visited[j] = true;
                    wordQueue.offer(wordItem);
                }
            }
        }
        return 0;

    }

    public Boolean canBeConverted(String word1, String word2){
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i))
                count++;
        }

        if (count != 1)
            return false;
        else
            return true;
    }
}

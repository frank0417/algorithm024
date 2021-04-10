package string;

public class FirstUniqueCharacterInAString {
    /*
     * 题 目：字符串中的第一个唯一字符
     * 链 接：https://leetcode-cn.com/problems/first-unique-character-in-a-string/
     * 描 述：给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     */
    public int firstUniqChar(String s) {
        int len = 0;
        if (s == null || (len = s.length()) == 0) return -1;
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            chars[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < len; ++i) {
            if (chars[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}

package string;

public class ReverseWordsInaStringiii {
    /*
     * 题 目：反转字符串中的单词 III
     * 链 接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
     * 描 述：给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     */
    public String reverseWords(String s) {
        char[] ca = s.toCharArray();
        for (int i = 0; i < ca.length; i++) {
            if (ca[i] != ' ') {
                int j = i;
                while (j + 1 < ca.length && ca[j + 1] != ' ') { j++; }
                reverse(ca, i, j);
                i = j;
            }
        }
        return new String(ca);
    }

    private void reverse(char[] ca, int i, int j) {
        for (; i < j; i++, j--) {
            char tmp = ca[i];
            ca[i] = ca[j];
            ca[j] = tmp;
        }
    }
}

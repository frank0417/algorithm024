package string;

public class ReverseStringii {
    /*
     * 题 目：反转字符串 II
     * 链 接：https://leetcode-cn.com/problems/reverse-string-ii/
     * 描 述：给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
     */
    public String reverseStr(String s, int k) {
        int len=0;
        if((len=s.length())==1) return s;
        char[] chars=s.toCharArray();
        for(int i=0;i<len;i+=2*k){
            int j=i,g=Math.min(j+k-1,len-1);
            while(j<g){
                char tmp=chars[j];
                chars[j++]=chars[g];
                chars[g--]=tmp;
            }
        }
        return  String.valueOf(chars);
    }
}

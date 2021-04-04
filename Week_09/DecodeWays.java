public class DecodeWays {
    /*
     * 题 目： 解码方法
     * 链 接: https://leetcode-cn.com/problems/decode-ways/
     * 描 述：一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
     *       'A' -> 1
     *       'B' -> 2
     *         ...
     *       'Z' -> 26
     *       要解码已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"111" 可以将 "1" 中的每个 "1"
     *       映射为 "A" ，从而得到 "AAA" ，或者可以将 "11" 和 "1"（分别为 "K" 和 "A" ）映射为 "KA" 。注意，"06" 不能映射为 "F" ，
     *       因为 "6" 和 "06" 不同。
     *       给你一个只含数字的非空字符串num ，请计算并返回解码方法的总数
     */
    public int numDecodings(String s) {
         int len=0;
         if(s==null || (len=s.length())==0 || s.charAt(0)=='0') return 0;
         int[] dp=new int[len];
         dp[0]=1;
         for(int i=1;i<len;++i){
             if(s.charAt(i)=='0'){
                 if(s.charAt(i-1)!='1' && s.charAt(i-1)!='2') return 0;
                 dp[i]=i==1?1:dp[i-2];
             }else if(s.charAt(i-1)=='1' || (s.charAt(i-1)=='2' && s.charAt(i)>='1' && s.charAt(i)<='6')){
                 dp[i]=i==1?2:dp[i-1]+dp[i-2];
             }else{
                 dp[i]=dp[i-1];
             }
         }
         return dp[len-1];
    }
}

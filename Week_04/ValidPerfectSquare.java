public class ValidPerfectSquare {
    /*
     * 题 目：有效的完全平方数
     * 链 接: https://leetcode-cn.com/problems/valid-perfect-square/
     * 描 述：给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
     */
    public boolean isPerfectSquare(int num) {
        long r=num;
        while(r*r>num){
            r=(r+num/r)/2;
        }
        return r*r==num;
    }

}

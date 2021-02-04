public class PlusOne {
    /*
     * 题 目：加一
     * 链 接：https://leetcode-cn.com/problems/plus-one/
     * 描 述：给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     *       最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     *       你可以假设除了整数 0 之外，这个整数不会以零开头。
     */
    public int[] plusOne(int[] digits) {
        int length=0;
        if(digits==null || (length=digits.length)==0) return digits;
        for(int i=length-1;i>=0;--i){
            digits[i]=(digits[i]+1)%10;
            if(digits[i]>0){
                return digits;
            }
        }
        digits=new int[length+1];
        digits[0]=1;
        return digits;
    }


}
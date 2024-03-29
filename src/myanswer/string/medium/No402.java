package myanswer.string.medium;

import java.util.Stack;

/**
 * @FileName: No402.java
 * @Description: 移掉K位数字
 * @Author: camille
 * @Date: 2021/3/20 10:43
 */
public class No402 {

    public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0) {
            return "0";
        }
        if (k >= num.length()) {
            return "0";
        }
        // 单调递增序列
        Stack<Character> stack = new Stack<>();
        char[] chars = num.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (stack.isEmpty() || (k > 0 && stack.peek() <= chars[i])) {
                stack.push(chars[i]);
            } else {
                // 重点是这一句，只要大于当前字符就出栈
                while (k > 0 && !stack.isEmpty() && stack.peek() > chars[i]) {
                    k--;
                    stack.pop();
                }
                stack.push(chars[i]);
            }
        }

        // 如果还能移除字符，k的次数还没用完
        if (k >= stack.size()) {
            return "0";
        }
        while (k > 0 && !stack.isEmpty()) {
            k--;
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        String s = sb.reverse().toString();

        // 去除前导零
        char[] resultChars = s.toCharArray();
        int idx = resultChars.length - 1;
        for (int i = 0; i <= resultChars.length - 1; i++) {
            if (resultChars[i] != '0') {
                idx = i;
                break;
            }
        }
        return s.substring(idx, resultChars.length);
    }


    public static void main(String[] args) {
        String num = "50337";
        int k = 2;
        No402 no402 = new No402();
        String ans = no402.removeKdigits1(num, k);
        System.out.println(ans);
    }

    public String removeKdigits1(String num, int k) {
        if (num.length() == k) return "0";
        StringBuilder s = new StringBuilder(num);
        for (int i = 0; i < k; i++) {
            int idx = 0;
            for (int j = 1; j < s.length() && s.charAt(j) >= s.charAt(j - 1); j++) idx = j;
            s.delete(idx, idx + 1);
            while (s.length() > 1 && s.charAt(0) == '0') s.delete(0, 1);
        }
        return s.toString();
    }


}

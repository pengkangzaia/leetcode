package myanswer.string;

public class No151 {

    public String reverseWords(String s) {
//        if (s == null || s.length() <= 1) {
//            return s;
//        }
        // 这种写法不能处理多个空格的情况
        String[] strings = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = strings.length - 1;
        while (i <= j) {
            String temp = strings[i];
            strings[i] = strings[j];
            strings[j] = temp;
            i++;
            j--;
        }
        for (int k = 0; k < strings.length; k++) {
            // 加一个判断，去除多个空格的情况
            if (!strings[k].equals("")) {
                sb.append(strings[k] + " ");
            }
        }
        return sb.toString().trim();
    }

    // 方法二，双指针
    public String reverseWords2(String s) {
        // 去除首尾空格
        // 逆序添加单词
        s = s.trim();
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = chars.length - 1;
        int j = chars.length - 1;
        while(i>=0){
            while (i>=0 && chars[i] != ' ') i--;
            // substring左闭右开
            sb.append(s.substring(i+1,j+1)+" ");
            while (i>=0 && chars[i] == ' ') i--;
            j = i;
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        No151 no151 = new No151();
        String ans = no151.reverseWords(" sawhifu sigwiu iaudiuw");
        System.out.println(ans);
    }


}

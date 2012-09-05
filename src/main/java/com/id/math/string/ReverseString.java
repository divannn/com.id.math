package com.id.math.string;

public class ReverseString {

    public static void main(String[] args) {
        String source = "abcd12345";
        System.err.println("  source: " + source);
        System.err.println("reversed: " + reverseString(source));
    }

    private static String reverseString(String s) {
        if (s == null) {
            return "";
        }
        char[] str = s.toCharArray();
        int len = str.length - 1;
        for (int i = 0; i <= len / 2; i++) {
            char tmp = str[i];
            str[i] = str[len - i];
            str[len - i] = tmp;
        }
        return new String(str);
    }


}

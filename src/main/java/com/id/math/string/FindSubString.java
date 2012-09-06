package com.id.math.string;

public class FindSubString {

    public static void main(String[] args) {
        String source = "abcd12345";
        String target = "cd1";
        System.err.println("source: " + source + " target: " + target);
        System.err.println("index: " + subString(target, source));
    }

    private static int subString(String n, String h) {
        if (n == null || h == null) {
            return -1;
        }
        char[] needle = n.toCharArray();
        char[] haystack = h.toCharArray();
        for (int i = 0; i < haystack.length; i++) {
            int j = 0;
            for (j = 0; j < needle.length; j++) {
                if (needle[j] != haystack[i + j]) {
                    break;
                }
            }
            if (j == needle.length) {
                return i;
            }
        }
        return -1;
    }

    private static int subString2(String n, String h) {
        char[] needle = n.toCharArray();
        char[] haystack = h.toCharArray();
        int needleIndex = 0;
        for (int i = 0; i < haystack.length; i++) {
            if (needle[needleIndex] == haystack[i]) {
                needleIndex++;
            } else {
                i -= needleIndex;
                needleIndex = 0;
                continue;
            }
            if (needleIndex == needle.length) {
                return i - n.length() + 1;
            }
        }
        return -1;
    }


}

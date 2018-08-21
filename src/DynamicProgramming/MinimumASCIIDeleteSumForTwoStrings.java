package DynamicProgramming;
/*
712
Given two strings s1, s2, find the lowest ASCII sum of deleted characters to make two strings equal.

        Example 1:
        Input: s1 = "sea", s2 = "eat"
        Output: 231
        Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
        Deleting "t" from "eat" adds 116 to the sum.
        At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
        Example 2:
        Input: s1 = "delete", s2 = "leet"
        Output: 403
        Explanation: Deleting "dee" from "delete" to turn the string into "let",
        adds 100[d]+101[e]+101[e] to the sum.  Deleting "e" from "leet" adds 101[e] to the sum.
        At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
        If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.
        Note:

        0 < s1.length, s2.length <= 1000.
        All elements of each string will have an ASCII value in [97, 122].
*/

import java.util.Scanner;

public class MinimumASCIIDeleteSumForTwoStrings {
    public static int minimumDeleteSum(String s1, String s2) {
        int[][] count = new int[s1.length()+1][s2.length()+1];
        int cost = 0;
        for(int i = 1; i < s1.length()+1; i++)
            count[i][0] = count[i-1][0] + s1.charAt(i-1);
        for(int j = 1; j < s2.length()+1; j++)
            count[0][j] = count[0][j-1] + s2.charAt(j-1);
        for(int i = 1; i < s1.length()+1; i++){
            for (int j = 1; j < s2.length()+1; j++){
                cost = s1.charAt(i-1) == s2.charAt(j-1) ? 0 : s1.charAt(i-1) + s2.charAt(j-1);
                count[i][j] = Math.min(count[i-1][j] + s1.charAt(i-1), count[i][j-1] + s2.charAt(j-1));
                count[i][j] = Math.min(count[i][j], count[i-1][j-1] + cost);
            }
        }
        return count[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine(), s2 = sc.nextLine();
        int result = minimumDeleteSum(s1, s2);
        System.out.println(result);
    }
}

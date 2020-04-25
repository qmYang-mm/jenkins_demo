package com.msg.duanxin.test;

import java.io.FileNotFoundException;

public class LCS {

	/*
	 * 最长公共子序列问题 给定两个字符串A、B，求A与B的最长公共子序列（子序列不要求是连续的） 举例： 字符串A： abcicba 字符串B：abdkscab
	 * 其中:ab、abc、abca都是公共子序列，但是abca是最长公共子序列
	 * 
	 * 从文件读取输入： 1A2C3D4B56 B1D23CA45B6A
	 * 
	 * 输出： 123456
	 * 
	 * 或者 12C4B6都正确
	 * 
	 * （这里的算法其实存在一个缺陷）
	 */

	public int[][] getdp(char[] str1, char[] str2) {
		int[][] dp = new int[str1.length][str2.length];

		dp[0][0] = (str1[0] == str2[0] ? 1 : 0);
		for (int i = 1; i < str1.length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], str1[i] == str2[0] ? 1 : 0);
		}
		for (int j = 1; j < str2.length; j++) {
			dp[0][j] = Math.max(dp[0][j - 1], str1[0] == str2[j] ? 1 : 0);
		}

		for (int i = 1; i < str1.length; i++) {
			for (int j = 1; j < str2.length; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				if (str1[i] == str2[j]) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
				}
			}
		}

		return dp;
	}

	public String lcse(String str1, String str2) {

		if (str1 == null || str2 == null || "".equals(str1) || "".equals(str2)) {
			return "";
		}

		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();

		int[][] dp = getdp(chs1, chs2);

		int m = chs1.length - 1;
		int n = chs2.length - 1;

		char[] res = new char[dp[m][n]];
		int index = res.length - 1;
		while (index >= 0) {
			if (n > 0 && dp[m][n] == dp[m][n - 1]) {
				n--;
			} else if (m > 0 && dp[m][n] == dp[m - 1][n]) {
				m--;
			} else {
				res[index--] = chs1[m];
				m--;
				n--;
			}
		}

		return String.valueOf(res);

	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		String aStr = "1A2C3D4B56"; // 读取A字符串
		String bStr = "B1D23CA45B6A"; // 读取B字符串
		System.out.println(aStr);
		System.out.println(bStr);
		
		LCS lcs = new LCS();
		String result = lcs.lcse(aStr, bStr);
		System.out.println(result);
	}

}


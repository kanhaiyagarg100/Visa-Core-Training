package com.visa.prj.util;

import java.util.Arrays;

public class ArrayUtil {
	public static int getSum(int[] elems) {
		int s=0;
		for(int i: elems) {
			s+= i;
		}
		return s;
	}
	public static int getCount(int[] elems, int no) {
		int s=0;
		for(int i:elems) {
			if(i==no)
				s++;
		}
		return s;
	}
	public static void sort(int[] elems) {
		Arrays.sort(elems);
	}
}

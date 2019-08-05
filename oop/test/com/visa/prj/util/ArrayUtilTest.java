package com.visa.prj.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayUtilTest {

	@Test
	void testGetSum() {
		int [] data= {5,6,4};
		assertEquals(15, ArrayUtil.getSum(data));
		
		int [] elems= {-1, 0, 1};
		assertEquals(0, ArrayUtil.getSum(elems));
	}

	@Test
	void testGetCount() {
		int [] elems= {53, 67, 2, 67, 74, 67};
		assertEquals(3, ArrayUtil.getCount(elems, 67));
		
	}

	@Test
	void testSort() {
		int [] elems= {53, 67, 2, 67, 74, 67};
		ArrayUtil.sort(elems);
		int [] expected= {2,53,67, 67, 67, 74};
		
		assertArrayEquals(expected, elems);
	}

}

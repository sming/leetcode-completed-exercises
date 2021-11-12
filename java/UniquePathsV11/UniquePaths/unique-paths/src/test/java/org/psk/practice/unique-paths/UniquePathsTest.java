package com.psk.practice.unique_paths;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UniquePathsTest {

	@Test
	void test() throws Exception {
		var s = new Solution();
		int numWalks = s.uniquePaths(3, 7);
		assertEquals(28, numWalks);
	}

}

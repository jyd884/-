package szu.csse.softwaretesting.ch1;

import java.util.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;

@RunWith (Parameterized.class)
public class FindLastTestDD {
	public int[] arr;  // for the first parameter of findLast
	public int y;  // for the second parameter of findLast
	public int exp; // for the expected result

	/*
	 * Constructor
	 * Pass test cases from @Patameters to the private variables, 
	 * which are then  used by @Test
	 */
	public FindLastTestDD(int[] arr, int y, int exp){
		if (arr == null) this.arr = null;
		else this.arr = arr.clone();
		this.y = y;
		this.exp = exp;
	}
	
	@Parameters
	public static Collection<Object[]> calcValues() {
		int[] arr1 = {1};
		int y1 = 1;
		int exp1 = 0;
		int[] arr2 = {1, 0, 1};
		int y2 = 1;
		int exp2 = 2;
		int[] arr3 = {2};
		int y3 = 1;
		int exp3 = -1;
		int[] arr4 = {0};
		int y4 = 0;
		int exp4 = 0;
		return Arrays.asList (new Object [][]{
			{arr1, y1, exp1}, 
			{arr2, y2, exp2},
			{arr3, y3, exp3},
			{arr4, y4, exp4}
		}); 
	}
	
	@Test
	public void additionTest() {
		int res;
		try {
			res = FindLast.findLast(this.arr, this.y);
		}catch (NullPointerException e) {
			return;
		}
		//fail("NullPointerException expected");
		assertTrue("Addition Test", this.exp == res);
	}
	
}

package kiran;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RotatingProblemTest {
	
	List<Integer> ints = new ArrayList<Integer>();
	
	@Before
	public void initializeInput()
	{
		ints.clear();
		ints.add(1);
		ints.add(2);
		ints.add(3);
		ints.add(4);
		ints.add(5);
		ints.add(6);
	}
	
	@Test
	public void test2Rotate() {
		int rotate = 4;
		List<Integer> expected=getExpectedArray(rotate);
		RotatingProblem rp = new RotatingProblem();
		rp.rotate(ints, rotate);
		Assert.assertEquals(expected, ints);
		
	}

	private List<Integer> getExpectedArray(int rotate) {
		List<Integer> expected=new ArrayList<Integer>();
		expected.addAll(ints);
		for(int i = 0 ; i< rotate;i++)
		{
			int val=expected.remove(0);
			expected.add(val);
		}
		
		return expected;
	}

}

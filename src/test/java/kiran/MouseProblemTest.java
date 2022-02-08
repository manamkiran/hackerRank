package kiran;

import org.junit.Assert;
import org.junit.Test;

public class MouseProblemTest {
	
	@Test
	public void TestBasicIntersection() {
		int[] points = new int[] {6,5,5,6};
		MouseProblem mp = new MouseProblem();
		int intersections = mp.findIntersections(points);
		Assert.assertEquals(1, intersections);
		
	}
	
	@Test
	public void TestIntersectionForLessThan3points() {
		int[] points = new int[] {6,5,5};
		MouseProblem mp = new MouseProblem();
		int intersections = mp.findIntersections(points);
		Assert.assertEquals(0, intersections);
		
	}
	
	@Test
	public void TestIntersectionSpiral() {
		int[] points = new int[] {1,2,3,4,5,6,7,8};
		MouseProblem mp = new MouseProblem();
		int intersections = mp.findIntersections(points);
		Assert.assertEquals(0, intersections);
		
	}
	
	@Test
	public void TestIntersections() {
		int[] points = new int[] {6,5,5,6,4,8};
		MouseProblem mp = new MouseProblem();
		int intersections = mp.findIntersections(points);
		Assert.assertEquals(3, intersections);
		
	}

}

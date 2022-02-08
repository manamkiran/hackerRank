package kiran;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Question Given an mouse which moves n steps and then take a right turn. Given
 * a sequence of input find how many times the mouse intersects its path.
 *
 */

public class MouseProblem {

	public int findIntersections(int[] points) {
		if (points.length < 4) {
			return 0;
		}
		Direction dt = Direction.UP;
		int intersections = 0;
		Point point = new Point(0, 0);
		Set<Point> set = new HashSet<Point>();
		for (int steps : points) {
			if (steps <= 0) {
				throw new RuntimeException("point cannot be less than 0");
			}
			List<Point> plotPoints = Point.getPoints(point, dt, steps);
			for (Point point2 : plotPoints) {
				if (set.contains(point2)) {
					intersections++;
				} else {
					set.add(point2);
				}
			}
			point = plotPoints.get(plotPoints.size() - 1);
			dt = dt.next();
		}
		//set.stream().forEach(System.out::println);
		return intersections;
	}

	enum Direction {
		LEFT, UP, RIGHT, DOWN;

		Direction next() {
			return values()[(ordinal() + 1) % values().length];
		}
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public static List<Point> getPoints(Point p, Direction d, int steps) {
			List<Point> points = new ArrayList<MouseProblem.Point>();
			switch (d) {
			case UP:
				for (int i = 1; i <= steps; i++) {
					points.add(new Point(p.x, p.y + i));
				}
				break;
			case RIGHT:
				for (int i = 1; i <= steps; i++) {
					points.add(new Point(p.x + i, p.y));
				}
				break;
			case DOWN:
				for (int i = 1; i <= steps; i++) {
					points.add(new Point(p.x, p.y - i));
				}
				break;
			case LEFT:
				for (int i = 1; i <= steps; i++) {
					points.add(new Point(p.x - i, p.y));
				}
			}
			return points;
		}

		@Override
		public String toString() {
			return "Point p is " + x + " " + y;
		}

		@Override
		public int hashCode() {
			return x + y;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == this)
				return true;
			if (!(obj instanceof Point))
				return false;
			Point p = (Point) obj;
			return x == p.x && y == p.y;
		}
	}

}

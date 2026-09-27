package com.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseSchedule {

	// Global visited Set to store all courses along the current DFS path
	Set<Integer> visited = new HashSet<>();

	// Global Map to map each course to prerequisite list
	Map<Integer, List<Integer>> map = new HashMap<>();

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		for (int idx = 0; idx < numCourses; idx++) {
			map.putIfAbsent(idx, new ArrayList<>());
		}

		for (int[] prereq : prerequisites) {
			map.get(prereq[0]).add(prereq[1]);
		}

		for (int course = 0; course < numCourses; course++) {
			if (!dfs(course)) {
				return false;
			}
		}

		return true;
	}

	public boolean dfs(int currCourse) {
		if (visited.contains(currCourse)) {
			return false;
		}

		if (map.get(currCourse).isEmpty()) {
			return true;
		}

		visited.add(currCourse);

		for (Integer pre : map.get(currCourse)) {
			if (!dfs(pre)) {
				return false;
			}
		}

		visited.remove(currCourse);
		map.put(currCourse, new ArrayList<>());

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CourseSchedule cs = new CourseSchedule();
		
		int numCourses1=2;
		int[][] prerequisites1= {{0,1}};
		
		System.out.println(cs.canFinish(numCourses1, prerequisites1));
		
		int numCourses2=5;
		int[][] prerequisites2= {{0,1}, {0,2}, {1,3}, {1,4}, {3,4}};
		
		System.out.println(cs.canFinish(numCourses2, prerequisites2));
		
		int numCourses3=3;
		int[][] prerequisites3= {{0,1}, {1,2}, {2,0}};
		
		System.out.println(cs.canFinish(numCourses3, prerequisites3));
		

	}

}

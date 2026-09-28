class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Set<Integer> cycle = new HashSet<>();
		Set<Integer> visited = new HashSet<>();
		List<Integer> output = new ArrayList<>();

		Map<Integer, List<Integer>> prereqMap = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            prereqMap.put(i, new ArrayList<Integer>());
        }

        for (int[] prereq : prerequisites) {
            prereqMap.get(prereq[0]).add(prereq[1]);
        }

        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course, prereqMap, cycle, visited, output)) {
                return new int[0];
            }
        }

        int[] result = new int[numCourses];
        for (int i = 0; i < result.length; i++) {
            result[i] = output.get(i);
        }

        return result;
    }

    public boolean dfs(int curCourse, Map<Integer, List<Integer>> prereqMap, Set<Integer> cycle, Set<Integer> visited,
			List<Integer> output) {
        if (cycle.contains(curCourse))
            return false;

        if (visited.contains(curCourse))
            return true;

        cycle.add(curCourse);

        for (Integer preq : prereqMap.get(curCourse)) {
            if (!dfs(preq, prereqMap, cycle, visited, output)) {
                return false;
            }
        }

        cycle.remove(curCourse);
        visited.add(curCourse);
        output.add(curCourse);

        return true;
    }
}

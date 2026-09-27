class Solution {
    // Global visited Set to store all courses along the current  DFS path
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
        if (visited.contains(currCourse))
            return false;

        if (map.get(currCourse).isEmpty())
            return true;

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
}

import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        // Initialize graph
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph
        // [a, b] means b -> a
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];

            graph.get(prereq).add(course);
            indegree[course]++;
        }

        // Add courses with no prerequisites
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;

        // BFS Topological Sort
        while (!queue.isEmpty()) {
            int current = queue.poll();
            result[index++] = current;

            for (int next : graph.get(current)) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // If all courses are processed, return the order
        if (index == numCourses) {
            return result;
        }

        // Cycle exists, so it's impossible
        return new int[0];
    }
}
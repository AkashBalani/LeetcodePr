class Solution{
    public int[] findOrder(int numCourses, int[][] prerequisites) { 
        if (numCourses == 0) return null;
        // Convert graph presentation from edges to indegree of adjacent list.
        int indegree[] = new int[numCourses], order[] = new int[numCourses], index = 0;
        for (int i = 0; i < prerequisites.length; i++) // Indegree - how many prerequisites are needed.
            indegree[prerequisites[i][0]]++;    
    
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) 
            if (indegree[i] == 0) {
                // Add the course to the order because it has no prerequisites.
                order[index++] = i;
                queue.offer(i);
            }
    
        // How many courses don't need prerequisites. 
        while (!queue.isEmpty()) {
            int prerequisite = queue.poll(); // Already finished this prerequisite course.
            for (int i = 0; i < prerequisites.length; i++)  {
                if (prerequisites[i][1] == prerequisite) {
                    indegree[prerequisites[i][0]]--; 
                    if (indegree[prerequisites[i][0]] == 0) {
                        // If indegree is zero, then add the course to the order.
                        order[index++] = prerequisites[i][0];
                        queue.offer(prerequisites[i][0]);
                    }
                } 
            }
        }
    
        return (index == numCourses) ? order : new int[0];
    }
}

/*
    numCourses = 2, prerequisites = [[1,0]], indegree[] = new int[2], order[] = new int[2], index = 0
    findOrder(int numCourses, int[][] prerequisites) -> findOrder(2, [[1, 0]])
        if (numCourses == 0) -> if(F)
            for(int i = 0; i < 1; i++)
                indegree[1]++;
/*
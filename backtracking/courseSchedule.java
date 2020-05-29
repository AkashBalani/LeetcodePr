class Solution{
    public boolean canFinish(int numCourses, int[][] prerequisites){
        HashMap<Integer, List<Integer>> courseDict = new HashMap<>();
        for(int[] relation : prerequisites){
            if (courseDict.containsKey(relation[1])) {
                courseDict.get(relation[1]).add(relation[0]);
            } else {
                List<Integer> nextCourses = new LinkedList<>();
                nextCourses.add(relation[0]);
                courseDict.put(relation[1], nextCourses);
            }
        }
    
    boolean[] path = new boolean[numCourses];

    for (int currCourse = 0; currCourse < numCourses; ++currCourse) {
        if (this.isCyclic(currCourse, courseDict, path)) {
            return false;
        }
    }

    return true;
    }

    protected boolean isCyclic(
      Integer currCourse,
      HashMap<Integer, List<Integer>> courseDict,
      boolean[] path) {

    if (path[currCourse]) {
      // come across a previously visited node, i.e. detect the cycle
      return true;
    }

    // no following courses, no loop.
    if (!courseDict.containsKey(currCourse))
      return false;

    // before backtracking, mark the node in the path
    path[currCourse] = true;

    // backtracking
    boolean ret = false;
    for (Integer nextCourse : courseDict.get(currCourse)) {
      ret = this.isCyclic(nextCourse, courseDict, path);
      if (ret)
        break;
    }
    // after backtracking, remove the node from the path
    path[currCourse] = false;
    return ret;
  }
}
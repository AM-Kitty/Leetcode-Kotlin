class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        // Keywords: Graph (DFS), Map

        val courseGraph: HashMap<Int, MutableList<Int>> = hashMapOf()
        val courseVisitedSet = hashSetOf<Int>()

        // build the graph
        for (idx in 0..numCourses-1){
            courseGraph[idx] = mutableListOf()
        }

        // build the graph for course -> prerequisites of that course
        for (coursePair in prerequisites){
            courseGraph[coursePair[0]]!!.add(coursePair[1])
        }

        for(edge in prerequisites){
            if(!dfs(courseGraph, edge[0], courseVisitedSet)) return false
        }
        return true

    }

    fun dfs(graph: HashMap<Int, MutableList<Int>>, course: Int, courseVisitedSet: HashSet<Int>): Boolean{
        if (courseVisitedSet.contains(course)) return false

        // no prerequisites needed for this course
        if (graph[course]!!.size == 0) return true

        courseVisitedSet.add(course)

        for (eachNeedPrereqCourse in graph[course]!!){
            if(!dfs(graph, eachNeedPrereqCourse, courseVisitedSet)) return false
        }

        // after check the course, the course is good to not to be checked again
        courseVisitedSet.remove(course)
        graph[course]!!.clear()
        return true
    }
}
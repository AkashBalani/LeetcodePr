import java.util.Arrays;

class Solution{
    public int[][] kClosest(int[][] points, int K){
        int N = points.length;
        int[] dists = new int[N];
        for(int i = 0; i < N; i++)
            dists[i] = dist(points[i]);
        
        Arrays.sort(dists);
        int distK = dists[K-1];
        int t = 0;
        int[][] ans = new int[K][2];
        for(int i = 0; i < N; i++){
            if(dist(points[i]) < distK)
                ans[t++] = points[i];
        }
        return ans;
    }
    public int dist(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }
}

class Solution{
    public int[][] kClosest(int[][] points){
        Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] + p2[1] * p2[1]);
        return Arrays.copyOfRange(points, 0, K);
    }
}
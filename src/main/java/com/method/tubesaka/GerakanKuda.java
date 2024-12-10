package com.method.tubesaka;

public class GerakanKuda {
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    
    public int HitungLangkahBFS(int n, int x1, int y1, int x2, int y2, int k) {
        /////////////////////////////////////////////////////////////////////////// BELOM
    }
    
    public int HitungLangkahDFS(int n, int x, int y, int x2, int y2, int k) {
        if (x < 0 || x >= n || y < 0 || y >= n || k < 0){
            return 0;
        }
        if (x == x2 && y == y2 && k == 0){
            return 1;
        }
        if (k == 0){
            return 0;
        }

        int ways = 0;
        for (int i = 0; i < 8; i++) {
            ways += HitungLangkahDFS(n, x + dx[i], y + dy[i], x2, y2, k - 1);
        }
        return ways;
    }
}

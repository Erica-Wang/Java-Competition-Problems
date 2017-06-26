/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classz20;
import java.util.*;
import java.io.*;
/**
 *
 * @author moyangwang
 */
public class lineGraph {
    static int [] p;
    static int [] rk;
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        p = new int [n+1];
        rk = new int [n+1];
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
        for (int i = 1; i+k<=n; i++) {
            int fx = find(i);
            int fy = find(i+k);
            if (fx!=fy) {
                union(fx, fy);
            }
        }
        ArrayList<edge> last = new ArrayList();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n; i++) {
            last.add(new edge(i, i+1, Integer.parseInt(st.nextToken())));
        }
        Collections.sort(last);
        int ans = 0;
        for (int c = n-k, i = 0; c < n-1; i++) {
            int fx = find(last.get(i).u);
            int fy = find(last.get(i).v);
            if (fx!=fy) {
                union(fx, fy);
                c++;
                ans+=last.get(i).w;
            }
        }
        System.out.println(ans);
    }
    static class edge implements Comparable<edge> {
        int u, v, w;
        edge(int u0, int v0, int w0) {
            u = u0;
            v = v0;
            w = w0;
        }
        
        @Override
        public int compareTo(edge x) {
            return this.w - x.w;
        }
    }
    static int find (int x) {
        if (x!=p[x]) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
    static void union(int x, int y) {
        if (rk[x] > rk[y]) {
            p[y] = x;
        }
        else {
            p[x] = y;
            if(rk[x]==rk[y]) {
                rk[y]++;
            }
        }
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classz26;
import java.util.*;
/**
 *
 * @author moyangwang
 */
public class ShortestPathPriorityQueue {
    
    public static void print(int [] arr){
        for(int i = 1; i<arr.length;i++){
            if(arr[i]==90000000){
                System.out.println(-1);
            }else{
                System.out.println(arr[i]);
            }
        }
    }
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int [][] map = new int [n+1][n+1];
        for(int i = 0; i<=n; i++){
            for(int u = 0; u<=n; u++){
                map[i][u]=1000000;
            }
        }
        for(int i = 0; i<m; i++){
            int a = input.nextInt();
            int b = input.nextInt();
            int c = input.nextInt();
            if(map[a][b]==0||map[a][b]>c){
                map[a][b]=c;
                map[b][a]=c;
            }
        }
        int [] dis = new int[n+1];
        Arrays.fill(dis,90000000);
        PriorityQueue<edge> pq = new PriorityQueue();
        pq.add(new edge(1,0));
        boolean[] vis = new boolean[n+1];
        int cur=-1;
        while(!pq.isEmpty()){
            edge e = pq.poll();
            if(dis[e.v]<e.c) continue;
            cur=e.v;
            dis[cur]=e.c;
            vis[cur]=true;
            for(int u = 1; u<=n; u++){
                if(!vis[u]&&map[cur][u]!=1000000){
                    if(dis[u]>map[cur][u]+dis[cur]){
                        pq.add(new edge(u,map[cur][u]+dis[cur]));
                    }
                }
            }
        }
        print(dis);
    }
    
    static class edge implements Comparable<edge>{
        int v,c;
        public edge(int vv, int cc){
            v = vv;
            c = cc;
        }
        
        @Override
        public int compareTo(edge x){
            return this.c-x.c;
        }
        
        @Override
        public String toString(){
            return this.v+" "+this.c;
        }
    }
}

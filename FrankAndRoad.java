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
public class FrankAndRoad {
    public static void print(int [] arr){
        for(int i = 0; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void print (ArrayList<edge>[]arr){
        for(int i = 0; i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        int n = input.nextInt();
        int m = input.nextInt();
        int g = input.nextInt();
        ArrayList<Integer> store = new ArrayList();
        for(int i = 0; i<g; i++){
            store.add(input.nextInt());
        }
        
        ArrayList<edge>[] map = new ArrayList[n+1];
        
        for(int i = 0; i<=n; i++){
            map[i] = new ArrayList();
        }
        for(int i = 0; i<m; i++){
            int a = input.nextInt();
            int b = input.nextInt();
            int c = input.nextInt();
            map[a].add(new edge(b,c));
        }
        int [] dis = new int[n+1];
        Arrays.fill(dis,90000000);
        PriorityQueue<edge> pq = new PriorityQueue();
        pq.add(new edge(0,0));
        boolean[] vis = new boolean[n+1];
        int cur=-1;
        while(!pq.isEmpty()){
            edge e = pq.poll();
            if(dis[e.v]<e.c) continue;
            cur=e.v;
            dis[cur]=e.c;
            vis[cur]=true;
            
            for(int u = 0; u<map[cur].size(); u++){
                edge ed = map[cur].get(u);
                if(!vis[ed.v]&&ed.c!=1000000){
                    if(dis[ed.v]>ed.c+dis[cur]){
                        pq.add(new edge(ed.v,ed.c+dis[cur]));
                    }
                }
            }
        }
        int count = 0;
        for(int i = 0; i<g; i++){
            if (dis[store.get(i)]<=t){
                count++;
            }
        }
        System.out.println(count);
    }
    static class edge implements Comparable<edge>{
        int c,v;
        public edge(int vv, int cc){
            v = vv;
            c = cc;
        }
        
        @Override
        public int compareTo(edge e){
            return e.c-this.c;
        }
        @Override
        public String toString(){
            return this.v+" "+this.c;
        }
    }
}

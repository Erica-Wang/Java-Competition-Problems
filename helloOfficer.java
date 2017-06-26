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
public class helloOfficer {
    public static void print(int [] arr){
        for(int i = 0; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void print(boolean [] arr){
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
    public static void main (String[]args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int b = input.nextInt();
        int q = input.nextInt();
        ArrayList<edge>[] map = new ArrayList[n+1];
        for(int i = 0; i<=n; i++){
            map[i]= new ArrayList();
        }
        for(int i = 0; i<m; i++){
            int a = input.nextInt();
            int bb = input.nextInt();
            int c = input.nextInt();
            map[a].add(new edge(bb,c));
            map[bb].add(new edge(a,c));
        }

        int [] dis = new int[n+1];
        Arrays.fill(dis,90000000);
        PriorityQueue<edge> pq = new PriorityQueue();
        pq.add(new edge(b,0));
        boolean[] vis = new boolean[n+1];
        int cur=-1;
        while(!pq.isEmpty()){
//            print(dis);
            edge e = pq.poll();
            if(dis[e.v]<e.c) continue;
            cur=e.v;
            dis[cur]=e.c;
            vis[cur]=true;
            for(int u = 0; u<map[cur].size(); u++){
                edge ed = map[cur].get(u);
                if(!vis[ed.v]){
                    if(dis[ed.v]>ed.c+dis[cur]){
                       pq.add(new edge(ed.v,ed.c+dis[cur]));
//                       System.out.println("pq"+pq);
                    }
                }
            }
//            System.out.println(pq);
        }
        
        for(int i = 0; i<q; i++){
            int a = input.nextInt();
            if(dis[a]==90000000){
                System.out.println(-1);
            }else{
                System.out.println(dis[a]);
            }
        }
        
    }
    static class edge implements Comparable<edge>{
        int c,v;
        public edge(int vv, int cc){
            v = vv;
            c = cc;
        }
        
        @Override
        public int compareTo(edge e){
            return this.c-e.c;
        }
        @Override
        public String toString(){
            return this.v+" "+this.c;
        }
    }
}
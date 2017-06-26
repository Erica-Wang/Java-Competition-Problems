/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classz24;
import java.util.*;
/**
 *
 * @author moyangwang
 */
public class shopAndShip {
    public static void print(int [] arr){
        for(int i = 1; i<arr.length;i++){
            if(arr[i]==1000000){
                System.out.print(-1+" ");
            }else{
                System.out.print(arr[i]+" ");
            }
        }
        System.out.println();
    }
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int t = input.nextInt();
        ArrayList<edge> [] map = new ArrayList[n+1];
        for(int i = 0; i<=n; i++){
            map[i]=new ArrayList();
        }
        for(int i = 0; i<t; i++){
            int a = input.nextInt();
            int b = input.nextInt();
            int c = input.nextInt();
            map[a].add(new edge(b,c));
            map[b].add(new edge(a,c));
        }
        int k = input.nextInt();
        int [] cost = new int[n+1];
        Arrays.fill(cost, 1000000);
        for(int i = 0; i<k; i++){
            int a = input.nextInt();
            int c = input.nextInt();
            cost[a]=c;
        }
        
        int [] dis = new int[n+1];
        Arrays.fill(dis,1000000);
        int d = input.nextInt();
        
        dis[d]=0;
        boolean[] vis = new boolean[n+1];
        int cur=-1;
        for(int i = 0; i<n; i++){
            int min = 10000000;
            for(int u = 1; u<=n; u++){
                if(!vis[u]){
                    if(dis[u]<min){
                        min = dis[u];
                        cur = u;
                    }
                }
            }
            vis[cur]=true;
            for(int u = 0; u<map[cur].size(); u++){
                edge e = map[cur].get(u);
                if(dis[e.v]>dis[cur]+e.c){
                    dis[e.v]=dis[cur]+e.c;
                }
            }
        }
        
        int min = 10000000;
        for(int i = 1; i<=n; i++){
            int co = cost[i]+dis[i];
            if(co<min){
                min = co;
            }
        }
        System.out.println(min);
    }
    
    static class edge{
        public int v, c;
        public edge(int vv, int cc){
            v = vv;
            c = cc;
        }
       public edge(){
            v = -1;
            c = -1;
        }
    }
}

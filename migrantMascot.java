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
public class migrantMascot {
    public static void print(long [] arr){
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
    public static void main (String [] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        
        ArrayList<edge> [] map = new ArrayList[n+1];
        for(int i = 1; i<map.length; i++){
            map[i]=new ArrayList();
        }
        for(int i = 0; i<m; i++){
            int a = input.nextInt();
            int b = input.nextInt();
            int p = input.nextInt();
            map[a].add(new edge(b,p));
            map[b].add(new edge(a,p));
        }
        long [] dis = new long[n+1];
        Arrays.fill(dis,-1);
        dis[1]=(long)Math.pow(10, 15);
        boolean[] vis = new boolean[n+1];
        int cur=-1;
        
//        for(int i = 0; i<map[1].size();i++){
//            vis[1]=true;
//            edge e = map[1].get(i);
//            dis[e.v]=e.c;
//        }
        
        for(int i = 0; i<n; i++){
            long max = -1;
            cur = -1;
            for(int u = 1; u<=n; u++){
                if(!vis[u]){
                    if(dis[u]>max){
                        max = dis[u];
                        cur = u;
                    }
                }
            }
            
            if (cur==-1)
                break;
            
            vis[cur]=true;
            for(int u = 0; u<map[cur].size(); u++){
                edge e = map[cur].get(u);
                long value = Math.min(e.c, dis[cur]);
                if(!vis[e.v]){
                    if(dis[e.v]<value){
                        dis[e.v]=value;
                    }
                }
            }
        }
        dis[1]=0;
        for(int i = 1; i<dis.length; i++){
            System.out.println(dis[i]);
        }
        
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
        
        public String toString(){
            return v+" "+c;
        }
    }
}

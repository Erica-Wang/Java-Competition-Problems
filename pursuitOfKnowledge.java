/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classz10;
import java.util.*;
/**
 *
 * @author ericawang
 */
public class pursuitOfKnowledge {
    
    
    public static void main(String [] args){
        
        Scanner input = new Scanner(System.in);
        
        int n = input.nextInt();
        int m = input.nextInt();
        int t = input.nextInt();
        
        ArrayList<Integer>[] roads = new ArrayList[n+1];
        
        for(int i = 0; i<=n; i++){
            roads[i] = new ArrayList();
        }
        
        for(int i = 0; i<m; i++){
            int a = input.nextInt();
            int b = input.nextInt();
            roads[a].add(b);
        }
        
        int q = input.nextInt();
        for(int NUM = 0; NUM<q; NUM++){
            
            int a = input.nextInt();
            int b = input.nextInt();
            

            int [] value = new int [n+1];
            boolean [] been = new boolean [n+1];
            Queue<Integer> qu = new LinkedList();
            
            value[a]=0;
            for(int i = 0; i<roads[a].size();i++){
                qu.add(roads[a].get(i));
                been[roads[a].get(i)]=true;
                value[roads[a].get(i)]=value[a]+1;
            }
            
            int tr = 0;
            
            loop: while(!qu.isEmpty()){
                
                int curr = qu.poll();
                for(int i = 0; i<roads[curr].size();i++){
                    if(!been[roads[curr].get(i)]){
                        been[roads[curr].get(i)]=true;
                        value[roads[curr].get(i)]=value[curr]+1;
                        qu.add(roads[curr].get(i));
                    }
                }
                
                if(curr==b){
                    System.out.println(value[b]*t);
                    tr = 1;
                    break loop;
                }
            }
            
            if(tr==0){
                System.out.println("Not enough hallways!");
            }
        }
        //        for (int NUM = 0; NUM < q; NUM++) {
//            int start = input.nextInt();
//            int end = input.nextInt();
//            int dis = BFS(start, end);
//            if (dis>=0) System.out.println(dis*t);
//            else System.out.println("Not enough hallways!");
//            
//        }
//    }
//    public static int BFS (int start, int end) {
//        boolean [] vis = new boolean[n+1];
//        int [] dis = new int [n+1];
//        Queue<Integer> q = new LinkedList<Integer>();
//        q.add(start);
//        vis[start] = true;
//        dis[start]=0;
//        while (!q.isEmpty()) {
//            int cur = q.poll();
//            for (int v : adj[cur]) {
//                if (!vis[v]) {
//                    vis[v] = true;
//                    dis[v] = dis[cur]+1;
//                    q.add(v);
//                }
//                if (v == end) return dis[end];
//            }
//        }
//        return -1;
//    }
//    
//}
    }
}

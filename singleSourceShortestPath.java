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
public class singleSourceShortestPath {
    public static void print(int [] arr){
        for(int i = 1; i<arr.length;i++){
            if(arr[i]==1000000){
                System.out.println(-1);
            }else{
                System.out.println(arr[i]);
            }
        }
    }
    public static void main(String []args){
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
        Arrays.fill(dis,1000000);
        dis[1]=0;
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
            for(int u = 1; u<=n; u++){
                if(dis[u]>dis[cur]+map[cur][u]){
                    dis[u]=dis[cur]+map[cur][u];
                }
            }
        }
        print(dis);
    }
}

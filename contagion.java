/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classz25;
import java.io.*;
import java.util.*;
/**
 *
 * @author moyangwang
 */
public class contagion {
    public static void print(int [] arr){
        for(int i = 0; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void print (int [][]arr){
        for(int i = 0; i<arr.length;i++){
            for(int u = 0; u<arr[0].length;u++){
                System.out.print(arr[i][u]+" ");
            }
            System.out.println();
        }
    }
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] coor = new int [n+1][2];
        long [][] map = new long [n+1][n+1];
        for(int i = 1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            coor[i][0] = x;
            coor[i][1] = y;
            for(int u = 1; u<i; u++){
                long value = (long)Math.pow(Math.abs(coor[i][0]-coor[u][0]),2)+
                        (long)Math.pow(Math.abs(coor[i][1]-coor[u][1]), 2);
                map[i][u]=value;
                map[u][i]=value;
            }
        }
        int x = Integer.parseInt(br.readLine());
        long [] dis = new long[n+1];
        Arrays.fill(dis,(long)Math.pow(10, 13));
        dis[x]=0;
        boolean[] vis = new boolean[n+1];
        int cur=-1;
        for(int i = 0; i<n; i++){
            long min = (long)Math.pow(10, 13);
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
        Arrays.sort(dis);
        int q = Integer.parseInt(br.readLine());
        for(int i = 0; i<q; i++){
            long a = Long.parseLong(br.readLine());
            int l = Arrays.binarySearch(dis, a);
            if(l<0){
                int res = (l+1)*-1;
                if(res==3001){
                    System.out.println(3000);
                }else{
                    System.out.println(res);
                }
            }else{
                for(int u = l; u<dis.length; u++){
                    if(dis[u]>a){
                        break;
                    }
                    l = u;
                }
                if(l==3000){
                    System.out.println(3000);
                }else{
                    System.out.println(l+1);
                }
            }
        }
    }
}


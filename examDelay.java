/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classz25;
import java.util.*;
/**
 *
 * @author moyangwang
 */
public class examDelay {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int v = input.nextInt();
        int e = input.nextInt();
        double [] [] map = new double [v+1][v+1];
        for(int i = 0; i<e; i++){
            int m = input.nextInt();
            int n = input.nextInt();
            double t = input.nextDouble() / input.nextDouble()*60;
            if(map[m][n]==0||map[m][n]>t){
                map[m][n]=t;
                map[n][m]=t;
            }
        }
        
        double [] dis = new double[v+1];
        Arrays.fill(dis,1000000);
        int [] pre = new int [v+1];
        Arrays.fill(pre, -1);
        dis[1]=0;
        boolean[] vis = new boolean[v+1];
        int cur=-1;
        for(int i = 0; i<v; i++){
            double min = 10000000;
            for(int u = 1; u<=v; u++){
                if(!vis[u]){
                    if(dis[u]<min){
                        min = dis[u];
                        cur = u;
                    }
                }
            }
            vis[cur]=true;
            for(int u = 1; u<=v; u++){
                if (map[cur][u]!=0){
                    if(dis[u]>dis[cur]+map[cur][u]){
                        dis[u]=dis[cur]+map[cur][u];
                        pre[u]=cur;
                    }
                }
            }
        }
        int ver = v;
        int preDes = pre[v];
        int count = 0;
        if(preDes!=-1){
            double value = 0;
            while (preDes!=-1){
                count++;
                ver = preDes;
                preDes = pre[ver];
            }
        }
        System.out.println(count);
        double delayed = dis[v]/3;
        int real = 0;
        if (delayed%1>=0.5){
            real = (int)delayed+1;
        }else{
            real = (int)delayed;
        }
        System.out.println(real);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classz35;
import java.util.*;
import Classz35.InputReader;
/**
 *
 * @author moyangwang
 */
public class bridgeCrossing {
    public static int findMax(int [] arr, int begin, int end){
        int max = arr[0];
        for(int i = begin; i<=end;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }
    public static void main(String[]args){
        InputReader input = new InputReader(System.in);
        int m = input.readInt();
        int n = input.readInt();
        String[] names = new String[n+1];
        int [] time = new int[n+1];
        for(int i = 1; i<=n; i++){
            names[i]=input.readString();
            time[i]=input.readInt();
        }
        int [] dp = new int [n+1];
        String [] order = new String [n+1]; //0=as new one
        for(int i = 1; i<=n; i++){
            order[i]="";
        }
        for(int i = 1; i<=m; i++){
            if(i>n){
                break;
            }
            dp[i]=findMax(time,1,i);
            for(int u = 0; u<i; u++){
                order[i]+="0";
            }
        }
        for(int i = m+1; i<=n; i++){
            int min = 10000000;
            int index = 0;
            for(int u = 1; u<=m; u++){
                int a = i-u;
                if(a<=0){
                    break;
                }
                int res = dp[a]+findMax(time,a+1,i);
                if(res<min){
                    min = res;
                    index = a;
                }
            }
            dp[i]=min;
            order[i]=order[index]+"1";
            for(int u = index+1; u<i; u++){
                order[i]+="0";
            }
        }
        System.out.println("Total Time: "+dp[n]);
        for(int i = 0; i<n; i++){
            char a = order[n].charAt(i);
            if(a=='1'){
                System.out.println();
            }
            System.out.print(names[i+1]+" ");
        }
    }
}

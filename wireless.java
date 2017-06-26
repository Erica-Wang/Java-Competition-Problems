/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classz32;
import java.util.*;
/**
 *
 * @author moyangwang
 */
public class wireless {
    public static void print (int [][]arr){
        for(int i = arr.length-1; i>=0;i--){
            for(int u = 0; u<arr[0].length;u++){
                System.out.print(arr[i][u]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int k = input.nextInt();
        int [][] value = new int [m+1][n+1];
        for(int i = 0; i<k; i++){
            int b = input.nextInt();
            int a = input.nextInt();
            int r = input.nextInt();
            int bi = input.nextInt();
            if(a-r>0){
                value[a-r][b]+=bi;
                if(b+1<=n)
                    value[a-r][b+1]-=bi;
            }
            if(a+r<=m){
                value[a+r][b]+=bi;
                if(b+1<=n)
                    value[a+r][b+1]-=bi;
            }
            for(int u=1; u<r*2; u++){
                int row = a-r+u;
                if(row<=0) continue;
                if(row>m) continue;
                int widthHalf = (int)Math.sqrt(r*r-(r-u)*(r-u));
                if(b-widthHalf>0){
                    value[row][b-widthHalf]+=bi;
                }
                else
                    value[row][1]+=bi;
                if(b+widthHalf+1<=n)
                    value[row][b+widthHalf+1]-=bi;
            }
        }
        
        for(int i = 1; i<=m; i++){
            for(int u = 2; u<=n; u++){
                value[i][u]+=value[i][u-1];
            }
        }
        
        int max = -1;
        int count = 0;
        for(int i = 1; i<=m; i++){
            for(int u = 1; u<=n; u++){
                if(value[i][u]>max){
                    max = value[i][u];
                    count=1;
                }else if(value[i][u]==max){
                    count++;
                }
            }
        }
        System.out.println(max+"\n"+count);
        
    }
}

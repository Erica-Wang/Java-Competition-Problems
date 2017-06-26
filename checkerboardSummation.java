/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classz31;
import java.util.*;
import Classz31.InputReader;
/**
 *
 * @author moyangwang
 */
public class checkerboardSummation {
    public static void print (int [][]arr){
        for(int i = 0; i<arr.length;i++){
            for(int u = 0; u<arr[0].length;u++){
                System.out.print(arr[i][u]+" ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[]args){
        InputReader input = new InputReader(System.in);
        int m = input.readInt();
        int n = input.readInt();
        int [][] map = new int [3003][3003];
        
        int r = input.readInt();
        int c = input.readInt();
        int x = input.readInt();
        while(r!=0&&c!=0){
            map[r][c]=x;
            r = input.readInt();
            c = input.readInt();
            x = input.readInt();
        }
        
        int [][] first = new int [m+1][n+1];
        int [][] second = new int [m+1][n+1];
        for(int i = 1; i<=m; i++){
            for(int u = 1; u<=n; u++){
                if((i+u)%2==0){
                    //first
                    first[i][u]=map[i][u];
                }else{
                    //second
                    second[i][u]=map[i][u];
                }
                first[i][u]+=(first[i-1][u]+first[i][u-1]-first[i-1][u-1]);
                second[i][u]+=(second[i-1][u]+second[i][u-1]-second[i-1][u-1]);
            }
        }
        int r1 = input.readInt();
        int c1 = input.readInt();
        int r2 = input.readInt();
        int c2 = input.readInt();
        while(r1!=0&&c1!=0&&r2!=0&&c2!=0){
            int value1, value2;
            value1=first[r2][c2]-first[r1-1][c2]-first[r2][c1-1]+first[r1-1][c1-1];
            value2=second[r2][c2]-second[r1-1][c2]-second[r2][c1-1]+second[r1-1][c1-1];
            
            if((r1+c1)%2==0){
                //add first
                System.out.println(value1-value2);
            }else{
                //add second
                System.out.println(value2-value1);
            }
            
            r1 = input.readInt();
            c1 = input.readInt();
            r2 = input.readInt();
            c2 = input.readInt();
        }
    }
}

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
public class blackAndWhite {
    public static void print (short [][]arr){
        for(int i = 0; i<arr.length;i++){
            for(int u = 0; u<arr[0].length;u++){
                System.out.print(arr[i][u]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[]args){
        InputReader input = new InputReader(System.in);
        int n = input.readInt();
        int m = input.readInt();
        short [][] diff = new short[n][n];
        //first column represents colour
        // false = black; true = white
        //all the columns after represents if changed
        // false = did not change colour; true = = change colour
        
        for(int i = 0; i<m; i++){
            int x = input.readInt();
            int y = input.readInt();
            int w = input.readInt();
            int h = input.readInt();
            diff[x][y]++;
            if((x+w)<n)
                diff[x+w][y]--;
            if((y+h)<n)
                diff[x][y+h]--;
            if((x+w)<n&&(y+h)<n)
                diff[x+w][y+h]++;
        }
        for(int i = 1; i<n; i++){
            diff[i][0]=(short)((int)diff[i-1][0]+(int)diff[i][0]%2);
            diff[0][i]=(short)((int)diff[0][i-1]+(int)diff[0][i]%2);
        }
        for(int i = 1; i<n; i++){
            for(int u = 1; u<n; u++){
                diff[i][u]=(short)(Math.abs(((int)diff[i][u]+(int)diff[i-1][u]+(int)diff[i][u-1]-(int)diff[i-1][u-1])%2));
            }
        }
        
        long count = 0;
        for(int i = 0; i<n; i++){
            for(int u = 0; u<n; u++){
                if(diff[i][u]%2==1){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}

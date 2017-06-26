/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classz22;
import java.util.*;
import java.io.*;

/**
 *
 * @author moyangwang
 */
public class GGG {
    public static void print(int [] arr){
        for(int i = 0; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main (String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] listn = new int [1000001];
        for(int i = 0; i<n; i++){
            listn[Integer.parseInt(st.nextToken())] = i+1;
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int [] increase = new int [1000001];
        int ind = -1;
        for(int i = 0; i<m; i++){
            int cur = listn[Integer.parseInt(st.nextToken())]-1;
            if(ind!=-1&&cur!=-1){
                if(cur>increase[ind]){
                    ind++;
                    increase[ind]=cur;
                }else{
                    int index = (Arrays.binarySearch(increase,0,ind+1, cur)+1)*-1;
                    //int index = least(increase,cur);
                    increase[index]=cur;
                }
            }else if(cur!=-1){
                ind++;
                increase[ind]=cur;
            }
        }
        System.out.println(ind+1);
        
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classz30;
import java.util.*;
/**
 *
 * @author moyangwang
 */
public class specialDelivery {
    public static void print(int [] arr){
        for(int i = 0; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        if(x==1){
            int d = input.nextInt();
            int n = input.nextInt();
            int p = input.nextInt();
            int[] pValue = new int [d+1];
            int[] value = new int [d+1];
            for(int i = 0; i<p; i++){
                int loc = input.nextInt();
                int val = input.nextInt();
                pValue[loc]=val;
            }
            pValue[0]=n;
            int index = 0;
            value[1]=1;
            value[n+1]=-1;
            for(int i = 1; i<=d; i++){
                int pv = pValue[i];
                if(pv!=0){
                    for(int u = index; u<i; u++){
                        value[u+1]+=value[u]%((int)Math.pow(10, 9)+7);
                    }
                    value[i+1]+=value[i]%((int)Math.pow(10, 9)+7);
                    if(i+pv<d) value[i+pv+1]-=value[i]%((int)Math.pow(10, 9)+7);
                    index = i;
                }
            }
            for(int u = index; u<d; u++){
                value[u+1]=value[u]%((int)Math.pow(10, 9)+7);
            }
            //print(value);
            System.out.println(value[d]%((int)Math.pow(10, 9)+7));
        }else{
            
        }
    }
}
// 0 1 2 2 2 4 7 11 11 11 11
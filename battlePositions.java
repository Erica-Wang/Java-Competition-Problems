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
public class battlePositions {
    public static void main(String[]args){
        InputReader input = new InputReader(System.in);
        int n = input.readInt();
        int k = input.readInt();
        int j = input.readInt();
        
        int [] diff = new int [n+1];
        for(int i = 0; i<j; i++){
            int a = input.readInt();
            int b = input.readInt();
            int x = input.readInt();
            diff[a]+=x;
            if((b+1)<=n){
                diff[b+1]-=x;
            }
        }
        int count = 0;
        for(int i = 1; i<=n; i++){
            diff[i]+=diff[i-1];
            if(diff[i]<k){
                count++;
            }
        }
        System.out.println(count);
    }
}

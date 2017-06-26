/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classz33;
import java.util.*;
/**
 *
 * @author moyangwang
 */
public class barkingDogs {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int d = input.nextInt();
        int [] waitTime = new int [d+1];
        for(int i = 0; i<d; i++){
            waitTime[i+1]=input.nextInt();
        }
        ArrayList<Integer> [] child = new ArrayList[d+1];
        int f = input.nextInt();
        for(int i = 0; i<f; i++){
            child[input.nextInt()].add(input.nextInt());
        }
        
        int t = input.nextInt();
        
        int [] condition = new int [d+1];
        Arrays.fill(condition, -1);
        condition[1]=0;
        for(int i = 0; i<=t; i++){
            for(int u = 1; u<=d; u++){
                if(condition[u]==0){
                    
                }else{
                    
                }
            }
        }
    }
}

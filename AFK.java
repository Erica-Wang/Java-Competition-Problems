/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classz11;
import java.util.*;
/**
 *
 * @author ericawang
 */
public class AFK {
    
    public static void print (boolean [][]arr){
        for(int i = 0; i<arr.length;i++){
            for(int u = 0; u<arr[0].length;u++){
                System.out.print(arr[i][u]+" ");
            }
            System.out.println();
        }
    }
    
    public static boolean [][] clone (boolean [][] arr){
        boolean [][] result = new boolean [arr.length][arr[0].length];
        for (int i = 0; i<arr.length; i++){
            result[i]=arr[i].clone();
        }
        return result;
    }
    
    public static void main (String [] args){
        
        Scanner input = new Scanner(System.in);
        
        int nu = input.nextInt();
        for(int num = 0; num<nu; num++){
            
            int w = input.nextInt();
            int h = input.nextInt();
            String [] map = new String [h];
            for(int i = 0; i<h; i++){
                map[i]=input.next();
            }
            
            int cw = 0, ch = 0, ww = 0, wh = 0;
            for(int i = 0; i<h; i++){
                for(int u = 0; u<w; u++){
                    if(map[i].charAt(u)=='C'){
                        cw = u;
                        ch = i;
                    }else if(map[i].charAt(i)=='W'){
                        ww = u;
                        wh = i;
                    }
                }
            }
            
            ArrayList<Integer> result = new ArrayList();
            
            Stack<Integer> width = new Stack();
            Stack<Integer> height = new Stack();
            Stack<Integer> count = new Stack();
            Stack<boolean [][]> been = new Stack();
            
            height.add(ch);
            width.add(cw);
            count.add(0);
            boolean[][] be = new boolean [h][w];
            be[ch][cw]=true;
            been.add(be);
            
            while(!height.isEmpty()){
                int he = height.peek();
                height.pop();
                int wi = width.peek();
                width.pop();
                int co = count.peek();
                count.pop();
                be = been.peek();
                been.pop();
                
                System.out.println(he+" "+wi);
                print(be);
                
                if(he==wh&&wi==ww){
                    result.add(co);
                }else{
                    
                    boolean [][] t = clone(be);
                    
                    if(he>0){
                        if(map[he-1].charAt(wi)!='W'){
                            width.add(wi);
                            height.add(he-1);
                            count.add(co+1);
                            t[he-1][wi]=true;
                            been.add(t);
                        }
                    }
                    t = clone(be);
                    if(he<h-1){
                        if(map[he+1].charAt(wi)!='W'){
                            width.add(wi);
                            height.add(he+1);
                            count.add(co+1);
                            t[he+1][wi]=true;
                            been.add(t);
                        }
                    }
                    t = clone(be);
                    if(wi>0){
                        if(map[he].charAt(wi-1)!='W'){
                            width.add(wi-1);
                            height.add(he);
                            count.add(co+1);
                            t[he][wi-1]=true;
                            been.add(t);
                        }
                    }
                    t = clone(be);
                    if(wi<w-1){
                        if(map[he].charAt(wi+1)!='W'){
                            width.add(wi+1);
                            height.add(he);
                            count.add(co+1);
                            t[he][wi+1]=true;
                            been.add(t);
                        }
                    }
                    
                }
                
            }
            
            Collections.sort(result);
            System.out.println(result.get(0));
            
        }
    }
    
}

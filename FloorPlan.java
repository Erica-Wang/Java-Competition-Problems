/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classz13;
import java.util.*;
/**
 *
 * @author ericawang
 */
public class FloorPlan {
    
    public static boolean allFalse (boolean [][] arr){
        
        for(int i = 0; i<arr.length; i++){
            for(int u = 0; u<arr[0].length; u++){
                if(arr[i][u]){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public static void main (String [] args){
        Scanner input = new Scanner(System.in);
        
        int tiles = input.nextInt();
        int r = input.nextInt();
        int c = input.nextInt();
        
        String [] floor = new String [r];
        for(int i = 0; i<r; i++){
            String s = input.next();
            floor[i]=s;
        }
        
        boolean [][] fl = new boolean [r][c];
        
        for(int i = 0; i<r; i++){
            for(int u = 0; u<c; u++){
                if(floor[i].charAt(u)=='.'){
                    fl[i][u]=true;
                }
            }
        }
        
        ArrayList<Integer> result = new ArrayList();
        
        while(!allFalse(fl)){
            
            int tr = 0, tc = 0;
            
            outerloop: for(int i = 0; i<r; i++){
                for(int u = 0; u<c; u++){
                    if(fl[i][u]){
                        tr = i;
                        tc = u;
                        break outerloop;
                    }
                }
            }
            
            Queue<Integer> locr = new LinkedList();
            Queue<Integer> locc = new LinkedList();
            locr.add(tr);
            locc.add(tc);
            fl[tr][tc]=false;
            
            int count = 0;
            
            while(!locr.isEmpty()){
                int rv = locr.poll();
                int cv = locc.poll();
                count++;
                
                
                if(rv>0){
                    if(fl[rv-1][cv]){
                        locr.add(rv-1);
                        locc.add(cv);
                        fl[rv-1][cv]=false;
                    }
                }
                if(cv>0){
                    if(fl[rv][cv-1]){
                        locr.add(rv);
                        locc.add(cv-1);
                        fl[rv][cv-1]=false;
                    }
                }
                if(rv<r-1){
                    if(fl[rv+1][cv]){
                        locr.add(rv+1);
                        locc.add(cv);
                        fl[rv+1][cv]=false;
                    }
                }
                if(cv<c-1){
                    if(fl[rv][cv+1]){
                        locr.add(rv);
                        locc.add(cv+1);
                        fl[rv][cv+1]=false;
                    }
                }
            }
            
            result.add(count);
        }
        
        
        Collections.sort(result);
        
        int co = 0;
        int tused = 0;
        while(co<result.size()&&tused<=tiles){
            tused+=result.get(result.size()-1-co);
            co++;
        }
        
        if((tiles-tused)<0){
            co--;
            tused-=result.get(result.size()-1-co);
        }
        
        if(co==1){
            System.out.println(co+" room, "+(tiles-tused)+" square metre(s) left over");
        }else{
            System.out.println(co+" rooms, "+(tiles-tused)+" square metre(s) left over");
        }
        
    }
    
}

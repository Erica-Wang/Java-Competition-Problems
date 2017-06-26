/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classz16;
import java.util.*;
/**
 *
 * @author ericawang
 */
public class Oversleep {
    
    public static void main (String [] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        
        String [] map= new String [n];
        for(int i = 0; i<n; i++){
            map[i]=input.next();
        }
        
        int sw= 0, sh=0, ew=0, eh=0;
        
        for(int i = 0; i<n; i++){
            for(int u = 0; u<m; u++){
                if(map[i].charAt(u)=='s'){
                    sw = u;
                    sh = i;
                }
                else if (map[i].charAt(u)=='e'){
                    ew = u;
                    ew = i;
                }
            }
        }
        
        Queue<Integer> wv = new LinkedList();
        Queue<Integer> hv = new LinkedList();
        Queue<boolean [][]> been = new LinkedList();
        Queue<Integer> count = new LinkedList();
        
        wv.add(sw);
        hv.add(sh);
        boolean [][] be = new boolean [n][m];
        be[sh][sw]=true;
        been.add(be);
        count.add(0);
        
        int result = 100000;
        
        while(!wv.isEmpty()){
            
            int locw = wv.poll();
            int loch = hv.poll();
            be = been.poll();
            int co = count.poll()+1;
            
            if(map[loch].charAt(locw)=='e'){
                if((co-1)<result){
                    result = co-1;
                }
            }
            else{
                if(locw>0){
                    if(!be[loch][locw-1]){
                        boolean [][] b = be.clone();
                        be[loch][locw-1]=true;
                        wv.add(locw-1);
                        hv.add(loch);
                        count.add(co);
                        been.add(be);
                    }
                }
                if(locw<m-1){
                    if(!be[loch][locw+1]){
                        boolean [][] b = be.clone();
                        be[loch][locw+1]=true;
                        wv.add(locw+1);
                        hv.add(loch);
                        count.add(co);
                        been.add(be);
                    }
                }
                if(loch>0){
                    if(!be[loch-1][locw]){
                        boolean [][] b = be.clone();
                        be[loch-1][locw]=true;
                        wv.add(locw);
                        hv.add(loch-1);
                        count.add(co);
                        been.add(be);
                    }
                }
                if(loch<n-1){
                    if(!be[loch+1][locw]){
                        boolean [][] b = be.clone();
                        be[loch+1][locw]=true;
                        wv.add(locw);
                        hv.add(loch+1);
                        count.add(co);
                        been.add(be);
                    }
                }
            }
            
        }
        
        System.out.println(result-1);
        
        
    }
    
}

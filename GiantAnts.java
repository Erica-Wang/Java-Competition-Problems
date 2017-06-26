/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classz15;
import java.util.*;
/**
 *
 * @author ericawang
 */
public class GiantAnts {
    
    public static void main (String [] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        
        ArrayList<Integer> [] roads = new ArrayList [n+1];
        
        for(int i = 1; i<=n; i++){
            roads[i]= new ArrayList();
        }
        
        for(int i = 0; i<m; i++){
            int a =input.nextInt();
            int b = input.nextInt();
            roads[a].add(b);
            roads[b].add(a);
        }
        
        int w = input.nextInt();
        int [] ants = new int [w];
        for(int i = 0; i<w; i++){
            ants[i]=input.nextInt();
        }
        
        int [] byAnts = new int [n+1];
        for(int i = 1; i<=n; i++){
            byAnts[i]=10000000;
        }
        
        for(int num = 0; num<w; num++){
            int placeForAnts = ants[num];
            byAnts[placeForAnts]=0;
            Queue<Integer> t = new LinkedList();
            boolean [] been = new boolean[n+1];
            been[1]=true;
            t.add(placeForAnts);
            while(!t.isEmpty()){
                int cur = t.poll();
                int count = byAnts[cur]+4;
                for(int i = 0; i<roads[cur].size(); i++){
                    int c = roads[cur].get(i);
                    if(byAnts[c]>count){
                        byAnts[c]=count;
                    }
                    if(!been[c]){
                        t.add(c);
                        been[c]=true;
                    }
                }
            }
        }
        
        Queue<Integer> collection = new LinkedList();
        Queue<Integer> paths = new LinkedList();
        Queue<boolean[]> be = new LinkedList();
        collection.add(1);
        boolean [] bee = new boolean [n+1];
        bee[1]=true;
        be.add(bee);
        paths.add(0);
        
        int result = 10000;
        
        while(!collection.isEmpty()){
            int tl = collection.poll();
            boolean [] tb = be.poll();
            int tc = paths.poll()+1;
            
            if(tl==n){
                if(tc-1<result){
                    result = tc-1;
                }
            }else{
                if(tc<result){
                    for(int i = 0; i<roads[tl].size(); i++){
                        int cc = roads[tl].get(i);
                        boolean [] ttb = tb.clone();
                        if(!ttb[cc] && byAnts[cc]>tc){
                            ttb[cc]=true;
                            be.add(ttb);
                            collection.add(cc);
                            paths.add(tc);
                        }
                    }
                }
            }
        }
        
        if(result==10000){
            System.out.println("sacrifice bobhob314");
        }else{
            System.out.println(result);
        }
        
    }
    
}

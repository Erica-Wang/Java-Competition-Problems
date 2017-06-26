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
public class knightHop {
    
    public static int findMin(ArrayList<Integer> list){
        int max = list.get(0);
        for(int i = 1; i<list.size();i++){
            if(list.get(i)>max){
                max = list.get(i);
            }
        }
        return max;
    }
    
    public static void main (String [] args){
        
        Scanner input = new Scanner(System.in);
        
        int c1 = input.nextInt();
        int r1 = input.nextInt();
        int c2 = input.nextInt();
        int r2 = input.nextInt();
        
        Queue <Integer> r = new LinkedList();
        Queue <Integer> c = new LinkedList();
        Queue <Integer> counter = new LinkedList();
        Queue <boolean [][]> map = new LinkedList();
        
        int tr = r1;
        int tc = c1;
        boolean[][] temp = new boolean [9][9];
        temp[tr][tc]=true;
        int count = 0;
        
        while (tr!=-1){
            if(tr==r2&&tc==c2){
                System.out.println(count);
                tr = -1;
            }else{
                count++;
                boolean [][] cl = temp.clone();
                
                if(tc>=3&&tr>=2){
                    
                    if(!temp[tr-1][tc-2]){
                        r.add(tr-1);
                        c.add(tc-2);
                        cl[tr-1][tc-2]=true;
                        map.add(cl);
                        counter.add(count);
                    }
                    
                }
                cl = temp.clone();
                
                if(tc>=2&&tr>=3){
                    
                    if(!temp[tr-2][tc-1]){
                        r.add(tr-2);
                        c.add(tc-1);
                        cl[tr-2][tc-1]=true;
                        map.add(cl);
                        counter.add(count);
                    }
                    
                }
                cl = temp.clone();
                
                if(tc>=3&&tr<=7){
                    
                    if(!temp[tr+1][tc-2]){
                        r.add(tr+1);
                        c.add(tc-2);
                        cl[tr+1][tc-2]=true;
                        map.add(cl);
                        counter.add(count);
                    }
                    
                }
                cl = temp.clone();
                
                if(tc>=2&&tr<=6){
                    
                    if(!temp[tr+2][tc-1]){
                        r.add(tr+2);
                        c.add(tc-1);
                        cl[tr+2][tc-1]=true;
                        map.add(cl);
                        counter.add(count);
                    }
                    
                }
                cl = temp.clone();
                
                if(tc<=6&&tr<=7){
                    
                    if(!temp[tr+1][tc+2]){
                        r.add(tr+1);
                        c.add(tc+2);
                        cl[tr+1][tc+2]=true;
                        map.add(cl);
                        counter.add(count);
                    }
                    
                }
                cl = temp.clone();
                
                if(tc<=7&&tr<=6){
                    
                    if(!temp[tr+2][tc+1]){
                        r.add(tr+2);
                        c.add(tc+1);
                        cl[tr+2][tc+1]=true;
                        map.add(cl);
                        counter.add(count);
                        
                    }
                    
                }
                cl = temp.clone();
                
                if(tc<=6&&tr>=2){
                    
                    if(!temp[tr-1][tc+2]){
                        r.add(tr-1);
                        c.add(tc+2);
                        cl[tr-1][tc+2]=true;
                        map.add(cl);
                        counter.add(count);
                    }
                    
                }
                cl = temp.clone();
                
                if(tc<=7&&tr>=3){
                    
                    if(!temp[tr-2][tc+1]){
                        r.add(tr-2);
                        c.add(tc+1);
                        cl[tr-2][tc+1]=true;
                        map.add(cl);
                        counter.add(count);
                    }
                    
                }
                
            }
            if(tr!=-1){
            
                if(!r.isEmpty()){
                    tr = r.poll();

                    tc = c.poll();

                    count = counter.poll();

                    temp = map.poll();
                }else{
                    tr = -1;
                }
            }
        }
        
    }
    
}

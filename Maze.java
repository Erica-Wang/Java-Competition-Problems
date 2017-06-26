/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classz10;
import java.util.*;
/**
 *
 * @author ericawang
 */
public class Maze {
    public static void print (boolean [][]arr){
        for(int i = 0; i<arr.length;i++){
            for(int u = 0; u<arr[0].length;u++){
                System.out.print(arr[i][u]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main (String [] args){
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        
        for(int NUM = 0; NUM<t; NUM++){
            int r = input.nextInt();
            int c = input.nextInt();
            
            String nah = input.nextLine();
            String [] dir = new String [r];
            for(int i = 0; i<r; i++){
                dir[i]=input.nextLine();
            }
            
            Queue <Integer>locX = new LinkedList();
            Queue<Integer>locY = new LinkedList();
            Queue<Integer> count = new LinkedList();
            int x = 0;
            int y = 0;
            int co = 1;
            
            Queue<boolean[][]> beenn = new LinkedList();

            boolean [][] been = new boolean [r][c];
            been[0][0]=true;
            
            int tr = 0;

            while(x!=-1){

                char cur = dir[x].charAt(y);
                
                if ((x==r-1)&&(y==c-1)){
                    System.out.println(co);
                    x = -1;
                    tr = 1;
                }else{
                
                    if(cur=='+'){

                        boolean [][] b = been.clone();

                        if(x>0){
                            if(!b[x-1][y]&&dir[x-1].charAt(y)!='*'){
                                locX.add(x-1);
                                locY.add(y);
                                count.add(co+1);
                                b[x-1][y]=true;
                                beenn.add(b);
                            }
                        }

                       b = been.clone();

                        if(x<r-1){
                            if(!b[x+1][y]&&dir[x+1].charAt(y)!='*'){
                                locX.add(x+1);
                                locY.add(y);
                                count.add(co+1);
                                b[x+1][y]=true;
                                beenn.add(b);
                            }
                        }
                        b = been.clone();

                        if(y<c-1){
                            if(!b[x][y+1]&&dir[x].charAt(y+1)!='*'){
                                locX.add(x);
                                locY.add(y+1);
                                count.add(co+1);
                                b[x][y+1]=true;
                                beenn.add(b);
                            }
                        }
                        b = been.clone();

                        if(y>0){
                            if(!b[x][y-1]&&dir[x].charAt(y-1)!='*'){
                                locX.add(x);
                                locY.add(y-1);
                                count.add(co+1);
                                b[x][y-1]=true;
                                beenn.add(b);

                            }
                        }

                    }else if(cur == '-'){
                        boolean [][] b = been.clone();
                        if(y<c-1){
                            if(!b[x][y+1]&&dir[x].charAt(y+1)!='*'){
                                locX.add(x);
                                locY.add(y+1);
                                count.add(co+1);
                                b[x][y+1]=true;
                                beenn.add(b);
                            }
                        }

                        b = been.clone();

                        if(y>0){
                            if(!b[x][y-1]&&dir[x].charAt(y-1)!='*'){
                                locX.add(x);
                                locY.add(y-1);
                                count.add(co+1);
                                b[x][y-1]=true;
                                beenn.add(b);
                            }
                        }

                    }else if(cur == '|'){

                        boolean [][] b = been.clone();

                        if(x>0){
                            if(!b[x-1][y]&&dir[x-1].charAt(y)!='*'){
                                locX.add(x-1);
                                locY.add(y);
                                count.add(co+1);
                                b[x-1][y]=true;
                                beenn.add(b);
                            }
                        }


                        b = been.clone();

                        if(x<r-1){
                            if(!b[x+1][y]&&dir[x+1].charAt(y)!='*'){
                                locX.add(x+1);
                                locY.add(y);
                                count.add(co+1);
                                b[x+1][y]=true;
                                beenn.add(b);
                            }
                        }

                    }
                }
                
                if(x!=-1){

                    if(locX.isEmpty()){
                        x=-1;
                    }else{
                        x = locX.poll();
                        y = locY.poll();
                        co = count.poll();
                        been = beenn.poll();
                    }
                }

            
            }
            
            if(tr == 0){
                System.out.println(-1);
            }
        }
    }
    
}

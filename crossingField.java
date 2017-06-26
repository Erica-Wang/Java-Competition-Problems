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
public class crossingField {
    
    public static void main (String [] args){
        Scanner input = new Scanner(System.in);
        
        int n = input.nextInt();
        int h = input.nextInt();
        
        int [][] elevation = new int [n][n];
        for(int i = 0; i<n; i++){
            for(int u = 0; u<n; u++){
                elevation[i][u]=input.nextInt();
            }
        }
        
        Stack <Integer>locX = new Stack();
        Stack<Integer>locY = new Stack();
        int tempx = 0;
        int tempy = 0;
        
        boolean [][] been = new boolean [n][n];
        been[0][0]=true;
        
        while(tempx!=-1&&((tempx!=n-1)||(tempy!=n-1))){
            
            int ele = elevation[tempx][tempy];
            
            if(tempx>0){
                if(!been[tempx-1][tempy]){
                    if((elevation[tempx-1][tempy]<=ele+h)&&(elevation[tempx-1][tempy]>=ele-h)){
                        locX.add(tempx-1);
                        locY.add(tempy);
                        been[tempx-1][tempy]=true;
                    }
                }
            }
            
            if(tempx<n-1){
                if(!been[tempx+1][tempy]){
                    if((elevation[tempx+1][tempy]<=ele+h)&&(elevation[tempx+1][tempy]>=ele-h)){
                        locX.add(tempx+1);
                        locY.add(tempy);
                        been[tempx+1][tempy]=true;
                    }
                }
            }
            
            if(tempy<n-1){
                if((elevation[tempx][tempy+1]<=ele+h)&&(elevation[tempx][tempy+1]>=ele-h)){
                    if(!been[tempx][tempy+1]){
                        locX.add(tempx);
                        locY.add(tempy+1);
                        been[tempx][tempy+1]=true;
                    }
                }
            }
            
            if(tempy>0){
                if(!been[tempx][tempy-1]){
                    if((elevation[tempx][tempy-1]<=ele+h)&&(elevation[tempx][tempy-1]>=ele-h)){
                        locX.add(tempx);
                        locY.add(tempy-1);
                        been[tempx][tempy-1]=true;
                    }
                }
            }
            
            
            if(locX.isEmpty()){
                tempx=-1;
            }else{
                tempx = locX.peek();
                tempy = locY.peek();
                locX.pop();
                locY.pop();
            }
            
        }
        
        if(tempx==-1){
            System.out.println("no");
        }else{
            System.out.println("yes");
        }
        
    }
}

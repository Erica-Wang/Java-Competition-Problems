/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classz23;
import java.util.*;
/**
 *
 * @author moyangwang
 */
public class Alice {
    public static boolean recur(int m, int x, int y){
        
        if(x<0||x>Math.pow(5, m)){
            return false;
        }
        if(y<0||y>Math.pow(5,m)){
            return false;
        }
        
        if(m==1){
            if(x==1&&y==0){
                return true;
            }else if(x==2&&y==0){
                return true;
            }else if(x==3&&y==0){
                return true;
            }else if(x==2&&y==1){
                return true;
            }
            return false;
        }
        
        if(recur(m-1,x/5,y/5)){
            return true;
        }
        
        if(recur(m-1,x/5,y/5-1)){
            if(x-x/5*5==1&&y-y/5*5==0){
                return true;
            }else if(x-x/5*5==2&&y-y/5*5==0){
                return true;
            }else if(x-x/5*5==3&&y-y/5*5==0){
                return true;
            }else if(x-x/5*5==2&&y-y/5*5==1){
                return true;
            }
            return false;
        }
        return false;
    }
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for(int num = 0; num<t; num++){
            int m = input.nextInt();
            int x = input.nextInt();
            int y = input.nextInt();
            if(recur(m,x,y)){
                System.out.println("crystal");
            }else{
                System.out.println("empty");
            }
        }
    }
}
//y + 1 /5
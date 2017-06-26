/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classz12;
import java.util.*;
/**
 *
 * @author ericawang
 */
public class Friends {
    
    public static void main (String [] args){
        
        Scanner input = new Scanner(System.in);
        
        int n = input.nextInt();
        ArrayList<Integer> befriend = new ArrayList();
        ArrayList<Integer> friend = new ArrayList();
        
        for (int i = 0; i<n; i++){
            int a = input.nextInt();
            int b = input.nextInt();
            befriend.add(a);
            friend.add(b);
        }
        
        int a = input.nextInt();
        int b = input.nextInt();
            
        while(a!=0||b!=0){
            int [] degree = new int [n];
            boolean [] been = new boolean [n];
            int person = a;
            int loc = befriend.indexOf(person);
            degree[loc]=-1;
            been[loc]=true;
            int fri  = friend.get(loc);
            int friloc = befriend.indexOf(fri);
            degree[friloc] = degree[loc]+1;
            
            while(fri!=b&& !been[friloc]){
                been[friloc]=true;
                
                loc = friloc;
                person = fri;
                fri  = friend.get(loc);
                friloc = befriend.indexOf(fri);
                degree[friloc] = degree[loc]+1;
            }
            
            if(fri!=b){
                System.out.println("No");
            }else{
                System.out.println("Yes "+ degree[friloc]);
            }
            a = input.nextInt();
            b = input.nextInt();
            
        }
        
    }
    
}

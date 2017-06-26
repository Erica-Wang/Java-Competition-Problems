/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classz14;
import java.util.*;
/**
 *
 * @author ericawang
 */
public class HardToBeATeen {
    
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> before = new ArrayList();
        ArrayList<Integer> after = new ArrayList();
        ArrayList<Integer>  yet = new ArrayList();
        
        before.add(1);
        before.add(1);
        before.add(2);
        before.add(3);
        before.add(3);
        
        after.add(7);
        after.add(4);
        after.add(1);
        after.add(4);
        after.add(5);
        
        for(int i = 1; i<=7; i++){
            yet.add(i);
        }
        
        int b = input.nextInt();
        int a = input.nextInt();
        while(b!=0&&a!=0){
            before.add(b);
            after.add(a);
            b = input.nextInt();
            a = input.nextInt();
        }
        
        ArrayList<Integer> result = new ArrayList();
        
        while(!yet.isEmpty()){
            int next = -1;
            int index = -1;
            for(int i = 1; i<=7; i++){
                if(yet.contains(i)&&!after.contains(i)){
                    next = i;
                    index = yet.indexOf(i);
                    break;
                }
            }
            if(next==-1){
                break;
            }else{
                yet.remove(index);
                ArrayList<Integer> remove = new ArrayList();
                for(int i = 0; i<before.size(); i++){
                    if(before.get(i)==next){
                        remove.add(i);
                    }
                }
                for(int i = 0;i<remove.size();i++){
                    before.remove(remove.get(i)-i);
                    after.remove(remove.get(i)-i);
                }
                result.add(next);
            }
            
        }
        
        if(result.size()==7){
            for(int i = 0; i<7; i++){
                System.out.print(result.get(i)+" ");
            }
        }else{
            System.out.println("Cannot complete these tasks. Going to bed.");
        }
        
        
    }
    
}

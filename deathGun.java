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
public class deathGun {
    
    public static void main (String []args){
        Scanner input = new Scanner(System.in);
        ArrayList<String> names = new ArrayList();
        ArrayList<Integer> yet = new ArrayList();
        ArrayList<Integer> before = new ArrayList();
        ArrayList<Integer> after = new ArrayList();
        int n = input.nextInt();
        for(int i = 0; i<n; i++){
            String a = input.next();
            String b = input.next();
            if(!names.contains(a)){
                names.add(a);
            }
            if(!names.contains(b)){
                names.add(b);
            }
            
            before.add(names.indexOf(a));
            after.add(names.indexOf(b));
        }
        
        for(int i = 0; i<names.size(); i++){
            yet.add(i);
        }
        
        //System.out.println(names);
        ArrayList<String> result = new ArrayList();
        while(!yet.isEmpty()){
            
            boolean bool = false;
            
            for(int i = 0; i<yet.size(); i++){
                if(!before.contains(yet.get(i))){
                    bool = true;
                    int cur = yet.get(i);
                    result.add(names.get(cur));
                    //System.out.println("\n"+before+"\n"+after+"\n"+yet+"\n"+cur+"\n"+result);
                    
                    ArrayList<Integer> remove = new ArrayList();
                    for(int u = 0; u<after.size(); u++){
                        if(after.get(u)==cur){
                            remove.add(u);
                        }
                    }
                    
                    for(int u = 0; u<remove.size(); u++){
                        before.remove(remove.get(u)-u);
                        after.remove(remove.get(u)-u);
                    }
                    
                    yet.remove(i);
                    i--;
                    break;
                }
            }
            if(!bool){
                break;
            }
        }
        
        for(int i = 0; i<result.size(); i++){
            System.out.println(result.get(i));
        }
        
    }
    
}

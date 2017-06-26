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
public class AcidityLevel {
    public static void main (String [] args){
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        int [] arr = new int [1001];
        for(int i = 0; i<t; i++){
            int a = input.nextInt();
            arr[a]++;
        }
        
        ArrayList<Integer> highest = new ArrayList();
        ArrayList<Integer> second = new ArrayList();
        int h = 0;
        int s = 0;
        for(int i = 1; i<=1000; i++){
            int occ = arr[i];
            if(occ>h){
                s = h;
                second = (ArrayList<Integer>) highest.clone();
                h = occ;
                highest.clear();
                highest.add(i);
            }else if(occ==h){
                highest.add(i);
            }else if(occ>s){
                s = occ;
                second.clear();
                second.add(i);
            }else if(occ==s){
                second.add(i);
            }
        }
        
        if(highest.size()==1&&second.size()==1){
            System.out.println(Math.abs(highest.get(0)-second.get(0)));
        }else if (highest.size()>1){
            System.out.println(Math.abs(highest.get(0)-highest.get(highest.size()-1)));
        }else{
            int max = -1;
            for(int i = 0; i<second.size(); i++){
                int diff = Math.abs(second.get(i)-highest.get(0));
                if(diff>max){
                    max = diff;
                }
            }
            System.out.println(max);
        }
    }
}

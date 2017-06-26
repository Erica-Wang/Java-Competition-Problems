/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class9;
import java.util.*;
/**
 *
 * @author ericawang
 */
public class Unfriend {
    
    public static void main (String [] args){
        
        Scanner input = new Scanner(System.in);
        
        int num = input.nextInt();
        
        int [] cnt = new int []{0,1,1,1,1,1,1};
        
        for(int i = 1; i<num; i++){
            int x=input.nextInt();
            cnt[x]=cnt[x]*(cnt[i]+1);
        }
        System.out.println(cnt[num]);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class5;
import java.util.*;
/**
 *
 * @author EricaWang
 */
public class ZenGarden {

    /**
     * @param args the command line arguments
     */
    static int [] med;
    static ArrayList <Integer> result=new ArrayList();
    static ArrayList <Integer> value = new ArrayList();
    public static boolean find (int a){
        for(int i = 0; i<result.size();i++){
            if(result.get(i)==a){
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        med = new int [n+1];
        for(int i = 1; i<=n; i++){
            med[i]=in.nextInt();
        }
        int m = in.nextInt();
        for(int i = 0;i<m; i++){
            int dis = in.nextInt();
            int val = in.nextInt();
            int temp=0;
            if(med[dis]<med[dis+1]){
                temp = dis;
            }else{
                temp = dis+1;
                
            }
            int min = med[temp];
            if(val>min){
                result.add(temp);
            }else{
                value.add(val);
            }
        }
        int sum = 0;
        for(int i = 1;i<=n;i++){
            if(!find(i)){
                sum+=med[i];
            }else{
            }
        }
        for(int i = 0; i<value.size();i++){
            sum-=value.get(i);
        }
        System.out.println(sum);
    }
    
}

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
public class BridgeCrossing {

    /**
     * @param args the command line arguments
     */
    static String [] name;
    static int [] time;
    static int [] result;
    public static void print1D(int [] arr){
        for(int i = 0; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    //1 5 5 3 3
    //8 5 3
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int q = in.nextInt();
        name = new String [q+1];
        time = new int [q+1];
        for(int i = 1; i<=q; i++){
            name[i]=in.next();
            time[i]=in.nextInt();
        }
        result = new int [q+1];
        ArrayList<Integer> [] re= new ArrayList[q+1];
        for(int i= 1; i<=q;i++){
            re[i]=new ArrayList();
        }
        int sumM=0;
        for(int i = 1; i<=q;i++){
            if(i<=m){
                if(time[i]>sumM){
                    sumM=time[i];
                }
                result[i]=sumM;
                re[i].add(1);
            }else{
                int min = result[i-1]+time[i];
                sumM = time[i];
                int temp = 0;
                int index = i;
                for(int u = 1;u<m;u++){
                    if(i-u<=0){
                        break;
                    }else{
                        if(time[i-u]>sumM){
                            sumM=time[i-u];
                        }
                        temp = result[i-u-1]+sumM;
                    }
                    if(temp<min){
                        min=temp;
                        index = i-u;
                    }
                }
                result[i]=min;
                re[i]=(ArrayList) re[index-1].clone();
                re[i].add(index);
            }
        }
        System.out.println("Total Time: "+result[q]);
        int k = 1;
        for(int i = 1; i<=q;i++){
            System.out.print(name[i]+" ");
            if(i+1==re[q].get(k)){
                System.out.println();
                if(k!=re[q].size()-1){
                    k++;
                }
            }
        }
    }
    
}

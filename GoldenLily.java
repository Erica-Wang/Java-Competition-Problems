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
public class GoldenLily {
    public static void print (int [][]arr){
        for(int i = 0; i<arr.length;i++){
            for(int u = 0; u<arr[0].length;u++){
                System.out.print(arr[i][u]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int l = input.nextInt();
        int d = input.nextInt();
        ArrayList<Integer>[] map = new ArrayList[d];
        for(int i = 0; i<d; i++){
            map[i]= new ArrayList();
            for(int u = 0; u<l; u++){
                map[i].add(input.nextInt());
            }
        }
        int [][] res = new int [d][l];
        for(int i = 0; i<d; i++){
            for(int u = 0; u<l; u++){
                res[i][u]=(int)Math.pow(10, 7);
            }
        }
        res[0][0]=map[0].get(0);
        Queue<Integer> wid = new LinkedList();
        wid.add(0);
        Queue<Integer> hei = new LinkedList();
        hei.add(0);
        while(!wid.isEmpty()){
            int wi = wid.poll();
            int he = hei.poll();
//            System.out.println(wi+" "+he);
            int cur = res[he][wi];
            if(wi>0){
                int result = cur+map[he].get(wi-1);
//                System.out.println("b"+result);
                if(result<res[he][wi-1]){
                    res[he][wi-1]=result;
                    wid.add(wi-1);
                    hei.add(he);
                }
            }
            if(wi<l-1){
                int result = cur+map[he].get(wi+1);
//                System.out.println("b"+result);
                if(result<res[he][wi+1]){
                    res[he][wi+1]=result;
                    wid.add(wi+1);
                    hei.add(he);
                }
            }
            if(he>0){
                int result = cur+map[he-1].get(wi);
//                System.out.println("c"+result);
                if(result<res[he-1][wi]){
                    res[he-1][wi]=result;
                    wid.add(wi);
                    hei.add(he-1);
                }
            }
            if(he<d-1){
                int result = cur+map[he+1].get(wi);
//                System.out.println("d"+result);
                if(result<res[he+1][wi]){
                    res[he+1][wi]=result;
                    wid.add(wi);
                    hei.add(he+1);
                }
            }
        }
//        System.out.println("a");
//        print(res);
        int w = input.nextInt();
        int h = input.nextInt();
        System.out.println(res[h][w]);
    }
}

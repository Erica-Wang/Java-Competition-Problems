/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class7;
import java.util.*;
/**
 *
 * @author EricaWang
 */
public class pieDay {

    /**
     * @param args the command line arguments
     */
    static int [][] dp;
    public static int sumList(ArrayList <Integer> list){
        int sum = 0;
        for(int i = 1; i<list.size();i++){
            sum+=list.get(i);
        }
        return sum;
    }
    
    public static void print2D (int [][]arr){
        for(int i = 0; i<arr.length;i++){
            for(int u = 0; u<arr[0].length;u++){
                System.out.print(arr[i][u]+" ");
            }
            System.out.println();
        }
    }
    public static int func (int n, int k){
        if((n<0)||(k==0&&n!=0)){
            return 0;
        }else if (dp[n][k]!=10000){
            return dp[n][k];
        }else if (n==0&&k!=0){
            return 1;
        }
        return dp[n][k]=func(n, k-1) + func(n-k, k);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        int pie = input.nextInt();
        int k = input.nextInt();
        
        dp = new int [501][501];
        for(int i = 0; i<=500; i++){
            for(int u = 0; u<=500; u++){
                dp[i][u]=10000;
            }
        }
        System.out.println(func(pie-k,k));
        
        
//        dp = new int [pie+1][k+1];
//        for(int i = 1; i<=pie; i++){
//            dp[i][1]=1;
//        }for(int i = 1; i<=k; i++){
//            dp[1][i]=1;
//        }
//        for(int i = 1; i<=k; i++){
//            for(int u = 1; u<i; u++){
//                dp[u][i]=0;
//            }
//        }
//        for(int i =2; i<=pie; i++){
//            for(int u = 2; u<=k; u++){
//                if(i<u){
//                }else if(i==u){
//                    dp[i][u]=1;
//                }else{
////                    System.out.println(i+" "+u+" "+(u-1)+" "+(i-u));
//                    dp[i][u]=dp[i][u-1]+dp[i-u][u];
//                }
//                //System.out.print(dp[i][u]+" ");
//            }
////            System.out.println();
//        }
//        System.out.println(dp[pie][k]);
        
//        Stack<ArrayList<Integer>> line = new Stack();
//        ArrayList<ArrayList<Integer>> result = new ArrayList();
//        
//        ArrayList <Integer> list = new ArrayList();
//        list.add(1);
//        
//        ArrayList <Integer> list1 = new ArrayList();
//        for(int i = 0; i<=k+1;i++){
//            list1.add(1);
//        }
//        line.push(list1);
//        
//        while(list.size()<=k+1){
//            int last = list.get(list.size()-1);
//            int sum = sumList(list);
//            int left = (pie-sum)/(k-list.size()+1);
//            //System.out.println(list);
//            ArrayList<Integer> temp = (ArrayList<Integer>) list.clone();
//            int sum1 = sum;
//            
//            for(int i = last;i<=left;i++){
//                temp.add(i);
//                if(temp.size()==k+1){
//                    if((sum1+=i)==pie)
//                    result.add(temp);
//                }else{
//                    line.push(temp);
//                }
//                sum1 = sum;
//                temp = (ArrayList<Integer>) list.clone();
//            }
//            
//            list = line.peek();
//            line.pop();
//        }
////        for(int i = 0; i<result.size();i++){
////            System.out.println(result.get(i));
////        }
//        System.out.println(result.size());
    }
    
}

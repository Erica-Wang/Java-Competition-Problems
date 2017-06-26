/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classz21;
import java.util.*;
/**
 *
 * @author moyangwang
 */
public class hideNSeekNew {
    public static boolean [][] clone(boolean [][] arr){
        boolean [][] result = new boolean[arr.length][arr[0].length];
        for(int i = 0; i<arr.length; i++){
            result[i]=arr[i].clone();
        }
        return result;
    }
    public static void print (int [][]arr){
        for(int i = 0; i<arr.length;i++){
            for(int u = 0; u<arr[0].length;u++){
                System.out.print(arr[i][u]+" ");
            }
            System.out.println();
        }
    }
    public static void print(int [] arr){
        for(int i = 0; i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    
    public static int fact(int num){
        if(num==1){
            return 1;
        }else{
            return fact(num-1)*num;
        }
    }
    
    public static ArrayList<Integer> notHere(int [] arr, int a){
        ArrayList<Integer> list = new ArrayList();
        for(int i = 0; i<=a; i++){
            list.add(arr[i]);
        }
        ArrayList<Integer> res = new ArrayList();
        for(int i = 1; i<=arr.length; i++){
            if(!list.contains(i)){
                res.add(i);
            }
        }
        return res;
    }
    
    public static int nextPos(int [] arr, int a){
        int cur = arr[a];
        ArrayList<Integer> list = new ArrayList();
        for(int i = 0; i<a; i++){
            list.add(arr[i]);
        }
        for(int i = cur+1; i<=arr.length; i++){
            if(!list.contains(i)){
                return i;
            }
        }
        return -1;
    }
    
    public static int [] ne(int [] arr, int a){
        int [] ne = arr.clone();
        ne[a] = nextPos(ne,a);
        ArrayList<Integer> n = notHere(ne,a);
        Collections.sort(n);
        for(int i = a+1; i<arr.length; i++){
            ne[i]=n.get(i-a-1);
        }
        return ne;
    }
    public static boolean order(int [] arr, int a){
        ArrayList<Integer> list = new ArrayList();
        for(int i = a; i<arr.length; i++){
            list.add(arr[i]);
        }
        ArrayList<Integer> old = (ArrayList<Integer>) list.clone();
        Collections.sort(list);
        ArrayList<Integer> backward = new ArrayList();
        for(int i = list.size()-1; i>=0; i--){
            backward.add(list.get(i));
        }
        if(backward.equals(old)){
            return true;
        }
        return false;
    }
    
    public static int [][] perm(int num){
        int [][] res = new int [fact(num)][num];
        int [] cur = new int [num];
        for(int i = 1; i<=num; i++){
            cur[i-1]=i;
        }
        res[0]=cur;
        for(int i = 1; i<fact(num); i++){
            for(int u = 0; u<num; u++){
                if(order(cur,u)){
                    cur = ne(cur, u-1);
                    res[i]=cur;
                    break;
                }
            }
        }
        return res;
    }
    
//    public static boolean next_permutation(int [] a) {
//        int p=0, q=0;
//        for (p = a.length-2; p>=0; p--) {
//            if (a[p]<a[p+1]) {
//                break;
//            }
//        }
//        if (p<0 ) { 
//            return false;
//        }
//        for (q = a.length-1; q > p; q--) {
//            if (a[q]>a[p]) {
//                break;
//            }
//        }
//        int t = a[p];
//        a[p] = a[q];
//        a[q] = t;
//        for (int l = p+1, r=a.length-1; l<=r; l++, r--) {
//            int t2 = a[l];
//            a[l]=a[r];
//            a[r]=t2;
//        }
//        return true;
//    }
    public static void print (ArrayList<int[]> list){
        for(int i = 0; i<list.size();i++){
            print(list.get(i));
        }
    }
    public static void main (String [] args){
        
        Scanner input = new Scanner(System.in);
        int th = input.nextInt();
        int tw = input.nextInt();
        int hn = input.nextInt();
        String [] dir = new String [th];
        for(int i = 0; i<th; i++){
            dir[i]=input.next();
        }
        int [] rv = new int [hn+1];
        int [] cv = new int [hn+1];
        int cou = 0;
        for(int i =0; i<th; i++){
            for(int u = 0; u<tw; u++){
                if(dir[i].charAt(u)=='G'||dir[i].charAt(u)=='H'){
                    rv[cou]=i;
                    cv[cou]=u;
                    cou++;
                }
            }
        }
        int [][] value = new int [hn+1][hn+1];
        for(int num = 0; num<=hn; num++){
            Queue<point> pt = new LinkedList();
            int [][] val = new int [th][tw];
            
            point poi = new point(rv[num],cv[num]);
            pt.add(poi);

            int result = 1000000;

            while(!pt.isEmpty()){

                point p = pt.poll();
                int cw = p.w;
                int ch = p.h;
                int count = val[ch][cw]+1;
                
                if(ch>0){
                    if(dir[ch-1].charAt(cw)!='X'){
                        if(val[ch-1][cw]==0||val[ch-1][cw]>count){
                            val[ch-1][cw]=count;
                            pt.add(new point(ch-1,cw));
                        }
                    }
                }
                if(ch<th-1){
                    if(dir[ch+1].charAt(cw)!='X'){
                        if(val[ch+1][cw]==0||val[ch+1][cw]>count){
                            val[ch+1][cw]=count;
                            pt.add(new point(ch+1,cw));
                        }
                    }
                }
                if(cw<tw-1){
                    if(dir[ch].charAt(cw+1)!='X'){
                        if(val[ch][cw+1]==0||val[ch][cw+1]>count){
                            val[ch][cw+1]=count;
                            pt.add(new point(ch,cw+1));
                        }
                    }
                }
                if(cw>0){
                    if(dir[ch].charAt(cw-1)!='X'){
                        if(val[ch][cw-1]==0||val[ch][cw-1]>count){
                            val[ch][cw-1]=count;
                            pt.add(new point(ch,cw-1));
                        }

                    }
                }
            }
            for(int u = num+1; u<=hn; u++){
                int rr = rv[u];
                int cc = cv[u];
                int v = val[rr][cc];
                value[num][u]=v;
                value[u][num]=v;
            }
        }
        
        //print(value);

        int [][] perm = perm(hn+1);
        
        int result = 1000000;
        for(int i = 0; i<perm.length; i++){
            int [] cur = perm[i];
            int temp = 0;
            for(int u = 1; u<cur.length; u++){
                int begin = cur[u-1]-1;
                int end = cur[u]-1;
                temp+=value[begin][end];
            }
            if(temp<result){
                result = temp;
            }
        }
        System.out.println(result);
    }
    
    static class point{
        public int w;
        public int h;
        public point (int a, int b){
            h = a;
            w = b;
        }
        
        public String toString(){
            return w+" "+h;
        }
    }
}

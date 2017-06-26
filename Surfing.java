/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classz13;
import java.util.*;
/**
 *
 * @author ericawang
 */
public class Surfing {
    
    public static int contains (String a){
        int lena = a.length();
        int lenb = 8;
        
        for(int i = 0; i<lena-lenb; i++){
            if(a.substring(i, i+lenb).equals("<A HREF=")){
                return i+9;
            }
        }
        
        return -1;
    }
    
    public static int end (String a, int cur){
        for(int i = cur; i<a.length(); i++){
            if(a.charAt(i)=='>'){
                return i-1;
            }
        }
        return -1;
    }
    
    public static void print (ArrayList<String>[]arr){
        for(int i = 0; i<arr.length;i++){
            System.out.println(arr[i]);
        }
    } 
    
    public static void main (String[]args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        ArrayList<String> original = new ArrayList();
        
        int count = 0;
        String useless = input.nextLine();
        String s;
        
        ArrayList<String> [] sites = new ArrayList [n];
        for(int i = 0; i<n; i++){
            sites[i] = new ArrayList();
        }
        
        int html = 1;
        
        s = input.nextLine();
        original.add(s);
        
        while(count<n){
            int cur = 0;
            int loc = contains(s);
            while(loc!=-1){
                loc+=cur;
                int end = end(s,loc);
                sites[count].add(s.substring(loc, end));
                
                cur = end+2;
                loc = contains(s.substring(cur));
            }
            
            s = input.nextLine();
            if(html==2){
                original.add(s);
                html = 1;
            }
            if(s.startsWith("</HTML>")){
                html = 2;
                count++;
            }
            
//            System.out.println(html);
//            // 1 = next time new page; 2 = next line new page; 0 = just finished
//            System.out.println(original);
            
        }
        
        for(int i = 0; i<n; i++){
            String b = original.get(i);
            for(int u = 0; u< sites[i].size(); u++){
                String e = sites[i].get(u);
                System.out.println("Link from "+b+" to "+e);
            }
        }
        
        ArrayList<String> questions = new ArrayList();
        
        s = input.nextLine();
        while (!s.equals("The End")){
            questions.add(s);
            s = input.nextLine();
        }
        
        int testCases = questions.size()/2;
        
        for(int num = 0; num<testCases; num++){
            
            String begin = questions.get(num*2);
            String end = questions.get(num*2+1);
            
            int index = original.indexOf(begin);
            
            Stack<Integer> loc = new Stack();
            boolean [] been = new boolean [n];
            been[index]=true;
            loc.add(index);
            
            boolean boo = false;
            
            while(!loc.isEmpty()){
                
                int c = loc.peek();
                loc.pop();
                
                String st = original.get(c);
                if(st.equals(questions.get(num*2+1))){
                    boo = true;
                    break;
                }
                
                for(int i = 0; i<sites[c].size(); i++){
                    s = sites[c].get(i);
                    
                    s = sites[c].get(i);
                    if(s.equals(questions.get(num*2+1))){
                        boo = true;
                        break;
                    }
                    
                    int in = original.indexOf(s);
                    if(in!=-1){
                        if(!been[in]){
                            loc.add(in);
                            been[in]=true;
                        }
                    }
                }
                
            }
            
            if(boo){
                System.out.println("Can surf from "+begin+" to "+end+".");
            }else{
                System.out.println("Can't surf from "+begin+" to "+end+".");
            }
            
        }
        
    }
    
}

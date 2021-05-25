import java.util.*;

class Brainfuckfile {
    static Scanner sc;
    public static void main(String[] arg){
        int t = Integer.parseInt(arg[0]);
        //System.out.println(t);
        sc = new Scanner(System.in);
        
        StringBuilder s = new StringBuilder("");
        for(;t>0;t--){
            s.append(sc.nextLine());
        }
        solver(s.toString());

    }
    static int size = 300001;

    static void solver(String s){
        int[] arr = new int[size];
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        int pointer = -1;
        int idx = 0;
        int len=  s.length();
        while(idx<len){
            if(s.charAt(idx)=='<'){
                if(cur==0)cur =size-1;
                else{
                    cur--;
                }
            }
            else if(s.charAt(idx)=='>'){
                if(cur==size-1)cur =0;
                else{
                    cur++;
                }
            }
            else if(s.charAt(idx)=='+'){
                arr[cur]++;
            }
            else if(s.charAt(idx)=='-'){
                arr[cur]--;
            }
            else if(s.charAt(idx)==','){
                pointer = cur;
            }
            else if(s.charAt(idx)=='.'){
                System.out.print((char)arr[cur]);
                //System.out.print(arr[cur]+ " " );
            }
            else if(s.charAt(idx)=='['){
                stack.push(idx);
            }
            else if(s.charAt(idx)==']'){
                if(stack.isEmpty()){
                    System.out.println("Compilation error at "+cur+"! \nCheck for loops");
                    return;
                }
                else{
                    if(arr[cur]!=0){
                        idx = stack.peek();
                    }
                    else{
                        stack.pop();
                    }
                }
            }
            //else{
            //    System.out.println("Compilation error at "+cur+"! \nInvalid syntax");
            //    return;
            //}
            idx++;
        }
    }
}

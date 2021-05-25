import java.util.*;

class Brainfuckfile {
    static Scanner sc;
    static int argIndex = 0;
    static char[] argsChar;
    public static void main(String[] args){
        int t = Integer.parseInt(args[0]);
        if(args.length>1)
            argsChar = args[1].toCharArray();

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
                if(argsChar==null || argsChar.length==argIndex){
                    System.out.println("Error at "+idx+"! Please pass arguments");
                    return;
                }
                else
                    arr[cur] = (int)argsChar[argIndex++];

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
                    System.out.println("Compilation error at "+cur+"! \nInvalid brackets");
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
            // Uncomment for strict single line brainfuck check
            
            //else{
            //    System.out.println("Compilation error at "+cur+"! \nInvalid syntax");
            //    return;
            //}
            idx++;
        }
    }
}

import java.util.*;

class Brainfuckcli {
    static Scanner sc;
    public static void main(String[] arg){
        sc = new Scanner(System.in);
        System.out.print(
                "Welcome to BrainFuck interpreter!\n"+
                "= Enter all programs in a single line =\n"
        );
        while(true){
            System.out.print(">> ");
            String s = sc.nextLine();
            solver(s);

            System.out.println();
        }

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
                int pointer = (int)sc.next().charAt(0);
                arr[cur] = pointer;
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
            else{
                System.out.println("Compilation error at "+cur+"! \nInvalid syntax");
                return;
            }
            idx++;
        }
    }
}

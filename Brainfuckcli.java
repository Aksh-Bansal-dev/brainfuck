import java.util.*;

class Brainfuckcli {
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        int t= 10; 
        System.out.print(
                "Welcome to BrainFuck interpreter!\n"+
                "= Enter all programs in a single line =\n"
        );
        while(t-->0){
            System.out.print(">> ");
            String s = sc.nextLine();
            solver(s);

            System.out.println();
        }
        System.out.println("GAME OVER");

    }
    static int size = 300001;

    static void solver(String s){
        int[] arr = new int[size];
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        int idx = 0;
        int len=  s.length();
        int pointer = -1;
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
            else{
                System.out.println("Compilation error at "+cur+"! \nInvalid syntax");
                return;
            }
            idx++;
        }
    }
}

import java.util.*;

class GenBrainfuck {
    private static Map<Integer, String> map;
    public static void main(String[] args){
        
        StringBuilder s = new StringBuilder("");
        for(int i=0;i<args.length;i++){
            if(i!=0)
                s.append(' ');
            s.append(args[i]);
        }
        
        int len = s.length();
        StringBuilder res = new StringBuilder("");
        map = new HashMap<>();
        for(int i=0;i<len;i++){
            int c = (int)s.charAt(i);
            String letter = getLetter(c);
            res.append(letter);
        }

        System.out.println(res);
    }

    private static String getLetter(int c){
        if(map.containsKey(c))return map.get(c);

        StringBuilder res = new StringBuilder("");
        int a = c/10;
        int b = 10;
        int rem = c-b*a;

        for(int j=0;j<a;j++){
            res.append('+');
        }
        res.append("[>");

        for(int j=0;j<b;j++){
            res.append('+');
        }
        res.append("<-]>");
        for(int j=0;j<rem;j++){
            res.append('+');
        }
        res.append(".>");

        map.put(c, res.toString());
        return res.toString();
    }
}

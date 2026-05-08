import java.util.Stack;
import java.util.HashMap;
import java.util.List;  
public class Balanced{
    public static void main(String[] args) {
        String[] str = {"({[]})","({[})", "((()))", "({)}"};
        for(String s: str)
            System.out.println(isBalanced(s));

    }
    public static boolean isBalanced(String s){
        String items=s;
        Stack<Character> stack1 =new Stack<>();
        HashMap<Character,Character> pairs=new HashMap<>();
        pairs.put('(',')');
        pairs.put('[',']');
        pairs.put('{','}');
        List<Character> opening = List.of('[', '{', '(');
        List<Character> clossing =List.of(']','}',')');
        for (int x=0 ;x<items.length();x++){
            if ((clossing.contains(items.charAt(x))) && (stack1.size()>0)) {
                char last=stack1.pop();
                char match=pairs.get(last);
                if (match!= items.charAt(x)) {
                    return false;
                }
            }else if (stack1.size()==0 && (clossing.contains(items.charAt(x)))){
                return false;
            }
            else{
                stack1.push(items.charAt(x));
            }
        }
        if (stack1.size()>0){
            return false;
        }

        return true;
    }


}

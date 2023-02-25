import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.function.Consumer;

public class Client {
    public static void main(String[] args) {
        String str = "()";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            Character character = str.charAt(i);
            switch (character) {
                case '(':
                case '{':
                case '[':
                   stack.push(character);
                   continue;
                default:break;
            }
            switch (character) {
                case ')': {
                    if (stack.pop() != '(')
                        return;
                    break;
                }
                case '}': {
                    if (stack.isEmpty() || stack.pop() != '{')
                        return;
                    break;
                }
                case ']': {
                    if (stack.pop() != '[')
                        return;
                    break;
                }
            }
        }

        System.out.println(stack.size());
    }


}

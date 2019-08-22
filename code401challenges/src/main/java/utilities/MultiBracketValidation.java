package utilities;

import stacksandqueues.Stack;

public class MultiBracketValidation {

    public static boolean multiBracketValidation(String input) {
        Stack<String> stack = new Stack<>();

        String[] inputs = input.split("");

        for (String i : inputs) {
            if (i.equals("(") || i.equals("{") || i.equals("[")) {
                stack.push(i);
            } else if (stack.peek().equals("(") && i.equals(")")) {
                stack.pop();
            } else if (stack.peek().equals("{") && i.equals("}")) {
                stack.pop();
            } else if (stack.peek().equals("[") && i.equals("]")) {
                stack.pop();
            }
        }

        return stack.peek() == null;
    }

}

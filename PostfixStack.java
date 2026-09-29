public class PostfixStack {
    int[] stack = new int[100];
    int top = -1;

    public void push(int value) {
        if (top == stack.length - 1) {
            System.out.println("Stack is full.");
            return;
        }

        top++;
        stack[top] = value;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return -1;
        }

        int value = stack[top];
        top--;
        return value;
    }

    public int peek() {
        if (top == -1) {
            return -1;
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public static int evaluate(String expression) {
        String[] values = expression.split(" ");
        PostfixStack stack = new PostfixStack();

        for (int i = 0; i < values.length; i++) {
            String value = values[i];

            if (value.equals("+") || value.equals("-") ||
                value.equals("*") || value.equals("/")) {

                int right = stack.pop();
                int left = stack.pop();
                int answer = 0;

                if (value.equals("+")) {
                    answer = left + right;
                } else if (value.equals("-")) {
                    answer = left - right;
                } else if (value.equals("*")) {
                    answer = left * right;
                } else if (value.equals("/")) {
                    answer = left / right;
                }

                stack.push(answer);
            } else {
                int number = Integer.parseInt(value);
                stack.push(number);
            }
        }

        return stack.pop();
    }
}

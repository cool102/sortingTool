import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
       Scanner sc= new Scanner(System.in);
        int deqSize = sc.nextInt();

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < deqSize; i++) {
            stack.push(sc.nextInt());
        }

        for (Integer curr:stack
             ) {
            System.out.println(stack.pop());
        }

    }
}
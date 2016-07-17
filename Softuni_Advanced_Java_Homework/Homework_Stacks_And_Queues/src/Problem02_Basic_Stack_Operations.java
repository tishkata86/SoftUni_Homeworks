import org.omg.PortableInterceptor.INACTIVE;

import java.util.Scanner;
import java.util.Stack;

public class Problem02_Basic_Stack_Operations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] params = sc.nextLine().split(" ");
        int elementsSize = Integer.parseInt(params[0]);
        int amountToPop = Integer.parseInt(params[1]);
        int isInArray = Integer.parseInt(params[2]);
        Stack<Integer> array = new Stack<>();

        for (int i = 0; i < elementsSize; i++) {
            array.push(sc.nextInt());
        }

        for (int i = 0; i < amountToPop; i++) {
            array.pop();
        }

        if (array.contains(isInArray)){
            System.out.println("true");
        } else {
            int min = 0;
            if (array.size() > 0){
                min = array.get(0);
                for (int i = 0; i < array.size(); i++) {
                    min = Integer.min(array.get(i), min);
                }
            }
            System.out.println(min);
        }
    }
}

/* Given two integer arrays pushed and popped each with distinct values, return true if this could have been the result of a sequence of push and pop operations on an initially empty stack, or false otherwise... 
 * Eg 1: pushed = [1, 2, 3, 4, 5]  popped = [4, 5, 3, 2, 1]     Validated = True
 * Eg 2: pushed = [1, 2, 3, 4, 5]  popped = [4, 5, 3, 1, 2]     Validated = False    Reason : 1 cannot be popped before 2...
*/
import java.util.*;
public class ValidateStack
{
    public boolean Validation(int pushed[], int popped[])
    {
        int i = 0, j = 0, loop = 0;
        boolean check = false;
        Stack<Integer> stack = new Stack<Integer>();
        while(loop != 1)
        {
            if(i != pushed.length)   // While all elements are not pushed...
            {
                stack.push(pushed[i]);
                if(pushed[i] == popped[j])    // If element to be popped is pushed...
                {
                    stack.pop();
                    i++;       // Increment both counters...
                    j++;
                }
                else
                    i++;      // Otherwise only increment pushed counter...
            }
            if(i == pushed.length)   // When all elements are pushed...
            {
                if(stack.isEmpty())
                    return true;
                if(stack.peek() == popped[j])    // If element to be popped is at the top...
                {
                    stack.pop();
                    j++;           // Remove element and increment popped counter...
                    if(j == popped.length)
                    {
                        check = true;    // If popped array is completely traversed...
                        loop = 1;
                    }
                }
                else    // If element to be popped is not at the top...
                    loop = 1;
            }
        }
        return check;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int x;
        System.out.print("Enter the number of Operations : ");
        x = sc.nextInt();
        int pushed[] = new int[x];
        int popped[] = new int[x];
        for(int i = 0; i < pushed.length; i++)
        {
            System.out.print("Enter "+(i+1)+" pushed element : ");
            pushed[i] = sc.nextInt();
        }
        for(int i = 0; i < pushed.length; i++)
        {
            System.out.print("Enter "+(i+1)+" popped element : ");
            popped[i] = sc.nextInt();
        }
        ValidateStack validate = new ValidateStack();   // Object creation...
        System.out.println("Stack Validated : "+validate.Validation(pushed, popped));
        sc.close();
    }
}

// Time Complexity  - O(n) time...
// Space Complexity - O(n) time...

/* DEDUCTIONS :-
 * 1. We use two pointers to point for pushed and popped array...
 * 2. We then redirect the pointers as per the operations...
 */
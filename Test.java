import java.util.*;

public class Test {
    private Scanner scanner = new Scanner(System.in);
    public int inputVaildPosInt(String prompt) {
        System.out.println(prompt);
        while (true) {
            boolean isValid = true;
            int value = 0;
            String textValue = scanner.nextLine();
            try {
                value = Integer.parseInt(textValue); 
                if(value <= 0)
                    isValid = false;
            } catch (Exception e) {
                isValid = false;
            }
            if (isValid) {
                System.out.println("See that wasn't so hard :D");
                return value;
            } else {
                System.out.println("ENTER A POSITIVE INTEGER!!!!!");
            }
        }
    }
    public static void main(String[] args) {
        Test test = new Test();
        test.inputVaildPosInt("Enter pages");
    }
}

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        boolean islessThan10 = scanner.nextInt() < 10? true : false;
        System.out.println(islessThan10);
    }
}
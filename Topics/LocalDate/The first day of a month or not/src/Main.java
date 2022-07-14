import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split("\\s");

        int year = Integer.parseInt(arr[0]);
        int day = Integer.parseInt(arr[1]);
        LocalDate date = LocalDate.ofYearDay(year, day);
       int candidate = date.getDayOfMonth();
       String result = candidate == 1 ? "true" : "false";
       System.out.println(result);
    }
}
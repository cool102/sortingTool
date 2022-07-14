import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split("\\s");
        int year = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        LocalDate date = LocalDate.of(year, month,1);
        int lengthOfMonth = date.lengthOfMonth();

        for (int i = 1; i <=lengthOfMonth ; i++) {
            LocalDate dateLoop = LocalDate.of(year, month,i);
            if (dateLoop.getDayOfWeek().toString().equals("MONDAY")) {
                System.out.println(dateLoop);
            }
        }



    }
}
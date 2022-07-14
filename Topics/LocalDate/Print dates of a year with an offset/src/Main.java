import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String strDate = scanner.nextLine();
        int offset = Integer.parseInt(scanner.nextLine());
        LocalDate date = LocalDate.parse(strDate);
        int nextYear = date.getYear() + 1;
        for (LocalDate currDate = date; currDate.getYear() < nextYear; currDate = currDate.plusDays(offset)) {

            System.out.println(currDate);
        }
    }

}
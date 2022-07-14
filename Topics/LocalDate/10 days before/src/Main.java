import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stringDate = scanner.nextLine();
        LocalDate date = LocalDate.parse(stringDate);
        System.out.println(date.minusDays(10));
    }
}
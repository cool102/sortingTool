import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();
      // LocalDate initialDate = LocalDate.of(year, month, 2);
      // LocalDate start = initialDate.withDayOfMonth(1);
      // LocalDate end = initialDate.withDayOfMonth(initialDate.getMonth().length(initialDate.isLeapYear()));

      LocalDate initial =  LocalDate.of(year, month, 2);
      LocalDate start = initial.with(firstDayOfMonth());
      LocalDate end = initial.with(lastDayOfMonth());



        System.out.println(start + " " + end);

    }
}
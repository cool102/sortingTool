import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String output = switch (input) {
            case "gryffindor" -> "bravery";
            case "hufflepuff" -> "loyalty";
            case "slytherin" -> "cunning";
            case "ravenclaw" -> "intellect";
            default -> "not a valid house";
        };
        System.out.println(output);
    }
}
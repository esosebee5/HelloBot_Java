import java.time.Instant;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static String name = "";
    private static boolean state = true;
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        show("Enter your name: ");
        name = getInputLine();
        showLine("Hello, " + name + ".");

        while (state) {
            show("\nEnter '1' for Clock, '2' to Calculate Age, or\n" +
                    "enter 'end' to terminate: ");
            chooseProgram(getInputLine());
        }
    }

    private static String getInputLine() {
        String in = input.nextLine();
        showLine("");
        return in;
    }

    private static void chooseProgram(String in) {
        switch (in) {
            case "end":
                endProgram();
                break;
            case "1":
                clock();
                break;
            case "2":
                calculateAge();
                break;
            default:

        }
    }

    private static void calculateAge() {
        startApp();

        // get month
        show("Enter your birth month: ");
        String mon = getInputLine();
        int month = getMonthNumber(mon);

        // get day
        int day = 0;
        while (day == 0) {
            show("On what day of the month were you born? ");
            day = getPositiveInt();
        }

        // get year
        int year = 0;
        while (year == 0) {
            show("Enter your birth year: ");
            year = getPositiveInt();
        }

        // get details of current time
        Date now = Date.from(Instant.now());
        String[] timePieces = now.toString().split(" ");
        String curMonth = timePieces[1];
        int currentMonth = getMonthNumber(curMonth);
        int currentDay = Integer.parseInt(timePieces[2]);
        int currentYear = Integer.parseInt(timePieces[5]);

        boolean alreadyHadBirthday = true;
        int daysTill = 0;
        int monthsTill = 0;
        if (month >= currentMonth && day >= currentDay) {
            alreadyHadBirthday = false;
            daysTill = day - currentDay;
            monthsTill = month - currentMonth;
        }

        // calculate age
        int age = currentYear - year;
        if (alreadyHadBirthday) {
            showLine("You are " + age + " years old.");
        } else {
            age--;
            showLine("You are " + age + " years old.");
            showLine("Your next birthday is in " + monthsTill +
                    " months and " + daysTill + " days.");
        }

        endApp();
    }

    private static void startApp() {
        showLine("--------------------------------");
    }

    private static void endApp() {
        showLine("--------------------------------");
    }

    private static int getPositiveInt() {
        try {
            int number = Integer.parseInt(getInputLine());
            if (number < 1) {
                throw new Exception();
            }
            return number;
        } catch (Exception e) {
            showLine("Please enter a positive integer.");
            return 0;
        }
    }

    private static void clock() {
        startApp();
        Date now = Date.from(Instant.now());
        String[] timePieces = now.toString().split(" ");
        showLine("The current time is " + timePieces[3]);
        endApp();
    }

    private static void endProgram() {
        state = false;
        show("User ended process.");
    }

    private static void show(String text) {
        System.out.print(text);
    }

    private static void showLine(String text) {
        show(text);
        show("\n");
    }

    private static int getMonthNumber(String m) {
        String month = m.toLowerCase();

        switch (month) {
            case ("january"):
            case ("jan"):
                return 1;
            case ("february"):
            case ("feb"):
                return 2;
            case ("march"):
            case ("mar"):
                return 3;
            case ("april"):
            case ("apr"):
                return 4;
            case ("may"):
                return 5;
            case ("june"):
            case ("jun"):
                return 6;
            case ("july"):
            case ("jul"):
                return 7;
            case ("august"):
            case ("aug"):
                return 8;
            case ("september"):
            case ("sep"):
                return 9;
            case ("october"):
            case ("oct"):
                return 10;
            case ("november"):
            case ("nov"):
                return 11;
            case ("december"):
            case ("dec"):
                return 12;
            default:
                return 0;
        }
    }

}

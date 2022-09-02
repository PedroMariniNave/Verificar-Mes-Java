package com.pedromarini.exercicio;

import com.pedromarini.exercicio.enums.Month;
import com.pedromarini.exercicio.utils.DateUtils;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        initProgram();
    }

    private static void initProgram() {
        Scanner scanner = new Scanner(System.in);
        requestInputs(scanner);
    }

    private static void requestInputs(Scanner scanner) {
        System.out.println("Digite o dia:");
        int day = getDayFromInput(scanner);

        System.out.println("Digite o mês:");
        Month month = getMonthFromInput(scanner);

        System.out.println("Digite o ano:");
        int year = getYearFromInput(scanner);

        String date = DateUtils.getDateString(day, month.getCalendarNumber(), year);
        if (!DateUtils.isValid(date)) {
            System.out.println("A data informada é inválida! Tente novamente.");
            requestInputs(scanner);
            return;
        }

        System.out.println("Dia " + day + " de " + month.getTranslation() + " de " + year + ".");
    }

    private static int getDayFromInput(Scanner scanner) {
        int day = -1;
        do {
            day = getNumberByString(scanner.nextLine());
            if (day == -1) System.out.println("O dia informado é inválido! Tente novamente.");
        } while (day <= 0 || day > 31);

        return day;
    }

    private static Month getMonthFromInput(Scanner scanner) {
        Month month = null;
        int calendarNumber;
        do {
            calendarNumber = getNumberByString(scanner.nextLine());
            month = Month.getByCalendarNumber(calendarNumber);
            if (month == null) System.out.println("O mês informado é inválido! Tente novamente.");
        } while (month == null);

        return month;
    }

    private static int getYearFromInput(Scanner scanner) {
        int year = -1;
        do {
            year = getNumberByString(scanner.nextLine());
            if (year == -1) System.out.println("O ano informado é inválido! Tente novamente.");
        } while (year <= 0);

        return year;
    }

    private static int getNumberByString(String str) {
        int number = -1;
        try {
            number = Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            // ignore
        }

        return number;
    }
}
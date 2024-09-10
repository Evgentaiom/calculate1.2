import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите выражение:");
            String input = scanner.nextLine();
            String result = calculate(input);  
            System.out.println(result);  
        }
    }

    public static String calculate(String input) {
        input = input.trim();// Удаление лишних пробелов
        // сложение
        if (input.contains("+")) {
            String[] parts = input.split("\\+");
            if (parts.length != 2) return "Неправильный формат выражения.";
            String str1 = parts[0].trim();
            String str2 = parts[1].trim();
            // Проверка длины строки
            if (str1.length() > 12 || str2.length() > 12) 
                return "Строка должна быть не длиннее 10 символов (включая кавычки)."; 
            
            return str1.substring(1, str1.length() - 1) + str2.substring(1, str2.length() - 1);
        }
        // вычитание
        if (input.contains("-")) {
            String[] parts = input.split("-");
            if (parts.length != 2) return "Неправильный формат выражения.";
            String str1 = parts[0].trim();
            String str2 = parts[1].trim();
            // Проверка длины строки
            if (str1.length() > 12 || str2.length() > 12) 
                return "Строка должна быть не длиннее 10 символов (включая кавычки).";
            return str1.substring(1, str1.length() - 1)
                       .replace(str2.substring(1, str2.length() - 1), "");
        }
        // умножение строки на число
        if (input.contains("*")) {
            String[] parts = input.split("\\*");
            if (parts.length != 2) return "Неправильный формат выражения.";
            String str = parts[0].trim();
            // Проверка длины строки
            if (str.length() > 12) return "Строка должна быть не длиннее 10 символов (включая кавычки).";
            int num;
            try {
                num = Integer.parseInt(parts[1].trim());
            } catch (NumberFormatException e) {
                return "Неправильный формат числа.";
            }
            // Проверка диапазона числа
            if (num < 1 || num > 10) return "Число должно быть в диапазоне от 1 до 10.";
            String repeatedStr = str.substring(1, str.length() - 1).repeat(num);
            if (repeatedStr.length() > 40) {
                return repeatedStr.substring(0, 40) + "...";
            } else {
                return repeatedStr;
            }
        }
        // деление строки на число
        if (input.contains("/")) {
            String[] parts = input.split("/");
            if (parts.length != 2) return "Неправильный формат выражения.";
            String str = parts[0].trim();
            // Проверка длины строки
            if (str.length() > 12) return "Строка должна быть не длиннее 10 символов (включая кавычки).";
            int num;
            try {
                num = Integer.parseInt(parts[1].trim());
            } catch (NumberFormatException e) {
                return "Неправильный формат числа.";
            }
            // Проверка диапазона числа
            if (num < 1 || num > 10) return "Число должно быть в диапазоне от 1 до 10.";
            String result = str.substring(1, str.length() - 1);
            if (num > result.length()) return "Делитель больше длины строки.";
            return result.substring(0, result.length() / num);
        }
        return "Операция неверна.";
    }
}

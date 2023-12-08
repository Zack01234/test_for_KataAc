import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        startCalc();

        while (true) {

            System.out.println("Input: ");
            String line = scanner.nextLine();

            if (line.equals("exit")) {
                exitCalc();
                break;
            }

            try {
                String[] symbols = line.split(" ");
                if (symbols.length != 3) throw new Exception("Ошибка. Попробуйте еще раз.");

                Number firstNumber = NumberService.parseAndValidate(symbols[0]);
                Number secondNumber = NumberService.parseAndValidate(symbols[2], firstNumber.getType());
                String result = ActionService.calculate(firstNumber, secondNumber, symbols[1]);
                System.out.println("Output: \n" + result);

            } catch (Exception e) {
                System.out.println(e.getMessage());
                exitCalc();
                break;
            }
        }

        scanner.close();
    }

    private static void startCalc() {
        System.out.println("Привет, я Калькулятор. Используйте только арабские и римские цифры от 1 до 10.");
        System.out.println("Возможны следующие операции: \nСложение(+), Вычитание(-), Умножение(*), Деление(/).");
        System.out.println("Для выхода из программы, введите 'exit'.");
    }

    private static void exitCalc() {

        System.out.println("=)");

    }
}

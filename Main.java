import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Задача 2: Минимальное из трех чисел
        //Условие:
        //Пользователь вводит три целых числа. Программа должна найти и вывести минимальное из них.
          Scanner in = new Scanner(System.in);
//        System.out.print("Input number 1: ");
//        int a = in.nextInt();
//        System.out.print("Input number 2: ");
//        int b = in.nextInt();
//        System.out.print("Input number 3: ");
//        int c = in.nextInt();
//        if (a < b && a < c){
//            System.out.println("минимальное первое число");
//        }
//        else if (c < b && c < a) {
//            System.out.println("минимальное третье число");
//        }
//        else {
//            System.out.println("минимальное второе число");
//        }

        // Задача 3: Таблица умножения
        //Условие:
        //Напишите программу, которая выводит таблицу умножения на 5 (от 1 до 10).
//        for (int i = 1; i < 11 ; i ++){
//            int j = i * 5;
//            System.out.printf("5 * %d = %d \n", i, j);
//        }

        //Задача 4: Сумма чисел от 1 до N
        //Условие:
        //Пользователь вводит целое число N. Программа должна вывести сумму всех чисел от 1 до N.
//        System.out.print("Input number N: ");
//        int n = in.nextInt();
//        int sum = 0;
//        for (int i = 1; i <= n; i++)
//        {
//            sum += i;
//        }
//        System.out.printf("сумма всех чисел от 1 до N = %d", sum);

        //Задача 5: Число Фибоначчи
        //Условие:
        //Пользователь вводит целое число N. Программа должна вывести первые N чисел Фибоначчи.
//        System.out.print("Введите целое число N: ");
//        int n = in.nextInt();
//        int a = 0, b = 1;
//        System.out.printf("Первые %d чисел Фибоначчи: ", n );
//        for (int i = 1; i <= n; i++) {
//            System.out.print(a + "; ");
//            int next = a + b;
//            a = b;
//            b = next;
//        }
//        System.out.println();

        //Задача 6: Проверка простого числа
        //Условие:
        //Пользователь вводит целое число. Программа должна проверить, является ли это число простым (делится только на 1 и само на себя).
//        System.out.println("Ваше число: ");
//        int num = in.nextInt();
//        int u = 0;
//        for (int i = 2; i < num; i++)
//        {
//            if ( num % i == 0)
//            {
//                System.out.println("это не простое число");
//                break;
//            }
//            else
//            {
//                u++;
//            }
//        }
//        if (u == num - 2){
//            System.out.println("это простое число");
//        }

        //Задача 7: Обратный порядок чисел
        //Условие:
        //Пользователь вводит целое число N. Программа должна вывести числа от N до 1 в обратном порядке.
//        System.out.println("Ваше число: ");
//        int num = in.nextInt();
//        while (num > 0) {
//            System.out.printf("%d ", num);
//            num--;
//        }

        //Задача 8: Сумма четных чисел
        //Условие:
        //Пользователь вводит два целых числа A и B. Программа должна найти сумму всех четных чисел в диапазоне от A до B (включительно).
//        System.out.println("число 1: ");
//        int num1 = in.nextInt();
//        System.out.println("число 2: ");
//        int num2 = in.nextInt();
//        int sum = 0;
//        for (int i = num1; i <= num2; i++) {
//            if (i % 2 == 0) {
//                sum += i;
//            }
//        }
//        System.out.printf("Сумма четных чисел от %d до %d: %d",num1, num2, sum);

        //Задача 9: Реверс строки
        //Условие:
        //Пользователь вводит строку. Программа должна вывести эту строку в обратном порядке.
//        System.out.println("Строка: ");
//        String str = in.nextLine();
//        String revers = new StringBuilder(str).reverse().toString();
//        System.out.printf("Обратная строка: %s ", revers);

        //Задача 10: Количество цифр в числе
        //Условие:
        //Пользователь вводит целое число. Программа должна вывести количество цифр в этом числе.
//        System.out.println("число: ");
//        int num = in.nextInt();
//        int count = String.valueOf(Math.abs(num)).length();
//        System.out.printf("количество цифр в этом числе: %d ", count);

        //Задача 11: Факториал числа
        //Условие:
        //Пользователь вводит целое число N. Программа должна вычислить факториал этого числа (N!).
//        System.out.println("число: ");
//        int num = in.nextInt();
//        int f = 1;
//        for (int i = 1; i <= num; i++)
//        {
//            f *= i;
//        }
//        System.out.printf("факториал %d => %d", num, f);

        //Задача 12: Сумма цифр числа
        //Условие:
        //Пользователь вводит целое число. Программа должна найти сумму всех цифр этого числа.
//        System.out.println("число: ");
//        int num = in.nextInt();
//        int sum = 0;
//        while (num != 0) {
//            sum += num % 10;
//            num /= 10;
//        }
//        System.out.printf("Сумма цифр числа: %d ", sum);


        //Задача 13: Палиндром
        //Условие:
        //Пользователь вводит строку. Программа должна проверить, является ли эта строка палиндромом (читается одинаково слева направо и справа налево).
//        System.out.println("Строка: ");
//        String str1 = in.nextLine();
//        String str = str1.replaceAll("[^a-zа-яА-ЯA-Z0-9]", "").toLowerCase();
//        String revers = new StringBuilder(str).reverse().toString();
//        System.out.println(str.equals(revers) ? "палиндром." : "не палиндром.");



        //Задача 14: Найти максимальное число в массиве
        //Условие:
        //Пользователь вводит размер массива и элементы массива. Программа должна найти и вывести максимальное число в массиве.
//        System.out.println("размер массива: ");
//        int size = in.nextInt();
//        int[] array = new int[size];
//        for (int i = 0; i < size; i++) {
//            System.out.printf("%d элемент массива: ", i+1);array[i] = in.nextInt();
//        }
//        int max = array[0];
//        for (int i = 1; i < size; i++) {
//            if (array[i] > max) {
//                max = array[i];
//            }
//        }
//        System.out.printf("Максимальное число в массиве: %d", max);


        //Задача 15: Сумма всех элементов массива
        //Условие:
        //Пользователь вводит размер массива и его элементы. Программа должна вычислить и вывести сумму всех элементов массива.
//        System.out.println("размер массива: ");
//        int size = in.nextInt();
//        int[] array = new int[size];
//        for (int i = 0; i < size; i++) {
//            System.out.printf("%d элемент массива: ", i+1);array[i] = in.nextInt();
//        }
//        int sum = 0;
//        for (int i = 0; i < size; i++) {
//            sum += array[i];
//        }
//        System.out.printf("Сумма всех элементов массива %d", sum);


        //Задача 16: Количество положительных и отрицательных чисел
        //Условие:
        //Пользователь вводит размер массива и его элементы. Программа должна подсчитать и вывести количество положительных и отрицательных чисел в массиве.
//        System.out.println("размер массива: ");
//        int size = in.nextInt();
//        int[] array = new int[size];
//        for (int i = 0; i < size; i++) {
//            System.out.printf("%d элемент массива: ", i+1);array[i] = in.nextInt();
//        }
//        int p = 0;
//        int m = 0;
//        boolean n = false;
//        for(int i = 0; i < size; i++){
//            if (array[i] < 0) m++;
//            else if (array[i] > 0) p++;
//            else if(array[i] == 0) n = true;
//        }
//        if (n == true) System.out.printf("количество положительных => %d,  отрицательных чисел => %d, в массиве есть 0", p, m);
//        else System.out.printf("количество положительных => %d,  отрицательных чисел => %d", p, m);



        //Задача 17: Простые числа в диапазоне
        //Условие:
        //Пользователь вводит два целых числа A и B. Программа должна вывести все простые числа в этом диапазоне (включительно).
//        System.out.println("число 1: ");
//        int num1 = in.nextInt();
//        System.out.println("число 2: ");
//        int num2 = in.nextInt();
//        for (int i = num1; i <= num2; i++) {
//            int u = 0;
//            for (int j = 2; j < i; j++)
//                {
//                    if ( i % j == 0) continue;
//                    else u++;
//                }
//                    if (u == i - 2) System.out.print(i + " ");
//        }




        //Задача 18: Подсчет гласных и согласных в строке
        //Условие:
        //Пользователь вводит строку. Программа должна подсчитать и вывести количество гласных и согласных букв в этой строке.
//        System.out.println("Введите строку: ");
//        String str1 = in.nextLine();
//        String str = str1.replaceAll("[^a-zа-яА-ЯA-Z0-9]", "").toLowerCase();
//        int vowel = 0;
//        int consonant = 0;
//        for (char ch : str.toCharArray()) if (Character.isLetter(ch)) {
//                if ("aeiouаоуеэяиюы".indexOf(ch) != -1) vowel++;
//                else consonant++;
//            }
//        System.out.printf("Количество гласных: %d\n", vowel);
//        System.out.printf("Количество согласных: %d", consonant);


        //Задача 19: Перестановка слов в строке
        //Условие:
        //Пользователь вводит строку, состоящую из нескольких слов. Программа должна вывести слова в обратном порядке.
//        System.out.println("Введите строку: ");
//        String str = in.nextLine();
//        String[] words = str.split(" ");
//        StringBuilder revers = new StringBuilder();
//        for (int i = words.length - 1; i >= 0; i--) {
//            revers.append(words[i]).append(" ");
//        }
//        System.out.println("в обратном порядке: " + revers.toString().trim());


        //Задача 20: Число Армстронга
        //Условие:
        //Пользователь вводит целое число. Программа должна проверить, является ли это число числом Армстронга (сумма цифр в степени, равной количеству цифр, равна самому числу).
//        System.out.println("Введите целое число: ");
//        int number = in.nextInt();
//        int originalNumber = number;
//        int digitsCount = String.valueOf(number).length();
//        int armstrongSum = 0;
//        while (number != 0) {
//            int digit = number % 10;
//            armstrongSum += (int) Math.pow(digit, digitsCount);
//            number /= 10;
//        }
//        System.out.println(armstrongSum == originalNumber ? originalNumber + " - число Армстронга." : originalNumber + " - не число Армстронга.");

        //1. Функция для нахождения максимума.
        //Напишите функцию, которая принимает два числа и возвращает максимальное из них. Если числа равны, выбрасывайте исключение с сообщением об ошибке.
//        System.out.print("Введите первое число: ");
//        int num1 = in.nextInt();
//        System.out.print("Введите второе число: ");
//        int num2 = in.nextInt();
//        try {
//            int max = findMax(num1, num2);
//            System.out.println("Максимальное число: " + max);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

        //2. Калькулятор деления.
        //Создайте функцию для деления двух чисел. Если делитель равен нулю, выбрасывайте ArithmeticException с сообщением о недопустимости деления на ноль.
//        System.out.print("Введите числитель: ");
//        double numerator = in.nextDouble();
//        System.out.print("Введите знаменатель: ");
//        double denominator = in.nextDouble();
//        try {
//            double result = divide(numerator, denominator);
//            System.out.println("Результат деления: " + result);
//        } catch (ArithmeticException e) {
//            System.out.println(e.getMessage());
//        }

        //3. Конвертер строк в числа.
        //Напишите функцию, которая принимает строку и пытается конвертировать её в целое число. Если строка не может быть конвертирована, выбрасывайте NumberFormatException.
//        System.out.print("Введите строку: ");
//        String input = in.nextLine();
//        try {
//            int result = convertToInt(input);
//            System.out.println("Конвертированное число: " + result);
//        } catch (NumberFormatException e) {
//            System.out.println(e.getMessage());
//        }

        //4. Проверка возраста.
        //Создайте функцию, которая принимает возраст и выбрасывает IllegalArgumentException, если возраст меньше нуля или больше 150.
//        System.out.print("Введите возраст: ");
//        int age = in.nextInt();
//        try {
//            checkAge(age);
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }

        //5. Нахождение корня.
        //Реализуйте функцию, которая находит корень из числа. Если число отрицательное, выбрасывайте IllegalArgumentException.
//        System.out.print("Введите число: ");
//        double number = in.nextDouble();
//        try {
//            double result = findSquareRoot(number);
//            System.out.println("Корень из числа: " + result);
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }

        //6. Факториал.
        //Напишите функцию, которая вычисляет факториал числа. Если число отрицательное, выбрасывайте исключение.
        System.out.print("Введите число: ");
        int number = in.nextInt();

        try {
            long result = factorial(number);
            System.out.println("Факториал числа " + number + " равен: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        //7. Проверка массива на нули.
        //Создайте функцию, которая проверяет массив на наличие нулей. Если в массиве есть нули, выбрасывайте исключение.
//        System.out.print("Введите количество элементов в массиве: ");
//        int size = in.nextInt();
//        int[] array = new int[size];
//        System.out.println("Введите элементы массива:");
//        for (int i = 0; i < size; i++) {
//            System.out.print("Элемент " + (i + 1) + ": ");
//            array[i] = in.nextInt();
//        }
//        try {
//            checkForZeros(array);
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }

        //8. Калькулятор возведения в степень.
        //Реализуйте функцию, которая возводит число в степень. Если степень отрицательная, выбрасывайте исключение.
//        System.out.print("Введите основание: ");
//        double base = in.nextDouble();
//        System.out.print("Введите степень: ");
//        int exponent = in.nextInt();
//        try {
//            double result = power(base, exponent);
//            System.out.println(base + " в степени " + exponent + " равно: " + result);
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }

        //9. Обрезка строки.
        //Напишите функцию, которая принимает строку и число символов. Функция должна возвращать строку, обрезанную до указанного числа символов. Если число символов больше длины строки, выбрасывайте исключение.
//        System.out.print("Введите строку: ");
//        String input = in.nextLine();
//        System.out.print("Введите число символов: ");
//        int length = in.nextInt();
//        try {
//            String result = trimString(input, length);
//            System.out.println("Обрезанная строка: " + result);
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }

        //10. Поиск элемента в массиве.
        //Напишите функцию, которая ищет элемент в массиве. Если элемент не найден, выбрасывайте исключение с сообщением об ошибке.
//        System.out.print("Введите количество элементов в массиве: ");
//        int size = in.nextInt();
//        int[] array = new int[size];
//        System.out.println("Введите элементы массива:");
//        for (int i = 0; i < size; i++) {
//            System.out.print("Элемент " + (i + 1) + ": ");
//            array[i] = in.nextInt();
//        }
//        System.out.print("Введите элемент для поиска: ");
//        int element = in.nextInt();
//        try {
//            findElement(array, element);
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }
//        in.close();
    }
    public static int findMax(int a, int b) throws Exception {
        if (a == b) {
            throw new Exception("Ошибка: числа равны");
        }
        return Math.max(a, b);
    }
    public static double divide(double numerator, double denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Ошибка: деление на ноль недопустимо");
        }
        return numerator / denominator;
    }
    public static int convertToInt(String str) throws NumberFormatException {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Ошибка: строка не может быть конвертирована в целое число");
        }
    }
    public static void checkAge(int age) throws IllegalArgumentException {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Ошибка: возраст должен быть в диапазоне от 0 до 150");
        }
        System.out.println("Возраст корректен: " + age);
    }
    public static double findSquareRoot(double number) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException("Ошибка: невозможно найти корень из отрицательного числа");
        }
        return Math.sqrt(number);
    }
    public static long factorial(int number) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException("Ошибка: факториал отрицательного числа не определен");
        }
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
    public static void checkForZeros(int[] array) throws IllegalArgumentException {
        for (int num : array) {
            if (num == 0) {
                throw new IllegalArgumentException("Ошибка: массив содержит ноль");
            }
        }
        System.out.println("Массив не содержит нулей.");
    }
    public static double power(double base, int exponent) throws IllegalArgumentException {
        if (exponent < 0) {
            throw new IllegalArgumentException("Ошибка: степень не может быть отрицательной");
        }
        return Math.pow(base, exponent);
    }
    public static String trimString(String input, int length) throws IllegalArgumentException {
        if (length > input.length()) {
            throw new IllegalArgumentException("Ошибка: число символов больше длины строки");
        }
        return input.substring(0, length);
    }
    public static void findElement(int[] array, int element) throws IllegalArgumentException {
        for (int num : array) {
            if (num == element) {
                System.out.println("Элемент " + element + " найден в массиве.");
                return;
            }
        }
        throw new IllegalArgumentException("Ошибка: элемент " + element + " не найден в массиве");
    }
}
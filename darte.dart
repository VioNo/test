import 'dart:io';

void main() {
  print('Введите целое число:');
  String? input = stdin.readLineSync();

  if (input != null && input.isNotEmpty) {
    try {
      int number = int.parse(input);

      if (number % 2 == 0) {
        print('$number является четным числом.');
      } else {
        print('$number является нечетным числом.');
      }
    } catch (e) {
      print('Ошибка: Введенное значение не является целым числом.');
    }
  } else {
    print('Ошибка: Ввод пуст.');
  }
}







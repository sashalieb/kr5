/* Вариант3
Создать базовый класс с функцией – сумма прогрессии. Создать производные классы: арифметическая
прогрессия и геометрическая прогрессия. Каждый класс имеет два поля типа double. Первое – первый член прогрессии,
 второе – постоянная разность (для арифметической) и постоянное отношение (для геометрической). Определить функцию
 вычисления суммы, где параметром является количество элементов прогрессии.

Для каждого класса провести модульное тестирование основных методов класса.

*/

// Базовый класс для прогрессий
public abstract class Progression {
    protected double firstTerm;
    protected double second;

    // Конструктор базового класса
    public Progression(double firstTerm, double second) {
        this.firstTerm = firstTerm;
        this.second = second;
    }

    // Абстрактный метод для вычисления суммы прогрессии
    public abstract double sum(int n);
}

// Класс для арифметической прогрессии
public class ArithmeticProgression extends Progression {

    // Конструктор для арифметической прогрессии
    public ArithmeticProgression(double firstTerm, double difference) {
        super(firstTerm, difference);
    }

    // Реализация метода для вычисления суммы арифметической прогрессии
    @Override
    public double sum(int n) {
        // Формула суммы арифметической прогрессии: S_n = n/2 * (2a + (n - 1)d)
        return n / 2.0 * (2 * firstTerm + (n - 1) * second);
    }
}

// Класс для геометрической прогрессии
public class GeometricProgression extends Progression {

    // Конструктор для геометрической прогрессии
    public GeometricProgression(double firstTerm, double otn) {
        super(firstTerm, otn);
    }

    // Реализация метода для вычисления суммы геометрической прогрессии
    @Override
    public double sum(int n) {
        // Формула суммы геометрической прогрессии: S_n = a * (1 - r^n) / (1 - r), если r != 1
        if (second == 1) {
            return firstTerm * n; // Если r == 1, сумма просто n * a
        }
        return firstTerm * (1 - Math.pow(second, n)) / (1 - second);
    }
}

// Тестовый класс для проверки методов каждого класса
public class Main {
    public static void main(String[] args) {
        // Тестирование арифметической прогрессии
        ArithmeticProgression arithProg = new ArithmeticProgression(1, 2);
        System.out.println("Arithmetic Progression Sum (n=5): " + arithProg.sum(5));
        // Ожидаемый результат: 1 + 3 + 5 + 7 + 9 = 25

        // Тестирование геометрической прогрессии
        GeometricProgression geomProg = new GeometricProgression(2, 3);
        System.out.println("Geometric Progression Sum (n=4): " + geomProg.sum(4));
        // Ожидаемый результат: 2 + 6 + 18 + 54 = 80

        // Тестирование геометрической прогрессии с r = 1
        GeometricProgression geomProgR1 = new GeometricProgression(2, 1);
        System.out.println("Geometric Progression Sum (n=4, r=1): " + geomProgR1.sum(4));
        // Ожидаемый результат: 2 + 2 + 2 + 2 = 8
    }
}

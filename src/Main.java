import java.net.SocketOption;
import java.time.LocalDate;

public class Main {

    /**
     * Определяет, високосный ли год,переданный в качестве параметра
     * @param year int - год
     */
    public static void task1(int year)
    {
        if (
                year > 1584
                        && year % 4 == 0
                        && (year % 100 != 0 || year % 400 == 0)
        ) {
            System.out.println(year +  " год — високосный год");
        } else {
            System.out.println(year +  " год — невисокосный год");
        }
    }

    /**
     * Определяет, какую версию приложения надо установить на телефон
     * @param clientOS int - тип ОС телефона:  0 - iOS, 1 - Андроид
     * @param clientDeviceYear int - год выпуска телефона
     */
    public static void task2(int clientOS, int clientDeviceYear)
    {
        int currentYear = LocalDate.now().getYear(); // Текущий год
        // версия системы
        byte versionOS = 0; // начальное значение 00B - облегченная для iOS

        // iOS или Андроид?
        if (clientOS == 1) {
            versionOS += 1; // устанавливаем 0-й бит, если Андроид
        }

        // современная или облегченная?
        if (clientDeviceYear >= currentYear) {
            versionOS += 2; // устанавливаем 1-й бит, если современная
        }

        switch (versionOS) {
            case 0:
                System.out.println("Установите облегченную версию приложения для iOS по ссылке");
                break;
            case 1:
                System.out.println("Установите облегченную версию приложения для Android по ссылке");
                break;
            case 2:
                System.out.println("Установите версию приложения для iOS по ссылке");
                break;
            default:
                System.out.println("Установите версию приложения для Android по ссылке");
        }
    }

    /**
     * Определяет количество дней, необходимое для доставки заказа, в зависимости от расстояния
     * @param deliveryDistance int - расстояние доставки
     * @return int - кол-во дней для доставки
     */
    public static int task3(int deliveryDistance)
    {
        int deliveryDays;

        if (deliveryDistance <= 20) {
            // до 20 км - 1 сутки
            deliveryDays = 1;
        } else if (deliveryDistance <= 60) {
            // от 20 до 60 км - 2 суток
            deliveryDays = 2;
        } else if (deliveryDistance <= 100) {
            // от 60 до 100 км - 3 суток
            deliveryDays = 3;
        } else {
            // свыше 100 км - доставка не производится
            deliveryDays = -1;
        }

        return deliveryDays;
    }

    public static void main(String[] args) {
        // Задача 1
        System.out.println("Задача 1");
        task1(2024);
        System.out.println("-----");

        // Задача 2
        System.out.println("Задача 2");
        task2(0, 2023);
        System.out.println("-----");

        // Задача 3
        System.out.println("Задача 3");
        int deliveryDays = task3(95);
        if (deliveryDays < 0) {
            System.out.println("Расстояние свыше 100 км - доставка не производится");
        } else {
            System.out.println("Потребуется дней: " + deliveryDays);
        }
        System.out.println("-----");
    }
}
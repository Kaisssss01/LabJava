import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task7_14 {

    public static void main(String[] args) {

        // 1. Определяем размеры матрицы (6 дней в неделю, 7 пар в день)
        int days = 6; // Дней в неделю (изменили на 6, как в задании)
        int pairs = 7; // Пар в день (изменили на 7, как в задании)

        // 2. Создаем матрицу (расписание студента)
        int[][] schedule = new int[days][pairs];

        // 3. Заполняем матрицу случайными числами (номер предмета от 1 до 9, 0 - нет занятия)
        Random random = new Random();
        for (int i = 0; i < days; i++) {
            for (int j = 0; j < pairs; j++) {
                int lessonNumber = random.nextInt(2); // Случайное число от 0 до 9
                schedule[i][j] = lessonNumber; // Сохраняем в расписание
            }
        }

        // 4. Выводим расписание на экран
        System.out.println("Расписание студента на неделю:");
        printSchedule(schedule, days, pairs);

        // 5. Находим "окна" в расписании
        List<String> windows = findWindows(schedule, days, pairs);

        // 6. Выводим найденные "окна"
        System.out.println("nНайденные 'окна' в расписании:");
        if (windows.isEmpty()) {
            System.out.println("Окон не найдено.");
        } else {
            for (String window : windows) {
                System.out.println(window);
            }
        }
    }

    // Функция для поиска "окон" в расписании
    public static List<String> findWindows(int[][] schedule, int days, int pairs) {
        List<String> windows = new ArrayList<>(); // Список для хранения найденных "окон"

        for (int i = 0; i < days; i++) { // Проходим по каждому дню
            for (int j = 0; j < pairs; j++) { // Проходим по каждой паре

                if (schedule[i][j] == 0) { // Если текущая пара свободна
                    // Проверяем, является ли это началом "окна"
                    boolean isWindowStart = true;
                    if (j > 0 && schedule[i][j - 1] == 0) {  //Если предыдущая пара тоже равна нулю, то это не начало "окна"
                        isWindowStart = false;
                    }

                    if (isWindowStart) { //Если это начало "окна"
                        int windowEnd = j;
                        //Находим конец этого окна
                        while(windowEnd < pairs && schedule[i][windowEnd] == 0){
                            windowEnd++;
                        }
                        //Проверяем, что перед окном есть занятия и после
                        boolean hasBefore = j > 0;
                        if (j > 0) hasBefore = schedule[i][j-1] != 0;

                        boolean hasAfter = windowEnd < pairs;
                        if (windowEnd < pairs) hasAfter = schedule[i][windowEnd] != 0;

                        if(hasBefore && hasAfter){
                            windows.add("День " + (i + 1) + ", пары " + (j + 1) + "-" + windowEnd);
                            j = windowEnd - 1; //Сдвигаем счетчик цикла for (int j = 0; j < pairs; j++)
                        }
                    }
                }
            }
        }

        return windows;
    }

    // Функция для вывода расписания на экран
    public static void printSchedule(int[][] schedule, int days, int pairs) {
        System.out.println("-----------------------------------------");

        System.out.print("    ");
        for (int j = 0; j < pairs; j++) {
            System.out.printf(" %d ", j + 1);
        }
        System.out.println();

        System.out.println("-----------------------------------------");

        for (int i = 0; i < days; i++) {
            System.out.printf(" %d |", i + 1);
            for (int j = 0; j < pairs; j++) {
                System.out.printf(" %d ", schedule[i][j]);
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------");
        System.out.println("0 - нет занятия, 1-9 - номер предмета");
    }
}
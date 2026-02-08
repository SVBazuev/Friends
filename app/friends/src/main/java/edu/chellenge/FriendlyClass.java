package edu.chellenge;


import java.util.*;
import java.util.Map.Entry;


public class FriendlyClass {

    private static final Set<String> NAMES = new HashSet<>(Arrays.asList(
        "Лёша", "Влад", "Миша", "Вова", "Саня", "Коля",
        "Дима", "Толя", "Ваня", "Петя", "Олег", "Сеня",
        "Лёня", "Егор", "Витя", "Стас", "Глеб", "Илья",
        "Женя", "Вика", "Нина", "Анна", "Соня", "Рита",
        "Лика", "Маша", "Лиля", "Роза", "Таня", "Надя",
        "Алла", "Даша", "Кира", "Лена", "Тоня", "Люда"
    ));

    // TODO заполните availableNames стримом из friends.json
    private static List<String> availableNames = new ArrayList<>(NAMES);
    private static Map<String, List<String>> friends = new LinkedHashMap<>();

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {

        int count = 1;        // TODO Это dev-var, в далнейшем проверку
        while (count-- > 0) { // условия надо реализовать в shouldContinue
            int len = friends.size();

            if (len == 0) {
                addFirstFriend();
            } else if (len < 4) {
                addNextFriend();
            } else {
                addLateFriend(len);
            }
        }

        // dev-output
        for (Entry<String, List<String>> entry : friends.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // ========== МЕТОДЫ ДОБАВЛЕНИЯ ДРУЗЕЙ =============================

    private static void addFirstFriend() {
        String key = getRandomName();
        List<String> value = getRandomName(6);
        friends.put(key, value);
    }

    private static void addNextFriend() {
        // TODO метод добавляет новые элементы в friends
        // по базовому алгоритму
    }

    private static void addLateFriend(int len) {
        // TODO метод добавляет новые элементы в friends
        // начиная с 5-го элемента
    }

    // ========== ВСПОМОГАТЕЛЬНЫЕ МЕТОДЫ ===============================

    private static String getRandomName() throws IllegalStateException {
        if (availableNames.isEmpty()) {
            // Если вдруг ваша реализация выгребет все доступные имена
            throw new IllegalStateException("Не осталось имён для выбора");
        }
        int index = RANDOM.nextInt(availableNames.size());
        String name = availableNames.get(index);
        availableNames.remove(index);
        return name;
    }

    private static List<String> getRandomName(int count) {
        List<String> value = new ArrayList<>(count);
        while (count-- > 0) {
            value.add(getRandomName());
        }
        return value;
    }

    // TODO здесь реализуйте другие вспомогателные методы

    // =========== МЕТОДЫ ПРОВЕРКИ =====================================

    private static boolean shouldContinue() {
        int len = friends.size();
        if (len == 0) return true;

        // TODO дальше ваша реализация
        return false;
    }

    // TODO здесь реализуйте другие методы проверки

}

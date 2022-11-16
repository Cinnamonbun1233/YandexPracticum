package JavaCore_2.Sprint_7.Theme_1.Tests.Test_1;

import java.util.LinkedList;
import java.util.List;

class StringsSaver {
    // количество запоминаемых строк
    public static final int MAX_SIZE = 3;

    // связный список для быстрого удаления с начала
    private List<String> saved = new LinkedList<>();

    // сохранить новую строку
    public void save(String line) {
        if (saved.size() == MAX_SIZE) {
            saved.remove(0);
        }
        saved.add(line);
    }

    // получить последние MAX_SIZE сохранённых строк
    public List<String> getSaved() {
        return saved;
    }
}

public class Practicum {
    public static void main(String[] args) {
        StringsSaver saver = new StringsSaver();
        saver.save("Пользователь залогинился.");
        saver.save("Пользователь загрузил фото.");
        saver.save("Пользователь пополнил счёт.");
        saver.save("Пользователь продлил подписку.");
        saver.save("Пользователь опубликовал пост.");
        System.out.println(saver.getSaved());
    }
}
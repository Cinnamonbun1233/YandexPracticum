package JavaCore_2.Sprint_7.Theme_1.Tests.Test_2;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.List;

class StringsSaver {
    // количество запоминаемых строк
    public static final int MAX_SIZE = 3;

    private List<String> saved = new LinkedList<>();

    private boolean doAddDate; // добавлять ли дату?
    private boolean doPrintErrors; // добавлять ли error?

    public void setDoAddDate(boolean doAddDate) {
        this.doAddDate = doAddDate;
    }

    public void setDoPrintErrors(boolean doPrintErrors) {
        this.doPrintErrors = doPrintErrors;
    }

    // сохранить строку
    public void save(String line) {
        if (saved.size() == MAX_SIZE) {
            saved.remove(0);
        }

        if (doAddDate) {
            line = "[" + LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES) + "] " + line;
        }
        saved.add(line);

        if (line.contains("ERROR")) {
            System.out.println(line);
        }
    }

    // получить последние MAX_SIZE сохранённых строк
    public List<String> getSaved() {
        return saved;
    }
}

public class Practicum {
    public static void main(String[] args) {
        StringsSaver saver = new StringsSaver();
        saver.setDoAddDate(true); // включаем режим
        saver.setDoPrintErrors(true);
        saver.save("Пользователь залогинился.");
        saver.save("Пользователь загрузил фото.");
        saver.save("Пользователь пополнил счёт.");
        saver.save("Пользователь продлил подписку.");
        saver.save("Пользователь опубликовал пост.");
        System.out.println(saver.getSaved());
    }
}
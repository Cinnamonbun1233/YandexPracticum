package JavaCore_2.Sprint_7.Theme_1.Tests.Test_7;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

interface StringsSaverConfig {
    // как нужно преобразовать сохраняемую строку?
    String transform(String line);

    // дополнительное действие при сохранении
    void onSave(String line);
}

class StringsSaver {
    public static final int MAX_SIZE = 10_000;

    private List<String> saved = new LinkedList<>();
    private StringsSaverConfig config;

    public StringsSaver(StringsSaverConfig config) {
        this.config = config;
    }

    public void save(String line) {
        if (saved.size() == MAX_SIZE) {
            saved.remove(0);
        }
        line = config.transform(line);
        saved.add(line);
        config.onSave(line);
    }

    public List<String> getSaved() {
        return saved;
    }
}

public class Practicum {
    public static String getKeyword() {
        return "ERROR";
    }

    public static void main(String[] args) {
        String keyWord = getKeyword();

        StringsSaverConfig config = new StringsSaverConfig() {
            final int lineLengthLimit = 100;

            @Override
            public String transform(String line) {
                return "[" + LocalDateTime.now() + "] " + line;
            }

            @Override
            public void onSave(String line) {
                if (line.contains(keyWord)) { // <- локальная переменная
                    if (line.length() > lineLengthLimit) {
                        line = line.substring(0, lineLengthLimit) + "...";
                    }
                    System.out.println(line);
                }
            }
        };

        StringsSaver saver = new StringsSaver(config);
        saver.save("Пользователь залогинился");
        saver.save("ERROR Пользователь загрузил фото");
        saver.save("Пользователь пополнил счёт");
        saver.save("Пользователь купил артефакт");
        saver.save("ERROR Пользователь опубликовал пост");
        System.out.println(saver.getSaved());

        // Менять эту локальную переменную теперь нельзя
        // Раскомментирование строки ниже приведёт к ошибке компиляции
        // keyWord = "WARN";
    }
}
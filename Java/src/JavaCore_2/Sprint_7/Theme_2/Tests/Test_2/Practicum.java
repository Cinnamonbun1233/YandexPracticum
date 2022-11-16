package JavaCore_2.Sprint_7.Theme_2.Tests.Test_2;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

interface StringsSaverTransformer {
    // как нужно преобразовать сохраняемую строку?
    String transform(String line);
}

@FunctionalInterface
interface StringsConsumer {
    void accept(String value);
}

class StringsSaver {
    public static final int MAX_SIZE = 10_000;

    private List<String> saved = new LinkedList<>();
    private StringsSaverTransformer transformer;
    private StringsConsumer onSaveListener;
    private StringsConsumer onRemoveListener;

    public void setTransformer(StringsSaverTransformer transformer) {
        this.transformer = transformer;
    }

    public void onSave(StringsConsumer onSaveListener) {
        this.onSaveListener = onSaveListener;
    }

    public void onRemove(StringsConsumer onRemoveListener) {
        this.onRemoveListener = onRemoveListener;
    }

    public void save(String line) {
        if (saved.size() == MAX_SIZE) {
            String removedLine = saved.remove(0);
            if (onRemoveListener != null) {
                onRemoveListener.accept(removedLine);
            }
        }
        if (transformer != null) {
            line = transformer.transform(line);
        }
        saved.add(line);
        if (onSaveListener != null) {
            onSaveListener.accept(line);
        }
    }

    public List<String> getSaved() {
        return saved;
    }
}

public class Practicum {
    public static void main(String[] args) {
        StringsSaver saver = new StringsSaver();

        saver.setTransformer(new StringsSaverTransformer() {
            @Override
            public String transform(String line) {
                return "[" + LocalDateTime.now() + "] " + line;
            }
        });

        saver.onSave(new StringsConsumer() {
            final int lineLengthLimit = 100;

            @Override
            public void accept(String line) {
                if (line.contains("ERROR")) {
                    if (line.length() > lineLengthLimit) {
                        line = line.substring(0, lineLengthLimit) + "...";
                    }
                    System.out.println(line);
                }
            }
        });

        saver.save("Пользователь залогинился.");
        saver.save("ERROR Пользователь загрузил фото.");
        saver.save("Пользователь пополнил счёт.");
        saver.save("Пользователь продлил подписку.");
        saver.save("ERROR Пользователь опубликовал пост.");

        System.out.println(saver.getSaved());
    }
}
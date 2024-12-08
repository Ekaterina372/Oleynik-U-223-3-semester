package TASK8;

// Класс Memento, представляющий снимок состояния текстового редактора
class Memento {
  private String text;

  public Memento(String text) {
      this.text = text;
  }

  public String getText() {
      return text;
  }
}

// Класс TextEditor (Создатель) — сам текстовый редактор
class TextEditor {
  private String text;

  public TextEditor(String text) {
      this.text = text;
  }

  public void setText(String text) {
      this.text = text;
  }

  public String getText() {
      return text;
  }

  // Метод для создания снимка текущего состояния
  public Memento save() {
      return new Memento(text);
  }

  // Метод для восстановления состояния из снимка
  public void restore(Memento memento) {
      this.text = memento.getText();
  }
}

// Класс TextEditorHistory (Хранитель), который управляет снимками
class TextEditorHistory {
  private Memento memento;

  public void saveMemento(Memento memento) {
      this.memento = memento;
  }

  public Memento getMemento() {
      return memento;
  }
}

// Главный класс для демонстрации паттерна Снимок
public class TextEditorMementoPattern {

  public static void main(String[] args) {
      // Создание текстового редактора и редактирование текста
      TextEditor editor = new TextEditor("Первоначальный текст");

      // Сохранение состояния
      TextEditorHistory history = new TextEditorHistory();
      history.saveMemento(editor.save());

      System.out.println("Текущий текст: " + editor.getText());

      // Изменение текста
      editor.setText("Измененный текст");
      System.out.println("Текущий текст после изменения: " + editor.getText());

      // Восстановление состояния
      editor.restore(history.getMemento());
      System.out.println("Текущий текст после восстановления: " + editor.getText());
  }
}


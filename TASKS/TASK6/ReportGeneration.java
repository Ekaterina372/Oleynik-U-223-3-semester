package TASK6;

abstract class Report {

  // Шаблонный метод: общий алгоритм для генерации отчета
  public final void generateReport() {
      fetchData();
      formatData();
      generateContent();
      printReport();
  }

  // Шаг 1: Сбор данных (общий для всех отчетов)
  protected abstract void fetchData();

  // Шаг 2: Форматирование данных (общий для всех отчетов)
  protected abstract void formatData();

  // Шаг 3: Генерация содержимого отчета (различается в зависимости от типа отчета)
  protected abstract void generateContent();

  // Шаг 4: Печать отчета (общий для всех отчетов)
  private void printReport() {
      System.out.println("Отчет напечатан.");
  }
}

// Конкретный отчет: График
class GraphReport extends Report {
  @Override
  protected void fetchData() {
      System.out.println("Сбор данных для графика.");
  }

  @Override
  protected void formatData() {
      System.out.println("Форматирование данных для графика.");
  }

  @Override
  protected void generateContent() {
      System.out.println("Генерация графического контента.");
  }
}

// Конкретный отчет: Текстовый отчет
class TextReport extends Report {
  @Override
  protected void fetchData() {
      System.out.println("Сбор текстовых данных.");
  }

  @Override
  protected void formatData() {
      System.out.println("Форматирование текста.");
  }

  @Override
  protected void generateContent() {
      System.out.println("Генерация текстового контента.");
  }
}

// Конкретный отчет: Таблица
class TableReport extends Report {
  @Override
  protected void fetchData() {
      System.out.println("Сбор данных для таблицы.");
  }

  @Override
  protected void formatData() {
      System.out.println("Форматирование данных для таблицы.");
  }

  @Override
  protected void generateContent() {
      System.out.println("Генерация контента таблицы.");
  }
}

// Главный класс для демонстрации
public class ReportGeneration {

  public static void main(String[] args) {
      // Создание различных типов отчетов
      Report graphReport = new GraphReport();
      Report textReport = new TextReport();
      Report tableReport = new TableReport();

      // Генерация отчетов
      System.out.println("Генерация графического отчета:");
      graphReport.generateReport();

      System.out.println("\nГенерация текстового отчета:");
      textReport.generateReport();

      System.out.println("\nГенерация табличного отчета:");
      tableReport.generateReport();
  }
}

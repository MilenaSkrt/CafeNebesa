package cafe.nebesa.report;

import java.time.LocalDate;

// Абстрактный класс Report
public abstract class Report {
    protected LocalDate startDate;
    protected LocalDate endDate;

    public Report(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Шаблонный метод: общий алгоритм
    public final void createReport() {
        fetchData();
        processData();
        formatReport();
        printReport();
    }

    // Этапы алгоритма
    protected abstract void fetchData();  // Сбор данных
    protected abstract void processData(); // Обработка данных
    protected abstract void formatReport(); // Форматирование отчета

    // Общий этап - печать отчета
    protected void printReport() {
        System.out.println("Отчет сформирован с " + startDate + " по " + endDate + ".");
    }
}

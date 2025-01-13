package cafe.nebesa.report;

import java.time.LocalDate;

// Отчет о продажах
public class SalesReport extends Report {
    public SalesReport(LocalDate startDate, LocalDate endDate) {
        super(startDate, endDate);
    }

    @Override
    protected void fetchData() {
        System.out.println("Сбор данных о продажах за период с " + startDate + " по " + endDate + ".");
    }

    @Override
    protected void processData() {
        System.out.println("Обработка данных о продажах...");
    }

    @Override
    protected void formatReport() {
        System.out.println("Форматирование отчета о продажах...");
    }
}

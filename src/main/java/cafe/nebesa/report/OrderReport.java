package cafe.nebesa.report;

import java.time.LocalDate;

// Отчет о заказах
public class OrderReport extends Report {
    public OrderReport(LocalDate startDate, LocalDate endDate) {
        super(startDate, endDate);
    }

    @Override
    protected void fetchData() {
        System.out.println("Сбор данных о заказах за период с " + startDate + " по " + endDate + ".");
    }

    @Override
    protected void processData() {
        System.out.println("Обработка данных о заказах...");
    }

    @Override
    protected void formatReport() {
        System.out.println("Форматирование отчета о заказах...");
    }
}

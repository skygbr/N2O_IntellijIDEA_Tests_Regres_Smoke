package businessFramework.module.hospital.pages.prescriptionOnceExecution;


import businessFramework.module.Values;

public interface PrescriprionOnceExecutionValues extends Values
{
    String BREADCRUMB_TEXT              = "Списать на пациента";

    // Список Списанные перепараты

    String COLUMN_HOLDING           = "Препарат";
    String COLUMN_DOSE              = "Доза";
    String COLUMN_FROM              = "Период с";
    String COLUMN_TO                = "Период по";
    String COLUMN_PERIODICITY       = "Периодичность";
    String COLUMN_EMPLOYEE          = "Сотрудник";

    // Список Товарные запасы склада

    String COLUMN_MODIFICATION      = "Модификация";
    String COLUMN_STORE             = "Склад";
    String COLUMN_FUNDING_SOURCE    = "Финансирование";

    //Форма Лекаственное назначение

    String CONFIRM_BUTTON_LABEL_TEXT    = "Списать на пациента";

    // Модальное окно

    String MODAl_HOLDING_BALANCE_TITLE  = "Товарные запасы склада";

}

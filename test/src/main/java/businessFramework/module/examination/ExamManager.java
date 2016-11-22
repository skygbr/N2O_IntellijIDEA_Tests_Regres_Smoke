package businessFramework.module.examination;

import businessFramework.module.examination.pages.qualityExam.QualityExamPage;
import net.framework.autotesting.ApplicationManager;
import net.framework.autotesting.meta.Page;

public class ExamManager {
    private Page page = Page.getInstance();
    private ApplicationManager app = ApplicationManager.getInstance();

    /**
     * Получение страницы Экспертиза качества мед.помощи
     * @return страницу Экспертиза качества мед.помощи
     */
    public QualityExamPage getQualityExaminationPage() {
        return new QualityExamPage(app);
    }

    /**
     * Открытие модуля Экспертиза
     */
    public void openExaminationModule() {
        page.getHeader().openModule("modules.examination");
    }

    /**
     * Открытие страницы Экспертиза качества мед.помощи
     */
    public void openQualityExamination() {
        page.getHeader().openSpaceAndPage("Экспертиза качества медицинской помощи", "examination.qualityExamination");
    }

    /**
     * Открытие страницы Врачебные комиссии
     */
    public void openCommissionList() {
        page.getHeader().openSpaceAndPage("Врачебная комиссия", "examination.examCommissionList");
    }
}

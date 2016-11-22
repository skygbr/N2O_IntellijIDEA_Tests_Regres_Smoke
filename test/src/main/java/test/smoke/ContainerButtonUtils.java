package test.smoke;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebElement;

import java.util.*;


public class ContainerButtonUtils
{

    static Log log = LogFactory.getLog(ContainerButtonUtils.class);

    static Set<String> createButtonNames    = new HashSet<String>(Arrays.asList("Создать", "Добавить", "Создать(Ins)", "Создать (Ins)", "Добавить(Ins)", "Добавить (Ins)"));
    static Set<String> editButtonNames      = new HashSet<String>(Arrays.asList("Редактировать", "Изменить", "Изменить (Enter)", "Изменить(Enter)"));
    static Set<String> deleteButtonNames    = new HashSet<String>(Arrays.asList("Удалить", "Удалить(Enter)", "Удалить (Enter)", "Удалить(Del)", "Удалить (Del)"));

    /**
     * Метод заполняет список доступных кнопок для указанного контейнера на странице.
     *
     * @param buttonType            Кнопка
     * @param containerIdentifier   Идентификатор контейнера
     * @param containerInfo         Информация о контейнере, куда добавить кнопки
     */
    public static void addButtonToContainer(WebElement buttonType, ContainerIdentifier containerIdentifier, ContainerInfo containerInfo, TestExclusions exclusions, TestInclusions inclusions)
    {
        ContainerButtonType containerButtonType = null; // Создадим переменную buttonType типа класса ContainerButtonType enum. Пока null.
        String buttonText                       = buttonType.getText(); // Получим текст очередной кнопки.

        if (buttonText != null && !"".equals(buttonText)) // Если текст не null и не пустая строка - то будем заполнять переменную значением в зависимости от текста кнопки.
        {

            if (createButtonNames.contains(buttonText))
            {
                containerButtonType = ContainerButtonType.Create;
            }

            else if (editButtonNames.contains(buttonText))
            {
                containerButtonType = ContainerButtonType.Edit;
            }

            else if (deleteButtonNames.contains(buttonText))
            {
                containerButtonType = ContainerButtonType.Delete;
            }

            log.debug("Button: '" + buttonText + "' => "+ containerButtonType);

            if (containerButtonType != null
                    && !containerInfo.buttons.contains(containerButtonType)
                    && !exclusions.isButtonExcluded(containerIdentifier, containerButtonType)
                    && (inclusions == null || inclusions.isButtonIncluded(containerIdentifier, containerButtonType)))
            {
                containerInfo.buttons.add(containerButtonType); // И добавить тип кнопки в список кнопок.
                log.debug(String.format("CurrentContainerId = '%s'; Added button '%s' as '%s'", containerIdentifier.containerId, buttonText, containerButtonType));
            }
        }
    }
}

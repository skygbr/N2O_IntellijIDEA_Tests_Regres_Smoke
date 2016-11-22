package test.smoke;

import java.util.ArrayList;
import java.util.List;

/**
 * Здесь содержится:
 *
 * - список кнопок, которые есть в контейнере,
 * - идентификатор созданной записи,
 * - информацию, есть ли в контейнере фильтр,
 * - есть ли в контейнере таблица
 * - список заговолков столбцов таблицы
 */
public class ContainerInfo
{
    public List<ContainerButtonType> buttons = new ArrayList<ContainerButtonType>();
    /**
     * Идентификатор созданный записи
     */
    public Long createdId;

    public boolean hasFilter;

    public boolean hasTable;

    public List<String> tableColumns = new ArrayList<String>();
}

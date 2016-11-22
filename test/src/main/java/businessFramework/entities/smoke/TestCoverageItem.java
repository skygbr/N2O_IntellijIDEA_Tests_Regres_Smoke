package businessFramework.entities.smoke;

import test.smoke.ContainerButtonType;
import test.smoke.ContainerIdentifier;

import java.util.ArrayList;
import java.util.List;

/**
 * Данные о покрытии контейнера и кнопок
 */
public class TestCoverageItem
{
    public ContainerIdentifier container;
    public List<ContainerButtonType> buttons = new ArrayList<>();
}

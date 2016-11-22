package businessFramework.module.hospital.modals.loadDoctors;


import businessFramework.entities.hospital.HospitalData;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LoadDoctorsModal implements LoadDoctorsValues
{
    private LoadDoctorsHelper loadDoctorsHelper;

    public LoadDoctorsModal()
    {
        loadDoctorsHelper = new LoadDoctorsHelper();
    }

    public LoadDoctorsModal(String locator)
    {
        loadDoctorsHelper = new LoadDoctorsHelper(locator);
    }

    /**
     * Проверяем информацию о загруженности врачей
     */
    public void assertLoadDoctors(Map<String, String> doctors, HospitalData hospitalData)
    {
        loadDoctorsHelper.getContainer().showFilter();
        loadDoctorsHelper.getDepartment().assertValue_contains(hospitalData.getDepartment());

        for (Map.Entry entry : doctors.entrySet()) {
            Map<String, String> doc = new HashMap<>();
            doc.put(LoadDoctorsValues.DOCTOR_FIELD, entry.getKey().toString());
            int row = loadDoctorsHelper.getContainer().getTable().getRowNumberBySeveralColumnValues(doc, true);

            StringBuffer output = new StringBuffer();
            output.append(loadDoctorsHelper.getContainer().getTable().getRowColumnIntersectionValue(row, LoadDoctorsValues.COUNT_PATIENTS_FIELD, true));
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(output);
            int result = 0;
            int start = 0;
            while (matcher.find(start)) {
                String value = output.substring(matcher.start(), matcher.end());
                result = result + Integer.parseInt(value);
                start = matcher.end();
            }

            assertThat(String.format("Count doctor's %s patients doesn't contains %s", entry.getKey(), entry.getValue()),
                    Integer.parseInt(String.valueOf(entry.getValue())), is(result));
        }
    }
}

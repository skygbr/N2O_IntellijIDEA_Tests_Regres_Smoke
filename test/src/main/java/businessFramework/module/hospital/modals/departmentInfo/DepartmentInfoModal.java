package businessFramework.module.hospital.modals.departmentInfo;


import businessFramework.entities.hospital.HospitalData;

import java.util.Map;

public class DepartmentInfoModal
{
    private DepartmentInfoHelper departmentInfoHelper;

    public DepartmentInfoModal()
    {
        departmentInfoHelper = new DepartmentInfoHelper();
    }

    public DepartmentInfoModal(String locator)
    {
        departmentInfoHelper = new DepartmentInfoHelper(locator);
    }

    public void assertDepartmentInfo(Map<String, String> info, HospitalData hospitalData)
    {
        departmentInfoHelper.getContainer().showFilter();
        departmentInfoHelper.getDepartment().assertValue_contains(hospitalData.getDepartment());
        departmentInfoHelper.getContainer().getTable().assertThatTableContainsOnlyXRows(1);
        departmentInfoHelper.getContainer().getTable().assertThatRowColumnsIntersectionValueContains(0, info);
    }
}

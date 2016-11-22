package businessFramework.module.hospital.modals.doctorHistory;


public class DoctorHistoryModal
{
    private DoctorHistoryHelper doctorHistoryHelper;

    public DoctorHistoryModal()
    {
        doctorHistoryHelper = new DoctorHistoryHelper();
    }

    public DoctorHistoryModal(String locator)
    {
        doctorHistoryHelper = new DoctorHistoryHelper(locator);
    }

    public void assertCountDoctors(int count)
    {
        doctorHistoryHelper.getContainer().getTable().assertThatTableContainsOnlyXRows(count);
    }
}

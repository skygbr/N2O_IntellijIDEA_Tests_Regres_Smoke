package businessFramework.entities.hospital;

/**
 * Created by bulat.garipov on 28.01.2016.
 */
public class EmployeeRoleData {
    private String role;
    private String department;
    private String employee;
    private String position;
    private String copyToEmployee;

    public EmployeeRoleData() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCopyToEmployee() {
        return copyToEmployee;
    }

    public void setCopyToEmployee(String copyToEmployee) {
        this.copyToEmployee = copyToEmployee;
    }
}

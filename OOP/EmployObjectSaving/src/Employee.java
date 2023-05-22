import java.io.Serializable;

public class Employee implements Serializable {
    private int id;
    private String name;
    private String department;
    private double expLevel;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getExpLevel() {
        return expLevel;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setExpLevel(double expLevel) {
        this.expLevel = expLevel;
    }
}

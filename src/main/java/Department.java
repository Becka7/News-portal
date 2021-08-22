import org.sql2o.Connection;

import java.util.ArrayList;
import java.util.Objects;

public class Department implements DatabaseManagement {
    private int id;
    private String name;
    private String description;
    private int employees;
    private static ArrayList<Department> mInstance = new ArrayList<>();

    public Department(String name, String description, int employees){
        this.name = name;
        this.description = description;
        this.employees = employees;
        mInstance.add(this);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getEmployees() {
        return employees;
    }

    public static ArrayList<Department> getmInstance() {
        return mInstance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id && employees == that.employees && Objects.equals(name, that.name) && Objects.equals(description, that.description);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, employees);
    }

    @Override
    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO departments (name , description, employees) VALUES (:name,:department,:employees)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("name", this.description)
                    .addParameter("Developer", this.employees)
                    .executeUpdate()
                    .getKey();
        }
    }

}

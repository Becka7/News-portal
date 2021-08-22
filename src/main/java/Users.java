import org.sql2o.Connection;

import java.util.ArrayList;
import java.util.Objects;

public class Users implements DatabaseManagement{
    private int id;
    private String name;
    private int department_id;
    private String role;
    private static ArrayList<Users> mInstance = new ArrayList<>();

    public Users(String name,String role,int department_id){
        this.name=name;
        this.role=role;
        this.department_id=department_id;
        mInstance.add(this);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public String getRole() {
        return role;
    }

    public static ArrayList<Users> getmInstance() {
        return mInstance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id && department_id == users.department_id && Objects.equals(name, users.name) && Objects.equals(role, users.role);
    }

    @Override
    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO users (name , department_id, role) VALUES (:name,:id,:role)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("name", this.department_id)
                    .addParameter("Developer", this.role)
                    .executeUpdate()
                    .getKey();
        }

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, department_id, role);
    }




}

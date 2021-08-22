import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    void InstanceOfDepartment_IsCreated_Successfully() {
        Department department = new Department("Foods","This department deals with all articles concerning food",34);
        assertEquals(true, true);
    }


    public Department setUpInstanceOf_NewDepartment() {
        Department department = new Department("Fashion","This department deals with all articles concerning food",45);
        return department;
    }

    public Department setUpAnotherDepartment() {
        Department department = new Department("Love","This department deals with all articles concerning food",50);
        return department;
    }


    @Test
    void getName_returnsCorrectNameOfDepartment() {
        Department department=setUpInstanceOf_NewDepartment();
        assertEquals("Fashion",department.getName());
    }

    @Test
    void getDepartmentIdAssertsTrue() {
        Department department=setUpAnotherDepartment();
        assertEquals(50, department.getEmployees());

    }

}
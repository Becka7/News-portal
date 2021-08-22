import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsersTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
     void InstanceOfUser_IsCreated_Successfully() {
        Users users = new Users("Becka", "Senior DEveloper", 4);
        assertEquals(true, true);
    }


        public Users setUpInstanceOf_NewUser() {
            Users users = new Users("Mercy","Senior DEveloper",4);
            return users;
        }

        public Users setUpAnotherUser() {
            Users users = new Users("Essy","Senior DEveloper",4);
            return users;
        }


    @Test
    void getName_returnsCorrectNameOfUser() {
        Users users=setUpInstanceOf_NewUser();
                assertEquals("Mercy",users.getName());
    }

    @Test
    void getDepartmentIdAssertsTrue() {
        Users users=setUpAnotherUser();
               assertEquals(4,users.getDepartment_id());

    }
}
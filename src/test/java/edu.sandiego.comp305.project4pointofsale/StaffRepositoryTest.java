package edu.sandiego.comp305.project4pointofsale;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StaffRepositoryTest {

    @Test
    void loadDefaultStaff() {
        StaffRepository repository = new StaffRepository();

        assertEquals(4, repository.getStaffCount());
    }

    @Test
    void findByPinServer() {

        StaffRepository repository = new StaffRepository();
        Staff staff = repository.findByPin("1234");

        assertInstanceOf(Server.class, staff);
        assertEquals(StaffRole.SERVER, staff.getRole());
    }

    @Test
    void findByPinChef() {

        StaffRepository repository = new StaffRepository();
        Staff staff = repository.findByPin("4321");

        assertInstanceOf(Chef.class, staff);
        assertEquals(StaffRole.CHEF, staff.getRole());
    }



}
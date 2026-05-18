package edu.sandiego.comp305.project4pointofsale;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StaffRepositoryTest {

    @Test
    void loadDefaultStaff() {
        final StaffRepository repository = new StaffRepository();

        assertEquals(4, repository.getStaffCount());
    }

    @Test
    void findByPasswordServer() {

        final StaffRepository repository = new StaffRepository();
        final Staff staff = repository.findByPassword("1234");

        assertInstanceOf(Server.class, staff);
        assertEquals(StaffRole.SERVER, staff.getRole());
    }

    @Test
    void findByPasswordChef() {

        final StaffRepository repository = new StaffRepository();
        final Staff staff = repository.findByPassword("2345");

        assertInstanceOf(Chef.class, staff);
        assertEquals(StaffRole.CHEF, staff.getRole());
    }

    @Test
    void findByPasswordNull() {

        final StaffRepository repository = new StaffRepository();
        final Staff staff = repository.findByPassword("4444");

        assertNull(staff);
    }

    @Test
    void countDefaultStaffInRepo() {
        final StaffRepository repository = new StaffRepository();

        int[] staffCount = repository.getRoleCounts();

        assertEquals(2, staffCount[0]);
        assertEquals(2, staffCount[1]);
    }


}

package edu.sandiego.comp305.project4pointofsale;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginServiceTest {

    @Test
    void loginServer() {
        final StaffRepository staffRepository = new StaffRepository();
        final LoginService loginService = new LoginService(staffRepository);

        final Staff server = loginService.login("1234");

        assertEquals(StaffRole.SERVER, server.getRole());
    }

    @Test
    void loginChef(){
        final StaffRepository staffRepository = new StaffRepository();
        final LoginService loginService = new LoginService(staffRepository);

        final Staff chef = loginService.login("2345");

        assertEquals(StaffRole.CHEF, chef.getRole());
    }

}

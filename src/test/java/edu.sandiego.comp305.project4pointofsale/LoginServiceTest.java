package edu.sandiego.comp305.project4pointofsale;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginServiceTest {

    @Test
    void loginServer() {
        StaffRepository staffRepository = new StaffRepository();
        LoginService loginService = new LoginService(staffRepository);

        Staff server = loginService.login("1234");

        assertEquals(StaffRole.SERVER, server.getRole());
    }

    @Test
    void loginChef(){
        StaffRepository staffRepository = new StaffRepository();
        LoginService loginService = new LoginService(staffRepository);

        Staff chef = loginService.login("4321");

        assertEquals(StaffRole.CHEF, chef.getRole());
    }

}
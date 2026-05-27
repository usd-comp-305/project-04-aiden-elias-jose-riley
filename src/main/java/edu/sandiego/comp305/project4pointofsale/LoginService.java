package edu.sandiego.comp305.project4pointofsale;

public class LoginService {
    private final StaffRepository staffRepo;

    public LoginService(final StaffRepository staffRepo) {
        this.staffRepo = staffRepo;
    }

    public Staff login(final String password){
        return staffRepo.findByPassword(password);
    }
}

package edu.sandiego.comp305.project4pointofsale;

import java.util.ArrayList;
import java.util.List;

public class StaffRepository {

    private final List<Staff> staffMembers;

    public StaffRepository(){
        this.staffMembers = new ArrayList<>();
        loadDefaultStaff();
    }

    public void loadDefaultStaff(){

        staffMembers.add(new Server(1, "Elias", "1234"));
        staffMembers.add(new Server(2, "Aiden", "4321"));
        staffMembers.add(new Chef(3, "Riley", "2345"));
        staffMembers.add(new Chef(4, "Jose", "3456"));

    }

    public Staff findByPassword(final String password){
        for (Staff staff : staffMembers){
            if (staff.createPassword(password)){
                return staff;
            }
        }
        return null;
    }

    public int getStaffCount(){
        return staffMembers.size();
    }


}

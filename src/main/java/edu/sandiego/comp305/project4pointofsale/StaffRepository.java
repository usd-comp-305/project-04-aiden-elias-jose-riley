package edu.sandiego.comp305.project4pointofsale;

import java.util.ArrayList;
import java.util.List;

public class StaffRepository {

    private final List<Staff> staffMembers;

    public StaffRepository(){
        this.staffMembers = new ArrayList<>();
    }

    public void loadDefaultStaff(){

    }

    public Staff findByPin(final String pin){
        return null;
    }

    public int getStaffCount(){
        return 0;
    }


}

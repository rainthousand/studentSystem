package com.example.studentsystem.pattern.state_Role;

public abstract class   State_Role {
//    public void doAction(Context_Role context_role);

    protected Context_Role context_role;
    public void doAction(Context_Role context_role){this.context_role=context_role;};
    abstract void shiftAdmin();
    abstract void shiftNotReg();
    abstract void shiftTeacher();
    abstract void shiftStudent();

}

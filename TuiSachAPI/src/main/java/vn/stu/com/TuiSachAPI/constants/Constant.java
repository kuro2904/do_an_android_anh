package vn.stu.com.TuiSachAPI.constants;

public class Constant {
    public static final String LOGIN_SUCCESSFUL = "Login Successful";
    public static final String LOGIN_WRONG_PASSWORD = "Incorrect username or password";
    public static final String LOGIN_UNAUTHORIZED = "This user is not existed";
    public static final String REGISTER_USER_EXISTED = "This user already existed";
    public static final String REGISTER_SUCCESSFUL = "Register Successful";
    public static String nullError(String type){
        return type + " is null";
    }
}

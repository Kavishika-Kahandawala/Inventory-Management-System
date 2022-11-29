package Code;

import Code.loginModel;
//import GUI.adminCourseView;
public class loginController {
    loginModel objlogin;
    //adminCourseView objcourse;
    //String  course;
    
    public loginModel validateuser(String uname, String pass, String usertype) {
        objlogin = new loginModel(uname, pass, usertype);
        return objlogin;

    }
  
}

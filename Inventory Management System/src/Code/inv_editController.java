package Code;

import Code.inv_editModel;
//import GUI.adminCourseView;
public class inv_editController {
    inv_editModel obj_inv_edit;
    //adminCourseView objcourse;
    //String  course;
    
    public inv_editModel transferpid(int pid) {
        obj_inv_edit = new inv_editModel(pid);
        return obj_inv_edit;

    }
  
}

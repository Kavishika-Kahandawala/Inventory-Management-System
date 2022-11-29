package Code;

public  class loginModel {

    private static String uname;
    private static String pass;
    private static String usertype;

    public loginModel(String uname, String pass, String usertype) {
        this.uname = uname;
        this.pass = pass;
        this.usertype = usertype;
    }
    
    
    static public String getUname() {
        return uname;

    }

    /*public void setUname(String uname) {
        this.uname = uname;
    }*/
    
    public String getPass() {
        return pass;
    }

    static public String getUtype() {
        return usertype;
    }

    @Override
    public String toString() {
        return this.pass;
    }


}

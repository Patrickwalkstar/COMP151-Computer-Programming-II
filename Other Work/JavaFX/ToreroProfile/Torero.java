
public class Torero {
    private String studentName;
    private int gradClass;
    private String major;
    private String hometown;
    boolean livesOnCampus;

    public Torero(String n) {
        studentName = n;
        gradClass = 2099;
        major = "undeclared";
        hometown = null;
        livesOnCampus = false;
    }
    
    public Torero(String n, int c, String m, String h, boolean l) {
        studentName = n;
        gradClass = c;
        major = m;
        hometown = h;
        livesOnCampus = l;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getGradClass() {
        return gradClass;
    }
    
    public String getMajor() {
        return major;
    }
   
    
    public String getHometown() {
        return hometown;
    }
    
    public boolean getLivesOnCampus() {
        return livesOnCampus;
    }
    
}

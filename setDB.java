package com.surveyData.Project04;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.transform.Result;
import java.io.Serializable;
import java.sql.*;
import java.sql.Connection;


@SessionScoped
@ManagedBean (eager = true)
public class setDB implements Serializable
{
    public Connection getConnection() throws Exception {
        try {
            Connect connection = new Connect();
            Connection con = connection.connect();
            if (con != null)
                return con;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new Exception("Error in getConnection", e);
        }
        return null;
    }


    public String createUser() throws Exception
    {
        try {
            Connection con = new setDB().getConnection();
            PreparedStatement stmt = con.prepareStatement("BEGIN IF NOT EXISTS (SELECT * FROM survey_data WHERE USERNAME = ?) BEGIN INSERT INTO survey_data (USERNAME, PASSWORD) VALUES (?, ?) END END");
            stmt.setString(1, user);
            stmt.setString(2, user);
            stmt.setString(3, pass);

            int row = stmt.executeUpdate();
            System.out.println(row); //row affected

            return "Login";
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            throw new Exception("Error in createUser()", exception);
        }
    }
    public String toWelcome() throws Exception
    {
        try
        {
            Connection con = new setDB().getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT USERNAME FROM survey_data WHERE USERNAME = ? AND PASSWORD = ?");
            stmt.setString(1, user);
            stmt.setString(2, pass);

            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                return "WelcomePage";
            }

            return "ReLoginPage";
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            throw new Exception("Error in toWelcome", exception);
        }
    }

    public String toCategory1() throws Exception
    {
        try
        {
        Connection con = new setDB().getConnection();
        PreparedStatement stmt = con.prepareStatement("UPDATE survey_data SET COURSE = ?, INSTRUCTOR = ?, STUDENT = ? WHERE USERNAME = ?");
        stmt.setString(1, course);
        stmt.setString(2, instructor);
        stmt.setString(3, studentName);
        stmt.setString(4, user);

        int row = stmt.executeUpdate();
        System.out.println(row); //row affected

        return "Category1";
        }
        catch (Exception exception)
        {
        exception.printStackTrace();
        throw new Exception("Error in toCategory1", exception);
        }
    }

    public String toCategory2() throws Exception
    {
        try
        {
            Connection con = new setDB().getConnection();
            PreparedStatement stmt = con.prepareStatement("UPDATE survey_data SET ANSWER1 = ?, ANSWER2 = ?, ANSWER3 = ?," +
                    " ANSWER4 = ?, ANSWER5 = ?, ANSWER6 = ?, ANSWER7 = ?, ANSWER8 = ?, ANSWER9 = ?, ANSWER10 = ?, " +
                    "COMMENT1 = ? WHERE USERNAME = ?");
            stmt.setString(1, answer1);
            stmt.setString(2, answer2);
            stmt.setString(3, answer3);
            stmt.setString(4, answer4);
            stmt.setString(5, answer5);
            stmt.setString(6, answer6);
            stmt.setString(7, answer7);
            stmt.setString(8, answer8);
            stmt.setString(9, answer9);
            stmt.setString(10, answer10);
            stmt.setString(11, comment1);
            stmt.setString(12, user);

            int row = stmt.executeUpdate();
            System.out.println(row); //row affected

            return "Category2";
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            throw new Exception("Error in toCategory2", exception);
        }
    }

    public String toCategory3() throws Exception
    {
        try
        {
            Connection con = new setDB().getConnection();
            PreparedStatement stmt = con.prepareStatement("UPDATE survey_data SET ANSWER11 = ?, ANSWER12 = ?, " +
                    "ANSWER13 = ?, COMMENT2 = ? WHERE USERNAME = ?");
            stmt.setString(1, answer11);
            stmt.setString(2, answer12);
            stmt.setString(3, answer13);
            stmt.setString(4, comment2);
            stmt.setString(5, user);


            int row = stmt.executeUpdate();
            System.out.println(row); //row affected

            return "Category3";
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            throw new Exception("Error in toCategory3", exception);
        }
    }

    public String toCategory4() throws Exception
    {
        try
        {
            Connection con = new setDB().getConnection();
            PreparedStatement stmt = con.prepareStatement("UPDATE survey_data SET ANSWER14 = ?, " +
                    "ANSWER15 = ?, ANSWER16 = ?, COMMENT3 = ? WHERE USERNAME = ?");
            stmt.setString(1, answer14);
            stmt.setString(2, answer15);
            stmt.setString(3, answer16);
            stmt.setString(4, comment3);
            stmt.setString(5, user);


            int row = stmt.executeUpdate();
            System.out.println(row); //row affected

            return "Category4";
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            throw new Exception("Error in toCategory4", exception);
        }
    }

    public String toCategory5() throws Exception
    {
        try
        {
            Connection con = new setDB().getConnection();
            PreparedStatement stmt = con.prepareStatement("UPDATE survey_data SET ANSWER17 = ?, ANSWER18 = ?, " +
                    "ANSWER19 = ?, ANSWER20 = ?, ANSWER21 = ?, COMMENT4 = ? WHERE USERNAME = ?");
            stmt.setString(1, answer17);
            stmt.setString(2, answer18);
            stmt.setString(3, answer19);
            stmt.setString(4, answer20);
            stmt.setString(5, answer21);
            stmt.setString(6, comment4);
            stmt.setString(7, user);

            int row = stmt.executeUpdate();
            System.out.println(row); //row affected

            return "Category5";
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            throw new Exception("Error in toCategory5", exception);
        }
    }

    public String toCategory6() throws Exception
    {
        try
        {
            Connection con = new setDB().getConnection();
            PreparedStatement stmt = con.prepareStatement("UPDATE survey_data SET ANSWER22 = ?, " +
                    "ANSWER23 = ?, ANSWER24 = ?, ANSWER25 = ?, COMMENT5 = ? WHERE USERNAME = ?");
            stmt.setString(1, answer22);
            stmt.setString(2, answer23);
            stmt.setString(3, answer24);
            stmt.setString(4, answer25);
            stmt.setString(5, comment5);
            stmt.setString(6, user);


            int row = stmt.executeUpdate();
            System.out.println(row); //row affected

            return "Category6";
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            throw new Exception("Error in toCategory6", exception);
        }
    }

    public String toCategory7() throws Exception
    {
        try
        {
            Connection con = new setDB().getConnection();
            PreparedStatement stmt = con.prepareStatement("UPDATE survey_data SET ANSWER26 = ?, " +
                    "ANSWER27 = ?, COMMENT6 = ? WHERE USERNAME = ?");
            stmt.setString(1, answer26);
            stmt.setString(2, answer27);
            stmt.setString(3, comment6);
            stmt.setString(4, user);


            int row = stmt.executeUpdate();
            System.out.println(row); //row affected

            return "Category7";
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            throw new Exception("Error in toCategory7", exception);
        }
    }

    public String toResult() throws Exception
    {
        try
        {
            Connection con = new setDB().getConnection();
            PreparedStatement stmt = con.prepareStatement("UPDATE survey_data SET COMMENT7 = ?, " +
                    "COMMENT8 = ?, COMMENT9 = ?, COMMENT10 = ? WHERE USERNAME = ?");
            stmt.setString(1, comment7);
            stmt.setString(2, comment8);
            stmt.setString(3, comment9);
            stmt.setString(4, comment10);
            stmt.setString(5, user);
            int row = stmt.executeUpdate();
            System.out.println(row); //row affected

            stmt = con.prepareStatement("SELECT * FROM survey_data WHERE USERNAME = ?");
            stmt.setString(1, user);


            ResultSet set = stmt.executeQuery();
            while (set.next())
            {
                for(int i = 1; i <=42; i++)
                {
                    results[i] = set.getString(i);
                }
            }

            return "Result";
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            throw new Exception("Error in toCategory7", exception);
        }
    }


    private String[] results = new String[43];
    private String user;
    private String pass;
    private String course;
    private String instructor;
    private String studentName;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String answer5;
    private String answer6;
    private String answer7;
    private String answer8;
    private String answer9;
    private String answer10;
    private String answer11;
    private String answer12;
    private String answer13;
    private String answer14;
    private String answer15;
    private String answer16;
    private String answer17;
    private String answer18;
    private String answer19;
    private String answer20;
    private String answer21;
    private String answer22;
    private String answer23;

    public String[] getResults() {
        return results;
    }

    public void setResults(String[] results) {
        this.results = results;
    }

    private String answer24;
    private String answer25;
    private String answer26;
    private String answer27;
    private String comment1;
    private String comment2;
    private String comment3;
    private String comment4;
    private String comment5;
    private String comment6;
    private String comment7;
    private String comment8;
    private String comment9;
    private String comment10;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getAnswer5() {
        return answer5;
    }

    public void setAnswer5(String answer5) {
        this.answer5 = answer5;
    }

    public String getAnswer6() {
        return answer6;
    }

    public void setAnswer6(String answer6) {
        this.answer6 = answer6;
    }

    public String getAnswer7() {
        return answer7;
    }

    public void setAnswer7(String answer7) {
        this.answer7 = answer7;
    }

    public String getAnswer8() {
        return answer8;
    }

    public void setAnswer8(String answer8) {
        this.answer8 = answer8;
    }

    public String getAnswer9() {
        return answer9;
    }

    public void setAnswer9(String answer9) {
        this.answer9 = answer9;
    }

    public String getAnswer10() {
        return answer10;
    }

    public void setAnswer10(String answer10) {
        this.answer10 = answer10;
    }

    public String getAnswer11() {
        return answer11;
    }

    public void setAnswer11(String answer11) {
        this.answer11 = answer11;
    }

    public String getAnswer12() {
        return answer12;
    }

    public void setAnswer12(String answer12) {
        this.answer12 = answer12;
    }

    public String getAnswer13() {
        return answer13;
    }

    public void setAnswer13(String answer13) {
        this.answer13 = answer13;
    }

    public String getAnswer14() {
        return answer14;
    }

    public void setAnswer14(String answer14) {
        this.answer14 = answer14;
    }

    public String getAnswer15() {
        return answer15;
    }

    public void setAnswer15(String answer15) {
        this.answer15 = answer15;
    }

    public String getAnswer16() {
        return answer16;
    }

    public void setAnswer16(String answer16) {
        this.answer16 = answer16;
    }

    public String getAnswer17() {
        return answer17;
    }

    public void setAnswer17(String answer17) {
        this.answer17 = answer17;
    }

    public String getAnswer18() {
        return answer18;
    }

    public void setAnswer18(String answer18) {
        this.answer18 = answer18;
    }

    public String getAnswer19() {
        return answer19;
    }

    public void setAnswer19(String answer19) {
        this.answer19 = answer19;
    }

    public String getAnswer20() {
        return answer20;
    }

    public void setAnswer20(String answer20) {
        this.answer20 = answer20;
    }

    public String getAnswer21() {
        return answer21;
    }

    public void setAnswer21(String answer21) {
        this.answer21 = answer21;
    }

    public String getAnswer22() {
        return answer22;
    }

    public void setAnswer22(String answer22) {
        this.answer22 = answer22;
    }

    public String getAnswer23() {
        return answer23;
    }

    public void setAnswer23(String answer23) {
        this.answer23 = answer23;
    }

    public String getAnswer24() {
        return answer24;
    }

    public void setAnswer24(String answer24) {
        this.answer24 = answer24;
    }

    public String getAnswer25() {
        return answer25;
    }

    public void setAnswer25(String answer25) {
        this.answer25 = answer25;
    }

    public String getAnswer26() {
        return answer26;
    }

    public void setAnswer26(String answer26) {
        this.answer26 = answer26;
    }

    public String getAnswer27() {
        return answer27;
    }

    public void setAnswer27(String answer27) {
        this.answer27 = answer27;
    }

    public String getComment1() {
        return comment1;
    }

    public void setComment1(String comment1) {
        this.comment1 = comment1;
    }

    public String getComment2() {
        return comment2;
    }

    public void setComment2(String comment2) {
        this.comment2 = comment2;
    }

    public String getComment3() {
        return comment3;
    }

    public void setComment3(String comment3) {
        this.comment3 = comment3;
    }

    public String getComment4() {
        return comment4;
    }

    public void setComment4(String comment4) {
        this.comment4 = comment4;
    }

    public String getComment5() {
        return comment5;
    }

    public void setComment5(String comment5) {
        this.comment5 = comment5;
    }

    public String getComment6() {
        return comment6;
    }

    public void setComment6(String comment6) {
        this.comment6 = comment6;
    }

    public String getComment7() {
        return comment7;
    }

    public void setComment7(String comment7) {
        this.comment7 = comment7;
    }

    public String getComment8() {
        return comment8;
    }

    public void setComment8(String comment8) {
        this.comment8 = comment8;
    }

    public String getComment9() {
        return comment9;
    }

    public void setComment9(String comment9) {
        this.comment9 = comment9;
    }

    public String getComment10() {
        return comment10;
    }

    public void setComment10(String comment10) {
        this.comment10 = comment10;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentquiz;

/**
 *
 * @author Chizzy Meka | 16036630 | MSc. Computing
 */
public class StudentQuiz {

    private String name;
    private int mark;

    public StudentQuiz(String n) {
        this.name = n;
        this.mark = 0;
    }

    public void setName(String n) {
        this.name = n;
    }

    public int getName(String n) {
        return mark;
    }

    public String getGrade(String n, int gd) {
        String grade = null;
        
        //check to ensure the grade is between '1' and '100'
        if (gd < 0 || gd > 100) {
            System.out.println("Out of range! Please ensure the grade is between 0 & 100");
        } else {
            if (gd >= 69) {
                grade = "Distinction";
            } else if (gd > 60) {
                grade = "Merit";
            } else if (gd > 50) {
                grade = "Pass";
            }else{
                grade = "Fail";
            }
        }
        return grade;
    }

    public static void main(String[] args) {
        StudentQuiz sq = new StudentQuiz("John");
    }
}

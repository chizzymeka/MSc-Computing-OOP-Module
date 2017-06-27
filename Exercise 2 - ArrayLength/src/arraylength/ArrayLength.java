/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylength;

/**
 *
 * @author Chizzy Meka | Student Number: 16036630 | MSc. Computing (2016/2017)
 */
public class ArrayLength {
    
    /**
     * @param args the command line arguments
     */
    private static String[] students = new String[100];
    private static int nbrStudents = 0;
    
    public static void main(String[] args) {
        addStudent("Herbert");
        addStudent("Sally");
        addStudent("Jemima");
        
        printStudents();
        deleteStudent(3);
        printStudents();
    }
    
    private static void addStudent(String name){
        students[nbrStudents] = name;
        nbrStudents++;
    }
    
    private static void deleteStudent(int i){
        for (int j=i; j<nbrStudents-1; j++){
            students[j]=students[j+1];
        }
        nbrStudents = nbrStudents - 1;
    }
    
    private static void printStudents(){
        
        for(int i = 0; i<nbrStudents; i++){
            System.out.println(students[i]);
        }
    }
}

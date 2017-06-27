/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intwrapper;

/**
 *
 * @author Chizzy Meka | Student Number: 16036630 | MSc. Computing
 */
public class IntWrapperTest {
    public static void main(String[] args){
        ArrayList<IntWrapper> myList = new ArrayList<>;
        myList.add(new IntWrapper(3));
        myList.add(new IntWrapper(5));
        
        for (IntWrapper i: myList){
            System.out.println(i.getIntValue());
        }
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.plil.sio.jpa;

/**
 *
 * @author tsome
 */
public enum TypeEnum{
    Owner (0),
    Veterinarian (1);
    
    private final int value;
    
    private TypeEnum(int value){
        this.value =  value;
    }
    
    public int getValue(){
        return value;
    }
}

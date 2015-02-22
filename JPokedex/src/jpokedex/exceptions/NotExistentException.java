/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpokedex.exceptions;

/**
 *
 * @author grb19
 */
public class NotExistentException extends Exception {
    public NotExistentException(String message) {
        super(message);
    }
}

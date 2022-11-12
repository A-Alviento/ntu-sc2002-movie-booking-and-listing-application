package model;

import java.io.Serializable;

/**
 * Abstract class to be inherited by objects in our application.
 */
public abstract class Model implements Serializable{
    // Need to write a random serial versionUID for every non-abstract class 
    // extending Model: Use any random number generator to generate it.
    // "public static final long serialVersionUID = 42L;"
}

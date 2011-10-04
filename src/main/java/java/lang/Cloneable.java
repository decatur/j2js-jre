package java.lang;

/**
 * A class implements the Cloneable interface to indicate to the Object.clone() method
 * that it is legal for that method to make a field-for-field copy of instances of that class.
 * 
 * Invoking Object's clone method on an instance that does not implement the Cloneable interface
 * results in the exception CloneNotSupportedException being thrown. 
 */
public interface Cloneable {

}

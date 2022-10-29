package io;

import model.Serializable;

/*
 * Serializing is the process of converting an object into format suitable for
 * storage, be it in text, binary, etc.
 */
public interface ISerializer<T, S extends Serializable>{
    /*
     * Transform object into the target serial format.
     * @param   obj object of type S 
     * @return  T   target serial format
     */
    public T serialize(S obj) throws Exception;


    /*
     * Transform from the source back to the serial object.
     * @param   src source
     * @return  S   object of type S
     */
    public S deserialize(T src) throws Exception;
}

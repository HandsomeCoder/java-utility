package io.github.handsomecoder.utils;

/**
 * The type Object utils.
 *
 * @author Harsh Shah
 */
public class ObjectUtils {

    private ObjectUtils(){}

    /**
     * Is null boolean.
     *
     * @param obj the obj
     * @return the boolean
     * @author Harsh Shah
     */
    public boolean isNull(Object obj){
        return null == obj;
    }

    /**
     * Is not null boolean.
     *
     * @param obj the obj
     * @return the boolean
     * @author Harsh Shah
     */
    public boolean isNotNull(Object obj){
        return !isNull(obj);
    }

    /**
     * Is any null boolean.
     *
     * @param objects the objects
     * @return the boolean
     * @author Harsh Shah
     */
    public boolean isAnyNull(Object... objects){
        for(Object object: objects){
            if(isNull(object)){
                return true;
            }
        }

        return false;
    }

    /**
     * Is all null boolean.
     *
     * @param objects the objects
     * @return the boolean
     * @author Harsh Shah
     */
    public boolean isAllNull(Object... objects){
        for(Object object: objects){
            if(isNotNull(object)){
                return false;
            }
        }

        return true;
    }

    public <T> boolean isInstance(Object object, Class<T> tClass){
        return tClass.isInstance(object);
    }

}

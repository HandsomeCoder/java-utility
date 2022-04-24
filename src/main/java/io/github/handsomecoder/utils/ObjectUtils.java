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
    public static boolean isNull(Object obj){
        return null == obj;
    }

    /**
     * Is not null boolean.
     *
     * @param obj the obj
     * @return the boolean
     * @author Harsh Shah
     */
    public static boolean isNotNull(Object obj){
        return !isNull(obj);
    }

    /**
     * Is any null boolean.
     *
     * @param objects the objects
     * @return the boolean
     * @author Harsh Shah
     */
    public static boolean isAnyNull(Object... objects){
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
    public static boolean isAllNull(Object... objects){
        for(Object object: objects){
            if(isNotNull(object)){
                return false;
            }
        }

        return true;
    }

    /**
     * Is all not null boolean.
     *
     * @param objects the objects
     * @return the boolean
     */
    public static boolean isAllNotNull(Object... objects){
        for(Object object: objects){
            if(isNull(object)){
                return false;
            }
        }

        return true;
    }

    /**
     * Is instance boolean.
     *
     * @param <T>    the type parameter
     * @param object the object
     * @param tClass the t class
     * @return the boolean
     */
    public static <T> boolean isInstance(Object object, Class<T> tClass){
        return tClass.isInstance(object);
    }

}

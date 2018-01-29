package utils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * pojo 转换 dto
 * @author hzy
 * @date 2018/01/29
 */
public class ConvertClass {
    public static <T> T PojoToDto(Object origin, Class<T> targetClass) {
        T target = null;
        try {
            target = targetClass.newInstance();
            Class originClass = origin.getClass();
            Map<String,String> originMap = fileModifiers(origin.getClass());
            Map<String,String> targetMap = fileModifiers(targetClass);
            for(String key : originMap.keySet()){
                if(targetMap.get(key) != null && targetMap.get(key).equals(originMap.get(key))){
                    setProperty(target, key, getProperty(origin, key));
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return target;
    }

    /**
     * 获取类的属性名和属性类型（static除外）
     * @param target 目标类
     * @param <T>
     * @return
     */
    private static <T> Map<String, String> fileModifiers(Class<T> target){
        Map<String, String> map = new HashMap<String, String>();
        Field[] fields = target.getDeclaredFields();
        for(Field field : fields){
            if(Modifier.isStatic(field.getModifiers())){
                continue;
            }
            map.put(field.getName(), field.getType().toString());
        }
        return map;
    }

    /**
     * 该方法用于传入某实例对象以及对象方法名，通过反射调用该对象的某个get方法
     * @param beanObj
     * @param property
     * @return
     * @throws IntrospectionException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public static Object getProperty(Object beanObj, String property) throws IntrospectionException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        //此处应该判断beanObj,property不为null
        PropertyDescriptor pd = new PropertyDescriptor(property, beanObj.getClass());
        Method getMethod = pd.getReadMethod();
        if(getMethod == null){
            return null;
        }
        return getMethod.invoke(beanObj);
    }

    /**
     * 该方法用于传入某实例对象以及对象方法名、修改值，通过放射调用该对象的某个set方法设置修改值
     * @param beanObj
     * @param property
     * @param value
     * @return
     * @throws IntrospectionException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public static Object setProperty(Object beanObj, String property, Object value) throws IntrospectionException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        //此处应该判断beanObj,property不为null
        PropertyDescriptor pd = new PropertyDescriptor(property, beanObj.getClass());
        Method setMethod = pd.getWriteMethod();
        if (setMethod == null) {
            return null;
        }
        return setMethod.invoke(beanObj, value);
    }
}

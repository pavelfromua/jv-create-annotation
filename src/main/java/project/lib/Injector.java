package project.lib;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import project.exceptions.DaoModelNullException;
import project.factory.Factory;
import project.model.Bet;
import project.model.User;

public class Injector {
    public static Object getInstance(Class clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException,
            DaoModelNullException {

        Constructor constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();
                Type actualType = parameterizedType.getActualTypeArguments()[0];

                if (actualType.equals(Bet.class)) {
                    field.set(instance, Factory.getBetDao());
                } else if (actualType.equals(User.class)) {
                    field.set(instance, Factory.getUserDao());
                } else {
                    throw new DaoModelNullException("No implementation for type "
                            + clazz.getName());
                }
            }
        }

        return instance;
    }
}

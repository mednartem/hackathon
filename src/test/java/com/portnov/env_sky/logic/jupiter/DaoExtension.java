package com.portnov.env_sky.logic.jupiter;

import com.portnov.env_sky.logic.db.dao.*;
import com.portnov.env_sky.logic.db.dao.impl.*;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

import java.lang.reflect.Field;
import java.util.Map;

public class DaoExtension implements TestInstancePostProcessor {

    private static final Map<Class<?>, Class<?>> daoMap = Map.of(
            CategoryDAO.class, CategoryDAOJdbc.class,
            ManufacturerDAO.class, ManufacturerDAOJdbc.class,
            ProductDAO.class, ProductDAOJdbc.class,
            ProductAttributesDAO.class, ProductAttributesDAOJdbc.class,
            CheckoutAttributesDAO.class, CheckoutAttributesDAOJdbc.class,
            CustomerDAO.class, CustomerDAOJdbc.class
    );

    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws Exception {
        for (Field field : testInstance.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Dao.class)) {
                field.setAccessible(true);
                Class<?> fieldType = field.getType();
                if (daoMap.containsKey(fieldType)) {
                    Class<?> daoImplementation = daoMap.get(fieldType);
                    field.set(testInstance, daoImplementation.getDeclaredConstructor().newInstance());
                }
            }
        }
    }
}

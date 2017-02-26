package com.pd.base;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Annotation
{
    @Retention(RetentionPolicy.RUNTIME)
    public static @interface Dao
    {
        
    }
    
    @Retention(RetentionPolicy.RUNTIME)
    public static @interface DaoApi
    {
        
    }
    
    @Retention(RetentionPolicy.RUNTIME)
    public static @interface Fo
    {
        String name();
        
        String[] params();
    }
    
    @Retention(RetentionPolicy.RUNTIME)
    public static @interface Service
    {
        String name();
        
        String[] apis();
    }
    
    @Retention(RetentionPolicy.RUNTIME)
    public static @interface Vo
    {
        String name();
        
        String[] params();
    }
}

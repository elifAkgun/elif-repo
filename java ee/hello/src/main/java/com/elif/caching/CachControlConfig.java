package com.elif.caching;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
public @interface CachControlConfig {
    
    public boolean isPrivate() default true;
    public boolean noCache() default false;
    public boolean noStore() default false;
    public boolean noTransform() default true;
    public boolean mustRevalidate() default true;
    public boolean proxyRevalidate() default false;
    public int maxAge() default 0;
    public int sMaxAge() default 0;
 
}
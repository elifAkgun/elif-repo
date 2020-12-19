package com.elif.config.filter;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

import com.elif.caching.CachControlConfig;

@Provider
public class DynamicFilterFeature implements DynamicFeature {
	
    @Override
    public void configure(ResourceInfo resourceInfo, FeatureContext context) {
    	CachControlConfig annotation = resourceInfo.getResourceMethod().getAnnotation(CachControlConfig.class);

        if (annotation != null) {
        	
        	CacheControl cacheControl = new CacheControl();
        	cacheControl.setMaxAge(annotation.maxAge());
        	cacheControl.setMustRevalidate(annotation.mustRevalidate());
        	cacheControl.setNoCache(annotation.noCache());
        	cacheControl.setNoStore(annotation.noStore());
        	cacheControl.setNoTransform(annotation.noTransform());
        	cacheControl.setPrivate(annotation.isPrivate());
        	cacheControl.setSMaxAge(annotation.sMaxAge());
        	
        	DynamicCacheResponseFilter dynamicFilter = new DynamicCacheResponseFilter(cacheControl);
        	
            context.register(dynamicFilter);
        }
    }
}

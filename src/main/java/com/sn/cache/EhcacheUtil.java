package com.sn.cache;

import java.net.URL;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;


public class EhcacheUtil {  
  
    private static final String path = "/ehcache.xml"; 
    public static final String TOKEN_CACHE_NAME = "tokenCache";
    public static final String SERIAL_CACHE_NAME = "serialCache";
    public static final String MESSAGE_QUEUING_CACHE_NAME = "MessageQueuingCache";
  
    private URL url;  
  
    private CacheManager manager;  
  
    private static EhcacheUtil ehCache;  
  
    private EhcacheUtil(String path) {  
        url = getClass().getResource(path);  
        manager = CacheManager.create(url);  
    }  
  
    
    public static EhcacheUtil getInstance() {  
        if (ehCache== null) {  
			ehCache = new EhcacheUtil(path);  
        }  
        return ehCache;  
    }  
  
    /**
     * @see 加入缓存
     * @param cacheName  缓存名称
     * @param key  关键字
     * @param value  值
     */ 
    public void put(String cacheName, String key, Object value) {  
        Cache cache = manager.getCache(cacheName);   
        Element element = new Element(key, value);  
        cache.put(element);  
    }  
  
    public Object get(String cacheName, String key) {  
        Cache cache = manager.getCache(cacheName);  
        Element element = cache.get(key);  
        return element == null ? null : element.getObjectValue();  
    }  
  
    public Cache get(String cacheName) {  
        return manager.getCache(cacheName);  
    }  
  
    public void remove(String cacheName, String key) {  
        Cache cache = manager.getCache(cacheName);  
        cache.remove(key);  
    }  
  
}
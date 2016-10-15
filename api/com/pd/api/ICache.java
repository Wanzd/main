package com.pd.api;

import java.util.HashMap;
import java.util.Map;

public interface ICache<K, V>
{
    
    @SuppressWarnings("rawtypes")
    Map map = new HashMap();
    
    default void clear()
    {
        map.clear();
    }
    
    @SuppressWarnings("unchecked")
    default void put(K key, V value)
    {
        map.put(key, value);
    }
    
    default void del(K key)
    {
        map.remove(key);
    }
    
    @SuppressWarnings("unchecked")
    default K[] keys()
    {
        return (K[])map.keySet().toArray();
    }
    
    @SuppressWarnings("unchecked")
    default V[] values()
    {
        return (V[])map.values().toArray();
    }
}
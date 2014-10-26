package io.github.lucaseasedup.logit.config;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface PropertyHolder
{
    public Map<String, Property> getProperties();
    public Property getProperty(String path);
    
    public boolean contains(String path);
    public Set<String> getKeys(String path);
    public Map<String, Object> getValues(String path);
    public Object get(String path);
    public boolean getBoolean(String path);
    public List<Boolean> getBooleanList(String path);
    public List<Byte> getByteList(String path);
    public List<Character> getCharacterList(String path);
    // TODO: getColor
    public double getDouble(String path);
    public List<Double> getDoubleList(String path);
    public List<Float> getFloatList(String path);
    public int getInt(String path);
    public List<Integer> getIntegerList(String path);
    // TODO: getItemStack
    public List<?> getList(String path);
    public long getLong(String path);
    public List<Long> getLongList(String path);
    public List<Map<?, ?>> getMapList(String path);
    public List<Short> getShortList(String path);
    public String getString(String path);
    public List<String> getStringList(String path);
    // TODO: getVector
    // TODO: getLocation
    public long getTime(String path, TimeUnit convertTo);
    public void set(String path, Object value) throws InvalidPropertyValueException;
}

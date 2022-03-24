package test.jesus.product_api.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cache<T> {
    private List<CacheItem> items = new ArrayList<>();

    public T GetItem(int key){
        return (T) items.stream().filter(item -> item.key == key).collect(Collectors.toList()).get(0).content;
    }

    public boolean AddItem(int key, T item) throws Exception {
        if(!Exists(key)){
            items.add(new CacheItem<T>(key, item));
            return true;
        }
        else {
            return false;
        }
    }

    public boolean Exists(int key){
        return items.stream().anyMatch(item -> item.key == key);
    }

    class CacheItem<T> {
        CacheItem(int key, T content){
            this.key = key;
            this.content = content;
        }
        int key;
        T content;
    }
}


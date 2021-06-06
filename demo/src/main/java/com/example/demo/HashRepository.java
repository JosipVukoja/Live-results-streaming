package com.example.demo;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.example.demo.Result;

@Service
public class HashRepository {
    private static ConcurrentHashMap<String, Result> resultStorage = new ConcurrentHashMap<>();
    

    public Result add(Result result){
        resultStorage.put(result.getmatchID(), result);
        return result;
    }

    public Result delete(String id) {
        Result res = resultStorage.get(id);
        resultStorage.remove(id);

        return res;
    }

    public Result findById(String id) {
        return resultStorage.get(id);
    }

    public List<Result> findAll() {
        return resultStorage
                .values()
                .stream()
                .collect(Collectors.toList());
    }

    public Boolean isEmptyResult(){
        Boolean isEmpty;
        isEmpty = resultStorage.isEmpty();
        
        return isEmpty;
        
    }



}


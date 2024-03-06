package com.example.msusers.util;

import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;


public class PredicateUtil {

    private final List<Predicate> predicateList = new ArrayList<>();

    public static PredicateUtil builder(){
        return new PredicateUtil();
    }

    public <T> PredicateUtil add(T objecct , Function<T,Predicate> function){
        predicateList.add(function.apply(objecct));
        return this;
    }

    public <T> PredicateUtil addNullSafety(T  object , Function<T,Predicate> function){
        if(Objects.nonNull(object))
         predicateList.add(function.apply(object));
        return this;
    }

    public Predicate[] build(){
        return predicateList.toArray(new Predicate[0]);
    }

    public static  String applyLikePattern(String string){return "%" + string + "%"; }

}

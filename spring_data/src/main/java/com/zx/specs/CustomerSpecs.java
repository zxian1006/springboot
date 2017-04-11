package com.zx.specs;

import static com.google.common.collect.Iterables.toArray;
import org.springframework.data.jpa.domain.Specification;

import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Credittone on 2017/4/10.
 */
public class CustomerSpecs {

    public static <T> Specification<T> byAuto(final EntityManager entityManager,final T example){  //1
        final Class<T> type = (Class<T>) example.getClass();  //2

        return new Specification<T>() {
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();  //3

                EntityType<T> entity = entityManager.getMetamodel().entity(type);  // 获得实体类的EntityType，可以从EntityType获取实体类的属性

                for (Attribute<T,?> attr:entity.getDeclaredAttributes()){  //5
                    Object attrValue = getValue(example,attr);  //6
                    if(attrValue != null){
                        if(attr.getJavaType() == String.class){  //7
                            if(!StringUtils.isEmpty(attrValue)){  //8
                                predicates.add(cb.like(root.get(attribute(entity,attr.getName(),String.class)),pattern((String) attrValue)));  //9
                            }
                        }else {
                            predicates.add(cb.equal(root.get(attribute(entity,attr.getName(),attrValue.getClass())),attrValue));  //10
                        }
                    }
                }
                return predicates.isEmpty() ? cb.conjunction() : cb.and(toArray(predicates,Predicate.class));  //11
            }
            private <T> Object getValue(T example,Attribute<T,?> attr){
                return ReflectionUtils.getField((Field) attr.getJavaMember(),example);
            }

            private <E,T>SingularAttribute<T,E> attribute(EntityType<T> entity,String fieldName,Class<E> fieldClass){
                return entity.getDeclaredSingularAttribute(fieldName,fieldClass);
            }
        };
    }

    static private String pattern(String str){
        return "%"+str+"%";
    }
}

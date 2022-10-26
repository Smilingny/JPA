package com.edu.Dao;

import com.edu.Util.JPAUtil;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class BaseDao<T> {
    //提供基础类，简化Dao层操作的重复性
    private Class<T> clz;

    public BaseDao() {
        ParameterizedType paramClass = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type[] actualTypeArguments = paramClass.getActualTypeArguments();
        clz = (Class<T>) actualTypeArguments[0];
    }

    // 增加数据
    public void save(T object) {
        // 获得实体
        EntityManager manager = JPAUtil.getEntityManager();
        // 开启事务
        manager.getTransaction().begin();
        // 进行持久化操作
        manager.persist(object);
        // 事务提交
        manager.getTransaction().commit();
        // 关闭事务
        manager.close();
    }

    // 更新数据
    public void update(T object) {
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        // 进行合并操作
        manager.merge(object);
        manager.getTransaction().commit();
        manager.close();
    }

    // 删除数据
    public void delete(Serializable i) {
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        T entity = manager.find(clz, i);
        manager.remove(entity);
        manager.getTransaction().commit();
        manager.close();
    }
}

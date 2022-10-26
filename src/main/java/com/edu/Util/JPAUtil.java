package com.edu.Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    public static EntityManagerFactory factory;  //JPA的实体管理器工厂
    static{
        //静态代码块，在使用该类时即会执行的部分
        factory = Persistence.createEntityManagerFactory("JPA_Util");
        // createEntityManagerFactory中的参数为persistence.xml中的<persistence-unit name="JPA_Util">标签中name
    }

    public static EntityManager getEntityManager(){
        // 返回创建一个实体
        return factory.createEntityManager();
    }
}

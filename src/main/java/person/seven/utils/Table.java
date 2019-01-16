package person.seven.utils;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author jianfu.wang
 * 实体对象类名对应数据库表的注解
 * 和表的ID主键
 * 注意：为了少配置甚至0配置，约定要求表字段名字和类的属性名字一致。
 * <p>
 * 有一句话叫做：约定优于配置
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Table {
    String name();

    String id() default "id";
}

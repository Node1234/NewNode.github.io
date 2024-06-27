package cn.hxzy.herbtool02.Herb;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 实体类Herb，用于映射到数据库中的herbs表。
 * 该类使用Jakarta Persistence（JPA）注解来定义实体和数据库表的映射关系。
 */
@Entity // 声明这是一个实体类，对应数据库中的一个表
@Table(name = "herbs") // 指定实体类映射的数据库表名为herbs
public class Herb {

    @Id // 声明这是一个主键字段
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键生成策略为自增长
    private int id; // 主键字段，用于唯一标识每条记录
    private String name; // 药材名称字段
    private String category; // 药材类别字段
    private String effect; // 药材功效字段

    /**
     * 默认构造函数，JPA需要一个无参的构造函数。
     */
    public Herb() {}

    /**
     * 带参构造函数，用于创建一个新的Herb对象，设置名称和类别。
     * @param name 药材名称
     * @param category 药材类别
     */
    public Herb(String name, String category) {
        this.name = name;
        this.category = category;
    }

    /**
     * 获取药材的ID。
     * @return 药材的ID
     */
    public int getId() {
        return id;
    }

    /**
     * 设置药材的ID。
     * @param id 药材的ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取药材的名称。
     * @return 药材的名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置药材的名称。
     * @param name 药材的名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取药材的类别。
     * @return 药材的类别
     */
    public String getCategory() {
        return category;
    }

    /**
     * 设置药材的类别。
     * @param category 药材的类别
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * 获取药材的功效。
     * @return 药材的功效
     */
    public String getEffect() {
        return effect;
    }

    /**
     * 设置药材的功效。
     * @param effect 药材的功效
     */
    public void setEffect(String effect) {
        this.effect = effect;
    }
}


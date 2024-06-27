package cn.hxzy.herbtool02.Repository;

import java.util.List;

import cn.hxzy.herbtool02.Herb.Herb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * HerbRepository接口，继承自Spring Data JPA的JpaRepository，用于与数据库中的herbs表进行交互。
 * 该接口提供了一些自定义的查询方法，以及JpaRepository默认提供的基本CRUD操作。
 */
@Repository // 声明这是一个仓库接口，Spring会自动为其创建实现类
public interface HerbRepository extends JpaRepository<Herb, Integer> {

    /**
     * 根据药材名称查找药材对象。
     * @param name 药材名称
     * @return 匹配的药材对象，如果不存在则返回null
     */
    Herb findByName(String name);

    /**
     * 根据包含指定关键字的药材名称查找药材列表。
     * 忽略关键字的大小写。
     * @param keyword 关键字
     * @return 匹配的药材列表
     */
    List<Herb> findByNameContainingIgnoreCase(String keyword);

    /**
     * 检查是否存在指定名称的药材。
     * @param name 药材名称
     * @return 如果存在则返回true，否则返回false
     */
    boolean existsByName(String name);

    /**
     * 根据药材类别查找药材列表。
     * @param category 药材类别
     * @return 匹配的药材列表
     */
    List<Herb> findByCategory(String category);

    /**
     * 根据包含指定关键字的药材功效查找药材列表。
     * 忽略关键字的大小写。
     * @param effect 关键字
     * @return 匹配的药材列表
     */
    List<Herb> findByEffectContainingIgnoreCase(String effect);
}


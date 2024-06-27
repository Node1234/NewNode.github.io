package cn.hxzy.herbtool02.Service;

import java.util.List;

import cn.hxzy.herbtool02.Herb.Herb;
import cn.hxzy.herbtool02.Repository.HerbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * HerbService类，提供与药材相关的业务逻辑处理。
 * 该类使用HerbRepository与数据库进行交互，并封装了业务逻辑。
 */
@Service // 声明这是一个服务类，Spring会自动管理其生命周期
public class HerbService {

    private final HerbRepository herbRepository; // 注入HerbRepository，用于数据库操作

    /**
     * 构造函数，用于注入HerbRepository。
     * @param herbRepository HerbRepository实例
     */
    @Autowired // 自动装配HerbRepository
    public HerbService(HerbRepository herbRepository) {
        this.herbRepository = herbRepository;
    }

    /**
     * 添加新的药材。
     * 如果药材名称已存在，则抛出异常。
     * @param name 药材名称
     * @param category 药材类别
     * @param effect 药材功效
     * @return 保存到数据库的药材对象
     */
    public Herb addHerb(String name, String category, String effect) {
        if (herbRepository.existsByName(name)) {
            throw new RuntimeException("药材名称已存在");
        }
        Herb herb = new Herb();
        herb.setName(name);
        herb.setCategory(category);
        herb.setEffect(effect);
        return herbRepository.save(herb);
    }

    /**
     * 检查药材名称是否已存在。
     * @param name 药材名称
     * @return 如果存在则返回true，否则返回false
     */
    private boolean isHerbNameExists(String name) {
        return herbRepository.findByName(name) != null;
    }

    /**
     * 根据药材名称分类和获取功效。
     * @param herbName 药材名称
     * @return 药材的类别和功效，如果未找到则返回提示信息
     */
    public String classify(String herbName) {
        Herb herb = herbRepository.findByName(herbName);
        if (herb != null) {
            return herb.getCategory() + "\n" + herb.getEffect();
        }
        return "未找到该药材";
    }

    /**
     * 模糊搜索药材名称。
     * @param keyword 搜索关键字
     * @return 匹配的药材列表
     */
    public List<Herb> fuzzySearch(String keyword) {
        return herbRepository.findByNameContainingIgnoreCase(keyword);
    }

    /**
     * 获取所有药材。
     * @return 所有药材的列表
     */
    public List<Herb> getAllHerbs() {
        return herbRepository.findAll();
    }

    /**
     * 根据药材类别获取药材列表。
     * @param category 药材类别
     * @return 匹配的药材列表
     */
    public List<Herb> getHerbsByCategory(String category) {
        return herbRepository.findByCategory(category);
    }

    /**
     * 搜索药材名称。
     * @param keyword 搜索关键字
     * @return 匹配的药材列表
     */
    public List<Herb> searchHerbs(String keyword) {
        return herbRepository.findByNameContainingIgnoreCase(keyword);
    }

    /**
     * 根据药材功效搜索药材。
     * @param effect 搜索关键字
     * @return 匹配的药材列表
     */
    public List<Herb> searchByEffect(String effect) {
        return herbRepository.findByEffectContainingIgnoreCase(effect);
    }

    /**
     * 根据药材名称删除药材。
     * @param name 药材名称
     */
    public void deleteHerbByName(String name) {
        Herb herb = herbRepository.findByName(name);
        if (herb == null) {
            throw new RuntimeException("药材名称不存在");
        }
        herbRepository.delete(herb);
    }
}



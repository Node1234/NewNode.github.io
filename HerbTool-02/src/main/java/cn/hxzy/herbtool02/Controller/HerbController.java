package cn.hxzy.herbtool02.Controller;

import cn.hxzy.herbtool02.Herb.Herb;
import cn.hxzy.herbtool02.Service.HerbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * HerbController类，作为RESTful API的控制器，处理与药材相关的HTTP请求。
 * 该类使用HerbService处理业务逻辑，并返回相应的HTTP响应。
 */
@RestController // 声明这是一个REST控制器，用于处理HTTP请求
@RequestMapping("/herbs") // 定义基础的请求映射路径
public class HerbController {

    private final HerbService herbService; // 注入HerbService，用于处理业务逻辑

    /**
     * 构造函数，用于注入HerbService。
     * @param herbService HerbService实例
     */
    @Autowired // 自动装配HerbService
    public HerbController(HerbService herbService) {
        this.herbService = herbService;
    }

    /**
     * 处理添加药材的POST请求。
     * @param name 药材名称
     * @param category 药材类别
     * @param effect 药材功效
     * @return 添加成功的药材对象
     */
    @PostMapping("/add") // 映射到POST请求
    public Herb addHerb(@RequestParam String name, @RequestParam String category, @RequestParam String effect) {
        try {
            return herbService.addHerb(name, category, effect);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "药材名称已存在");
        }
    }

    /**
     * 处理分类查询的GET请求。
     * @param name 药材名称
     * @return 药材的类别和功效
     */
    @GetMapping("/classify") // 映射到GET请求
    public String classify(@RequestParam String name) {
        return herbService.classify(name);
    }

    /**
     * 处理根据类别搜索药材的GET请求。
     * @param category 药材类别
     * @return 匹配的药材列表
     */
    @GetMapping("/searchByCategory") // 映射到GET请求
    public List<Herb> getHerbsByCategory(@RequestParam String category) {
        return herbService.getHerbsByCategory(category);
    }

    /**
     * 处理模糊搜索药材名称的GET请求。
     * @param keyword 搜索关键字
     * @return 匹配的药材列表
     */
    @GetMapping("/search") // 映射到GET请求
    public List<Herb> fuzzySearch(@RequestParam String keyword) {
        return herbService.fuzzySearch(keyword);
    }

    /**
     * 处理获取所有药材的GET请求。
     * @return 所有药材的列表
     */
    @GetMapping("/all") // 映射到GET请求
    public List<Herb> getAllHerbs() {
        return herbService.getAllHerbs();
    }

    /**
     * 处理根据药材功效搜索的GET请求。
     * @param effect 搜索关键字
     * @return 匹配的药材列表
     */
    @GetMapping("/searchByEffect") // 映射到GET请求
    public List<Herb> searchByEffect(@RequestParam String effect) {
        return herbService.searchByEffect(effect);
    }

    /**
     * 处理删除药材的DELETE请求。
     * @param name 药材名称
     */
    @DeleteMapping("/deleteByName") // 映射到DELETE请求
    public void deleteHerbByName(@RequestParam String name) {
        try {
            herbService.deleteHerbByName(name);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "删除失败");
        }
    }
}



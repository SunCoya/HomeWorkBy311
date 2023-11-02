package com.sky.controller.admin;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.ocr.model.v20191230.RecognizeCharacterRequest;
import com.aliyuncs.ocr.model.v20191230.RecognizeCharacterResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;
import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.exception.BaseException;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * 菜品管理
 */
@RestController
@RequestMapping("/admin/dish")
@Api(tags = "书籍相关接口")
@Slf4j
public class DishController {

    @Autowired
    private DishService dishService;
    @Autowired
    private RedisTemplate redisTemplate;


    @PostMapping
    @ApiOperation("新增书籍")
    public Result save(@RequestBody DishDTO dishDTO) {
        log.info("新增书籍：{}", dishDTO);
        Boolean bool=getKey(dishDTO.getImage(),dishDTO.getName());
        if(!bool){
            throw new BaseException("图片与书籍不符上传失败");
        }
        dishService.saveWithFlavor(dishDTO);

        //清理缓存数据
        String key = "dish_" + dishDTO.getCategoryId();
        cleanCache(key);
        return Result.success();
    }

    public Boolean getKey(String path,String name) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-shanghai", "LTAI5tGwGS9AR9p8NzqpKzbf", "TcdIPKOh5Cv9CllKEqe7bXdCc8bN1M" );
        IAcsClient client = new DefaultAcsClient(profile);
        RecognizeCharacterRequest request = new RecognizeCharacterRequest();
        request.setImageURL(path);
        request.setMinHeight(10);
        request.setOutputProbability(true);
        try {
            RecognizeCharacterResponse response = client.getAcsResponse(request);
            String res=new Gson().toJson(response);
            Map<String, Object> parse = (Map<String,Object>)JSON.parse(res);
            Map data = (Map)parse.get("data");
            List<Map<String,String>> result = (List<Map<String,String>>) data.get("results");
            for (Map<String,String> m:result) {
                if(name.equals(m.get("text"))){
                    return true;
                }
            }
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
        return false;

    }
    @GetMapping("/page")
    @ApiOperation("书籍分页查询")
    public Result<PageResult> page(DishPageQueryDTO dishPageQueryDTO) {
        log.info("书籍分页查询:{}", dishPageQueryDTO);
        PageResult pageResult = dishService.pageQuery(dishPageQueryDTO);
        return Result.success(pageResult);
    }


    @DeleteMapping
    @ApiOperation("书籍批量删除")
    public Result delete(@RequestParam List<Long> ids) {
        log.info("书籍批量删除：{}", ids);
        dishService.deleteBatch(ids);

        //将所有的菜品缓存数据清理掉，所有以dish_开头的key
        cleanCache("dish_*");

        return Result.success();
    }

    /**
     * 根据id查询菜品
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("根据id查询书籍")
    public Result<DishVO> getById(@PathVariable Long id) {
        log.info("根据id查询书籍：{}", id);
        DishVO dishVO = dishService.getByIdWithFlavor(id);
        return Result.success(dishVO);
    }

    /**
     * 修改书籍
     *
     * @param dishDTO
     * @return
     */
    @PutMapping
    @ApiOperation("修改书籍")
    public Result update(@RequestBody DishDTO dishDTO) {
        log.info("修改书籍：{}", dishDTO);
        dishService.updateWithFlavor(dishDTO);

        //将所有的菜品缓存数据清理掉，所有以dish_开头的key
        cleanCache("dish_*");

        return Result.success();
    }

    /**
     * 书籍起售停售
     *
     * @param status
     * @param id
     * @return
     */
    @PostMapping("/status/{status}")
    @ApiOperation("书籍起售停售")
    public Result<String> startOrStop(@PathVariable Integer status, Long id) {
        dishService.startOrStop(status, id);

        //将所有的菜品缓存数据清理掉，所有以dish_开头的key
        cleanCache("dish_*");

        return Result.success();
    }

    /**
     * 根据分类id查询书籍
     *
     * @param categoryId
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("根据分类id查询书籍")
    public Result<List<Dish>> list(Long categoryId) {
        List<Dish> list = dishService.list(categoryId);
        return Result.success(list);
    }

    /**
     * 清理缓存数据
     * @param pattern
     */
    private void cleanCache(String pattern){
        Set keys = redisTemplate.keys(pattern);
        redisTemplate.delete(keys);
    }
}

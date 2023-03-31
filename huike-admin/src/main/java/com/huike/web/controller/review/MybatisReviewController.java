package com.huike.web.controller.review;


import com.huike.common.core.controller.BaseController;
import com.huike.common.core.domain.AjaxResult;
import com.huike.common.core.page.TableDataInfo;
import com.huike.review.pojo.Review;
import com.huike.review.service.ReviewService;
import com.huike.review.vo.MybatisReviewVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 该Controller主要是为了复习三层架构以及Mybatis使用的，该部分接口已经放开权限，可以直接访问
 * 同学们在此处编写接口通过浏览器访问看是否能完成最简单的增删改查
 */
@RestController
@RequestMapping("/review")
@Slf4j
public class MybatisReviewController extends BaseController {

    @Autowired
    private ReviewService reviewService;

    /**=========================================================新增数据============================================*/
    @GetMapping("/saveData/{name}/{age}/{sex}")
    public AjaxResult saveData(@PathVariable String name,@PathVariable Integer age,@PathVariable String sex){
        log.info("name:{},age:{},sex:{}",name,age,sex);
        int i = reviewService.saveData(name, age, sex);
        return AjaxResult.success("成功插入"+i+"条数据");
    }
    @PostMapping("/saveData")
    public AjaxResult saveData(@RequestBody MybatisReviewVO mybatisReviewVO){
        int i = reviewService.saveData(mybatisReviewVO);
        return AjaxResult.success("成功添加："+i+"条数据");
    }
    /**=========================================================删除数据=============================================*/

    /**=========================================================修改数据=============================================*/

    /**=========================================================查询数据=============================================*/
    @GetMapping("/getById")
    public AjaxResult getById(Integer id){
        log.info("id:{}",id);
        Review review = reviewService.getById(id);
        return AjaxResult.success("查询成功",review);
    }
    //分页查询
    @GetMapping("/getDataByPage")
    public TableDataInfo getDataByPage(Integer pageNum, Integer pageSize){
        log.info("pageNum:{},pageSize:{}",pageNum,pageSize);
        startPage();
        List<Review> reviews = reviewService.getDataByPage(pageNum, pageSize);
        return getDataTable(reviews);

    }
}
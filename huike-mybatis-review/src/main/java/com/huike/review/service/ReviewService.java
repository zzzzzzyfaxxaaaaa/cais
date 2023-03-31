package com.huike.review.service;

import com.huike.common.core.domain.AjaxResult;
import com.huike.review.pojo.Review;
import com.huike.review.vo.MybatisReviewVO;

import java.util.List;

/**
 * mybatis复习接口层
 */
public interface ReviewService {
    //id查询
    Review getById(Integer id);
    //分页查询
    List<Review> getDataByPage(Integer pageNum,Integer pageSize);

    int saveData(String name, Integer age, String sex);

    int saveData(MybatisReviewVO mybatisReviewVO);
}

package com.huike.review.mapper;

import com.huike.review.pojo.Review;
import com.huike.review.vo.MybatisReviewVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Mybatis复习的Mapper层
 */
public interface MybatisReviewMapper {


    /**======================================================新增======================================================**/
    int saveData(@Param("name") String name, @Param("age") Integer age, @Param("sex") String sex);
    int saveDataByPojo(Review review);
    /**======================================================删除======================================================**/

    /**======================================================修改======================================================**/

    /**======================================================简单查询===================================================**/
    Review getById(Integer id);
    //分页查询
    List<Review> getDataByPage(@Param("pageIndex") Integer pageIndex,@Param("pageSize") Integer pageSize);



}

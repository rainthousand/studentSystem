package com.example.studentsystem.mapper;

import com.example.studentsystem.entity.Fee;
import com.example.studentsystem.entity.FeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FeeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fee
     *
     * @mbggenerated Sat Apr 30 00:56:34 BST 2022
     */
    int countByExample(FeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fee
     *
     * @mbggenerated Sat Apr 30 00:56:34 BST 2022
     */
    int deleteByExample(FeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fee
     *
     * @mbggenerated Sat Apr 30 00:56:34 BST 2022
     */
    int deleteByPrimaryKey(Integer feeid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fee
     *
     * @mbggenerated Sat Apr 30 00:56:34 BST 2022
     */
    int insert(Fee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fee
     *
     * @mbggenerated Sat Apr 30 00:56:34 BST 2022
     */
    int insertSelective(Fee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fee
     *
     * @mbggenerated Sat Apr 30 00:56:34 BST 2022
     */
    List<Fee> selectByExample(FeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fee
     *
     * @mbggenerated Sat Apr 30 00:56:34 BST 2022
     */
    Fee selectByPrimaryKey(Integer feeid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fee
     *
     * @mbggenerated Sat Apr 30 00:56:34 BST 2022
     */
    int updateByExampleSelective(@Param("record") Fee record, @Param("example") FeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fee
     *
     * @mbggenerated Sat Apr 30 00:56:34 BST 2022
     */
    int updateByExample(@Param("record") Fee record, @Param("example") FeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fee
     *
     * @mbggenerated Sat Apr 30 00:56:34 BST 2022
     */
    int updateByPrimaryKeySelective(Fee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fee
     *
     * @mbggenerated Sat Apr 30 00:56:34 BST 2022
     */
    int updateByPrimaryKey(Fee record);
}
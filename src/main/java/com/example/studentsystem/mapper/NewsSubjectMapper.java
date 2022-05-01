package com.example.studentsystem.mapper;

import com.example.studentsystem.entity.NewsSubject;
import com.example.studentsystem.entity.NewsSubjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NewsSubjectMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table newssubject
     *
     * @mbggenerated Sun May 01 14:47:08 BST 2022
     */
    int countByExample(NewsSubjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table newssubject
     *
     * @mbggenerated Sun May 01 14:47:08 BST 2022
     */
    int deleteByExample(NewsSubjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table newssubject
     *
     * @mbggenerated Sun May 01 14:47:08 BST 2022
     */
    int deleteByPrimaryKey(String subject);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table newssubject
     *
     * @mbggenerated Sun May 01 14:47:08 BST 2022
     */
    int insert(NewsSubject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table newssubject
     *
     * @mbggenerated Sun May 01 14:47:08 BST 2022
     */
    int insertSelective(NewsSubject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table newssubject
     *
     * @mbggenerated Sun May 01 14:47:08 BST 2022
     */
    List<NewsSubject> selectByExample(NewsSubjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table newssubject
     *
     * @mbggenerated Sun May 01 14:47:08 BST 2022
     */
    int updateByExampleSelective(@Param("record") NewsSubject record, @Param("example") NewsSubjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table newssubject
     *
     * @mbggenerated Sun May 01 14:47:08 BST 2022
     */
    int updateByExample(@Param("record") NewsSubject record, @Param("example") NewsSubjectExample example);
}
package com.luer.basicsetup.dao;

import com.luer.basicsetup.bean.Suppliermanage;
import com.luer.basicsetup.bean.SuppliermanageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SuppliermanageMapper {
	int countByExample(SuppliermanageExample example);

    int deleteByExample(SuppliermanageExample example);

    int deleteByPrimaryKey(String id);

    int insert(Suppliermanage record);

    int insertSelective(Suppliermanage record);

    List<Suppliermanage> selectByExample(SuppliermanageExample example);

    Suppliermanage selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Suppliermanage record, @Param("example") SuppliermanageExample example);

    int updateByExample(@Param("record") Suppliermanage record, @Param("example") SuppliermanageExample example);

    int updateByPrimaryKeySelective(Suppliermanage record);

    int updateByPrimaryKey(Suppliermanage record);

    boolean deleteByIds(String[] arr);

    Suppliermanage selectById(@Param("id") String id);

    List<Suppliermanage> select();

    List<Suppliermanage> selectByClassName(@Param("className")String className);

    List<Suppliermanage> selectByUnitName(@Param("unitName")String unitName);

    List<Suppliermanage> selectByUnitNameAndPhoneNumber(@Param("unitName")String unitName, @Param("phoneNumber")String phoneNumber);

    List<Suppliermanage> selectByPhoneNumber(@Param("phoneNumber") String phoneNumber);

    List<Suppliermanage> selectYByUnitName(@Param("unitName")String unitName);

    List<Suppliermanage> selectYByUnitNameAndPhoneNumber(@Param("unitName")String unitName, @Param("phoneNumber")String phoneNumber);

    List<Suppliermanage> selectYByPhoneNumber(@Param("phoneNumber")String phoneNumber);

    List<Suppliermanage> selectFByUnitName(@Param("unitName")String unitName);

    List<Suppliermanage> selectFByUnitNameAndPhoneNumber(@Param("unitName")String unitName,@Param("phoneNumber")String phoneNumber);

    List<Suppliermanage> selectFByPhoneNumber(@Param("phoneNumber")String phoneNumber);

    List<Suppliermanage> selectOtherBySpare01(@Param("spare01")String spare01);

    List<Suppliermanage> selectOtherYBySpare01(@Param("spare01")String spare01);

    List<Suppliermanage> selectOtherFBySpare01(@Param("spare01")String spare01);

    List<Suppliermanage> selectByUnitCode(@Param("unitCode")String unitCode);

    String selectUNameByUcode(@Param("unitCode")String unitCode);
}
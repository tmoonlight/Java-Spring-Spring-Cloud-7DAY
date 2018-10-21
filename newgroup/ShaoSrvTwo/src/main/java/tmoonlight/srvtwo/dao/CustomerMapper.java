package tmoonlight.srvtwo.dao;

import org.apache.ibatis.annotations.*;
import tmoonlight.srvtwo.model.Customer;

@Mapper
public interface CustomerMapper {
    @Delete({
        "delete from crm_customer",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into crm_customer (id, Name, ",
        "CardNo, Descriot, ",
        "CtfTp, CtfId, ",
        "Gender, Birthday, ",
        "Address, Zip, ",
        "Dirty, District1, ",
        "District2, District3, ",
        "District4, District5, ",
        "District6, FirstNm, ",
        "LastNm, Duty, ",
        "Mobile, Tel, Fax, ",
        "EMail, Nation, ",
        "Taste, Education, ",
        "Company, CTel, ",
        "CAddress, CZip, ",
        "Family, Version)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=NVARCHAR}, ",
        "#{cardno,jdbcType=NVARCHAR}, #{descriot,jdbcType=NVARCHAR}, ",
        "#{ctftp,jdbcType=NVARCHAR}, #{ctfid,jdbcType=NVARCHAR}, ",
        "#{gender,jdbcType=NVARCHAR}, #{birthday,jdbcType=NVARCHAR}, ",
        "#{address,jdbcType=NVARCHAR}, #{zip,jdbcType=NVARCHAR}, ",
        "#{dirty,jdbcType=NVARCHAR}, #{district1,jdbcType=NVARCHAR}, ",
        "#{district2,jdbcType=NVARCHAR}, #{district3,jdbcType=NVARCHAR}, ",
        "#{district4,jdbcType=NVARCHAR}, #{district5,jdbcType=NVARCHAR}, ",
        "#{district6,jdbcType=NVARCHAR}, #{firstnm,jdbcType=NVARCHAR}, ",
        "#{lastnm,jdbcType=NVARCHAR}, #{duty,jdbcType=NVARCHAR}, ",
        "#{mobile,jdbcType=NVARCHAR}, #{tel,jdbcType=NVARCHAR}, #{fax,jdbcType=NVARCHAR}, ",
        "#{email,jdbcType=NVARCHAR}, #{nation,jdbcType=NVARCHAR}, ",
        "#{taste,jdbcType=NVARCHAR}, #{education,jdbcType=NVARCHAR}, ",
        "#{company,jdbcType=NVARCHAR}, #{ctel,jdbcType=NVARCHAR}, ",
        "#{caddress,jdbcType=NVARCHAR}, #{czip,jdbcType=NVARCHAR}, ",
        "#{family,jdbcType=NVARCHAR}, #{version,jdbcType=NVARCHAR})"
    })
    int insert(Customer record);

    int insertSelective(Customer record);

    @Select({
        "select",
        "id, Name, CardNo, Descriot, CtfTp, CtfId, Gender, Birthday, Address, Zip, Dirty, ",
        "District1, District2, District3, District4, District5, District6, FirstNm, LastNm, ",
        "Duty, Mobile, Tel, Fax, EMail, Nation, Taste, Education, Company, CTel, CAddress, ",
        "CZip, Family, Version",
        "from crm_customer",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("CustomerMapper.BaseResultMap")
    Customer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Customer record);

    @Update({
        "update crm_customer",
        "set Name = #{name,jdbcType=NVARCHAR},",
          "CardNo = #{cardno,jdbcType=NVARCHAR},",
          "Descriot = #{descriot,jdbcType=NVARCHAR},",
          "CtfTp = #{ctftp,jdbcType=NVARCHAR},",
          "CtfId = #{ctfid,jdbcType=NVARCHAR},",
          "Gender = #{gender,jdbcType=NVARCHAR},",
          "Birthday = #{birthday,jdbcType=NVARCHAR},",
          "Address = #{address,jdbcType=NVARCHAR},",
          "Zip = #{zip,jdbcType=NVARCHAR},",
          "Dirty = #{dirty,jdbcType=NVARCHAR},",
          "District1 = #{district1,jdbcType=NVARCHAR},",
          "District2 = #{district2,jdbcType=NVARCHAR},",
          "District3 = #{district3,jdbcType=NVARCHAR},",
          "District4 = #{district4,jdbcType=NVARCHAR},",
          "District5 = #{district5,jdbcType=NVARCHAR},",
          "District6 = #{district6,jdbcType=NVARCHAR},",
          "FirstNm = #{firstnm,jdbcType=NVARCHAR},",
          "LastNm = #{lastnm,jdbcType=NVARCHAR},",
          "Duty = #{duty,jdbcType=NVARCHAR},",
          "Mobile = #{mobile,jdbcType=NVARCHAR},",
          "Tel = #{tel,jdbcType=NVARCHAR},",
          "Fax = #{fax,jdbcType=NVARCHAR},",
          "EMail = #{email,jdbcType=NVARCHAR},",
          "Nation = #{nation,jdbcType=NVARCHAR},",
          "Taste = #{taste,jdbcType=NVARCHAR},",
          "Education = #{education,jdbcType=NVARCHAR},",
          "Company = #{company,jdbcType=NVARCHAR},",
          "CTel = #{ctel,jdbcType=NVARCHAR},",
          "CAddress = #{caddress,jdbcType=NVARCHAR},",
          "CZip = #{czip,jdbcType=NVARCHAR},",
          "Family = #{family,jdbcType=NVARCHAR},",
          "Version = #{version,jdbcType=NVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Customer record);
}
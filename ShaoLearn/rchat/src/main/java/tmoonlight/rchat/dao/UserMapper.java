package tmoonlight.rchat.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tmoonlight.rchat.model.User;

public interface UserMapper {
    @Delete({
        "delete from aa_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into aa_user (id, user_name, ",
        "password, staff_no, ",
        "staff_name, proxy_user, ",
        "dept_no, loaded, disabled, ",
        "locked, remark)",
        "values (#{id,jdbcType=BIGINT}, #{userName,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{staffNo,jdbcType=VARCHAR}, ",
        "#{staffName,jdbcType=VARCHAR}, #{proxyUser,jdbcType=VARCHAR}, ",
        "#{deptNo,jdbcType=VARCHAR}, #{loaded,jdbcType=BIT}, #{disabled,jdbcType=BIT}, ",
        "#{locked,jdbcType=BIT}, #{remark,jdbcType=VARCHAR})"
    })
    int insert(User record);

    int insertSelective(User record);

    @Select({
        "select",
        "id, user_name, password, staff_no, staff_name, proxy_user, dept_no, loaded, ",
        "disabled, locked, remark",
        "from aa_user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("tmoonlight.rchat.dao.UserMapper.BaseResultMap")
    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    @Update({
        "update aa_user",
        "set user_name = #{userName,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "staff_no = #{staffNo,jdbcType=VARCHAR},",
          "staff_name = #{staffName,jdbcType=VARCHAR},",
          "proxy_user = #{proxyUser,jdbcType=VARCHAR},",
          "dept_no = #{deptNo,jdbcType=VARCHAR},",
          "loaded = #{loaded,jdbcType=BIT},",
          "disabled = #{disabled,jdbcType=BIT},",
          "locked = #{locked,jdbcType=BIT},",
          "remark = #{remark,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(User record);
}
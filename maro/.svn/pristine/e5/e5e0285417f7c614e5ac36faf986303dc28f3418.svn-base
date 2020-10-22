package com.maro.common.users.tsuser.dao;

import com.maro.common.users.tsuser.pojo.vo.UserInfoVO;
import com.maro.platform.web.system.pojo.base.TSDepart;
import com.maro.platform.web.system.pojo.base.TSUser;
import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.Sql;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MaroCommonUserServiceDao {

	@Arguments({"userName","passWord"})
	@Sql("SELECT t.*, t1.* FROM t_s_user t INNER JOIN t_s_base_user t1 ON t.id = t1.ID WHERE t1.username = :userName AND t1.`password` =:passWord")
	UserInfoVO getUserInfo(String userName, String passWord);
	
	@Arguments("userId")
	@Sql("SELECT t.* FROM t_s_depart t, t_s_user_org t1 WHERE t.id=t1.org_id AND t1.user_id =:userId")
	List<TSDepart> getCurrentDepart(String userId);
	
	@Arguments("userId")
	@Sql("SELECT * FROM t_s_depart WHERE id = ( SELECT t.parentdepartid FROM t_s_depart t, t_s_user_org t1 WHERE t.id=t1.org_id AND t1.user_id =:userId LIMIT 0,1)")
	TSDepart getParentDepart(String id);
	
	@Arguments("departId")
	List<TSUser> tsUserList(String departId);

	@Arguments({"shiftCode","userId"})
    List<Map> getIsLogin(String shiftCode, String userId);

	@Arguments({"shiftCode","userId"})
	void addShift(String shiftCode, String userId);
}

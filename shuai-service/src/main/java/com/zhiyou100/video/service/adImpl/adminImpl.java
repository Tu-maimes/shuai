package com.zhiyou100.video.service.adImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.adminMapper;
import com.zhiyou100.video.model.admin;
import com.zhiyou100.video.model.adminExample;
import com.zhiyou100.video.service.adminService;
@Service
public class adminImpl implements adminService{
		@Autowired
		adminMapper am;
	@Override
	public List<admin> selectadmin(admin ad) {
		adminExample example = new adminExample();
		example.createCriteria().andLoginNameEqualTo(ad.getLoginName()).andLoginPwdEqualTo(ad.getLoginPwd());
		return am.selectByExample(example);
	}

}

package com.zhiyou100.video.service.UserImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.UserMapper;
import com.zhiyou100.video.model.User;
import com.zhiyou100.video.model.UserExample;
import com.zhiyou100.video.service.UserService;
import com.zhiyou100.video.service.tools.MailUtil;
import com.zhiyou100.video.service.tools.VerificationCode;
@Service
public class UserImpl implements UserService {
	@Autowired
	UserMapper um;

	@Override
	public void addUser(User user) {
		um.insertSelective(user);
		
	}

	@Override
	public List<User> selectUser(User user) {
		UserExample example = new UserExample();
		example.createCriteria().andEmailEqualTo(user.getEmail()).andPasswordEqualTo(user.getPassword());
		return um.selectByExample(example);
	}

	@Override
	public void updatHeadUrl(User user) {
		um.updateByPrimaryKeySelective(user);
	}

	@Override
	public User selectUserIndex(Integer id) {
		return um.selectByPrimaryKey(id);
	}

	@Override
	public void updateProfile(User user) {
		um.updateByPrimaryKeySelective(user);
	}

	@Override
	public void userUpdate(User use) {
		um.updateByPrimaryKeySelective(use);
	}

	@Override
	public List<User> selectUsertoword(User pe) {
		UserExample example = new UserExample();
		example.createCriteria().andPasswordEqualTo(pe.getPassword()).andIdEqualTo(pe.getId());
		return um.selectByExample(example);
	}

	@Override
	public void sendemail(User user)  {
		/*String base = "abcdefghijklmnopqrstuvwxyz";     
	    Random random = new Random();     
	    StringBuffer sb = new StringBuffer();     
	    for (int i = 0; i <4; i++) {     
	        int number = random.nextInt(base.length());     
	        sb.append(base.charAt(number));     
	    }  
	    String sd= sb.toString();
	    try {
			MailUtil.send("1585019349@qq.com", "验证码",sd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		String sd=VerificationCode.VCode("jhkshfksfksfgskkhfskjfs",4);
		try {
			MailUtil.send(user.getEmail(), "验证码",sd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    user.setCaptcha(sd);
		um.sendemail(user);
	}

	@Override
	public List<User> forgetpwd(User user) {
		UserExample example = new UserExample();
		example.createCriteria().andCaptchaEqualTo(user.getCaptcha()).andEmailEqualTo(user.getEmail());
		return um.selectByExample(example);
	}

	@Override
	public void updateRestPwd(User user) {
		um.updateByPrimaryKeySelective(user);
	}

	@Override
	public List<User> detectionEmail(User user) {
		UserExample example = new UserExample();
		example.createCriteria().andEmailEqualTo(user.getEmail());
		return um.selectByExample(example);
	}

	


}

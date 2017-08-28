package com.zhiyou100.video.service.UserImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.UserMapper;
import com.zhiyou100.video.model.User;
import com.zhiyou100.video.service.UserService;
@Service
public class UserImpl implements UserService {
	@Autowired
	UserMapper um;
	@Override
	public List<User> selectUser(User us) {
		
		return um.selectByExample(null);
	}

}

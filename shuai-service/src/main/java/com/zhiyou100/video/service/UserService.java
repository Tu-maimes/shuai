package com.zhiyou100.video.service;

import java.util.List;

import com.zhiyou100.video.model.User;

public interface UserService {


	void addUser(User user);

	List<User> selectUser(User user);

	void updatHeadUrl(User user);

	User selectUserIndex(Integer id);

	void updateProfile(User user);

	void userUpdate(User use);

	List<User> selectUsertoword(User pe);

	void sendemail(User user);

	List<User> forgetpwd(User user);

	void updateRestPwd(User user);

	List<User> detectionEmail(User user);

	

}

package com.zhiyou100.video.model;

public class admin {
    private Integer id;

    private String loginName;

    private String loginPwd;

    private String loginPic;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd == null ? null : loginPwd.trim();
    }

    public String getLoginPic() {
        return loginPic;
    }

    public void setLoginPic(String loginPic) {
        this.loginPic = loginPic == null ? null : loginPic.trim();
    }

	@Override
	public String toString() {
		return "admin [id=" + id + ", loginName=" + loginName + ", loginPwd=" + loginPwd + ", loginPic=" + loginPic
				+ "]";
	}
    
}
package com.ifzer.controller;

import java.util.Date;
import java.util.List;

import com.ifzer.models.User;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Page;
import com.xiaoleilu.hutool.util.StrUtil;

public class UserController extends Controller{
	
	public void index(){
		renderHtml("<h1>user ok .</h1><br>");
	}

	public void adduser(){
		User user = getModel(User.class, "");
		user.save();
		list();
	}
	
	public void addrandomuser(){
		User user = new User().set("nickname", StrKit.getRandomUUID()).set("password", StrKit.getRandomUUID());
		user.set("createdate", new Date()).set("modifydate", new Date());
		user.set("realname", StrKit.getRandomUUID());
		user.set("status", Math.ceil(Math.random() * 10));
		user.save();
		list();
	}
	
	public void deletefirstuser(){
		List<User> userList = User.userdao.find("select * from t_users");
		if(userList != null && !userList.isEmpty()){
			User user = userList.get(0);
			renderHtml("<h1>delete ok .</h1><br>"+user.toJson());
			user.delete();
		}else{
			renderHtml("<h1>delete fail, no data .</h1>");
		}
	}
	
	public void deleteuserbyid(){
		int userid = getParaToInt(0);
		User user = User.userdao.findById(userid);
		StrUtil.builder().append("");
		if(user != null ){			
			user.delete();
			list();
		}else{
			renderHtml("<h1>delete fail, no data .</h1>");
		}
	}
	
	public void list(){
		int pageNo = getParaToInt("pageNo", 1);
		int pageSize = getParaToInt("pageSize", 15);
		Page<User> page = User.userdao.paginate(pageNo, pageSize, "select * ", "from t_users");
		if(page != null && page.getTotalRow() > 0){
			renderJson(page);
		}else{
			renderHtml("<p>列表暂无数据</p>");
		}
	}
	
}

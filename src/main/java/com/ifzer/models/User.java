package com.ifzer.models;

import com.jfinal.plugin.activerecord.Model;

public class User extends Model<User>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4931661548144354191L;

	public static final User userdao = new User().dao();
}

package com.ifzer.core;

import com.ifzer.controller.UserController;
import com.ifzer.models.User;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;

public class WebConfig extends JFinalConfig{

	@Override
	public void configConstant(Constants paramConstants) {
		paramConstants.setDevMode(getPropertyToBoolean("devMode"));
	}

	@Override
	public void configEngine(Engine paramEngine) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configHandler(Handlers paramHandlers) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configInterceptor(Interceptors paramInterceptors) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configPlugin(Plugins paramPlugins) {
		loadPropertyFile("config.properties");
		DruidPlugin dbplugin = new DruidPlugin(getProperty("db.url"), 
				getProperty("db.username"), getProperty("db.password"));
		paramPlugins.add(dbplugin);
		
		ActiveRecordPlugin activeRecordPlugin = new ActiveRecordPlugin(dbplugin);
		paramPlugins.add(activeRecordPlugin);
		activeRecordPlugin.addMapping("t_users", User.class);
	}

	@Override
	public void configRoute(Routes paramRoutes) {
		paramRoutes.add("/users", UserController.class);
	}

}

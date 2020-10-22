package com.maro.platform.web.system.manager;

import java.util.Comparator;

import com.maro.platform.web.system.pojo.base.Client;

public class ClientSort implements Comparator<Client> {

	
	public int compare(Client prev, Client now) {
		return (int) (now.getLogindatetime().getTime()-prev.getLogindatetime().getTime());
	}

}

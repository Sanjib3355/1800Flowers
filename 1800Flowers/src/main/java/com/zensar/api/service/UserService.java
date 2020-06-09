package com.zensar.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

public interface UserService {

	public List<Object> getUpdatedUserList(String url, int positionToUpdate) throws Exception;

	public int getUniqueUserIds(String url) throws Exception;

}
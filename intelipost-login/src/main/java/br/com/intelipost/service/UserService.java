package br.com.intelipost.service;

import br.com.intelipost.model.ResponseModel;
import br.com.intelipost.model.UserModel;

public interface UserService {

	public ResponseModel login(UserModel userModel);
}

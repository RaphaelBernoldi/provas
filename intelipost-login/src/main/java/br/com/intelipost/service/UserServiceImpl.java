package br.com.intelipost.service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.intelipost.entity.UserEntity;
import br.com.intelipost.model.ResponseModel;
import br.com.intelipost.model.UserModel;
import br.com.intelipost.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public ResponseModel login(UserModel userModel) {
		logger.info("UserService.login");
		ResponseModel response = new ResponseModel();

		try {
			
			final ThreadGroup threadUser = new ThreadGroup("threa_user");
				UserEntity userEntity = Executors
					.newCachedThreadPool(t -> new Thread(threadUser, t))
					.submit(() -> {
						return userRepository.findByloginAndPassword(userModel.getUser(), userModel.getPassword());
					}).get();
		
				if(userEntity != null){
					response.setPage("home/index");
					response.setMessage("Bem vindo! "+userEntity.getName());
					return response;
				}
				
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		response.setPage("login/index");
		response.setMessage("Usuário não encontrado");
		return response;
		
	}

}

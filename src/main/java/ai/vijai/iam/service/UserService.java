package ai.vijai.iam.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ai.vijai.iam.domain.Beneficiaries;
import ai.vijai.iam.domain.BeneficiaryUserSDO;
import ai.vijai.iam.entity.User;
import ai.vijai.iam.repository.IamRepository;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UserService {

	@Autowired
	IamRepository iamRepository;

	@Autowired
	private RestTemplate restTemplate;

	public Optional<User> getUser(Long id) {

		return iamRepository.findById(id);
	}

	public User addUser(User user) {
		// TODO Auto-generated method stub
		return iamRepository.save(user);
	}

	public BeneficiaryUserSDO getUserWithPayee(Long userId) {
		// TODO Auto-generated method stub
		BeneficiaryUserSDO beneficiaryUserSDO = new BeneficiaryUserSDO();
		Optional<User> user = iamRepository.findById(userId);
		beneficiaryUserSDO.setUser(user.get());
		Beneficiaries beneficiaries ;
		if (user.isPresent()) {
			log.info("User is present");
			beneficiaries= restTemplate.getForObject(
					"http://BENEFICIARY-MS/beneficiary/payee/" + user.get().getUserCifNo(), Beneficiaries.class);
			beneficiaryUserSDO.setBeneficiaries(beneficiaries);
		}
		
		return beneficiaryUserSDO;

	}

}

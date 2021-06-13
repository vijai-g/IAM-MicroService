package ai.vijai.iam.domain;

import java.util.Optional;

import ai.vijai.iam.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeneficiaryUserSDO {
	
	User user;
	Beneficiaries beneficiaries; 

}

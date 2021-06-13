package ai.vijai.iam.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Beneficiaries {

	private Long payeeUuid;
	
	private String payeeName;
	private String status;
	private String payeeType;
}

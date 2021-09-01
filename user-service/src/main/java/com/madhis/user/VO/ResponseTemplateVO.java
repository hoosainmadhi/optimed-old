package com.madhis.user.VO;

import com.madhis.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplateVO {
	
	private User user;
	private Department department;
}

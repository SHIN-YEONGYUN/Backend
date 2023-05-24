package command2;

import org.springframework.stereotype.Component;

@Component("product")
public class ProductCommand implements Command {

	@Override
	public String run() {
		// TODO Auto-generated method stub
		return "상품정보 : 등록중입니다.";
	}

}

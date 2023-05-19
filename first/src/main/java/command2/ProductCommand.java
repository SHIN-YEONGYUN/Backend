package command2;

import org.springframework.stereotype.Component;

@Component("product")
public class ProductCommand implements Command{

	
	@Override
	public String run() {
		return "상품 : 등록중입니다.";
	}
}
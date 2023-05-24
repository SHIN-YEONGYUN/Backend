package memberservice;

import org.springframework.stereotype.Repository;

@Repository //pointDAO
public class PointDAO {
	int point;

public int getPoint() {
	return point;
}

public void setPoint(int point) {
	this.point = point;
}
 
}

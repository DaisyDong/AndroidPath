package Service;

import java.util.List;

import net.sf.json.JSONObject;

public interface UserService {
	
	public String userQuery(String queryName,String queryNumber);
	public String userNew(JSONObject json);
	 
}

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.bean.User;
import com.cg.dao.UserDao;
public class UserAppClient 
{
	public static void main(String[] args) 
	{
		try
		{
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"spring-beans.xml");
			UserDao usrDao = (UserDao) context.getBean("userDao");
			User anjulata = new User();
			anjulata.setName("tanmaya");
			anjulata.setAge(80);			
			usrDao.create(anjulata);	
			System.out.println("----------User Inserted-----------------");
			System.out.println("------------Show User Info---------");
			List<User> userList=usrDao.getAllUser();
			for(User usr:userList)
			{
				System.out.println(usr.getId()  +"  :   "+  
								usr.getName()+ " :  "+usr.getAge());	
			}
		}
		catch (Exception e) 
		{
			System.out.println("Exception App.java" + e.getMessage());
			e.printStackTrace();
		}
	}
}
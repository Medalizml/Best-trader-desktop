package tn.esprit.BluesClient.Screeners;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ServiceLocator {
	private Context context;
	private static ServiceLocator instance;
	private Map<String, Object> cache=new HashMap<>();
	public Context getContext() {
		try{
		context=new InitialContext();
		}
		catch(NamingException ex){
			System.out.println(ex);
		}
	return context;
	}
	

	public void setContext(Context context) {
		this.context = context;
	}

	private ServiceLocator() {
		try {
			context= new InitialContext();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Object getProxy(String jndi){
		Object object=null;
		if(cache.containsKey(jndi)){
			return cache.get(jndi);
		}
		else{
			try{
				object=context.lookup(jndi);
				cache.put(jndi, object);
			}
			catch(NamingException ex){
			ex.printStackTrace();}
		}
		return cache.get(jndi);
	}


	public static ServiceLocator getInstance() {
		if(instance==null){
			instance=new ServiceLocator();
		}
		return instance;
	}


	public static void setInstance(ServiceLocator instance) {
		ServiceLocator.instance = instance;
	}

}

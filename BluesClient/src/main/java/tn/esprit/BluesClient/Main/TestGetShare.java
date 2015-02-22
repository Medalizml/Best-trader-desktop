package tn.esprit.BluesClient.Main;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import tn.esprit.Blues.Services.PaircurrencyServices;
import tn.esprit.Blues.Services.SharesServices;
import tn.esprit.Blues.entities.Paircurrency;
import tn.esprit.Blues.entities.Share;

public class TestGetShare {
	
	public PaircurrencyServices remote;
	
	@Before
	public void init() {
		try {
			Context context = new InitialContext();
			remote = (PaircurrencyServices) context.lookup("Blues/PaircurrencyServicesImpl!"+ PaircurrencyServices.class.getCanonicalName());
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("erreur share serveces");
		}
	}

	@Test
	public void test() {
		for (Paircurrency s :remote.findAll()) {
			System.out.println("The share is :"+s.getId());
		}
	}

}

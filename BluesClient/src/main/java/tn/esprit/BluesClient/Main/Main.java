package tn.esprit.BluesClient.Main;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.Blues.Services.BondServices;
import tn.esprit.Blues.Services.PaircurrencyServices;
import tn.esprit.Blues.Services.SharesServices;
import tn.esprit.Blues.entities.Bond;
import tn.esprit.Blues.entities.Company;
import tn.esprit.Blues.entities.Paircurrency;
import tn.esprit.Blues.entities.Share;

public class Main {

	public static void main(String[] args) {

		try {
			PaircurrencyServices remote;
			System.out.println("laaa");
			Context context = new InitialContext();
			remote = (PaircurrencyServices) context.lookup("Blues/PaircurrencyServicesImpl!"+PaircurrencyServices.class.getCanonicalName());
			System.out.println("ici");
			for (Paircurrency s : remote.findAll()) {
				System.out.println("The share is :" + s.getId());
			}
		} catch (NamingException e) {
			e.printStackTrace();
			System.out.println("erreur share serveces");
		}
	}
}

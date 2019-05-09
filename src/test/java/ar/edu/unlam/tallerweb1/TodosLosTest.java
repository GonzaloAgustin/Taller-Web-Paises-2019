package ar.edu.unlam.tallerweb1;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Ciudad;
import ar.edu.unlam.tallerweb1.modelo.Continente;
import ar.edu.unlam.tallerweb1.modelo.Pais;
import ar.edu.unlam.tallerweb1.modelo.Ubicacion;

public class TodosLosTest extends SpringTest{
	
	@Test @Transactional @Rollback
	public void TestQueBuscaPaisesDeHablaInglesa(){

		Continente america = new Continente();
		america.setNombre("America");
		
		Continente europa = new Continente();
		europa.setNombre("Europa");
		
		Pais argentina = new Pais();
		argentina.setNombre("Argentina");
		argentina.setHabitantes(4000000);
		argentina.setIdioma("Español");
		argentina.setContinente(america);
		
		Pais eeuu = new Pais();
		eeuu.setNombre("Estados Unidos");
		eeuu.setHabitantes(15674652);
		eeuu.setIdioma("Ingles");
		eeuu.setContinente(america);
		
		Pais inglaterra = new Pais();
		inglaterra.setNombre("Inglaterra");
		inglaterra.setHabitantes(2124524);
		inglaterra.setIdioma("Ingles");
		inglaterra.setContinente(europa);
		
		Session session = getSession();
		session.save(america);
		session.save(europa);
		session.save(argentina);
		session.save(eeuu);
		session.save(inglaterra);

		List<Pais> paisesLenguaInglesa = getSession()
				.createCriteria(Pais.class)
				.add(Restrictions.eq("idioma", "Ingles"))
				.list(); 
		
		assertThat(paisesLenguaInglesa).isNotNull();
		assertThat(paisesLenguaInglesa.size()).isEqualTo(2);
		assertThat(paisesLenguaInglesa).hasSize(2);
		
		
	}
	
	@Test @Transactional @Rollback
	public void TestQueBuscaPaisesEuropeos(){
		
		Continente america = new Continente();
		america.setNombre("America");
		
		Continente europa = new Continente();
		europa.setNombre("Europa");
		
		Pais argentina = new Pais();
		argentina.setNombre("Argentina");
		argentina.setHabitantes(4000000);
		argentina.setIdioma("Español");
		argentina.setContinente(america);
		
		Pais italia = new Pais();
		italia.setNombre("Italia");
		italia.setHabitantes(15674652);
		italia.setIdioma("Italiano");
		italia.setContinente(europa);
		
		Pais inglaterra = new Pais();
		inglaterra.setNombre("Inglaterra");
		inglaterra.setHabitantes(2124524);
		inglaterra.setIdioma("Ingles");
		inglaterra.setContinente(europa);
		
		Session session = getSession();
		session.save(america);
		session.save(europa);
		session.save(argentina);
		session.save(italia);
		session.save(inglaterra);

		List<Pais> paisesEuropeos = getSession().createCriteria(Pais.class)
				 .add(Restrictions.eq("continente", europa))
				 .list(); 

		assertThat(paisesEuropeos).isNotNull();
		assertThat(paisesEuropeos.size()).isEqualTo(2);
		assertThat(paisesEuropeos).hasSize(2);
		
	}
	
}
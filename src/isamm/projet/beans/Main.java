package isamm.projet.beans;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import isamm.projet.service.EtudiantService;
import isamm.projet.service.FiliereService;
import isamm.projet.service.FormateurService;
import isamm.projet.service.LigneMatiereFiliereService;
import isamm.projet.service.MatiereService;

public class Main {

	public static void main(String[] args) {
		FiliereService filiereService = new FiliereService(); 
		FormateurService formateurService = new FormateurService(); 
		MatiereService matiereService = new MatiereService();
		EtudiantService etudiantService = new EtudiantService();
		LigneMatiereFiliereService ligneMatiereFiliereService = new LigneMatiereFiliereService();
		
		Filiere fil0 = new Filiere("Ingénierie des automatismes et informatique industrielle", "IAII");
		Filiere fil1 = new Filiere("Ingénierie des réseaux et télécommunications", "IRT");
		Filiere fil2 = new Filiere("Ingénierie informatique et réseaux", "IIR");
		
		filiereService.create(fil0);
		filiereService.create(fil1);
		filiereService.create(fil2);
		
		Matiere mat0 = new Matiere("Techniques de programmation structurée", "TPC");
		Matiere mat1 = new Matiere("Java de Base", "JB");
		Matiere mat2 = new Matiere("Administration Unix", "AU");
		Matiere mat3 = new Matiere("Framework de persistance", "Hibernate");
		Matiere mat4 = new Matiere("Programmation orientée objet", "POO");

		matiereService.create(mat0);
		matiereService.create(mat1);
		matiereService.create(mat2);
		matiereService.create(mat3);
		matiereService.create(mat4);
		
		Formateur form0 = new Formateur();
			form0.setNom("SELIMANI");
			form0.setPrenom("Yahiya");
			Set<Matiere> formMat0 = new HashSet<Matiere>();
				formMat0.add(new Matiere("Cloud computing", "CC"));
				formMat0.add(mat0);
			form0.setMatieres(formMat0);
		
		Formateur form1 = new Formateur();
			form1.setNom("SAFI");
			form1.setPrenom("Ilham");
			Set<Matiere> formMat1 = new HashSet<Matiere>();
				formMat1.add(mat2);
				formMat1.add(mat4);
			form1.setMatieres(formMat1);
			
		formateurService.create(form0);
		formateurService.create(form1);
		
		Etudiant etud0 = new Etudiant();
			etud0.setNom("SAFI");
			etud0.setPrenom("Amal");
			etud0.setCne("22845676");
			etud0.setFiliere(fil2);
			
		Etudiant etud1 = new Etudiant();
			etud1.setNom("ALAMI");
			etud1.setPrenom("Samir");
			etud1.setCne("23845976");
			etud1.setFiliere(fil2);
			
		Etudiant etud2 = new Etudiant();
			etud2.setNom("ALAOUI");
			etud2.setPrenom("Safa");
			etud2.setCne("22345476");
			etud2.setFiliere(fil0);
			
		etudiantService.create(etud0);
		etudiantService.create(etud1);
		etudiantService.create(etud2);

		Iterator Mi = matiereService.getAll().iterator();
		System.out.println("Liste des matieres :");
		while (Mi.hasNext()) {
			Matiere m =(Matiere) Mi.next();
			System.out.println("\t Libelle => "+m.getLibelle());
			
		}
		
		Iterator FbMi = formateurService.getFormateurByMetiere(mat2).iterator();
		System.out.println("Liste des formateurs qui enseigne le matiere "+mat2.getLibelle()+" :");
		while (FbMi.hasNext()) {
			Formateur f =(Formateur) FbMi.next();
			System.out.println("\t Nom et Prenom => "+f.getNom()+" "+f.getPrenom());
			
		}
		
		Iterator EbFi = filiereService.getEtudiantByFiliere(fil0).iterator();
		System.out.println("Liste des etudiants pour le filiere "+fil0.getLibelle()+" :");
		while (EbFi.hasNext()) {
			Etudiant e = (Etudiant) EbFi.next();
			System.out.println("\t Nom et Prenom => "+e.getNom()+" "+e.getPrenom());
			
		}
		
		Iterator MbFi = ligneMatiereFiliereService.getMatiereByFiliere(fil0).iterator();
		System.out.println("Liste des matieres pour le filiere "+fil0.getLibelle()+" :");
		while (MbFi.hasNext()) {
			Matiere m =(Matiere) Mi.next();
			System.out.println("\t Libelle => "+m.getLibelle());
			
		}
		HibernateUtil.shutdown();

	}

}

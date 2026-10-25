package com.inss.immatriculation.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inss.immatriculation.pojo.PrsEmpHistorique;
import com.inss.immatriculation.pojo.PrsEmployeur;
import com.inss.immatriculation.repository.PrsEmpHistoriqueRepository;
import com.inss.immatriculation.repository.PrsEmployeurRepository;

import java.time.LocalDate;
import java.util.Objects;

@Service
public class PrsEmployeurService {

    private final PrsEmployeurRepository employeurRepo;
    private final PrsEmpHistoriqueRepository histRepo;

    public PrsEmployeurService(PrsEmployeurRepository employeurRepo,
                               PrsEmpHistoriqueRepository histRepo) {
        this.employeurRepo = employeurRepo;
        this.histRepo = histRepo;
    }

    @Transactional
    public PrsEmployeur update(Long id, PrsEmployeur nouveau) {
        PrsEmployeur ancien = employeurRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employeur introuvable: " + id));

        // Le trigger ne s'active que si l'ancienne décision = 'A'
        if ("A".equals(ancien.getEmpDecision())) {
            insertHistorique(ancien, nouveau);
        }

        // copier les champs de "nouveau" vers "ancien" (ou save(nouveau))
        copierChamps(ancien, nouveau);
        return employeurRepo.save(ancien);
    }

    private void insertHistorique(PrsEmployeur o, PrsEmployeur n) {
        Long aff = n.getEmpAffiliation();

        // Cas particulier du trigger Oracle : AFFILIATION
        if (diff(o.getEmpAffiliation(), n.getEmpAffiliation())) {
            histRepo.save(build("AFFILIATION", n.getEmpSequence(),
                    str(o.getEmpAffiliation()), str(n.getEmpAffiliation()), aff));
        }
        if (diff(o.getEmpEtat(), n.getEmpEtat()))
            histRepo.save(build("ETAT", n.getEmpSequence(), o.getEmpEtat(), n.getEmpEtat(), aff));
        if (diff(o.getEmpDtEffet(), n.getEmpDtEffet()))
            histRepo.save(build("DATE AFFILIATION", n.getEmpSequence(),
                    str(o.getEmpDtEffet()), str(n.getEmpDtEffet()), aff));
        if (diff(o.getEmpAssurance(), n.getEmpAssurance()))
            histRepo.save(build("TYPE ASSURANCE", n.getEmpSequence(), o.getEmpAssurance(), n.getEmpAssurance(), aff));
        if (diff(o.getEmpDtDemande(), n.getEmpDtDemande()))
            histRepo.save(build("DATE DEMANDE", n.getEmpSequence(),
                    str(o.getEmpDtDemande()), str(n.getEmpDtDemande()), aff));
        if (diff(o.getEmpDtReception(), n.getEmpDtReception()))
            histRepo.save(build("DATE RECEPTION", n.getEmpSequence(),
                    str(o.getEmpDtReception()), str(n.getEmpDtReception()), aff));
        if (diff(o.getEmpDecision(), n.getEmpDecision()))
            histRepo.save(build("DECISION", n.getEmpSequence(), o.getEmpDecision(), n.getEmpDecision(), aff));
        if (diff(o.getEmpDtDecision(), n.getEmpDtDecision()))
            histRepo.save(build("DATE DECISION", n.getEmpSequence(),
                    str(o.getEmpDtDecision()), str(n.getEmpDtDecision()), aff));
        if (diff(o.getEmpRaison(), n.getEmpRaison()))
            histRepo.save(build("RAISON", n.getEmpSequence(), o.getEmpRaison(), n.getEmpRaison(), aff));
        if (diff(o.getEmpNom(), n.getEmpNom()))
            histRepo.save(build("NOM/RAISON SOCIALE", n.getEmpSequence(), o.getEmpNom(), n.getEmpNom(), aff));
        if (diff(o.getEmpPrenom(), n.getEmpPrenom()))
            histRepo.save(build("PRENOM", n.getEmpSequence(), o.getEmpPrenom(), n.getEmpPrenom(), aff));
        if (diff(o.getEmpDtNaissance(), n.getEmpDtNaissance()))
            histRepo.save(build("DATE NAISSANCE", n.getEmpSequence(),
                    str(o.getEmpDtNaissance()), str(n.getEmpDtNaissance()), aff));
        if (diff(o.getEmpAbrev(), n.getEmpAbrev()))
            histRepo.save(build("SIGLE", n.getEmpSequence(), o.getEmpAbrev(), n.getEmpAbrev(), aff));
        if (diff(o.getEmpRue(), n.getEmpRue()))
            histRepo.save(build("RUE PHYSIQUE", n.getEmpSequence(), o.getEmpRue(), n.getEmpRue(), aff));
        if (diff(o.getEmpLocalite(), n.getEmpLocalite()))
            histRepo.save(build("LOCALITE PHYSIQUE", n.getEmpSequence(), o.getEmpLocalite(), n.getEmpLocalite(), aff));
        if (diff(o.getEmpVille(), n.getEmpVille()))
            histRepo.save(build("VILLE PHYSIQUE", n.getEmpSequence(), o.getEmpVille(), n.getEmpVille(), aff));
        if (diff(o.getEmpPays(), n.getEmpPays()))
            histRepo.save(build("PAYS PHYSIQUE", n.getEmpSequence(), o.getEmpPays(), n.getEmpPays(), aff));
        if (diff(o.getEmpCodePostal(), n.getEmpCodePostal()))
            histRepo.save(build("CODE POSTAL PHYSIQUE", n.getEmpSequence(), o.getEmpCodePostal(), n.getEmpCodePostal(), aff));
        if (diff(o.getEmpTelephone(), n.getEmpTelephone()))
            histRepo.save(build("TELEPHONE PHYSIQUE", n.getEmpSequence(), o.getEmpTelephone(), n.getEmpTelephone(), aff));
        if (diff(o.getEmpCodeFiscal(), n.getEmpCodeFiscal()))
            histRepo.save(build("CODE FISCAL", n.getEmpSequence(), o.getEmpCodeFiscal(), n.getEmpCodeFiscal(), aff));
        if (diff(o.getEmpEmail(), n.getEmpEmail()))
            histRepo.save(build("EMAIL PHYSIQUE", n.getEmpSequence(), o.getEmpEmail(), n.getEmpEmail(), aff));
        if (diff(o.getEmpFax(), n.getEmpFax()))
            histRepo.save(build("FAX PHYSIQUE", n.getEmpSequence(), o.getEmpFax(), n.getEmpFax(), aff));
        if (diff(o.getEmpRueP(), n.getEmpRueP()))
            histRepo.save(build("RUE POSTALE", n.getEmpSequence(), o.getEmpRueP(), n.getEmpRueP(), aff));
        if (diff(o.getEmpLocaliteP(), n.getEmpLocaliteP()))
            histRepo.save(build("LOCALITE POSTALE", n.getEmpSequence(), o.getEmpLocaliteP(), n.getEmpLocaliteP(), aff));
        if (diff(o.getEmpVilleP(), n.getEmpVilleP()))
            histRepo.save(build("VILLE POSTALE", n.getEmpSequence(), o.getEmpVilleP(), n.getEmpVilleP(), aff));
        if (diff(o.getEmpPaysP(), n.getEmpPaysP()))
            histRepo.save(build("PAYS POSTALE", n.getEmpSequence(), o.getEmpPaysP(), n.getEmpPaysP(), aff));
        if (diff(o.getEmpCodePostalP(), n.getEmpCodePostalP()))
            histRepo.save(build("CODE POSTAL POSTALE", n.getEmpSequence(), o.getEmpCodePostalP(), n.getEmpCodePostalP(), aff));
        if (diff(o.getEmpTelephoneP(), n.getEmpTelephoneP()))
            histRepo.save(build("TELEPHONE POSTALE", n.getEmpSequence(), o.getEmpTelephoneP(), n.getEmpTelephoneP(), aff));
        if (diff(o.getEmpAgence(), n.getEmpAgence()))
            histRepo.save(build("AGENCE", n.getEmpSequence(), o.getEmpAgence(), n.getEmpAgence(), aff));
        if (diff(o.getEmpProvince(), n.getEmpProvince()))
            histRepo.save(build("PROVINCE", n.getEmpSequence(), o.getEmpProvince(), n.getEmpProvince(), aff));
        if (diff(o.getEmpCommune(), n.getEmpCommune()))
            histRepo.save(build("COMMUNE/ZONE", n.getEmpSequence(), o.getEmpCommune(), n.getEmpCommune(), aff));
        if (diff(o.getEmpColline(), n.getEmpColline()))
            histRepo.save(build("COLLINE/QUARTIER", n.getEmpSequence(), o.getEmpColline(), n.getEmpColline(), aff));
        if (diff(o.getEmpNatJuridique(), n.getEmpNatJuridique()))
            histRepo.save(build("NATURE JURIDIQUE", n.getEmpSequence(), o.getEmpNatJuridique(), n.getEmpNatJuridique(), aff));
        if (diff(o.getEmpRegCommerce(), n.getEmpRegCommerce()))
            histRepo.save(build("REG. COMMERCE", n.getEmpSequence(), o.getEmpRegCommerce(), n.getEmpRegCommerce(), aff));
        if (diff(o.getEmpDtCreee(), n.getEmpDtCreee()))
            histRepo.save(build("DATE CREATION ENTREPRISE", n.getEmpSequence(),
                    str(o.getEmpDtCreee()), str(n.getEmpDtCreee()), aff));
        if (diff(o.getEmpDtPremierEm(), n.getEmpDtPremierEm()))
            histRepo.save(build("DATE DE PREMIERE EMBAUCHE", n.getEmpSequence(),
                    str(o.getEmpDtPremierEm()), str(n.getEmpDtPremierEm()), aff));
        if (diff(o.getEmpNbreTravaill(), n.getEmpNbreTravaill()))
            histRepo.save(build("NOMBRE TRAVAILLEURS", n.getEmpSequence(),
                    str(o.getEmpNbreTravaill()), str(n.getEmpNbreTravaill()), aff));
        if (diff(o.getEmpContacte(), n.getEmpContacte()))
            histRepo.save(build("NOM - CONTACT", n.getEmpSequence(), o.getEmpContacte(), n.getEmpContacte(), aff));
        if (diff(o.getEmpQualiteC(), n.getEmpQualiteC()))
            histRepo.save(build("QUALITE - CONTACT", n.getEmpSequence(), o.getEmpQualiteC(), n.getEmpQualiteC(), aff));
        if (diff(o.getEmpRueC(), n.getEmpRueC()))
            histRepo.save(build("RUE - CONTACT", n.getEmpSequence(), o.getEmpRueC(), n.getEmpRueC(), aff));
        if (diff(o.getEmpLocaliteC(), n.getEmpLocaliteC()))
            histRepo.save(build("LOCALITE - CONTACT", n.getEmpSequence(), o.getEmpLocaliteC(), n.getEmpLocaliteC(), aff));
        if (diff(o.getEmpVilleC(), n.getEmpVilleC()))
            histRepo.save(build("VILLE - CONTACT", n.getEmpSequence(), o.getEmpVilleC(), n.getEmpVilleC(), aff));
        if (diff(o.getEmpPaysC(), n.getEmpPaysC()))
            histRepo.save(build("PAYS - CONTACT", n.getEmpSequence(), o.getEmpPaysC(), n.getEmpPaysC(), aff));
        if (diff(o.getEmpCodePostalC(), n.getEmpCodePostalC()))
            histRepo.save(build("CODE POSTAL - CONTACT", n.getEmpSequence(), o.getEmpCodePostalC(), n.getEmpCodePostalC(), aff));
        if (diff(o.getEmpTelephoneC(), n.getEmpTelephoneC()))
            histRepo.save(build("TELEPHONE - CONTACT", n.getEmpSequence(), o.getEmpTelephoneC(), n.getEmpTelephoneC(), aff));
        if (diff(o.getEmpFrequencePaie(), n.getEmpFrequencePaie()))
            histRepo.save(build("FREQUENCE DE PAIE", n.getEmpSequence(), o.getEmpFrequencePaie(), n.getEmpFrequencePaie(), aff));
        if (diff(o.getEmpIndExempte(), n.getEmpIndExempte()))
            histRepo.save(build("EXEMPTION INTERET", n.getEmpSequence(), o.getEmpIndExempte(), n.getEmpIndExempte(), aff));
        if (diff(o.getEmpAffilPrecedent(), n.getEmpAffilPrecedent()))
            histRepo.save(build("AFFILIATION PRECEDENTE", n.getEmpSequence(),
                    str(o.getEmpAffilPrecedent()), str(n.getEmpAffilPrecedent()), aff));
        if (diff(o.getEmpFaxP(), n.getEmpFaxP()))
            histRepo.save(build("FAX POSTALE", n.getEmpSequence(), o.getEmpFaxP(), n.getEmpFaxP(), aff));
    }

    private PrsEmpHistorique build(String libelle, Long empSeq,
                                   String avant, String apres, Long affiliation) {
        PrsEmpHistorique h = new PrsEmpHistorique();
        h.setEhisLibelle(libelle);
        h.setEhisEmpSequence(empSeq);
        h.setEhisValeurAvant(avant);
        h.setEhisValeurApres(apres);
        h.setEhisDtCreee(LocalDate.now());
        h.setEhisUtilCree(currentUser());
        h.setEhisAffiliation(affiliation);
        return h;
    }

    private String currentUser() {
        try {
        	return "mugisha";
			/*
			 * return org.springframework.security.core.context.SecurityContextHolder
			 * .getContext().getAuthentication().getName();
			 */
        } catch (Exception e) {
            return "system";
        }
    }

    private boolean diff(Object a, Object b) { return !Objects.equals(a, b); }
    private String str(Object o) { return o == null ? null : o.toString(); }

    private void copierChamps(PrsEmployeur o, PrsEmployeur n) {
        // --- Identification / affiliation ---
        o.setEmpAffiliation(n.getEmpAffiliation());
        o.setEmpNom(n.getEmpNom());
        o.setEmpPrenom(n.getEmpPrenom());
        o.setEmpAbrev(n.getEmpAbrev());

        // --- Dates métier ---
        o.setEmpDtCreee(n.getEmpDtCreee());
        o.setEmpDtNaissance(n.getEmpDtNaissance());
        o.setEmpDtDemande(n.getEmpDtDemande());
        o.setEmpIndExempte(n.getEmpIndExempte());
        o.setEmpDtReception(n.getEmpDtReception());
        o.setEmpAffilPrecedent(n.getEmpAffilPrecedent());
        o.setEmpDtEffet(n.getEmpDtEffet());
        o.setEmpDtDecision(n.getEmpDtDecision());

        // --- Effectif / nature ---
        o.setEmpNbreTravaill(n.getEmpNbreTravaill());
        o.setEmpNatJuridique(n.getEmpNatJuridique());

        // --- Adresse physique ---
        o.setEmpRue(n.getEmpRue());
        o.setEmpLocalite(n.getEmpLocalite());
        o.setEmpVille(n.getEmpVille());
        o.setEmpCodePostal(n.getEmpCodePostal());
        o.setEmpTelephone(n.getEmpTelephone());
        o.setEmpPays(n.getEmpPays());
        o.setEmpProvince(n.getEmpProvince());
        o.setEmpCommune(n.getEmpCommune());
        o.setEmpAgence(n.getEmpAgence());
        o.setEmpColline(n.getEmpColline());
        o.setEmpEmail(n.getEmpEmail());
        o.setEmpFax(n.getEmpFax());

        // --- Contact ---
        o.setEmpContacte(n.getEmpContacte());
        o.setEmpQualiteC(n.getEmpQualiteC());
        o.setEmpRueC(n.getEmpRueC());
        o.setEmpLocaliteC(n.getEmpLocaliteC());
        o.setEmpVilleC(n.getEmpVilleC());
        o.setEmpPaysC(n.getEmpPaysC());
        o.setEmpTelephoneC(n.getEmpTelephoneC());
        o.setEmpCodePostalC(n.getEmpCodePostalC());

        // --- Adresse postale ---
        o.setEmpRueP(n.getEmpRueP());
        o.setEmpVilleP(n.getEmpVilleP());
        o.setEmpPaysP(n.getEmpPaysP());
        o.setEmpFaxP(n.getEmpFaxP());
        o.setEmpLocaliteP(n.getEmpLocaliteP());
        o.setEmpTelephoneP(n.getEmpTelephoneP());
        o.setEmpCodePostalP(n.getEmpCodePostalP());
        o.setEmpEmailP(n.getEmpEmailP());

        // --- Paramètres d'affiliation ---
        o.setEmpFrequencePaie(n.getEmpFrequencePaie());
        o.setEmpDtPremierEm(n.getEmpDtPremierEm());
        o.setEmpAssurance(n.getEmpAssurance());
        o.setEmpEtat(n.getEmpEtat());
        o.setEmpCodeFiscal(n.getEmpCodeFiscal());
        o.setEmpRegCommerce(n.getEmpRegCommerce());

        // --- Décision ---
        o.setEmpDecision(n.getEmpDecision());
        o.setEmpRaison(n.getEmpRaison());

        // --- Traçabilité (création : on ne touche pas à empDtCreee ni empUtilCree) ---
        o.setEmpDtModifiee(java.time.LocalDateTime.now());
        o.setEmpUtilModifie(currentUser());   // ou n.getEmpUtilModifie() si fourni par le client

        // --- Champs complémentaires ---
        o.setEmpOldAffiliation(n.getEmpOldAffiliation());
        o.setEmpImpressionPr(n.getEmpImpressionPr());
        o.setEmpCompte(n.getEmpCompte());
        o.setEmpBanque(n.getEmpBanque());
        o.setEmpBanqueArieres(n.getEmpBanqueArieres());
        o.setEmpMontantPaye(n.getEmpMontantPaye());
        o.setEmpMontantRest(n.getEmpMontantRest());
        o.setEmpBanqueArieres(n.getEmpBanqueArieres());
        o.setEmpDatePaiement(n.getEmpDatePaiement());
    }
}
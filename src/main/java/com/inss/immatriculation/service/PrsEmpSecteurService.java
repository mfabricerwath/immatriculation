package com.inss.immatriculation.service;

import com.inss.immatriculation.pojo.AuditRec;
import com.inss.immatriculation.pojo.PrsEmpSecteur;
import com.inss.immatriculation.pojo.PrsEmpSecteurId;
import com.inss.immatriculation.repository.AuditRecRepository;
import com.inss.immatriculation.repository.PrsEmpSecteurRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PrsEmpSecteurService {

    private final PrsEmpSecteurRepository secteurRepository;
    private final AuditRecRepository auditRecRepository;

    public PrsEmpSecteurService(PrsEmpSecteurRepository secteurRepository, 
                                AuditRecRepository auditRecRepository) {
        this.secteurRepository = secteurRepository;
        this.auditRecRepository = auditRecRepository;
    }

    // --- CRUD DE BASE ---

    public List<PrsEmpSecteur> findAll() {
        return secteurRepository.findAll();
    }

    public Optional<PrsEmpSecteur> findById(PrsEmpSecteurId id) {
        return secteurRepository.findById(id);
    }

    public List<PrsEmpSecteur> findByEmployeur(Long empSequence) {
        return secteurRepository.findByEmployeur(empSequence);
    }

    @Transactional
    public PrsEmpSecteur save(PrsEmpSecteur secteur) {
        if (secteur.getEsecDtCreee() == null) {
            secteur.setEsecDtCreee(LocalDateTime.now());
            secteur.setEsecUtilCree("admin"); // À remplacer par l'utilisateur connecté
        }
        return secteurRepository.save(secteur);
    }

    // --- UPDATE AVEC AUDIT ---

    @Transactional
    public PrsEmpSecteur update(PrsEmpSecteurId id, PrsEmpSecteur nouveau) {
        PrsEmpSecteur ancien = secteurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Secteur introuvable"));

        // 1. Enregistrer l'audit
        auditUpdate(ancien, nouveau);

        // 2. Mettre à jour les champs
        ancien.setEsecAffiliation(nouveau.getEsecAffiliation());
        ancien.setEsecDtModifiee(LocalDateTime.now());
        ancien.setEsecUtilModifie(nouveau.getEsecUtilModifie()); // ou l'utilisateur connecté

        return secteurRepository.save(ancien);
    }

    // --- DELETE AVEC AUDIT ---

    @Transactional
    public void delete(PrsEmpSecteurId id) {
        PrsEmpSecteur ancien = secteurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Secteur introuvable"));

        // Enregistrer l'audit pour suppression
        auditDelete(ancien);

        // Supprimer l'entité
        secteurRepository.delete(ancien);
    }

    // ==========================================
    // LOGIQUE D'AUDIT (Réimplémentation du trigger)
    // ==========================================

    private void auditUpdate(PrsEmpSecteur o, PrsEmpSecteur n) {
        String rowId = o.getId().getEsecSecteur() + "-" + o.getId().getEsecEmpSequence();

        // On compare chaque colonne comme dans le trigger
        if (diff(o.getEsecAffiliation(), n.getEsecAffiliation()))
            saveAudit("PRS_EMP_SECTEUR", "ESEC_AFFILIATION", rowId, str(o.getEsecAffiliation()), str(n.getEsecAffiliation()), "M");

        if (diff(o.getEsecDtModifiee(), n.getEsecDtModifiee()))
            saveAudit("PRS_EMP_SECTEUR", "ESEC_DT_MODIFIEE", rowId, str(o.getEsecDtModifiee()), str(n.getEsecDtModifiee()), "M");

        // (Le trigger ne compare pas ESEC_DT_CREEE car elle ne devrait pas changer en update, mais on peut l'ajouter si besoin)

        if (diff(o.getEsecUtilModifie(), n.getEsecUtilModifie()))
            saveAudit("PRS_EMP_SECTEUR", "ESEC_UTIL_MODIFIE", rowId, o.getEsecUtilModifie(), n.getEsecUtilModifie(), "M");

        if (diff(o.getEsecUtilCree(), n.getEsecUtilCree()))
            saveAudit("PRS_EMP_SECTEUR", "ESEC_UTIL_CREE", rowId, o.getEsecUtilCree(), n.getEsecUtilCree(), "M");

        // La clé primaire (ESEC_SECTEUR, ESEC_EMP_SEQUENCE) ne change pas, donc pas besoin de l'auditer en UPDATE
    }

    private void auditDelete(PrsEmpSecteur o) {
        String rowId = o.getId().getEsecSecteur() + "-" + o.getId().getEsecEmpSequence();

        // Le trigger Oracle fait une boucle sur TOUTES les colonnes lors d'un DELETE
        saveAudit("PRS_EMP_SECTEUR", "ESEC_AFFILIATION", rowId, str(o.getEsecAffiliation()), null, "S");
        saveAudit("PRS_EMP_SECTEUR", "ESEC_DT_MODIFIEE", rowId, str(o.getEsecDtModifiee()), null, "S");
        saveAudit("PRS_EMP_SECTEUR", "ESEC_DT_CREEE", rowId, str(o.getEsecDtCreee()), null, "S");
        saveAudit("PRS_EMP_SECTEUR", "ESEC_UTIL_MODIFIE", rowId, o.getEsecUtilModifie(), null, "S");
        saveAudit("PRS_EMP_SECTEUR", "ESEC_UTIL_CREE", rowId, o.getEsecUtilCree(), null, "S");
        saveAudit("PRS_EMP_SECTEUR", "ESEC_SECTEUR", rowId, o.getId().getEsecSecteur(), null, "S");
        saveAudit("PRS_EMP_SECTEUR", "ESEC_EMP_SEQUENCE", rowId, str(o.getId().getEsecEmpSequence()), null, "S");
    }

    private void saveAudit(String table, String column, String rowId, String oldVal, String newVal, String action) {
        AuditRec rec = new AuditRec();
        rec.setTableName(table);
        rec.setColumnName(column);
        rec.setRowId(rowId);
        rec.setOldValue(oldVal);
        rec.setNewValue(newVal);
        rec.setUserName(currentUser()); // ou "admin"
        rec.setDateModified(LocalDateTime.now());
        rec.setActionFlag(action);
        // Les champs SQL_TXT, TERMINAL, MODULE ne sont pas facilement récupérables en Java pur
        rec.setSqlTxt(null); 
        rec.setTerminal(null);
        rec.setModule(null);
        rec.setAppsUsername(currentUser()); // ou un utilisateur applicatif

        auditRecRepository.save(rec);
    }

    private boolean diff(Object a, Object b) {
        return !Objects.equals(a, b);
    }

    private String str(Object o) {
        return o == null ? null : o.toString();
    }

    private String currentUser() {
        try {
        	
        	return "Mugisha";
			/*
			 * return org.springframework.security.core.context.SecurityContextHolder
			 * .getContext().getAuthentication().getName();
			 */
        } catch (Exception e) {
            return "system";
        }
    }
}
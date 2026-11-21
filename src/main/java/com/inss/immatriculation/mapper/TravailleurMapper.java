package com.inss.immatriculation.mapper;

import com.inss.immatriculation.dto.*;
import com.inss.immatriculation.pojo.*;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TravailleurMapper {

    public PrsTravailleurDto toDto(PrsTravailleur entity) {
        if (entity == null) return null;

        PrsTravailleurDto dto = new PrsTravailleurDto();
        
        // Copie des champs simples
        dto.setTrvImmatriculation(entity.getTrvImmatriculation());
        dto.setTrvNom(entity.getTrvNom());
        dto.setTrvPrenom(entity.getTrvPrenom());
        dto.setTrvNomJeunefille(entity.getTrvNomJeunefille());
        dto.setTrvSexe(entity.getTrvSexe());
        dto.setTrvDtNaissance(entity.getTrvDtNaissance());
        dto.setTrvAnNaissance(entity.getTrvAnNaissance());
        dto.setTrvLieuNaissance(entity.getTrvLieuNaissance());
        dto.setTrvNationalite(entity.getTrvNationalite());
        dto.setTrvEtatCivil(entity.getTrvEtatCivil());
        dto.setTrvNomPere(entity.getTrvNomPere());
        dto.setTrvNomMere(entity.getTrvNomMere());
        dto.setTrvCni(entity.getTrvCni());
        dto.setTrvPhoto(entity.getTrvPhoto());
        
        dto.setTrvRue(entity.getTrvRue());
        dto.setTrvLocalite(entity.getTrvLocalite());
        dto.setTrvVille(entity.getTrvVille());
        dto.setTrvProvince(entity.getTrvProvince());
        dto.setTrvCommune(entity.getTrvCommune());
        dto.setTrvColline(entity.getTrvColline());
        dto.setTrvPays(entity.getTrvPays());
        dto.setTrvCodePostal(entity.getTrvCodePostal());
        dto.setTrvTelephone(entity.getTrvTelephone());
        dto.setTrvEmail(entity.getTrvEmail());
        dto.setTrvFax(entity.getTrvFax());

        dto.setTrvRueP(entity.getTrvRueP());
        dto.setTrvLocaliteP(entity.getTrvLocaliteP());
        dto.setTrvVilleP(entity.getTrvVilleP());
        dto.setTrvPaysP(entity.getTrvPaysP());
        dto.setTrvCodePostalP(entity.getTrvCodePostalP());
        dto.setTrvTelephoneP(entity.getTrvTelephoneP());
        dto.setTrvEmailP(entity.getTrvEmailP());
        dto.setTrvFaxP(entity.getTrvFaxP());

        dto.setTrvCatProf(entity.getTrvCatProf());
        dto.setTrvNiveauFormation(entity.getTrvNiveauFormation());
        dto.setTrvSalaire(entity.getTrvSalaire());
        dto.setTrvRepLegal(entity.getTrvRepLegal());
        dto.setTrvLivret(entity.getTrvLivret());

        dto.setTrvEtat(entity.getTrvEtat());
        dto.setTrvDtDemande(entity.getTrvDtDemande());
        dto.setTrvDtReception(entity.getTrvDtReception());
        dto.setTrvDtAssurance(entity.getTrvDtAssurance());

        dto.setTrvDtCreee(entity.getTrvDtCreee());
        dto.setTrvUtilCree(entity.getTrvUtilCree());
        dto.setTrvDtModifiee(entity.getTrvDtModifiee());
        dto.setTrvUtilModifie(entity.getTrvUtilModifie());

        // Conversion des listes imbriquées
        if (entity.getRelations() != null) {
            dto.setRelations(entity.getRelations().stream()
                    .map(this::toRelationDto)
                    .collect(Collectors.toList()));
        }

        if (entity.getServices() != null) {
            dto.setServices(entity.getServices().stream()
                    .map(this::toServiceDto)
                    .collect(Collectors.toList()));
        }

        return dto;
    }

    public PrsRelationDto toRelationDto(PrsRelation entity) {
        PrsRelationDto dto = new PrsRelationDto();
        dto.setRelCode(entity.getId() != null ? entity.getId().getRelCode() : null);
        dto.setRelNom(entity.getRelNom());
        dto.setRelPrenom(entity.getRelPrenom());
        dto.setRelDtNaissance(entity.getRelDtNaissance());
        dto.setRelAnNaissance(entity.getRelAnNaissance());
        dto.setRelSexe(entity.getRelSexe());
        dto.setRelEtat(entity.getRelEtat());
        return dto;
    }

    public PrsTrvServiceDto toServiceDto(PrsTrvService entity) {
        PrsTrvServiceDto dto = new PrsTrvServiceDto();
        if (entity.getId() != null) {
            dto.setTserDtEmbauche(entity.getId().getTserDtEmbauche());
            dto.setTserEmpSequence(entity.getId().getTserEmpSequence());
        }
        dto.setTserSalaire(entity.getTserSalaire());
        dto.setTserAffiliation(entity.getTserAffiliation());
        dto.setTserTypeAss(entity.getTserTypeAss());
        dto.setTserEtat(entity.getTserEtat());
        dto.setTserMatricule(entity.getTserMatricule());
        dto.setTserDtFin(entity.getTserDtFin());
        return dto;
    }
}
import { Injectable } from '@angular/core';
import { serverURL } from './constants';
import { EmploymentStatus, Ethnicity, Gender, Generation, Language, RelationshipStatus, 
    ReligiousBackground, SexualOrientation, Specialization, StateLocation, TreatmentModality } from '../models/fields';

const fieldsURL: string = `${serverURL}/fields`;

@Injectable({
    providedIn: 'root'
})
export class FieldsService {
    async getAllEmploymentStatuses(): Promise<EmploymentStatus[]> {
        const response = await fetch(`${fieldsURL}/employmentstatus/all`);
        return response.json();
    }

    async getAllEthnicities(): Promise<Ethnicity[]> {
        const response = await fetch(`${fieldsURL}/ethnicity/all`);
        return response.json();
    }

    async getAllGenders(): Promise<Gender[]> {
        const response = await fetch(`${fieldsURL}/gender/all`);
        return response.json();
    }

    async getAllGenerations(): Promise<Generation[]> {
        const response = await fetch(`${fieldsURL}/generation/all`);
        return response.json();
    }

    async getAllLanguages(): Promise<Language[]> {
        const response = await fetch(`${fieldsURL}/language/all`);
        return response.json();
    }

    async getAllRelationshipStatuses(): Promise<RelationshipStatus[]> {
        const response = await fetch(`${fieldsURL}/relationshipstatus/all`);
        return response.json();
    }

    async getAllReligiousBackgrounds(): Promise<ReligiousBackground[]> {
        const response = await fetch(`${fieldsURL}/religious_bkgrd/all`);
        return response.json();
    }

    async getAllSexualOrientations(): Promise<SexualOrientation[]> {    
        const response = await fetch(`${fieldsURL}/sexualorientation/all`);
        return response.json();
    }

    async getAllSpecializations(): Promise<Specialization[]> {
        const response = await fetch(`${fieldsURL}/specialization/all`);
        return response.json();
    }

    async getAllStateLocations(): Promise<StateLocation[]> {
        const response = await fetch(`${fieldsURL}/state_location/all`);
        return response.json();
    }

    async getAllTreatmentModalities(): Promise<TreatmentModality[]> {
        const response = await fetch(`${fieldsURL}/treatmentmodality/all`);
        return response.json();
    }

}

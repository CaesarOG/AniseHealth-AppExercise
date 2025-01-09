import { EmploymentStatus, Ethnicity, Gender, Generation, Language, RelationshipStatus, 
    ReligiousBackground, SexualOrientation, Specialization, StateLocation, TreatmentModality } from "./fields";

interface IUser {
    id?: number;
    username: string;
    password: string;
}

interface IProvider extends IUser {
    firstName: string;
    lastName: string;

    ethnicities: Ethnicity[];
    languages: Language[];
    gender: Gender;
    clientCapacity: number;
    states: StateLocation[];
    bio: string;
    sexualOrientation: SexualOrientation;
    religiousBackground: ReligiousBackground;
    treatmentModalities: TreatmentModality[];
    specializations: Specialization[];
}

interface IClient extends IUser {
    firstName: string;
    lastName: string;
    email: string;
    phone: number;
    dob: Date;
    
    state: StateLocation;
    gender: Gender;
    sexualOrientation: SexualOrientation;
    ethnicities: Ethnicity[];
    generation: Generation;
    relationshipStatus: RelationshipStatus;
    employmentStatus: EmploymentStatus;
    religiousBackground: ReligiousBackground;
}

class User implements IUser {
    id?: number;
    username: string;
    password: string;

    constructor(username: string, password: string) {
        this.username = username;
        this.password = password;
    }
}

export class Provider extends User implements IProvider {
    firstName: string;
    lastName: string;

    ethnicities: Ethnicity[];
    languages: Language[];
    gender: Gender;
    clientCapacity: number;
    states: StateLocation[];
    bio: string;
    sexualOrientation: SexualOrientation;
    religiousBackground: ReligiousBackground;
    treatmentModalities: TreatmentModality[];
    specializations: Specialization[];

    constructor(username: string, password: string, firstName: string, lastName: string, ethnicities: Ethnicity[],
        languages: Language[], gender: Gender, clientCapacity: number, states: StateLocation[], bio: string, sexualOrientation: SexualOrientation,
        religiousBackground: ReligiousBackground, treatmentModalities: TreatmentModality[], specializations: Specialization[]) {

        super(username, password);

        this.firstName = firstName;
        this.lastName = lastName;
        this.ethnicities = ethnicities;
        this.languages = languages;
        this.gender = gender;
        this.clientCapacity = clientCapacity;
        this.states = states;
        this.bio = bio;
        this.sexualOrientation = sexualOrientation;
        this.religiousBackground = religiousBackground;
        this.treatmentModalities = treatmentModalities;
        this.specializations = specializations;
        }
    }

export class Client extends User implements IClient {
    firstName: string;
    lastName: string;
    email: string;
    phone: number;
    dob: Date;
    
    state: StateLocation
    gender: Gender;
    sexualOrientation: SexualOrientation;
    ethnicities: Ethnicity[];
    generation: Generation;
    relationshipStatus: RelationshipStatus;
    employmentStatus: EmploymentStatus;
    religiousBackground: ReligiousBackground;

    constructor(username: string, password: string, firstName: string, lastName: string, email: string, phone: number, dob: Date,
        state: StateLocation, gender: Gender, sexualOrientation: SexualOrientation, ethnicities: Ethnicity[], generation: Generation,
        relationshipStatus: RelationshipStatus, employmentStatus: EmploymentStatus, religiousBackground: ReligiousBackground) {

        super(username, password);

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
        this.state = state;
        this.gender = gender;
        this.sexualOrientation = sexualOrientation;
        this.ethnicities = ethnicities;
        this.generation = generation;
        this.relationshipStatus = relationshipStatus;
        this.employmentStatus = employmentStatus;
        this.religiousBackground = religiousBackground;
        }
}
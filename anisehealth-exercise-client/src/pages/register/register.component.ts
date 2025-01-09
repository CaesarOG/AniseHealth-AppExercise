import { Component, inject, ChangeDetectionStrategy } from '@angular/core';
import {provideNativeDateAdapter} from '@angular/material/core';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {MatDividerModule} from '@angular/material/divider';
import {MatGridListModule} from '@angular/material/grid-list';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';
import {MatCardModule} from '@angular/material/card';
import {MatInputModule} from '@angular/material/input';
import { MatStepperModule } from '@angular/material/stepper';
import {MatFormFieldModule} from '@angular/material/form-field';
import {ErrorStateMatcher} from '@angular/material/core';
import {  FormControl, FormGroupDirective, NgForm, Validators, FormBuilder,
  FormsModule, ReactiveFormsModule} from '@angular/forms';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { FieldsService } from '../../services/fields.service';
import { ClientService } from '../../services/client.service';
import {MatSelectModule} from '@angular/material/select';
import { EmploymentStatus, Ethnicity, Gender, Generation, Language, RelationshipStatus, 
  ReligiousBackground, SexualOrientation, Specialization, StateLocation, TreatmentModality  } from '../../models/fields';
import { Client } from '../../models/users';

export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}

@Component({
  selector: 'register',
  imports: [MatStepperModule, FormsModule, MatSelectModule, MatFormFieldModule, MatInputModule, MatDatepickerModule, ReactiveFormsModule,
    CommonModule, MatCardModule, RouterModule, MatButtonModule, MatDividerModule, MatIconModule, MatGridListModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css',
  providers: [provideNativeDateAdapter()],
  standalone: true,
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class RegisterComponent {
  isLinear = true;

  username: string = '';
  password: string = '';
  password2: string = '';
  firstName: string = '';
  lastName: string = '';
  email: string = '';
  phone?: number;
  state?: StateLocation;
  dob?: Date
  gender?: Gender;
  sexualOrientation?: SexualOrientation;
  ethnicities: Ethnicity[] = [];
  generation?: Generation;
  relationshipStatus?: RelationshipStatus;
  employmentStatus?: EmploymentStatus;
  religiousBackground?: ReligiousBackground;


  usernameFormControl = new FormControl('', [Validators.required]);
  passwordFormControl = new FormControl('', [Validators.required, Validators.minLength(8)]);
  passwordFormControl2 = new FormControl('', [Validators.required, Validators.minLength(8), this.passwordsMatch.bind(this)]);

  passwordsMatch(control: FormControl): { [key: string]: boolean } | null {
    if (this.passwordFormControl.value !== control.value) {
      return { 'passwordsMismatch': true };
    }
    return null;
  }

  private _formBuilder = inject(FormBuilder);
  private router = inject(Router);

  registerGroup = this._formBuilder.group({
    usernameCtrl: this.usernameFormControl,
    passwordCtrl: this.passwordFormControl,
    password2Ctrl: this.passwordFormControl2,
  });

  firstNameFormControl = new FormControl('', [Validators.required]);
  lastNameFormControl = new FormControl('', [Validators.required]);
  emailFormControl = new FormControl('', [Validators.required, Validators.email]);
  phoneFormControl = new FormControl('', [Validators.required, Validators.pattern('^[0-9]{10}$')]);
  stateFormControl = new FormControl('', [Validators.required]);
  dobFormControl = new FormControl('', [Validators.required]);
  genderFormControl = new FormControl('', [Validators.required]);
  sexualOrientationFormControl = new FormControl('', [Validators.required]);
  ethnicityFormControl = new FormControl('', [Validators.required]);
  generationFormControl = new FormControl('', [Validators.required]);
  relationshipStatusFormControl = new FormControl('', [Validators.required]);
  employmentStatusFormControl = new FormControl('', [Validators.required]);
  religiousBackgroundFormControl = new FormControl('', [Validators.required]);

  secondFormGroup = this._formBuilder.group({
    firstNameCtrl: this.firstNameFormControl,
    lastNameCtrl: this.lastNameFormControl,
    emailCtrl: this.emailFormControl,
    phoneCtrl: this.phoneFormControl,
    stateCtrl: this.stateFormControl,
    dobCtrl: this.dobFormControl,
    genderCtrl: this.genderFormControl,
    sexualOrientationCtrl: this.sexualOrientationFormControl,
  });

  thirdFormGroup = this._formBuilder.group({
    ethnicityCtrl: this.ethnicityFormControl,
    generationCtrl: this.generationFormControl,
    relationshipStatusCtrl: this.relationshipStatusFormControl,
    employmentStatusCtrl: this.employmentStatusFormControl,
    religiousBackgroundCtrl: this.religiousBackgroundFormControl,
  });

  matcher = new MyErrorStateMatcher();
  matcher2 = new MyErrorStateMatcher();

  gendersValues: Gender[] = [];
  sexualOrientationsValues: SexualOrientation[] = [];
  ethnicitiesValues: Ethnicity[] = [];
  generationsValues: Generation[] = [];
  relationshipStatusesValues: RelationshipStatus[] = [];
  employmentStatusesValues: EmploymentStatus[] = [];
  religiousBackgroundsValues: ReligiousBackground[] = [];
  stateLocationsValues: StateLocation[] = [];

  fieldsService: FieldsService = inject(FieldsService);
  clientService: ClientService = inject(ClientService);

  constructor() {
    console.log('RegisterComponent constructor called');
    this.fieldsService.getAllEmploymentStatuses().then((statuses) => {
      this.employmentStatusesValues = statuses;
    });
    this.fieldsService.getAllEthnicities().then((ethnicities) => {
      this.ethnicitiesValues = ethnicities;
    });
    this.fieldsService.getAllGenders().then((genders) => {
      this.gendersValues = genders;
      console.log(genders);
    });
    this.fieldsService.getAllGenerations().then((generations) => {
      this.generationsValues = generations;
    });
    this.fieldsService.getAllRelationshipStatuses().then((statuses) => {
      this.relationshipStatusesValues = statuses;
    });
    this.fieldsService.getAllReligiousBackgrounds().then((backgrounds) => {
      this.religiousBackgroundsValues = backgrounds;
    });
    this.fieldsService.getAllSexualOrientations().then((orientations) => {
      this.sexualOrientationsValues = orientations;
    });
    this.fieldsService.getAllStateLocations().then((states) => {
      this.stateLocationsValues = states;
    });
    
  }

  registerClient() {
    if (this.ethnicities.length == 0 || this.generation == undefined || this.relationshipStatus == undefined || this.employmentStatus == undefined || this.religiousBackground == undefined) {
      alert('Please fill out all fields');
      return;
    }
    let client: Client = new Client(this.username, this.password, this.firstName, this.lastName, this.email, this.phone!, this.dob!, 
      this.state!, this.gender!, this.sexualOrientation!, this.ethnicities, this.generation!, this.relationshipStatus!, 
      this.employmentStatus!, this.religiousBackground!);
    this.clientService.createClient(client).then((res) => {
      if (typeof res === 'string') {
        alert(res);
      } else {
        localStorage.setItem('client', JSON.stringify(res));
        setTimeout(() => {
          this.router.navigate(['']);
        }, 1000);
      }
    });
  }

  parseGen(gen: Generation): string {
    if (gen.description) {
      return gen.name + ' ' + gen.description;
    }
    return gen.name;
  }
}
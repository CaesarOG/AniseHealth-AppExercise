import { Component, inject, AfterViewInit, ViewChild } from '@angular/core';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {MatDividerModule} from '@angular/material/divider';
import {MatGridListModule} from '@angular/material/grid-list';
import { CommonModule } from '@angular/common';
import { MatTableModule, MatTableDataSource } from '@angular/material/table';
import {MatPaginator, MatPaginatorModule} from '@angular/material/paginator';
import { Provider } from '../../models/users';
import { ProviderService } from '../../services/provider.service';
import { FieldsService } from '../../services/fields.service';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSelectModule} from '@angular/material/select';
import {FormsModule} from '@angular/forms';
import { Router } from '@angular/router';
import { EmploymentStatus, Ethnicity, Gender, Generation, Language, RelationshipStatus, 
  ReligiousBackground, SexualOrientation, Specialization, StateLocation, TreatmentModality  } from '../../models/fields';

@Component({
  selector: 'home',
  imports: [MatInputModule, MatFormFieldModule, FormsModule, MatSelectModule, MatIconModule, MatButtonModule, MatPaginatorModule, MatTableModule, CommonModule, MatDividerModule, MatIconModule, MatGridListModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
  standalone: true
})
export class HomeComponent {

  private providerService: ProviderService = inject(ProviderService);
  private fieldsService: FieldsService = inject(FieldsService);
  private router: Router = inject(Router);
  wildCardSearch: string = '';
  filteringTrue: boolean = false;

  gendersValues: Gender[] = [];
  languagesValues: Language[] = [];
  ethnicitiesValues: Ethnicity[] = [];
  religiousBackgroundsValues: ReligiousBackground[] = [];
  specializationsValues: Specialization[] = [];
  stateLocationsValues: StateLocation[] = [];
  sexualOrientationsValues: SexualOrientation[] = [];

  gender?: Gender;
  languages: Language[] = [];
  ethnicities: Ethnicity[] = [];
  religiousBackground?: ReligiousBackground;
  specializations: Specialization[] = [];
  states: StateLocation[] = [];
  sexualOrientation?: SexualOrientation;

  providers: MatTableDataSource<Provider> = new MatTableDataSource<Provider>();
  displayColumns: string[] = ['firstName', 'lastName', 'states', 'specializations','ethnicities', 'languages', 'gender'];

  @ViewChild(MatPaginator) paginator: MatPaginator|null = null;

  ngAfterViewInit() {
    this.providers.paginator = this.paginator;
  }

  wildCardSearchProviders() {
    if (this.wildCardSearch === '') {
      this.providerService.getAllProviders().then((res) => {
        if (typeof res === 'string') {
          alert(res);
        } else {
          this.providers = new MatTableDataSource<Provider>(res);
          this.providers.paginator = this.paginator;
        }
      });
    } else {
      this.providerService.searchProvidersWild(this.wildCardSearch).then((res) => {
        if (typeof res === 'string') {
          alert(res);
        } else {
          this.providers = new MatTableDataSource<Provider>(res);
          this.providers.paginator = this.paginator;
          }
      });
    }
  }

  logout() {
    localStorage.removeItem('client');
    setTimeout(() => {
      this.router.navigate(['login']);
    }, 1000);
  }

  clickRow(row: any) {
    this.router.navigate([`provider-detail/${row.id}`], { state: { provider: row } });
  }

  clearSearch() {
    this.wildCardSearch = '';
    this.providerService.getAllProviders().then((res) => {
      if (typeof res === 'string') {
        alert(res);
      } else {
        this.providers = new MatTableDataSource<Provider>(res);
        this.providers.paginator = this.paginator;
      }
    });
  }

  filterProviders() {
    if (!this.filteringTrue) {
      this.filteringTrue = true;
    }
    let provider = new Provider('', '', '', '', this.ethnicities, this.languages, this.gender!, 0, this.states, '', this.sexualOrientation!, this.religiousBackground!, [], this.specializations);
    console.log("at filter: \n", JSON.stringify(provider));
    this.providerService.filterProviders(provider).then((res) => {
      if (typeof res === 'string') {
        alert(res);
      } else {
        this.providers = new MatTableDataSource<Provider>(res);
        this.providers.paginator = this.paginator;
      }
    });
  }

  parseArray(array: any[]): string {
    let result = '';
    array.forEach((element) => {
      result += element.name + ', ';
    });
    result = result.slice(0, -2);
    if (result.length > 200) {
      return result.slice(0, 200) + '...';
    }
    return result
  }

  clearFilters() {
    this.filteringTrue = false;
    this.gender = undefined;
    this.languages = [];
    this.ethnicities = [];
    this.religiousBackground = undefined;
    this.specializations = [];
    this.states = [];

    this.providerService.getAllProviders().then((res) => {
      if (typeof res === 'string') {
        alert(res);
      } else {
        this.providers = new MatTableDataSource<Provider>(res);
        this.providers.paginator = this.paginator;
      }
    });
  }

  constructor() {
    this.providerService.getAllProviders().then((res) => {
      if (typeof res === 'string') {
        alert(res);
      } else {
        this.providers = new MatTableDataSource<Provider>(res);
        this.providers.paginator = this.paginator;
      }
    });

    this.fieldsService.getAllGenders().then((genders) => {
      this.gendersValues = genders;
    });

    // this.fieldsService.getAllLanguages().then((languages) => {
    //   this.languagesValues = languages;
    // });

    this.fieldsService.getAllEthnicities().then((ethnicities) => {
      this.ethnicitiesValues = ethnicities;
    });

    this.fieldsService.getAllReligiousBackgrounds().then((religiousBackgrounds) => {
      this.religiousBackgroundsValues = religiousBackgrounds;
    });

    this.fieldsService.getAllSpecializations().then((specializations) => {
      this.specializationsValues = specializations;
    });

    this.fieldsService.getAllStateLocations().then((stateLocations) => {
      this.stateLocationsValues = stateLocations;
    });

    this.fieldsService.getAllSexualOrientations().then((sexualOrientations) => {
      this.sexualOrientationsValues = sexualOrientations;
    });
  }
}

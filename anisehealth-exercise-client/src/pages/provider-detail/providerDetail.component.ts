import { Component, inject, Input } from '@angular/core';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {MatDividerModule} from '@angular/material/divider';
import {MatGridListModule} from '@angular/material/grid-list';
import { CommonModule } from '@angular/common';
import { RouterModule, Router } from '@angular/router';
import {MatCardModule} from '@angular/material/card';
import { Provider } from '../../models/users';
import { Gender, StateLocation } from '../../models/fields';

@Component({
  selector: 'login',
  imports: [CommonModule, MatCardModule, RouterModule, MatButtonModule, MatDividerModule, MatIconModule, MatGridListModule],
  templateUrl: './providerDetail.component.html',
  styleUrl: './providerDetail.component.css',
  standalone: true
})
export class ProviderDetailComponent {

  @Input()
  provider: Provider | null = null;

  private router = inject(Router);

  constructor() { 
    console.log("ProviderDetailComponent constructor");
    console.log(this.router.getCurrentNavigation()?.extras.state!['provider']);
    this.provider = this.router.getCurrentNavigation()?.extras.state!['provider'];
  }

  parseArray(arr: any[]): string {
    return arr.map((x) => x.name).join(', ');
  }
}

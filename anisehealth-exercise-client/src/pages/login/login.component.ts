import { Component, inject } from '@angular/core';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {MatDividerModule} from '@angular/material/divider';
import {MatGridListModule} from '@angular/material/grid-list';
import { CommonModule } from '@angular/common';
import { RouterModule, Router } from '@angular/router';
import {MatCardModule} from '@angular/material/card';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {ErrorStateMatcher} from '@angular/material/core';
import {  FormControl, FormGroupDirective, NgForm, Validators,
  FormsModule, ReactiveFormsModule} from '@angular/forms';
import { ClientService } from '../../services/client.service';

export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}

@Component({
  selector: 'login',
  imports: [FormsModule, MatFormFieldModule, MatInputModule, ReactiveFormsModule, CommonModule, MatCardModule, RouterModule, MatButtonModule, MatDividerModule, MatIconModule, MatGridListModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
  standalone: true
})
export class LoginComponent {
  buttonTitle = 'Search';

  username: string = '';
  password: string = '';

  clientService: ClientService = inject(ClientService);
  private router = inject(Router);

  usernameFormControl = new FormControl('', [Validators.required]);
  passwordFormControl = new FormControl('', [Validators.required]);

  passwordsMatch(control: FormControl): { [key: string]: boolean } | null {
    if (this.passwordFormControl.value !== control.value) {
      return { 'passwordsMismatch': true };
    }
    return null;
  }

  matcher = new MyErrorStateMatcher();

  loginClient() {
    this.clientService.loginClient(this.username, this.password).then((res) => {
      if (typeof res === 'string') {
        alert(res);
      } else {
        localStorage.setItem('client', JSON.stringify(res));
        setTimeout(() => {
          this.router.navigate(['']);
        }, 1000);
      }
    })
  }

  constructor() { 
    console.log('LoginComponent constructor called');
  }
}

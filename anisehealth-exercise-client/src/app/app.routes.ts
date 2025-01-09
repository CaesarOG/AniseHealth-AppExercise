import { Routes } from '@angular/router';
import { inject } from '@angular/core';
import { HomeComponent } from '../pages/home/home.component';
import { LoginComponent } from '../pages/login/login.component';
import { RegisterComponent } from '../pages/register/register.component';
import { NotFoundComponent } from '../pages/not-found/not-found.component';
import { ProviderDetailComponent } from '../pages/provider-detail/providerDetail.component';
import { Router } from '@angular/router';


export const routes: Routes = [
    {   path: '',
        canActivate: [() => {
            const isLoggedIn = !!localStorage.getItem('client');
            if (isLoggedIn) {
                return true
            } else {
                const router: Router = inject(Router);
                return router.navigate(['login']);
            }
        }],
        component: HomeComponent,
        title: 'Home page',  
    },
    {
        path: 'provider-detail/:id',
        component: ProviderDetailComponent,
        title: 'Provider detail page',
    },
    {
        path: 'login',
        component: LoginComponent,
        title: 'Login page',
    },
    {
        path: 'register',
        component: RegisterComponent,
        title: 'Register page',
    },
    {path: '**', component: NotFoundComponent}
];

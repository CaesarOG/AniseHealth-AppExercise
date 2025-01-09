import { Injectable } from '@angular/core';
import { serverURL } from './constants';
import { Provider } from '../models/users';

const providersURL: string = `${serverURL}/provider`;

@Injectable({
    providedIn: 'root'
})
export class ProviderService {
    async getAllProviders(): Promise<Provider[]|string> {
        const response = await fetch(`${providersURL}/all`);
        if (response.status === 200) {
            return response.json();
        } else return "Error getting providers";
    }

    async searchProvidersWild(wild: string): Promise<Provider[]|string> {
        let provider: Provider = new Provider("", "", wild, wild, [{name: wild}], [{name: wild}], {name: wild}, 0, [{name: wild}], wild, {name: wild}, {name: wild}, [{name: wild}], [{name: wild}]);
        console.log(JSON.stringify(provider));
        const response = await fetch(`${providersURL}/search`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(provider)
        });
        if (response.status === 200) {
            return response.json();
        } else return "Error searching providers";
    }

    async createProvider(provider: Provider): Promise<Provider|string> {
        const response = await fetch(`${providersURL}/create`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(provider)
        });
        if (response.status === 200) {
            return response.json();
        } else if (response.status === 409) {
            return "Provider already exists";
        } else {
            return "Error creating provider";
        }

    }

    async filterProviders(provider: Provider): Promise<Provider[]|string> {
        const response = await fetch(`${providersURL}/filter`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(provider)
        });
        if (response.status === 200) {
            return response.json();
        } else return "Error filtering providers";
    }
}
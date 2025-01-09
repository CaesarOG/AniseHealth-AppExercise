import { Injectable } from '@angular/core';
import { serverURL } from './constants';
import { Client } from '../models/users';

const clientsURL: string = `${serverURL}/client`;

@Injectable({
    providedIn: 'root'
})
export class ClientService {
    async getAllClients(): Promise<Client[]> {
        const response = await fetch(`${clientsURL}/all`);
        return response.json();
    }

    async loginClient(username: string, password: string): Promise<Client|string> {
        const response = await fetch(`${clientsURL}/login`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({username, password})
        });
        if (response.status === 200) {
            return response.json();
        } else if (response.status === 401) {
            return "Invalid password";
        } else {
            return "User not found";
        }
    }

    async createClient(client: Client): Promise<Client|string> {
        const response = await fetch(`${clientsURL}/create`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(client)
        });
        if (response.status === 200) {
            return response.json();
        } else if (response.status === 409) {
            return "Client already exists";
        } else {
            return "Error creating client";
        }

    }
}
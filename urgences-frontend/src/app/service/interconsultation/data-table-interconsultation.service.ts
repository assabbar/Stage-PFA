// src/app/service/interconsultation/data-table-interconsultation.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, map } from 'rxjs';
export interface Interconsultation {
  date: string | Date | null;
  ip: string;
  nom: string;
  genre: string;
  age: number;
  medecinDemandeur: string;
  statut: string;
  serviceDemandeur: string;
  serviceDestinataire: string;
  urgent: number;
  demande: {
    texte: string;
    date: string | Date;
  };
}

@Injectable({
  providedIn: 'root'
})
export class DataTableInterconsultationService {
  private apiUrl = 'http://localhost:8080/api/interconsultations';

  constructor(private http: HttpClient) {}

  // Récupérer toutes les interconsultations
  getData(): Observable<Interconsultation[]> {
    return this.http.get<any>(this.apiUrl).pipe(
      map(response => response.data as Interconsultation[]) // ⚡ Postman renvoie {message, data}
    );
  }

  // Récupérer une interconsultation par ID
  getById(id: number): Observable<Interconsultation> {
    return this.http.get<any>(`${this.apiUrl}/${id}`).pipe(
      map(response => response.data as Interconsultation)
    );
  }
}

import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DialogModule } from 'primeng/dialog';
import { DynamicDialogConfig } from 'primeng/dynamicdialog';
import { CardModule } from 'primeng/card';
import { TagModule } from 'primeng/tag';
import { AvatarModule } from 'primeng/avatar';
import { DividerModule } from 'primeng/divider';

@Component({
  selector: 'app-detail-interconsultation-dialog',
  standalone: true,
  imports: [
    CommonModule,
    DialogModule,
    CardModule,
    TagModule,
    AvatarModule,
    DividerModule
  ],
  templateUrl: './detail-interconsultation-dialog.component.html',
  styleUrls: ['./detail-interconsultation-dialog.component.css']
})
export class DetailInterconsultationDialogComponent {
  data: any;
  messages: { nomMedecin: string; texte: string; date: string }[] = [];

  constructor(public config: DynamicDialogConfig) {
    this.data = config.data.item;

    // Récupérer dynamiquement les messages si existe 
    if (this.data.messages && Array.isArray(this.data.messages)) {
      this.messages = this.data.messages;
    }
  }

  getGenreSeverity(genre: string): string {
    switch (genre) {
      case 'Homme': return 'homme';
      case 'Femme': return 'femme';
      default: return '';
    }
  }

  getStatutSeverity(statut: string): string {
    switch (statut) {
      case 'En Suivi': return 'success';
      case 'En Instance': return 'info';
      case 'Clôturée': return 'secondary';
      default: return '';
    }
  }
  isSentByDoctor(nomMedecin: string): boolean {
  // Le message est considéré envoyé (à droite) s’il ne vient PAS du médecin demandeur
  return nomMedecin !== this.data.medecinDemandeur;
}


}

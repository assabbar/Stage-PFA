// src/app/components/consultation/consultation.component.ts
import { Component, OnInit } from '@angular/core';
import { CardModule } from 'primeng/card';
import { ButtonModule } from 'primeng/button';
import { StatsCardsComponent } from './stats-cards/stats-cards.component';
import { TableInterconsultationComponent } from './table-interconsultation/table-interconsultation.component';
import { DataTableInterconsultationService, Interconsultation } from '../../service/interconsultation/data-table-interconsultation.service';

@Component({
  selector: 'app-consultation',
  standalone: true,
  imports: [ CardModule, ButtonModule, TableInterconsultationComponent ],
  templateUrl: './consultation.component.html',
  styleUrls: ['./consultation.component.css']
})
export class ConsultationComponent implements OnInit {

  stats = { total: 0, enSuivi: 0, cloturees: 0, urgences: 0 };

  constructor(private interconsultationService: DataTableInterconsultationService) {}

  ngOnInit(): void {
    this.interconsultationService.getData().subscribe((data: Interconsultation[]) => {
      this.stats.total = data.length;
      this.stats.enSuivi = data.filter(item => item.statut === 'En Suivi').length;
      this.stats.cloturees = data.filter(item => item.statut === 'Clôturée').length;
      this.stats.urgences = data.filter(item => item.urgent === 1).length;
    });
  }
}

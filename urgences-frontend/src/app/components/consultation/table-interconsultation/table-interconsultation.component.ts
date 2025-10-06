import { Component, OnInit, LOCALE_ID, ViewChild, OnDestroy } from '@angular/core';
import { CommonModule, registerLocaleData } from '@angular/common';
import localeFr from '@angular/common/locales/fr';
import { FormsModule } from '@angular/forms';

import { Table, TableModule } from 'primeng/table';
import { DropdownModule } from 'primeng/dropdown';
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { TagModule } from 'primeng/tag';
import { IconFieldModule } from 'primeng/iconfield';
import { InputIconModule } from 'primeng/inputicon';
import { HttpClientModule } from '@angular/common/http';
import { SelectModule } from 'primeng/select';
import { MultiSelectModule } from 'primeng/multiselect';
import { CalendarModule } from 'primeng/calendar';

/* ➜ Ajouts pour le popup */
import { DialogModule } from 'primeng/dialog';
import { DynamicDialogModule, DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { DetailInterconsultationDialogComponent } from '../detail-interconsultation-dialog/detail-interconsultation-dialog.component';

import { DataTableInterconsultationService } from '../../../service/interconsultation/data-table-interconsultation.service';
import { Interconsultation } from '../../../service/interconsultation/data-table-interconsultation.service'; // ✅ Import ajouté

registerLocaleData(localeFr);

@Component({
  selector: 'app-table-interconsultation',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    TableModule,
    DropdownModule,
    ButtonModule,
    InputTextModule,
    TagModule,
    IconFieldModule,
    InputIconModule,
    HttpClientModule,
    SelectModule,
    MultiSelectModule,
    CalendarModule,
    DialogModule,
    DynamicDialogModule
  ],
  templateUrl: './table-interconsultation.component.html',
  styleUrls: ['./table-interconsultation.component.css'],
  providers: [
    { provide: LOCALE_ID, useValue: 'fr-FR' },
    DialogService
  ]
})
export class TableInterconsultationComponent implements OnInit, OnDestroy {
  @ViewChild('dt1') dt1!: Table;

  searchValue = '';
  data: Interconsultation[] = [];
  filteredData: Interconsultation[] = [];

  ref?: DynamicDialogRef;

  statusOptions = [
    { label: 'En Suivi', value: 'En Suivi' },
    { label: 'En Instance', value: 'En Instance' },
    { label: 'Clôturée', value: 'Clôturée' }
  ];

  genreOptions = [
    { label: 'Homme', value: 'Homme' },
    { label: 'Femme', value: 'Femme' }
  ];

  constructor(
    private interconsultationService: DataTableInterconsultationService,
    private dialogService: DialogService
  ) {}

  ngOnInit() {
    this.interconsultationService.getData().subscribe((raw: Interconsultation[]) => {
      this.data = raw
        .map(r => ({ ...r, date: this.toDate(r.date) }))
        .sort((a, b) => Number(b.urgent) - Number(a.urgent));

      this.filteredData = [...this.data];
    });
  }

  ngOnDestroy(): void {
    if (this.ref) {
      this.ref.close();
    }
  }

  private toDate(val: any): Date | null {
    if (!val) return null;
    if (val instanceof Date) return isNaN(+val) ? null : val;

    if (typeof val === 'string' && /^\d{4}-\d{2}-\d{2}/.test(val)) {
      const d = new Date(val);
      return isNaN(+d) ? null : d;
    }

    if (typeof val === 'string' && /^\d{2}\/\d{2}\/\d{4}$/.test(val)) {
      const [a, b, y] = val.split('/').map(Number);
      const dd = a > 12 ? a : b;
      const mm = a > 12 ? b : a;
      const d = new Date(y, mm - 1, dd);
      return isNaN(+d) ? null : d;
    }

    const d = new Date(val);
    return isNaN(+d) ? null : d;
  }

  clear() {
    this.dt1.clear();
    this.searchValue = '';
  }

  getGenreSeverity(genre: string): string {
    switch (genre) {
      case 'Homme': return 'homme';
      case 'Femme': return 'femme';
      default: return '';
    }
  }

  getSeverity(status: string): string {
    switch (status) {
      case 'En Suivi': return 'success';
      case 'En Instance': return 'info';
      case 'Clôturée': return 'secondary';
      default: return '';
    }
  }

  openDetail(row: Interconsultation) {
    this.ref = this.dialogService.open(DetailInterconsultationDialogComponent, {
      header: "Détail d’Interconsultation",
      width: '80vw',
      height: '90vh',
      styleClass: 'full-blue-dialog',
      contentStyle: {
        overflow: 'auto',
        backgroundColor: 'rgba(120, 221, 247, 0.2)',
        padding: '0'
      },
      closable: true,
      dismissableMask: true,
      data: { item: row }
    });
  }
}

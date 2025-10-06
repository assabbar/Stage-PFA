import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-stats-cards',
  standalone: true,
  templateUrl: './stats-cards.component.html',
  styleUrls: ['./stats-cards.component.css']
})
export class StatsCardsComponent {
  @Input() total!: number;
  @Input() enSuivi!: number;
  @Input() cloturees!: number;
  @Input() urgences!: number;
}

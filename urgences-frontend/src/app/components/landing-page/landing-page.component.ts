import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { GalleriaModule } from 'primeng/galleria';
import { PanelModule } from 'primeng/panel';
import { CardModule } from 'primeng/card';

@Component({
  selector: 'app-landing-page',
  imports: [GalleriaModule, PanelModule, CardModule],
  templateUrl: './landing-page.component.html',
  standalone: true,
  styleUrl: './landing-page.component.css',
})
export class LandingPageComponent {
  images: any[] = [];
  responsiveOptions: any[];

  constructor(private router: Router) {
    this.images = [
      { previewImageSrc: 'h1.png', alt: 'H1' }, // anasElb: modify as you want this is just a placeholder
      { previewImageSrc: 'h1.png', alt: 'H2' },
      { previewImageSrc: 'h1.png', alt: 'H3' },
    ];

    this.responsiveOptions = [
      { breakpoint: '1024px', numVisible: 1 },
      { breakpoint: '768px', numVisible: 1 },
      { breakpoint: '560px', numVisible: 1 },
    ];
  }

  navigateTo(path: string) {
    this.router.navigate([path]);
  }
}

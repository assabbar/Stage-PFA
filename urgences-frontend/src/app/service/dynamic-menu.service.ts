import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Router, NavigationEnd } from '@angular/router';
import { MenuItem } from 'primeng/api';

@Injectable({ providedIn: 'root' })
export class DynamicMenuService {
  private menuItemsSource = new BehaviorSubject<MenuItem[]>([]);
  menuItems$ = this.menuItemsSource.asObservable(); //TO BE DELETED
  public closeDrawer!: () => void;

  constructor(private router: Router) {
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        this.menuItemsSource.next(this.getMenu(this.router.url));
      }
    });
  }

  private getMenu(path: string): MenuItem[] {
    if (path.includes('labo')) {
      return [
        { label: 'home', icon: 'pi pi-home', routerLink: ['/'],command: () => this.closeDrawer() },
        {
          label: 'laboratoire',
          items: [
            { label: 'resultats', icon: 'pi pi-users', routerLink: ['/labo'] },
            {
              label: 'statistiques',
              icon: 'pi pi-users',
              routerLink: ['/labo/statistique'],
            },
            {
              label: 'reglages',
              icon: 'pi pi-star',
              routerLink: ['/labo/reglage'],
            },
          ],
        },
      ];
    }
    return [
      { label: 'home', icon: 'pi pi-home', routerLink: ['/'],command: () => this.closeDrawer() },
      {
        label: 'consultations',
        icon: 'pi pi-chart-line',
        routerLink: ['/consultation'],
        command: () => this.closeDrawer(),
      },
      {
        label: 'radiologie',
        icon: 'pi pi-chart-line',
        routerLink: ['/radiology'],
        command: () => this.closeDrawer(),
      },
      {
        label: 'laboratoire',
        icon: 'pi pi-verified',
        routerLink: ['/labo'],
        command: () => this.closeDrawer(),
      },
    ];
  }
}

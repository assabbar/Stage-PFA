import { Component, OnInit } from '@angular/core';
import { RouterModule,RouterOutlet } from '@angular/router';
import { ToolbarModule } from 'primeng/toolbar';
import { DrawerModule } from 'primeng/drawer';
import { PanelMenuModule } from 'primeng/panelmenu';
import { MenuItem } from 'primeng/api';
import { DynamicMenuService } from './service/dynamic-menu.service';
import { ButtonModule } from 'primeng/button';

@Component({
  selector: 'app-root',
  imports: [
    RouterModule,
    RouterOutlet,
    ToolbarModule,
    DrawerModule,
    PanelMenuModule,
    ButtonModule,
  ],
  templateUrl: './app.component.html',
  standalone: true,
  styleUrl: './app.component.css',
})
export class AppComponent implements OnInit {
  title = 'CHU-emergency-app';
  visible = false;
  menuItems: MenuItem[] = [];

  constructor(private menuService: DynamicMenuService) {}

  ngOnInit() {
    this.menuService.menuItems$.subscribe((items) => {
      this.menuItems = items;
    });
    this.menuService.closeDrawer = this.toggleMenu.bind(this);
  }

  toggleMenu() {
    this.visible = !this.visible;
  }
}

import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { AboutComponent } from './pages/about/about.component';
import { MenuComponent } from './pages/menu/menu.component';
import { ContactosComponent } from './pages/contactos/contactos.component';
import { RoleComponent } from './pages/role/role.component';
import { ModuleComponent } from './pages/module/module.component';

export const routes: Routes = [
    {
        path: 'home',
        component: HomeComponent,
    },
    {
        path: 'about',
        component: AboutComponent,
    },
    {
        path: 'menu',
        component: MenuComponent,
    },
    {
        path: 'contactos',
        component: ContactosComponent,
    },
    {
        path: 'role',
        component: RoleComponent,
    },

       {
        path: 'module',
        component: ModuleComponent,
       },
];

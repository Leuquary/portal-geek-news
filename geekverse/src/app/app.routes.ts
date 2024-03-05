import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { NoticiaComponent } from './noticia/noticia.component';
import { CategoriaComponent } from './categoria/categoria.component';

export const routes: Routes = [
    {path: '', component: HomeComponent},
    {path: 'home', component: HomeComponent},
    {path: 'noticia', component: NoticiaComponent},
    {path: 'categoria',component:CategoriaComponent}
];

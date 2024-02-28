import { Routes } from '@angular/router';
import { GamesComponent } from './games/games.component';
import { HomeComponent } from './home/home.component';
import { LeituraComponent } from './leitura/leitura.component';
import { AnimesComponent } from './animes/animes.component';
import { EventosComponent } from './eventos/eventos.component';
import { TecnologiaComponent } from './tecnologia/tecnologia.component';
import { FilmesComponent } from './filmes/filmes.component';
import { PodcastsComponent } from './podcasts/podcasts.component';
import { NoticiaComponent } from './noticia/noticia.component';

export const routes: Routes = [
    {path: '', component: HomeComponent},
    {path: 'games', component: GamesComponent},
    {path: 'home', component: HomeComponent},
    {path: 'leitura', component: LeituraComponent},
    {path: 'animes', component: AnimesComponent},
    {path: 'eventos', component: EventosComponent},
    {path: 'tecnologia', component: TecnologiaComponent},
    {path: 'filmes', component: FilmesComponent},
    {path: 'podcasts', component: PodcastsComponent},
    {path: 'noticia', component: NoticiaComponent}
];

import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { NoticiaComponent } from './noticia/noticia.component';
import { TecnologiaComponent } from './tecnologia/tecnologia.component';
import { GamesComponent } from './games/games.component';
import { LeituraComponent } from './leitura/leitura.component';
import { FilmesSeriesComponent } from './filmes-series/filmes-series.component';
import { AnimesComponent } from './animes/animes.component';
import { CuriosidadesComponent } from './curiosidades/curiosidades.component';
import { PodcastsComponent } from './podcasts/podcasts.component';

export const routes: Routes = [
    {path: '', component: HomeComponent},
    {path: 'home', component: HomeComponent},
    {path: 'noticia', component: NoticiaComponent},
    {path: 'tecnologia',component:TecnologiaComponent},
    {path: 'games',component:GamesComponent},
    {path: 'leitura',component:LeituraComponent},
    {path: 'filmes-series',component:FilmesSeriesComponent},
    {path: 'animes',component:AnimesComponent},
    {path: 'curiosidades',component:CuriosidadesComponent},
    {path: 'podcasts',component:PodcastsComponent}
];

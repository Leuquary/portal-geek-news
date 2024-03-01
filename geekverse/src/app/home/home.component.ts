import { Component } from '@angular/core';
import { NoticiaComponent } from '../noticia/noticia.component';
import { Router } from '@angular/router';
import { CategoriaModel } from '../models/categoria.model';
import { NoticiaModel } from '../models/noticia.model';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    NoticiaComponent,
    CommonModule
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
    public categoria: CategoriaModel = new CategoriaModel();
    public noticia: NoticiaModel = new NoticiaModel();

    public noticias: NoticiaModel[] = [];

    constructor(private router: Router){
        this.categoria.id=3;
        this.categoria.nome = 'Games';
        this.categoria.cor = '#8DAC26';

        this.noticia.id=1;
        this.noticia.titulo = 'Deadpool & Wolverine: jovem de 15 anos recria trailer todinho em LEGO';
        this.noticia.subtitulo = 'O animador Preston Mutanga, provou ser mais do que um entusiasta da Marvel ao refazer o trailer de Deadpool & Wolverine';
        this.noticia.image = "assets/deadpool.png";
        this.noticia.data = '13 de fev. de 2024';

        this.noticias.push(this.noticia);
    }

    public navigateToNew(){
      this.router.navigate(['/noticia'])
    }
}

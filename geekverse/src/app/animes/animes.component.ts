import { Component } from '@angular/core';
import { CategoriaModel } from '../models/categoria.model';
import { NoticiaModel } from '../models/noticia.model';
import { Router } from '@angular/router';
import { CategoriaService } from '../services/categoria.service';
import { LocalStorageService } from '../services/local-storage.service';
import { NoticiaService } from '../services/noticia.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-animes',
  standalone: true,
  imports: [
    CommonModule
  ],
  templateUrl: './animes.component.html',
  styleUrl: './animes.component.css'
})
export class AnimesComponent {
  public noticia: NoticiaModel = new NoticiaModel();
  public listaNoticia: NoticiaModel[] = [];
  public categoria: CategoriaModel = new CategoriaModel();

  constructor(private router: Router,private serviceNoticia:NoticiaService,private serviceCategoria:CategoriaService,private localStorage:LocalStorageService){
      let id = this.localStorage.getItem('categoria');
      this.carregarCategoria(id);
      this.listarCategorias(id);
      this.postagemCategoria(id);
  }

  public postagemCategoria(id:number){
    this.serviceNoticia.postagemCategoria(id).subscribe(
      (data:NoticiaModel) => {
        this.noticia = data;
      }
    );
  }

  public listarCategorias(id:number){
    this.serviceNoticia.listarCategorias(id).subscribe(
      (data:NoticiaModel[]) => {
        this.listaNoticia = data;
      }
    );
  }

  public carregarCategoria(id:number){
    this.serviceCategoria.carregar(id).subscribe(
      (data:CategoriaModel) => {
        this.categoria = data;
      }
    );
  }

  public navigateToNew(id:number){
    this.localStorage.removeItem('noticia');
    this.localStorage.setItem('noticia',id);
    this.router.navigate(['/noticia']);
  }
}

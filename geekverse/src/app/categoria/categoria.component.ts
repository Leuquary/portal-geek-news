import { Component, OnInit } from '@angular/core';
import { CategoriaModel } from '../models/categoria.model';
import { NoticiaModel } from '../models/noticia.model';
import { Router } from '@angular/router';
import { NoticiaService } from '../services/noticia.service';
import { CategoriaService } from '../services/categoria.service';
import { LocalStorageService } from '../services/local-storage.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-categoria',
  standalone: true,
  imports: [
    CommonModule
  ],
  templateUrl: './categoria.component.html',
  styleUrl: './categoria.component.css'
})
export class CategoriaComponent{
  public noticia: NoticiaModel = new NoticiaModel();
  public listaNoticia: NoticiaModel[] = [];
  public categoria: CategoriaModel = new CategoriaModel();
  public id: number = 0;

  constructor(private router: Router,private serviceNoticia:NoticiaService,private serviceCategoria:CategoriaService,private localStorage:LocalStorageService){
      this.id = this.localStorage.getItem('categoria');
      this.carregarCategoria(this.id);
      this.listarCategoria(this.id);
      this.postagemCategoria(this.id);
  }

  public postagemCategoria(id:number){
    this.serviceNoticia.postagemCategoria(id).subscribe(
      (data:NoticiaModel) => {
        this.noticia = data;
      }
    );
  }

  public listarCategoria(id:number){
    this.serviceNoticia.listarCategoria(id).subscribe(
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

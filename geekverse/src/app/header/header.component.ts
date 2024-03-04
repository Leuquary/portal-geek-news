import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CategoriaService } from '../services/categoria.service';
import { CategoriaModel } from '../models/categoria.model';
import { LocalStorageService } from '../services/local-storage.service';
import { NoticiaModel } from '../models/noticia.model';
import { NoticiaService } from '../services/noticia.service';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [
    CommonModule,
    RouterModule
  ],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent{
    public noticia: NoticiaModel = new NoticiaModel();
    public listaCategoria: CategoriaModel[] = [];
    public listaNoticia: NoticiaModel[] = [];
    public componentes = ['/home','/tecnologia','/games','/leitura','/filmes-series','/animes','/curiosidades','/podcasts']
    
    constructor(private serviceCategoria: CategoriaService, private localStorage:LocalStorageService,private serviceNoticia:NoticiaService){
      this.listar();
    }

    public getStylesCategory(id:number){
      return {
        'backgroundColor': this.listaCategoria[id].corCabecalho,
        'color': 'white',
        'padding': '10px 0'
      }
    }

    public switchStyleHeader(id:number){
      let header = document.querySelector('.navigation__header') as HTMLElement;
      let search = document.querySelector('.search') as HTMLElement;
      header.style.backgroundColor = this.listaCategoria[id].corCabecalho;
      search.style.backgroundColor = this.listaCategoria[id].corPesquisa;
      header.style.transition = 'all ease-in 60ms';
    }

    public listar(){
      this.serviceCategoria.listar().subscribe(
        (data:CategoriaModel[]) => {
          this.listaCategoria = data;
        },
        (error) => {
          console.log('Não foi possível recuperar a lista de categorias'+error);
        }
      )
    }

    public listarCategorias(id:number){
      this.serviceNoticia.listarCategorias(id).subscribe(
        (data:NoticiaModel[]) => {
          this.listaNoticia = data;
        }
      );
    }

    public salvarCategoria(id:number){
      this.localStorage.setItem('categoria',id);
    }
}

import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CategoryModel } from '../models/category.mode';
import { CategoriaModel } from '../models/categoria.model';

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
    public category: CategoryModel = new CategoryModel();
    public categoria: CategoriaModel = new CategoriaModel();
    public categorias: CategoriaModel[] = [];
    
    constructor(){
      this.categoria.id = 1;
      this.categoria.nome = 'Tudo';
      this.categoria.cor = '#042940';
      
      this.categorias.push(this.categoria);
    }

    public getStyles(id:number){
      return {
        'backgroundColor': this.categorias[id].cor,
        'color': 'white',
        'padding': '10px 0'
      }
    }

    public switchStyleHeader(id:number){
      let header = document.querySelector('.navigation__header') as HTMLElement;
      let search = document.querySelector('.search') as HTMLElement;
      header.style.backgroundColor = this.categorias[id].cor;
      search.style.backgroundColor = this.categorias[id].cor;
      header.style.transition = 'all ease-in 60ms';
    }

}

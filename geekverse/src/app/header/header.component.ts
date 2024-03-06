import { CommonModule } from '@angular/common';
import { Component} from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { CategoriaService } from '../services/categoria.service';
import { CategoriaModel } from '../models/categoria.model';
import { LocalStorageService } from '../services/local-storage.service';
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
    public listaCategoria: CategoriaModel[] = [];
    public id:number = 0;
    
    constructor(private router: Router,private serviceCategoria: CategoriaService, private localStorage:LocalStorageService,private serviceNoticia:NoticiaService){
      this.listar();
    }

    public getStylesLogo(span:number){
      if(this.id>0){
          return {
            'color': this.listaCategoria[this.id].corLogo
          }
      }else{
        return span > 1 ? { 'color': this.listaCategoria[3].corCabecalho } : { 'color': this.listaCategoria[2].corCabecalho }
      }
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

    public salvarCategoria(id:number){
      this.localStorage.setItem('categoria',id);
    }

    public navigateToNew(id:number){
      if(id>0){
        this.router.navigateByUrl('/home', { skipLocationChange: true }).then(() => {
          this.router.navigate(['/categoria']);
        });
      }else{
        this.router.navigate(['/home']);
      }
      this.id = id;
    }
}

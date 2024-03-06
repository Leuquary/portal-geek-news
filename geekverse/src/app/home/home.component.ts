import { Component } from '@angular/core';
import { NoticiaComponent } from '../noticia/noticia.component';
import { Router } from '@angular/router';
import { CategoriaModel } from '../models/categoria.model';
import { NoticiaModel } from '../models/noticia.model';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NoticiaService } from '../services/noticia.service';
import { CategoriaService } from '../services/categoria.service';
import { LocalStorageService } from '../services/local-storage.service';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    NoticiaComponent,
    CommonModule
  ],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
    public noticia: NoticiaModel = new NoticiaModel();
    public listaNoticia: NoticiaModel[] = [];
    public categoria: CategoriaModel = new CategoriaModel();

    constructor(private router: Router,private serviceNoticia:NoticiaService,private serviceCategoria:CategoriaService,private localStorage:LocalStorageService){
        this.listarNoticiasPrincipal();
        this.ultimaPostagemPrincipal();
        this.carregarCategoria(1);
    }

    public ultimaPostagemPrincipal(){
      this.serviceNoticia.ultimaPostagemPrincipal().subscribe(
        (data:NoticiaModel) => {
          this.noticia = data;
        }
      );
    }

    public listarNoticiasPrincipal(){
      this.serviceNoticia.listarNoticiasPrincipal().subscribe(
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


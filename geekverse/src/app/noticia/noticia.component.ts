import { Component, OnInit } from '@angular/core';
import { LocalStorageService } from '../services/local-storage.service';
import { NoticiaService } from '../services/noticia.service';
import { NoticiaModel } from '../models/noticia.model';
import { CommonModule } from '@angular/common';
import { ParagrafoModel } from '../models/paragrafo.model';

@Component({
  selector: 'app-noticia',
  standalone: true,
  imports: [
    CommonModule
  ],
  templateUrl: './noticia.component.html',
  styleUrl: './noticia.component.css'
})
export class NoticiaComponent implements OnInit{
  public noticia: NoticiaModel = new NoticiaModel();
  public paragrafos: ParagrafoModel[] = [];

  ngOnInit(): void {
    console.log(this.localStorage.getItem('noticia'));
  }
  constructor(private localStorage:LocalStorageService,private serviceNoticia:NoticiaService){
    let codigo = this.localStorage.getItem('noticia');
    this.carregarNoticia(codigo);
    this.recuperarNoticia(codigo);
  }

  public carregarNoticia(id:number){
    this.serviceNoticia.carregar(id).subscribe(
      (data:NoticiaModel) => {
        this.noticia = data;
      }
    );
  }

  public recuperarNoticia(id:number){
    this.serviceNoticia.recuperarNoticia(id).subscribe(
      (data:ParagrafoModel[]) => {
        this.paragrafos = data;
      }
    );
  }
  
}

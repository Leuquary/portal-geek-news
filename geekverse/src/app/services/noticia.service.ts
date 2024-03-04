import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { NoticiaModel } from '../models/noticia.model';

@Injectable({
  providedIn: 'root'
})
export class NoticiaService {
  public url:string = "http://localhost:8081/api/";

  constructor(private http: HttpClient) { }

  public carregar(id:number):Observable<NoticiaModel>{
    return this.http.get<NoticiaModel>(this.url+"noticia/"+id);
  }

  public listarNoticias():Observable<NoticiaModel[]>{
    return this.http.get<NoticiaModel[]>(this.url+"noticia/lista");
  }

  public ultimaPostagem():Observable<NoticiaModel>{
    return this.http.get<NoticiaModel>(this.url+"noticia/ultima");
  }

  public listarCategorias(id:number):Observable<NoticiaModel[]>{
    return this.http.get<NoticiaModel[]>(this.url+"noticia/categoria/lista/"+id);
  }

  public postagemCategoria(id:number):Observable<NoticiaModel>{
    return this.http.get<NoticiaModel>(this.url+"noticia/categoria/"+id);
  }
}

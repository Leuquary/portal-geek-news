import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CategoriaModel } from '../models/categoria.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {
  public url:string = "http://localhost:8081/api/";

  constructor(private http: HttpClient) { }

  public listar():Observable<CategoriaModel[]>{
    return this.http.get<CategoriaModel[]>(this.url+"categoria/lista");
  }

  public carregar(id:number):Observable<CategoriaModel>{
    return this.http.get<CategoriaModel>(this.url+"categoria/"+id);
  }
}

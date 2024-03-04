import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LocalStorageService {

  constructor() { }

  public setItem(chave: string, valor: any): void {
    localStorage.setItem(chave, JSON.stringify(valor));
  }

  public getItem(chave: string): any {
    const item = localStorage.getItem(chave);
    return item ? JSON.parse(item) : null;
  }

  public removeItem(chave: string): void {
    localStorage.removeItem(chave);
  }

  public clear(){
    localStorage.clear();
  }
}

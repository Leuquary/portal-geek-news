import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ListItemsModel } from './listitems.model';
import { CategoryModel } from './category.model';

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
export class HeaderComponent implements OnInit{
    ngOnInit(){

    }
    public objectCategories: ListItemsModel = new ListItemsModel();
    public category: CategoryModel = new CategoryModel();

    public getStyles(id:number){
      return {
        'backgroundColor': this.category.headerColors[id],
        'color': 'white',
        'padding': '10px 0'
      }
    }

    public switchStyleHeader(id:number){
      let header = document.querySelector('.navigation__header') as HTMLElement;
      let search = document.querySelector('.search') as HTMLElement;
      header.style.backgroundColor = this.category.headerColors[id];
      search.style.backgroundColor = this.category.searchColors[id];
      header.style.transition = 'all ease-in 80ms';
    }

}

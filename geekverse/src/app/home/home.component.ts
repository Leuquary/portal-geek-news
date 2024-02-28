import { Component } from '@angular/core';
import { NoticiaComponent } from '../noticia/noticia.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    NoticiaComponent
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
    constructor(private router: Router){

    }

    public navigateToNew(){
      this.router.navigate(['/noticia'])
    }
}

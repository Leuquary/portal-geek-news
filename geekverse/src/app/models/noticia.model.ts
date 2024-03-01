import { CategoriaModel } from "./categoria.model";

export class NoticiaModel{
    public id:number;
    public titulo:string;
    public subtitulo:string;
    public corpo:string;
    public data:string;
    public image:string;
    public categoria: CategoriaModel;
    
    constructor(){
        this.id=0;
        this.titulo="";
        this.subtitulo="";
        this.corpo="";
        this.data="";
        this.image="";
        this.categoria = new CategoriaModel();
    }
}
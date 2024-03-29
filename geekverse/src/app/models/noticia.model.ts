import { AutorModel } from "./autor.model";
import { CategoriaModel } from "./categoria.model";
import { ImagemModel } from "./imagem.model";
import { ParagrafoModel } from "./paragrafo.model";

export class NoticiaModel{
    public codigo:number;
    public titulo:string;
    public subtitulo:string;
    public paragrafos: ParagrafoModel[];
    public data:string;
    public hora:string;
    public imagem:ImagemModel;
    public categoria: CategoriaModel;
    public autor: AutorModel;
    
    constructor(){
        this.codigo=0;
        this.titulo="";
        this.subtitulo="";
        this.paragrafos = [];
        this.data="";
        this.hora="";
        this.imagem = new ImagemModel();
        this.categoria = new CategoriaModel();
        this.autor = new AutorModel();
    }
}
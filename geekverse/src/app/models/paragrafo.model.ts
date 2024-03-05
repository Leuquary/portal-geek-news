import { ImagemModel } from "./imagem.model";

export class ParagrafoModel{
    public codigo:number;
    public tituloParagrafo:string;
    public corpoParagrafo:string;
    public imagem:ImagemModel;

    constructor(){
        this.codigo=0;
        this.tituloParagrafo="";
        this.corpoParagrafo="";
        this.imagem = new ImagemModel();
    }
}
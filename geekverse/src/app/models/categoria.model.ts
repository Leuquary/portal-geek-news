export class CategoriaModel{
    public codigo:number;
    public nome:string;
    public corCabecalho:string;
    public corPesquisa:string;
    public corLogo:string;

    constructor(){
        this.codigo=0;
        this.nome="";
        this.corCabecalho="";
        this.corPesquisa="";
        this.corLogo="";
    }
}
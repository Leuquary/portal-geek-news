export class CategoryModel{
    public headerColors: string[] = [];
    public searchColors: string[] = [];
    public names: string[] = [];
    public components: string[] = [];

    constructor(){
        this.headerColors = ['#042940','#005C53','#8DAC26','#BF2A37', '#A62E4B','#2A5E8C', '#922ABF','#AB357C'];
        this.searchColors = ['#031D2D','#05433D','#738C1F','#A01C27','#8F203B','#194771','#742198','#982168'];
        this.names = ['Tudo','Tecnologia','Games', 'Leitura', 'Filmes e Séries', 'Animes', 'Eventos', 'Podcasts'];
        this.components =  ['/home','/tecnologia','/games', '/leitura', '/filmes', '/animes', '/eventos', '/podcasts'];
    }
}
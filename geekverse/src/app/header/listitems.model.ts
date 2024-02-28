export class ListItemsModel{
    public firstColors: string[] = [];
    public secondColors: string[] = [];
    public names: string[] = [];
    public components: string[] = [];

    constructor(){
        this.firstColors = ['#042940','#005C53','#8DAC26','#BF2A37', '#A62E4B','#2A5E8C', '#922ABF','#AB357C'];
        this.names = ['Tudo','Tecnologia','Games', 'Leitura', 'Filmes e Séries', 'Animes', 'Eventos', 'Podcasts'];
        this.components =  ['/home','/tecnologia','/games', '/leitura', '/filmes', '/animes', '/eventos', '/podcasts'];
        this.secondColors = ['#05433D','#738C1F','#9F1B27','#92233D','#18456D','#922ABF','#AB357C'];
    }
}
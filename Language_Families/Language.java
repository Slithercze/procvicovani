class Language{
    protected String name;
    protected int numSpeakers;
    protected String regionsSpoken;
    protected String wordOrder;
  
    public Language(String name, int numSpeakers, String regionsSpoken, String wordOrder){
      this.name = name;
      this.numSpeakers = numSpeakers;
      this.regionsSpoken = regionsSpoken;
      this.wordOrder = wordOrder;
    }
  
    public void getInfo(){
      System.out.println(this.name + " is spoken by " + this.numSpeakers + " people mainly in " + this.regionsSpoken + ". The language follows the word order: " + this.wordOrder +"\n");
    }
  
    public static void main(String[] args){
      Language spanish = new Language("Spanish", 5550,"Spain","subject-verb-object");
      spanish.getInfo();
      Mayan mayan = new Mayan("Ki'che'", 23300);
      mayan.getInfo();
      SinoTibetan chinese = new SinoTibetan("Mandarin Chinese", 25600);
      SinoTibetan nonChinese = new SinoTibetan("Burmese", 67500);
      chinese.getInfo();
      nonChinese.getInfo();
    }
  }
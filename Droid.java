class Droid{
  int batteryLevel;
  String name;
  public Droid(String droidName){
    this.name = droidName;
    this.batteryLevel = 100;
  }
  public String toString(){
    return "Hello i am droid " + this.name;
  }
  public void performTask(String task){
    System.out.println(this.name + " is performing task: " + task);
    this.batteryLevel -= 10;
  }
  public int energyReport(){
    return this.batteryLevel;
  }
  public static void main(String[] args){
    Droid Codey = new Droid("Codey");
    System.out.println(Codey);
    Codey.performTask("dancing");
    System.out.println(Codey.energyReport());
  }
}
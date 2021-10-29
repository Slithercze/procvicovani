import java.util.ArrayList;
//Build Playlist.java with the best possible playlist of music using a Java ArrayList. Choose wisely.
class Playlist {
  
  public static void main(String[] args) {
    ArrayList<String> desertIslandPlaylist = new ArrayList<String>();
    desertIslandPlaylist.add("Diamonds");
    desertIslandPlaylist.add("Despacito");
    desertIslandPlaylist.add("Old Town Road");
    desertIslandPlaylist.add("Dark Light");
    desertIslandPlaylist.add("Maps");
    desertIslandPlaylist.add("Rap God");
    System.out.println(desertIslandPlaylist);
    System.out.println(desertIslandPlaylist.size());
    desertIslandPlaylist.remove("Rap God");
    System.out.println(desertIslandPlaylist);
    String a = desertIslandPlaylist.get(1); 
    desertIslandPlaylist.set(1, "Dark Light");
    desertIslandPlaylist.set(3, a);
    System.out.println(desertIslandPlaylist);
  }
  
} 

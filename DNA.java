public class DNA {
    public static void main(String[] args) {
   /*Write a DNA.java program that determines whether there is a protein in a strand of DNA.
  
  A protein has the following qualities:
  
  It begins with a “start codon”: ATG.
  It ends with a “stop codon”: TGA.
  In between, each additional codon is a sequence of three nucleotides.
  */
      //  -. .-.   .-. .-.   .
      //    \   \ /   \   \ / 
      //   / \   \   / \   \  
      //  ~   `-~ `-`   `-~ `-
      
      String dna1 = "ATGCGATACGCTTGA";
      String dna2 = "ATGCGATACGTGA";
      String dna3 = "ATTAATATGTACTGA";
      String dna = dna1;
      int length = dna.length();
      System.out.println(length);
      int start = dna.indexOf("ATG");
      int stop = dna.indexOf("TGA");
      if(start >= 0 && stop >= 0 && (stop - start) % 3 == 0){
        String protein = dna;
        System.out.println("Protein: " + protein);
      } else {
        System.out.println("No protein.");
      }
    }
  }

/**
*
* @author B171210393 Arif Seyda Özçelik - B171210018 Huseyin Halid Özkılıç
* @since 26.02.2019
* <p>
*  Fonksiyon işlemleri kodu buradadır
* </p>
*/
package pdp.pkg1.odev;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fonksiyonislmleri {
    private int parametreSayisi;

    public Fonksiyonislmleri() {
        parametreSayisi=0;
    }
    public void fonkIslem(){
        Pattern pattern = Pattern.compile("void");
        Pattern pattern1 = Pattern.compile("main");
        Pattern pattern2 = Pattern.compile(",");
        Pattern pattern3 = Pattern.compile("int");
        Pattern pattern4 = Pattern.compile("printf");
        Pattern pattern5 = Pattern.compile(";");
        Pattern pattern6 = Pattern.compile("float");
        Pattern pattern7 = Pattern.compile("double");
        Pattern pattern8 = Pattern.compile("char");
        Pattern pattern9 = Pattern.compile("long int");
        Pattern pattern10 = Pattern.compile("short int");
        Pattern pattern11 = Pattern.compile("unsigned int");
        Pattern pattern12 = Pattern.compile("unsigned char");
        Pattern pattern13 = Pattern.compile("signed char");
        Pattern pattern14 = Pattern.compile("signed int");
        Pattern pattern15 = Pattern.compile("unsigned long int");
        Pattern pattern16 = Pattern.compile("=");
        Pattern pattern18 = Pattern.compile("long");
        Pattern pattern19 = Pattern.compile("short");
        Pattern pattern20 = Pattern.compile("long double");
        char[] operators = {'+','-','*','/','&','=','<','>'};
        String regex = "void.+";
        try(Scanner scanner =new Scanner(new BufferedReader( new FileReader("Program.c")))){
             while(scanner.hasNextLine()){
                 String islemler = "";
                  String Bilgi = scanner.nextLine();
                  String[] array1 = Bilgi.split(" ");
                 Matcher matcher6 = pattern.matcher(Bilgi);
                 Matcher matcher5 = pattern2.matcher(Bilgi);
                 Matcher matcher4 = pattern5.matcher(Bilgi);
                 Matcher matcher2 = pattern3.matcher(Bilgi);
                 Matcher matcher3 = pattern4.matcher(Bilgi);
                 Matcher matcher = pattern1.matcher(Bilgi);
                 Matcher matcher1 = pattern6.matcher(Bilgi);
                 Matcher matcher7 = pattern7.matcher(Bilgi);
                 Matcher matcher8 = pattern8.matcher(Bilgi);
                 Matcher matcher9 = pattern9.matcher(Bilgi);
                 Matcher matcher10 = pattern10.matcher(Bilgi);
                 Matcher matcher11 = pattern11.matcher(Bilgi);
                 Matcher matcher12 = pattern12.matcher(Bilgi);
                 Matcher matcher13 = pattern13.matcher(Bilgi);
                 Matcher matcher14 = pattern14.matcher(Bilgi);
                 Matcher matcher15 = pattern15.matcher(Bilgi);
                 Matcher matcher16 = pattern16.matcher(Bilgi);
                 Matcher matcher18 = pattern18.matcher(Bilgi);
                 Matcher matcher19 = pattern19.matcher(Bilgi);
                 Matcher matcher20 = pattern20.matcher(Bilgi);
                 //Bir onceki sayfa ile aynı yerler sadece parametre işlemi is yapıypor. Bir onemi yok
                 while ((matcher2.find()&&!(matcher3.find())&&!matcher4.find()||matcher1.find()||matcher7.find()||matcher8.find()||matcher9.find()||matcher10.find()||matcher11.find()||matcher12.find()||matcher13.find()||matcher14.find()||matcher15.find())||matcher6.find()||matcher18.find()||matcher19.find()||matcher20.find()){
                    if (!matcher5.find()){
                        break;
                    }
                 }
                 //Bir onceki sayfa ile aynı yerler sadece parametre işlemi is yapıypor. Bir onemi yok
                 while (true) {
                     for (int i = 0; i < Bilgi.length(); i++) {
                         for (int j = 0; j < operators.length; j++) {
                             if (operators[j]==Bilgi.charAt(i)) { 
                             }
                         }
                     }
                     break;
                 }//Tek kelimeli olanları yazdırılması mesela int
                 if (Pattern.matches(regex, Bilgi)||(Pattern.matches("int.+", Bilgi)&&!Pattern.matches("(.)*;(.)*", Bilgi)&&!Pattern.matches("(.)*=(.)*", Bilgi)||Pattern.matches("float.+", Bilgi)||Pattern.matches("double.+", Bilgi)||Pattern.matches("char.+", Bilgi)||Pattern.matches("long.+", Bilgi)||Pattern.matches("short.+", Bilgi))) {
                    for (int i = 1; i < 2; i++) {
                        islemler = array1[i];
                        
                        for (int j = 0; j < islemler.length(); j++) {
                            if (islemler.charAt(j)!='(') {
                                System.out.print(islemler.charAt(j));
                        }
                            else break;
                    } 
                    }
                     System.out.print(" - Parametreler: ");
                         for (int i = 2; i < array1.length; i++) {
                             islemler = array1[i];
                             for (int j = 0; j < islemler.length(); j++) {
                            if (islemler.charAt(j)!=')' && islemler.charAt(j) != ',') {
                                System.out.print(islemler.charAt(j));
                        }
                            else break;       
                    }
                             if (array1[array1.length-1]!=islemler) {
                                 System.out.print(", ");
                             }
                         }
                         System.out.println("");
                     }//iki kelimeli olanların yazılması long int
                 if ((Pattern.matches("long int.+", Bilgi)||Pattern.matches("short int.+", Bilgi)||Pattern.matches("unsigned int.+", Bilgi)||Pattern.matches("unsigned char.+", Bilgi)||Pattern.matches("signed char.+", Bilgi)||Pattern.matches("signed int.+", Bilgi)||Pattern.matches("long double.+", Bilgi))&&!Pattern.matches("(.)*;(.)*", Bilgi)&&!Pattern.matches("(.)*=(.)*", Bilgi)) {
                     for (int i = 2; i < 3; i++) {
                        islemler = array1[i];
                        
                        for (int j = 0; j < islemler.length(); j++) {
                            if (islemler.charAt(j)!='(') {
                                System.out.print(islemler.charAt(j));
                        }
                            else break;
                    } 
                    }
                     System.out.print(" - Parametreler: ");
                         for (int i = 3; i < array1.length; i++) {
                             islemler = array1[i];
                             for (int j = 0; j < islemler.length(); j++) {
                            if (islemler.charAt(j)!=')' && islemler.charAt(j) != ',') {
                                System.out.print(islemler.charAt(j));
                        }
                            else break;       
                    }
                             if (array1[array1.length-1]!=islemler) {
                                 System.out.print(", ");
                             }
                         }
                         System.out.println("");
                 }//uc kelimeli olanların yazılması unsigned long int
                 if (Pattern.matches("unsigned long int.+", Bilgi)&&!Pattern.matches("(.)*;(.)*", Bilgi)&&!Pattern.matches("(.)*=(.)*", Bilgi)) {
                     for (int i = 3; i < 4; i++) {
                        islemler = array1[i];
                        
                        for (int j = 0; j < islemler.length(); j++) {
                            if (islemler.charAt(j)!='(') {
                                System.out.print(islemler.charAt(j));
                        }
                            else break;
                    } 
                    }
                     System.out.print(" - Parametreler: ");
                         for (int i = 4; i < array1.length; i++) {
                             islemler = array1[i];
                             for (int j = 0; j < islemler.length(); j++) {
                            if (islemler.charAt(j)!=')' && islemler.charAt(j) != ',') {
                                System.out.print(islemler.charAt(j));
                        }
                            else break;       
                    }
                             if (array1[array1.length-1]!=islemler) {
                                 System.out.print(", ");
                             }
                         }
                         System.out.println("");
                 }
                }
              
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Fonksiyonislmleri.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    public int getParametreSayisi() {
        return parametreSayisi;
    }
    public void setParametreSayisi(int parametreSayisi) {
        this.parametreSayisi = parametreSayisi;
    } 
}

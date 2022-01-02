package pdp.pkg1.odev;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
*
* @author B171210393 Arif Seyda Özçelik - B171210018 Huseyin Halid Özkılıç
* @since 26.02.2019
* <p>
*  Fonksiyon sayisi, parametre sayisi, operatör sayisinin kodları burdadır
* </p>
*/


public class Pdp1Odev {
    public static void main(String[] args){
        Fonksiyonislmleri fonk = new Fonksiyonislmleri();
        int fonksiyonSayisi = 0;
        int parametreSayisi = 0;
        int operatorSayisi = 0;
        
        char[] operators = {'+','-','*','/','&','=','<','>','!'}; //parametre sayısını bulmamıza yardımcı
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
        Pattern pattern17 = Pattern.compile("//");
        Pattern pattern18 = Pattern.compile("long");
        Pattern pattern19 = Pattern.compile("short");
        Pattern pattern20 = Pattern.compile("long double");
        String regex = "void.+";
        //Dosyayı alıyor
        try(Scanner scanner =new Scanner(new BufferedReader( new FileReader("Program.c")))){
             while(scanner.hasNextLine()){
                  String Bilgi = scanner.nextLine();
                  //Yorum satırını almama işlemleri
                  for (int k = 0; k < Bilgi.length(); k++) {
                      if (Bilgi.charAt(k)=='/' && Bilgi.charAt(k+1)=='*') {
                       Bilgi="y";
                      }
                      else if (Bilgi.charAt(k)=='*' && Bilgi.charAt(k+1)=='/') {
                          Bilgi="y";
                      }
                      else if (Bilgi.charAt(k)=='/' && Bilgi.charAt(k+1)=='/') {
                          Bilgi="y";
                      }
                 }
                  //Patternlari alma islemleri
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
                 Matcher matcher17 = pattern17.matcher(Bilgi);
                 Matcher matcher18 = pattern18.matcher(Bilgi);
                 Matcher matcher19 = pattern19.matcher(Bilgi);
                 Matcher matcher20 = pattern20.matcher(Bilgi);
                 //fonksiyon sayisini bulma
                while ((matcher2.find()&&!(matcher3.find())&&!matcher4.find()||matcher1.find()||matcher7.find()||matcher8.find()||matcher9.find()||matcher10.find()||matcher11.find()||matcher12.find()||matcher13.find()||matcher14.find()||matcher15.find())||matcher6.find()||matcher18.find()||matcher19.find()||matcher20.find()){
                    if (!matcher5.find()){
                        fonksiyonSayisi++;
                        break;
                    }
                 }
                 //operator sayısını bulma
                 while (true) {
                     if (!matcher17.find()) {
                         for (int i = 0; i < Bilgi.length(); i++) {
                         for (int j = 0; j < operators.length; j++) {
                             if (operators[j]==Bilgi.charAt(i)) {
                                 operatorSayisi++;
                             }
                             if (operators[j]==Bilgi.charAt(i)&&operators[j]==Bilgi.charAt(i+1)) { //++ -- yi 1 sayma
                                 operatorSayisi--;
                             } 
                         }
                         if (Bilgi.charAt(i)=='<'&&Bilgi.charAt(i+1)=='=') { //<= 1 sayma
                                 operatorSayisi--;
                             }
                         if (Bilgi.charAt(i)=='>'&&Bilgi.charAt(i+1)=='=') {//>= 1 sayma
                                 operatorSayisi--;
                             }
                         if (Bilgi.charAt(i)=='!'&&Bilgi.charAt(i+1)=='=') {
                                 operatorSayisi--;
                             }
                             
                     }
                     } 
                     break;
                 }//paremetre sayisini bulma void olanların ifi
                 if (Pattern.matches(regex, Bilgi)) {
                    for (int i = 2; i < array1.length; i++) {
                        parametreSayisi++; 
                    }
                }
                 //Parametre sayisini bulma void haricindeki hepsinin
                 if (matcher2.find()&&!matcher16.find()||matcher1.find()||matcher7.find()||matcher8.find()||matcher9.find()||matcher10.find()||matcher11.find()||matcher12.find()||matcher13.find()||matcher14.find()||matcher15.find()||matcher18.find()||matcher19.find()||matcher20.find()) {
                    for (int i = 2; i < array1.length; i++) {
                        parametreSayisi++; 
                    }
                }
             }
             System.out.println("Toplam Operatör Sayisi : "+ operatorSayisi);
             System.out.println("Toplam Fonksiyon Sayisi: "+ fonksiyonSayisi);
             System.out.println("Toplam Parametre Sayisi: "+ parametreSayisi);
             System.out.println("Fonksiyon işlemleri: ");
             fonk.fonkIslem(); //Yazdırma işlemleri
        } catch (FileNotFoundException ex) {
            System.out.println("Dosya Bulunamadi  ");
        }
    }
}

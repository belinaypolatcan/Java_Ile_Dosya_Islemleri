
package prolab3;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.LogManager;
import java.util.logging.*;
import javafx.scene.control.Cell;
import static org.apache.commons.collections4.CollectionUtils.size;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.ComparisonOperator;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class Prolab {

  

    Kullanici kullanici = new Kullanici();
    
    public static void main(String[] args) throws FileNotFoundException, IOException  {
        

            ArrayList <Kisi> kisiListesi = new ArrayList<>();
              ArrayList <Kisi> ayniKanGrubuListesi = new ArrayList<>();
              ArrayList <String> meslekler= new ArrayList<>();
              
        
        ArrayList <String> anneler = new ArrayList<>();
        ArrayList <String> babalar = new ArrayList<>();
        
        String excelFilePath=".\\datafiles\\Prolab3.xlsx";
        FileInputStream inputStream=new FileInputStream(excelFilePath);
        XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
        workbook.getSheet("Sheet1");
        int num=workbook.getNumberOfSheets();
        
       // XSSFSheet sheet=workbook.getSheet("Sheet1");
       
 
           
        XSSFSheet sheet=workbook.getSheetAt(2);
       int rows= sheet.getLastRowNum();
       int cols=sheet.getRow(1).getLastCellNum();
       
  
       String adtum;
       
       for(int r=1;r<=rows;r++){
           Kisi kisi=new Kisi();
           XSSFRow row = sheet.getRow(r);
           for(int c=0;c<cols;c++){
               XSSFCell cell= row.getCell(c);
               switch(cell.getCellType()){
                 //  case STRING:System.out.print(cell.getStringCellValue()); break;
                   //case NUMERIC:System.out.print(cell.getNumericCellValue()); break;
                   //case BOOLEAN:System.out.print(cell.getBooleanCellValue()); break;
                   //case BLANK:System.out.print("  "); break;
                           
               }
               if(c==0){
                   kisi.id=(int) cell.getNumericCellValue();
               }
               if(c==1){
                   kisi.ad=cell.getStringCellValue();
               }
               if(c==2){
                   kisi.soyad=cell.getStringCellValue();
               }
               if(c==3){
                  
                   kisi.dogumTarihi=new DataFormatter().formatCellValue(row.getCell(3));
                 
               }
               if(c==4){
                   adtum=cell.getStringCellValue();
                   String[] dizi=adtum.split(" ");
                   kisi.esadi=dizi[0];
               }
               if(c==5){
                   kisi.anneAdi=cell.getStringCellValue();
               }
               if(c==6){
                   kisi.babaAdi=cell.getStringCellValue();
               }
               if(c==7){
                   kisi.kanGrubu=cell.getStringCellValue();
               }if(c==8){
                   kisi.meslek=cell.getStringCellValue();
               }
               if(c==9){
                   kisi.medeniHal=cell.getStringCellValue();
               }if(c==10){
                   kisi.kizlikSoyad=cell.getStringCellValue();
               }if(c==11){
                   kisi.cinsiyet=cell.getStringCellValue();
               }
               
           }
          
            kisiListesi.add(kisi);
            
            
             
       }
        
       
            if("Erkek".equals(kisiListesi.get(1).cinsiyet)){
                babalar.add(kisiListesi.get(1).ad);
                anneler.add(kisiListesi.get(1).esadi);
            }
            if("Erkek".equals(kisiListesi.get(0).cinsiyet)){
                babalar.add(kisiListesi.get(0).ad);
                anneler.add(kisiListesi.get(0).esadi); 
            }
            
            
       
       
       
       
       
            String annead = null ;
            String babaad = null ;
            String anne2=null;
            String baba2=null;
            String anne3=null;
            String baba3=null;
            String anne4=null;
            String baba4=null;
         if("Erkek".equals(kisiListesi.get(1).cinsiyet)){
                babaad=kisiListesi.get(1).ad;
                annead=kisiListesi.get(1).esadi;
            }
            if("Erkek".equals(kisiListesi.get(0).cinsiyet)){
                babaad=kisiListesi.get(0).ad;
                 annead=kisiListesi.get(0).esadi;
            }
            
            
            
          
            
            System.out.println("                                        "+annead+ "-----"+babaad);
            
            
            
           
       
       
            for(int i=0;i<kisiListesi.size();i++){
               
               
               if(kisiListesi.get(i).anneAdi.contains(annead) || kisiListesi.get(i).babaAdi.contains(babaad)){
                   System.out.println(annead+ "ve " +babaad +" nin Çocukları: "+kisiListesi.get(i).ad+" "+kisiListesi.get(i).soyad);
                   
                   //Çocuğu kadın ve evliyse
                   if("Evli".equals(kisiListesi.get(i).medeniHal) && "Kadın".equals(kisiListesi.get(i).cinsiyet)){
                      
                       anne2=kisiListesi.get(i).ad;
                       baba2=kisiListesi.get(i).esadi;
                       System.out.println("Eşi "+baba2);
                      for(int m=0;m<kisiListesi.size();m++){
                          if(kisiListesi.get(m).anneAdi.contains(anne2) || kisiListesi.get(m).babaAdi.contains(baba2)){
                             
                              System.out.println("   "+anne2 +" ve "+ baba2 + " nin çocukları "+kisiListesi.get(m).ad);
                              
                          }
                      } 
                       
                   }
                   
                   
                   // çocukları Erkek ve evliyse
                   if("Evli".equals(kisiListesi.get(i).medeniHal) && "Erkek".equals(kisiListesi.get(i).cinsiyet)){
                      
                       anne2=kisiListesi.get(i).esadi;
                       baba2=kisiListesi.get(i).ad;
                       System.out.println("Eşi "+anne2);
                      for(int m=0;m<kisiListesi.size();m++){
                          if(kisiListesi.get(m).anneAdi.contains(anne2) || kisiListesi.get(m).babaAdi.contains(baba2)){
 
                              System.out.println(anne2 +" ve "+ baba2 + " nin çocukları "+kisiListesi.get(m).ad);
                     
                          }
                      } 
                       
                   }
                   
                   
                   
               }
       }
       
       
       
      
            System.out.println("-------------------------------");
               System.out.println("kan grubu A Rh olan kisiler");
                 for(int i=0;i<kisiListesi.size();i++) {
               if("A(+)".equals(kisiListesi.get(i).kanGrubu)||"A(-)".equals(kisiListesi.get(i).kanGrubu)) {
                   
                   System.out.println(kisiListesi.get(i).ad +"\t" + kisiListesi.get(i).soyad);
                   ayniKanGrubuListesi.add(kisiListesi.get(i));
               }
               
                 }
                 
                    System.out.println("------------------------------");
                   System.out.println("Ayni meslege sahip olan kisiler:\n");
                 
                     
                     
                     for(int i=0;i<kisiListesi.size();i++){
                        meslekler.add(kisiListesi.get(i).meslek);
                         
                     }
                     
                           Object[] st = meslekler.toArray();
                           for (Object s : st) {
                             if (meslekler.indexOf(s) != meslekler.lastIndexOf(s)) {
                                 meslekler.remove(meslekler.lastIndexOf(s));
                              }
                           }
      
      
               for(int i=0;i<meslekler.size();i++) {
                   System.out.println();
                    System.out.println("Meslek "+meslekler.get(i));
               
                          for(int j=0;j<kisiListesi.size();j++){
                              if(kisiListesi.get(j).meslek==meslekler.get(i)){
                                 
                                  System.out.println(kisiListesi.get(j).ad+" "+kisiListesi.get(j).soyad);
                         
                      }
                      
               }
               }
                  
      
                   
                       
                            System.out.println("-------------------------------");
                            System.out.println("Ayni isime sahip olan kisiler:\n");
                      
                            for(int i=0;i<kisiListesi.size();i++){
                                for(int j=i+1;j<kisiListesi.size();j++){
                                    if(kisiListesi.get(i).ad==kisiListesi.get(j).ad){
                                        
                                        System.out.println(kisiListesi.get(i).ad + " "+kisiListesi.get(i).soyad+" "+kisiListesi.get(i).dogumTarihi+"-----"+kisiListesi.get(j).ad + " "+kisiListesi.get(j).soyad+" "+kisiListesi.get(j).dogumTarihi);
                                        
                                    }
                                }
                            }
            
            
            
            
            
            
            
            
       
       
       
    }
}
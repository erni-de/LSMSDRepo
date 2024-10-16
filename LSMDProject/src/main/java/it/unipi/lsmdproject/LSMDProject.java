/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package it.unipi.lsmdproject;

import org.apache.commons.lang3.StringUtils;
/**
 *
 * @author erni
 */
public class LSMDProject {

    public static void main(String[] args) {
      // Test per verificare se la dipendenza Apache Commons Lang funziona
      String str = "  Hello Maven!  ";
      System.out.println("Originale: '" + str + "'");

      // Utilizziamo StringUtils per togliere gli spazi iniziali e finali
      String trimmedStr = StringUtils.trim(str);
      System.out.println("Stringa ripulita: '" + trimmedStr + "'");

      // Verifica se la stringa è vuota
      boolean isEmpty = StringUtils.isEmpty(trimmedStr);
      System.out.println("La stringa è vuota? " + isEmpty);

    }
}

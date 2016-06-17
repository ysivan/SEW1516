package ysivan;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.TreeSet;
import java.util.Date;
import java.util.TreeMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.dom.DOMSource;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
* @author Yehezkel Sivan
*/
public class DOMPrinter {
	
    public static void main(String [] args) {
        // Hier wird ein XML-Dokument eingelesen
		Document doc = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder builder = factory.newDocumentBuilder();
            System.out.println("File Location:");

            BufferedReader brE = new BufferedReader(new InputStreamReader(System.in));
            String inputE = brE.readLine();
            doc = builder.parse(new File(inputE));

            // Übung 1, Wie viele Kunden und wie viele Bestellungen sind gespeichert?
            System.out.println("Übung 1:");
            System.out.println("Eingabe:(1): Auftrag + Kunde");
            System.out.println("Eingabe:(2): Auftrag");
            System.out.println("Eingabe:(3): Kunde");
			
            NodeList kunden = doc.getElementsByTagName("Kunde");
            NodeList buchungen = doc.getElementsByTagName("Auftrag");
			
            // Mit dem Buffer wird der Input gespeichert.
            BufferedReader br00 = new BufferedReader(new InputStreamReader(System.in));
            // User Input
            int inputint00 = Integer.parseInt(br00.readLine());
            // Jetzt werden die Inputs verglichen.
            if(inputint00 == 1){
                System.out.println("Es wurden "+buchungen.getLength()+" Buchungen durchgeführt!");
                System.out.println("Es existieren "+kunden.getLength()+" Kunden.");
            }else if(inputint00 == 2){
                System.out.println("Es wurden "+buchungen.getLength()+" Buchungen durchgeführt!");
            }else if(inputint00 == 3){
                System.out.println("Es existieren "+kunden.getLength()+" Kunden.");
            }else{
                System.out.println("Bitte geben Sie eine Zahl zwischen 1 und 3 ein!");
                System.exit(0);
            }

            // Übung 2, Welche CustomerID besitzt der vierte Kunde?
            System.out.println("Übung 2: CustomerID Eingabe(0-3)");
            // Mit dem Buffer wird der Input gespeichert.
            BufferedReader br01 = new BufferedReader(new InputStreamReader(System.in));
            // User Input
            int inputint01 = Integer.parseInt(br01.readLine());
            // Input wird wieder verglichen.
            if((inputint01 < 0) || (inputint01 > 3)){
                System.out.println("Bitte geben Sie eine Zahl zwischen 0 und 3 ein!");
            }

            Node node4 = kunden.item(inputint01);
            Element kunde = (Element)node4;
            String name = kunde.getAttribute("CustomerID");
            System.out.println("|Die ID vom "+ inputint01 +" Kunden lautet: "+name +"|");

            // Übung 3, Wie lautet die vollständige Adresse von der Firma Lazy K Kountry Store?
            System.out.println("Übung 3: Eingabe(0-3)");
            System.out.println("(0): Great Lakes Food Market");
            System.out.println("(1): Hungry Coyote Import Store");
            System.out.println("(2): Lazy K Kountry Store");
            System.out.println("(3): 12 Orchestra Terrace");

            // Mit dem Buffer wird der Input gespeichert.
            BufferedReader br02 = new BufferedReader(new InputStreamReader(System.in));
            // User Input
            int inputint02 = Integer.parseInt(br02.readLine());
            // Inputs werden verglichen
            if((inputint02 < 0) || (inputint02 > 3)){
                System.out.println("Bitte geben Sie eine Zahl zwischen 0 und 3 ein!");
            }
            NodeList firmanr3 = doc.getElementsByTagName("FullAddress").item(inputint02).getChildNodes();
            for (int i = 0, size = firmanr3.getLength(); i < size; i++) {
                Node adresse = firmanr3.item(i);
                String tmp1 = adresse.getTextContent();
                System.out.print(tmp1);
            }


            // Übung 4, Gibt es Kunden, welche dieselbe dreistellige Vorwahl verwenden?
            System.out.println();
            System.out.println("Übung 4:");

            NodeList vorwahl = doc.getElementsByTagName("Phone");
            boolean tele;
            int itele = 0;
            for (int i = 0, nodsize = vorwahl.getLength(); i < nodsize; i++) {
                Node temp1 = vorwahl.item(i);
                Node temp2 = vorwahl.item(i++);
                // Hier werden die ersten 5 Nummern rausgefiltert
                temp1.toString().substring(0, 4);
                temp2.toString().substring(0, 4);
                // Beide Variablen werden überprüft
                if (temp1.equals(temp2)) {
                    tele = true;
                    itele ++;
                }
            }
            // Wenn die Nummer gleich ist:
            if (tele = true) {
                System.out.println("Es gibt " + itele + " Kunden mit der gleichen Vorwahl!");
            }


            // Übung 5, Gibt es Kunden, die nicht aus den USA sind?
            System.out.println("Übung 5: Eingabe(Länder) wie z.B.USA");

            // Mit dem Buffer wird der Input gespeichert.
            BufferedReader br03 = new BufferedReader(new InputStreamReader(System.in));
            // User Input
            String input01 = br01.readLine();
            NodeList land = doc.getElementsByTagName("Country");
            int inputland = 0;
            for (int i = 0, nodsize = land.getLength(); i < nodsize; i++) {
                Node address = land.item(i);
                if (address.getTextContent().equals(input01)) {
                    inputland ++;
                }
            }
            System.out.println("Es sind " + inputland + " Mitarbeiter aus: " + input01);


            // Übung 6, Welche(r) Kunde(n ) hatte(n ) die meisten Bestellungen?
            System.out.println("Übung 6: Eingabe(1-2)");
            System.out.println("Eingabe:(1): Die Wenigsten Bestellungen");
            System.out.println("Eingabe:(2): Die Meisten Bestellungen");

			NodeList bestellungen = doc.getElementsByTagName("Auftrag");
            int greal01 = 0; int hungc01 = 0; int lazyk01 = 0; int letss01 = 0;
            for (int i = 0, nodsize = bestellungen.getLength(); i < nodsize; i++) {
                Node Auftrag = bestellungen.item(i).getChildNodes().item(1);
                String name1 = Auftrag.getTextContent();
                // Hier werden die Namen verglichen
                if (name1.equals("GREAL")) {
                    greal01++;
                } else if (name1.equals("HUNGC")) {
                    hungc01++;
                } else if (name1.equals("LAZYK")) {
                    lazyk01++;
                } else if (name1.equals("LETSS")) {
                    letss01++;
                }
            }
			
			// Jetzt werden die Daten hier aufgeschrieben.
            TreeMap<Integer,String> top01 = new TreeMap<Integer,String>();
            top01.put(greal01,"GREAL");
            top01.put(hungc01,"HUNGC");
            top01.put(lazyk01,"LAZYK");
            top01.put(letss01,"LETSS");
			
            // Mit dem Buffer wird der Input gespeichert.
            BufferedReader br04 = new BufferedReader(new InputStreamReader(System.in));
            // User Input
            int inputint04 = Integer.parseInt(br04.readLine());
            // Die Benutzer Inputs werden jetzt verglichen.
            if(inputint04 == 1) {
                Object firstKey = top01.keySet().toArray()[0];
                Object valueForFirstKey = top01.get(firstKey);
                System.out.println("Die Wenigsten: " + firstKey + " = " + valueForFirstKey);
            }else if(inputint04 == 2){
                Object firstKey = top01.keySet().toArray()[top01.size()-1];
                Object valueForFirstKey = top01.get(firstKey);
                System.out.println("Die Meisten: " + firstKey + " = " + valueForFirstKey);
            }else{
                System.out.println("Bitte geben Sie eine Zahl zwischen 1 und 2 an!");
            }


            // Übung 7, Wann war die letzte Bestellung von LAZYK?
            System.out.println("Übung 7:Eingabe(1-4)");
            System.out.println("(1): GREAL");
            System.out.println("(2): HUNGC");
            System.out.println("(3): LAZYK");
            System.out.println("(4): LETSS");

            // Mit dem Buffer wird der Input gespeichert.
            BufferedReader br05 = new BufferedReader(new InputStreamReader(System.in));
            // User Input
            int inputint05 = Integer.parseInt(br05.readLine());
            String sinput05 = null;
            // Die Benutzer Eingaben werden hier wieder verglichen
            if(inputint05 == 1){
                sinput05 = "GREAL";
            }else if(inputint05 == 2){
                sinput05 = "HUNGC";
            }else if(inputint05 == 3){
                sinput05 = "LAZYK";
            }else if(inputint05 == 4){
                sinput05 = "LETSS";
            }else{
                System.out.println("Bitte geben Sie eine Zahl zwischen 1 und 4 an!");
                System.exit(0);
            }

            NodeList KundenID = doc.getElementsByTagName("CustomerID");
            NodeList BestellDatum = doc.getElementsByTagName("AuftragDate");
            Integer i1 = 0;
            Date DatumD = null;
            for (int i = 0, size = bestellungen.getLength(); i < size; i++) {
                Node Temp1 = KundenID.item(i);
                String Name1 = Temp1.getTextContent();

                // Die Zeichenketten werden jetzt verglichen
                if (Name1.equals(sinput05)) {
                    Node Temp02 = BestellDatum.item(i);
                    String Datum01 = Temp02.getTextContent();
                    String Datum02 = Datum01.substring(0,10);
                    String stemp01 = Datum01.substring(12,19);
                    String DateTime01 = Datum02 + " " + stemp01;
                    Date temp01 = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").parse(DateTime01);

                    if(i1 == 0){
                        Node Temp03 = BestellDatum.item(i+1);
                        String Datum03 = Temp03.getTextContent();
                        String Datum04 = Datum03.substring(0,10);
                        String stemp02 = Datum03.substring(12,19);
                        String DateTime02 = Datum04 + " " + stemp02;
                        Date temp02 = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").parse(DateTime02);

                        // Beiden Daten werden verglichen und das Ergebnis wird in DatumD eingechrieben
                        if(temp01.after(temp02)){
                            DatumD = temp01;
                        }else{
                            DatumD = temp02;
                        }

                    }else{
                        if(temp01.after(DatumD)){
                            DatumD = temp01;
                        }
                    }
                    i1++;

                }

            }
			// Ausgabe
            System.out.println(sinput05+": " +DatumD);


            // Übung 8, Von wie vielen verschiedenen Mitarbeitern wurde GREAL bedient?
            System.out.println("Übung 8: Eingabe(1-4)");
            System.out.println("(1): GREAL");
            System.out.println("(2): HUNGC");
            System.out.println("(3): LAZYK");
            System.out.println("(4): LETSS");

            // Mit dem Buffer wird der Input gespeichert.
            BufferedReader br06 = new BufferedReader(new InputStreamReader(System.in));
            // User Input
            int inputint06 = Integer.parseInt(br05.readLine());
            String sinput06 = null;
            // Die Benutzer eingabe wird verglichen.
            if(inputint06 == 1){
                sinput06 = "GREAL";
            }else if(inputint06 == 2){
                sinput06 = "HUNGC";
            }else if(inputint06 == 3){
                sinput06 = "LAZYK";
            }else if(inputint06 == 4){
                sinput06 = "LETSS";
            }else{
                System.out.println("Bitte geben Sie eine Zahl zwischen 1 und 4 ein!");
                System.exit(0);
            }

            NodeList KundenID1 = doc.getElementsByTagName("CustomerID");
            NodeList EmployeeID1 = doc.getElementsByTagName("EmployeeID");
            TreeSet<String> ts01 = new TreeSet<String>();

            for (int i = 0, nodsize = bestellungen.getLength(); i < nodsize; i++) {
                Node tempID01 = KundenID1.item(i);
                Node tempID02 = EmployeeID1.item(i);
                String name01 = tempID01.getTextContent();
                String name02 = tempID02.getTextContent();
                // Die Kunden Werte werden verglichen, falls diese ident sind so wird es im TreeSet gespeichert.
                if (name01.equals(sinput06)) {
                    ts01.add(name02);
                }
            }
            // Ausgabe
            System.out.println(sinput06 +": Von "+ ts01.size()+" verschiedenen Mitarbeitern!");

            // Übung 9, Welches Gewicht hat LETSS insgesamt verschicken lassen?
            System.out.println("Übung 9: Eingabe(1-4)");
            System.out.println("(1): GREAL");
            System.out.println("(2): HUNGC");
            System.out.println("(3): LAZYK");
            System.out.println("(4): LETSS");

            // Wie immer wird hier ein Buffer verwendet zum zwischenspeichern
            BufferedReader br07 = new BufferedReader(new InputStreamReader(System.in));
            // User Input
            int inputint07 = Integer.parseInt(br05.readLine())
            String sinput07 = null;
            // Auch hier wird die Benutzer Eingabe verglichen
            if(inputint07 == 1){
                sinput07 = "GREAL";
            }else if(inputint07 == 2){
                sinput07 = "HUNGC";
            }else if(inputint07 == 3){
                sinput07 = "LAZYK";
            }else if(inputint07 == 4){
                sinput07 = "LETSS";
            }else{
                System.out.println("Bitte geben Sie eine Zahl zwischen 1 und 4 an!");
                System.exit(0);
            }

            NodeList KundenID2 = doc.getElementsByTagName("CustomerID");
            NodeList Gewicht = doc.getElementsByTagName("Freight");
            double dGewicht = 0.0;
            // Hier werden die Elemente überprüft
            for (int i = 0, nodesize = bestellungen.getLength(); i < nodesize; i++) {
                Node tempID = KundenID2.item(i);
                String name01 = tempID.getTextContent();

                // Und die Zeichenketten verglichen
                if (name01.equals(sinput07)){
                    String s01 = Gewicht.item(i).getTextContent();
                    double Gewicht2 = Double.parseDouble(s01);
                    dGewicht += Gewicht2;
                }
            }
            System.out.println("Das Gewicht beträgt: "+dGewicht);

            // Hier wird das neue Element "language" hinzugefügt.
            Element language = doc.createElement("language");
            // Mit dieser Schleife wird der Node in jedem Kunden abgespeichert.
            for (int i = 0, nodesize = KundenID.getLength(); i < nodesize; i++) {
                KundenID.item(i).appendChild(language);
            }
			
            // Hier wird es auf die Speicherung vorbereitet
            DOMSource source = new DOMSource(doc);
            // Der Ausgabe Kanal wird festgelegt
            StreamResult result = new StreamResult(new File("output.xml"));
            // Mit Hilfe der Factory kann ein Transformer geholt werden
            TransformerFactory tFactory = TransformerFactory.newInstance();
            // Der Transformer wird hier geladen
            Transformer transformer = tFactory.newTransformer();
            // Speichern der vorbereiteten Daten im Ausgabe-Kanal
            transformer.transform(source, result);

        }catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
    /**
	* @param node
	* @param prefix
	*/
	
	public static void printNode(Node node, String prefix) {
        if (node == null) {
            return;
        }
        System.out.print(prefix + node.getNodeName());
        if (node.getNodeValue() != null) {
            System.out.println(":" + node.getNodeValue());
        } else {
            System.out.println();
        }
        NamedNodeMap cl = node.getAttributes();
        if (cl != null) {
            for (int i = 0; i < cl.getLength(); i++) {
                Node attr = cl.item(i);
                System.out.println(prefix + "\t" + attr.getNodeName() + "->"
                        + attr.getNodeValue());
            }
        }
        NodeList nl = node.getChildNodes();
        if (nl != null) {
            for (int i = 0; i < nl.getLength(); i++) {
                Node child = nl.item(i);
                printNode(child, prefix + "\t");
            }
        }
    }
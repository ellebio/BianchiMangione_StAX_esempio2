/* Authors: Leonardo Bianchi and Carlo Mangione */
/* Version: 1.0, last modified on 21-11-21 */

package it.davincifascetti.quintainfa.bianchimangione;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;

public class Init {

	public static void main(String[] args) {

		List<Pacco> pacchi = new ArrayList<Pacco>();
		Pacco paccoAttuale = null;

		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		try {

			XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream("files/pacco.xml"));
			while (reader.hasNext()) {

				XMLEvent nextEvent = reader.nextEvent();
				if (nextEvent.isStartElement()) {

					StartElement element = nextEvent.asStartElement();

					switch (element.getName().getLocalPart()) {

					case "pacchi":
						break;

					case "pacco":
						Attribute descrizioneAttr = element.getAttributeByName(new QName("descrizione"));
						String descrizione = descrizioneAttr.getValue();
						Attribute dataOrdineAttr = element.getAttributeByName(new QName("dataOrdine"));
						String dataOrdine = dataOrdineAttr.getValue();
						Attribute dataConsegnaAttr = element.getAttributeByName(new QName("dataConsegna"));
						String dataConsegna = dataConsegnaAttr.getValue();
						Attribute prezzoAttr = element.getAttributeByName(new QName("prezzo"));
						String prezzo = prezzoAttr.getValue();
						paccoAttuale = new Pacco(descrizione, dataOrdine, dataConsegna, prezzo);
						pacchi.add(paccoAttuale);

						break;

					}

				}

				if (nextEvent.isEndElement()) {

					EndElement element = nextEvent.asEndElement();

					switch (element.getName().getLocalPart()) {

					case "pacchi":
						break;

					}

				}

			}

			System.out.print("FINISHED READING!\n\n");

			for (int i = 0; i < pacchi.size(); i++) {

				System.out.print(pacchi.get(i).getDetails());

			}

		} catch (FileNotFoundException e) {

			System.out.print("File not found! " + e + ".\n");

		} catch (XMLStreamException e) {

			System.out.print("Stream exception! " + e + ".\n");

		} catch (Exception e) {

			System.out.print("Exception! " + e + ".\n");

		}

	}

}

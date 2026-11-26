package EJER;

import java.io.File;
import java.io.IOException;
import java.nio.file.ClosedDirectoryStreamException;
import java.util.Iterator;

import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*Realizar un programa en DOM

A. Que muestre el contenido del fichero XML de la siguiente manera:

CD: 1
Título: Empire Burlesque
Artista: Bob Dylan
País: EE.UU.
Sello: Columbia
Precio: 10.90
Año: 1985

Ejercicios

B. Añadir un nuevo CD al documento XML dado. (Con datos de prueba)

C. Añadir, en cada elemento del documento XML, el número de CD que le

corresponde a cada uno.
 * 
 * */
public class EJE1 {

	public static void main(String[] args) {

		try {
			File archivo = new File("src/cds.xml");
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = dbBuilder.parse(archivo);
			document.getDocumentElement().normalize();
			System.out.println(document.getDocumentElement().getNodeName());
			NodeList nList = (NodeList) document.getElementsByTagName("CD");

			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eeElement = (Element) nNode;
					System.out.println("CD id : " + eeElement.getAttribute("id"));

					System.out
							.println("\tTítulo : " + eeElement.getElementsByTagName("TITULO").item(0).getTextContent());
					System.out.println(
							"\tArtista: " + eeElement.getElementsByTagName("ARTISTA").item(0).getTextContent());

					System.out.println("\tPaís   : " + eeElement.getElementsByTagName("PAIS").item(0).getTextContent());
					System.out
							.println("\tSello  : " + eeElement.getElementsByTagName("SELLO").item(0).getTextContent());
					System.out
							.println("\tPrecio : " + eeElement.getElementsByTagName("PRECIO").item(0).getTextContent());
					System.out.println("\tAño    : " + eeElement.getElementsByTagName("AÑO").item(0).getTextContent());
					System.out.println("------------------------------------");
				}

			}

			Element eeElementnv = document.createElement("CD");
			document.getDocumentElement().appendChild(eeElementnv);
			Attr attr = document.createAttribute("id");
			attr.setValue("4");
			eeElementnv.setAttributeNode(attr);
			

			Element tituloElement = document.createElement("TITULO");
			Element artistaElement = document.createElement("ARTISTA");
			Element paisElement = document.createElement("PAIS");
			Element selloElement = document.createElement("SELLO");
			Element precioElement = document.createElement("PRECIO");
			Element anioElement = document.createElement("AÑO");

			tituloElement.setTextContent("Thriller");
			artistaElement.setTextContent("Michael Jackson");
			paisElement.setTextContent("EE.UU.");
			selloElement.setTextContent("Epic");
			precioElement.setTextContent("15.50");
			anioElement.setTextContent("1982");
			
			
			eeElementnv.appendChild(tituloElement);
			eeElementnv.appendChild(artistaElement);
			eeElementnv.appendChild(paisElement);
			eeElementnv.appendChild(selloElement);
			eeElementnv.appendChild(precioElement);
			eeElementnv.appendChild(anioElement);
			
			
			NodeList nListnv = (NodeList) document.getElementsByTagName("CD");

			for (int i = 0; i < nListnv.getLength(); i++) {
				Node nNode = nListnv.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element cdElement = (Element) nNode;
					Element numElement=document.createElement("NUMERO");
					numElement.setTextContent((String.valueOf(i + 1)));
					cdElement.appendChild(numElement);
				}
			}

			
			TransformerFactory transformerFactory=TransformerFactory.newInstance();
			Transformer transformer=transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source =new DOMSource(document);
			StreamResult result=new StreamResult(new File("src/cds.xml"));
			transformer.transform(source, result);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

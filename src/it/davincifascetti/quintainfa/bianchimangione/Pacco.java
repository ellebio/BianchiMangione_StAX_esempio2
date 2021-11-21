/* Authors: Leonardo Bianchi and Carlo Mangione */
/* Version: 1.0, last modified on 21-11-21 */

package it.davincifascetti.quintainfa.bianchimangione;

public class Pacco {

	private String descrizione, dataOrdine, dataConsegna, prezzo;

	public Pacco(String descrizione, String dataOrdine, String dataConsegna, String prezzo) {

		this.descrizione = descrizione;
		this.dataOrdine = dataOrdine;
		this.dataConsegna = dataConsegna;
		this.prezzo = prezzo;

	}

	public boolean isComplete() {

		if (this.descrizione.isBlank() || this.descrizione.isEmpty() || this.dataOrdine.isEmpty()
				|| this.dataOrdine.isBlank() || this.dataConsegna.isBlank() || this.dataConsegna.isEmpty()
				|| this.prezzo.isBlank() || this.prezzo.isEmpty()) {

			return false;

		} else {

			return true;

		}

	}

	public String getDetails() throws Exception {

		if (this.isComplete()) {

			String toReturn = "+-----------------------------------+\n";
			toReturn += "Descrizione pacco: " + this.descrizione + "\n";
			toReturn += "Ordinato in data " + this.dataOrdine + " e consegnato in data " + this.dataConsegna + "\n";
			toReturn += "Costo ordine: " + this.prezzo + "€\n";

			return toReturn;

		} else {

			throw new Exception("Errore, le informazioni del pacco non sono complete");

		}

	}

}

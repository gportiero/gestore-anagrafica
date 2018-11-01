# gestore-anagrafica
Gestore di Anagrafiche è un'applicazione WEB che permette di gestire le anagrafiche attraverso le seguenti funzionalità: 

* Autenticazione utente
* Caricamento CSV contenente le anagrafiche
* Visualizzazione delle anagrafiche

Il progetto è stato sviluppato utilizzando _Spring Boot_, _Thymeleaf_ e _Web Socket_

# Utilizzo

## Se utilizzi Eclipse

Importare il progetto come Progetto Maven

Posizionarsi sul package it.gportiero.registry e clicca con il tasto destro sulla classe RegistryApplication e seleziona "Run as()" Java Application

Apri il browser all'indirizzo http://localhost:8080. Si aprirà una schermata di Login dove è necessario inserire i seguenti dati di accesso:

* username: test 
* password: password

### Upload CSV File

Una volta effettuato la login, cliccare sulla voce di menù "Importa Anagrafiche" e successivamente clicca su "Choose File" per caricare il file CSV. La pagina mostrerà un avviso ad import terminato (utilizzando websocket e sockjs). Sul backend è stato inserito un Thread.sleep (2 secondi) per simulare un processo lungo.

# Punti di forza
* Pattern Model-view-controller
* Password cifrata con algoritmo bcrypt
* Thymeleaf per la creazione di template modulari e riutilizzabili

# Sviluppi mancanti
* La visualizzazione ed il download dei csv importati